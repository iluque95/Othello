/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Player;

import epsevg.eu.Othello.Player.Interface.Player;
import epsevg.eu.Othello.Logic.Board;
import epsevg.eu.Othello.Base.Movement;
import epsevg.eu.Othello.Util.Point;
import epsevg.eu.Othello.Util.Color;
import static epsevg.eu.Othello.Constants.Constants.HEIGHT;
import static epsevg.eu.Othello.Constants.Constants.WIDTH;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Vector;

public class LloydC implements Player {

    HashMap<Point, Boolean> top;
    HashMap<Point, Boolean> frame;
    HashMap<Point, Boolean> bad;
    HashMap<Point, Boolean> middle;
    HashMap<Point, Boolean> baddest;
    HashMap<Point, Boolean> never;

    int prof;

    public LloydC(int profunditat) {
        
        
        
        
        prof = profunditat;
        //Hashmaps amb els conjunts de caselles amb un mateix valor
        this.top = new HashMap<Point, Boolean>() {
            {
                //Cantonades
                put(new Point(0, 0), true);
                put(new Point(0, 7), true);
                put(new Point(7, 0), true);
                put(new Point(7, 7), true);
            }
        };
       


        this.frame = new HashMap<Point, Boolean>() {
            {
                //Marc exterior excepte dolentes
                put(new Point(0, 2), true);
                put(new Point(0, 3), true);
                put(new Point(0, 4), true);
                put(new Point(0, 5), true);
                put(new Point(2, 0), true);
                put(new Point(2, 7), true);
                put(new Point(3, 0), true);
                put(new Point(3, 7), true);
                put(new Point(4, 0), true);
                put(new Point(4, 7), true);
                put(new Point(5, 0), true);
                put(new Point(5, 7), true);
                put(new Point(7, 2), true);
                put(new Point(7, 3), true);
                put(new Point(7, 4), true);
                put(new Point(7, 5), true);
            }
        };
        
                this.never = new HashMap<Point, Boolean>() {
            {
                //Cantonades
                put(new Point(1, 1), true);
                put(new Point(1, 6), true);
                put(new Point(6, 1), true);
                put(new Point(6, 6), true);
            }
        };
        this.baddest = new HashMap<Point, Boolean>() {
            {
                //Cantonades
                put(new Point(0, 1), true);
                put(new Point(0, 6), true);
                put(new Point(1, 0), true);
                put(new Point(1, 7), true);
                put(new Point(6, 0), true);
                put(new Point(6, 7), true);
                put(new Point(7, 1), true);
                put(new Point(7, 6), true);
            }
        };
        
        this.bad = new HashMap<Point, Boolean>() {
            {
             //   put(new Point(1, 1), true);
                put(new Point(1, 2), true);
                put(new Point(1, 3), true);
                put(new Point(1, 4), true);
                put(new Point(1, 5), true);
             //   put(new Point(1, 6), true);
                put(new Point(2, 1), true);
                put(new Point(2, 6), true);
                put(new Point(3, 1), true);
                put(new Point(3, 6), true);
                put(new Point(4, 1), true);
                put(new Point(4, 6), true);
                put(new Point(5, 1), true);
                put(new Point(5, 6), true);
            //    put(new Point(6, 1), true);
                put(new Point(6, 2), true);
                put(new Point(6, 3), true);
                put(new Point(6, 4), true);
                put(new Point(6, 5), true);
             //   put(new Point(6, 6), true);
            }
        };

        this.middle = new HashMap<Point, Boolean>() {
            {
                //Resta caselles centrals
                put(new Point(2, 2), true);
                put(new Point(2, 3), true);
                put(new Point(2, 4), true);
                put(new Point(2, 5), true);
                put(new Point(3, 2), true);
                put(new Point(3, 3), true);
                put(new Point(3, 4), true);
                put(new Point(3, 5), true);
                put(new Point(4, 2), true);
                put(new Point(4, 3), true);
                put(new Point(4, 4), true);
                put(new Point(4, 5), true);
                put(new Point(5, 2), true);
                put(new Point(5, 3), true);
                put(new Point(5, 4), true);
                put(new Point(5, 5), true);

            }
        };
        
        
    }

    
    public String name() {
        return "LloydC";

    }

    @Override
    public int movement(Board t, int color) {    
        //Demanar moviments possibles del tauler
        Vector<Movement> list = t.getMovements(color);
        Integer n = Integer.MIN_VALUE;
        //Posició amb valor màxim
        int pos = 0;
        //Per cada moviment possible
        for (int i = 0; i < list.size(); ++i) {
            try {
                //copiar tauler i afegir fitxa en el moviment actual
                Board b = new Board(t);
                //System.out.println("Soy el tablero MAX movement con la i"+i);
                //b.drawBoard();
                b.add(i, color);
                //Enviar a evaluar
                int x = profund(b, -color, color, prof, false);
                if( x== Integer.MAX_VALUE) return i;
                //Obtenir màxim, nivell MAX
                if (x > n) {
                    n = x;
                    pos = i;
                }
            }catch(Exception e){}
            
        }
        return pos;
    }
    
    
    

    private int heuristic(Board b, int color) {
        int my=b.getMovements(color).size();
        int other=b.getMovements(-color).size();
        //No hi han moviments + / - infinit
        if( my==0 && other==0){
            if(b.getQuantityOfPieces(color) > b.getQuantityOfPieces(-color)) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
                }
        int h = 0;
        boolean [] cols = new boolean[8];
        Arrays.fill(cols, Boolean.TRUE);
        for (int i = 0; i < HEIGHT; i++) {
            //Mirar columnes del mateix color fer taula de 8 posicions i anar anotant a cada columna
            boolean row=true;
            for (int j = 0; j < WIDTH; j++) {
                
                Point x = new Point(i, j);
                int xColor = b.getColor(x);
                // row observa files assegurades
                if(row) row = xColor == color;
                if(cols[j]) cols[j]= xColor == color; 


                if (xColor != Color.EMPTY.getColor()) {
                    //Cantonades del tauler
                    if (top.containsKey(x)) {                        
                        h += 10000 * (xColor * color);
                    //Marc exterior    
                    } else if (frame.containsKey(x)) {
                       // h+=1000;
                        //Si hi ha una casella lliure a les vores, devaluem si som al costat del contrari amb un espai al costat
                        //Verticals
                        if (i==0 || i==7) {
                            if ((b.getColor(i, j-1) != xColor) && (b.getColor(i, j-1) != b.getColor(i, j+1))) h -= 200 * (xColor * color);
                            else h+=200 * (xColor * color); // Incluye al lado de una nuestra
                        }
                        //Horitzontals
                        if (j==0 || j==7) {
                            if ((b.getColor(i-1, j) != xColor) && (b.getColor(i-1, j) != b.getColor(i+1, j))) h -= 200 * (xColor * color);
                            else h+=200 * (xColor * color); // Incluye al lado de una nuestra
                        }
                        else{
                            h+=2000;
                        }
                            
                    //Caselles adjacents a les vores    
                    } else if (bad.containsKey(x)) {
                        
                        //Valorar positivament una d'aquestes caselles si els 3 moviments del marc estan ocupats
                        if (i==1 && (j>1 && j<6)) {
                            if (b.getColor(0,j-1)==0 || b.getColor(0,j)==0 || b.getColor(0, j+1)==0) h-= 200 * (xColor * color);
                            else h+=200 * (xColor * color);
                        } else if (i==6 && (j>1 && j<6)) {
                            if (b.getColor(7,j-1)==0 || b.getColor(7,j)==0 || b.getColor(7, j+1)==0) h-= 200 * (xColor * color);
                            else h+=200 * (xColor * color);
                        } else if (j==1 && (i>1 && i<6)) {
                            if (b.getColor(i,0)==0 || b.getColor(i-1,0)==0 || b.getColor(i+1, 0)==0) h-= 200 * (xColor * color);
                            else h+=200 * (xColor * color);
                        } else if (j==1 && (i>1 && i<6)) {
                            if (b.getColor(i,7)==0 || b.getColor(i+1,7)==0 || b.getColor(i-1, 7)==0) h-= 200 * (xColor * color);
                            else h+=200 * (xColor * color);
                        }else{
                            if (i==1 && j==1) {
                                if (b.getColor(0,0)==0 || b.getColor(0, 1)==0 || b.getColor(0, 2)==0 || b.getColor(1,0)==0 || b.getColor(2,0)==0) h-= 600 * (xColor * color);
                                else h+=200 * (xColor * color); 
                            }else if(i==1 && j==6) {
                                if (b.getColor(0,7)==0 || b.getColor(0, 5)==0 || b.getColor(0, 6)==0 || b.getColor(1,7)==0 || b.getColor(2,7)==0) h-= 600 * (xColor * color);
                                else h+=200 * (xColor * color); 
                            }else if(i==6 && j==1) {
                                if (b.getColor(7,0)==0 || b.getColor(5, 0)==0 || b.getColor(6, 0)==0 || b.getColor(7,1)==0 || b.getColor(7,2)==0) h-= 600 * (xColor * color);
                                else h+=200 * (xColor * color);
                            }else if(i==6 && j==6) {
                                if (b.getColor(7,7)==0 || b.getColor(5, 7)==0 || b.getColor(6, 7)==0 || b.getColor(7,5)==0 || b.getColor(7,6)==0) h-= 600 * (xColor * color);
                                else h+=200 * (xColor * color);
                            }else{
                                h-=400 * (xColor * color);
                            }
                        }
                    //Caselles centrals    
                    } else if (middle.containsKey(x)) {
                         h += 200 * (xColor * color);
                    } else if (baddest.containsKey(x)){
                        if((i==1 && j==0) || (i==0 && j==1)){
                            if(b.getColor(0, 0)!=0) h+=2000;
                            else h-=3000;
                        } else if((i==0 && j==6) || (i==1 && j==7)){
                            if(b.getColor(0, 7)!=0) h+=2000;
                            else h-=3000;
                        } else if((i==6 && j==0) || (i==7 && j==1)){
                            if(b.getColor(7, 0)!=0) h+=2000;
                            else h-=3000;
                        } else if((i==6 && j==7) || (i==7 && j==6)){
                            if(b.getColor(7, 7)!=0) h+=2000;
                            else h-=3000;
                        }
                        
                    } else if (never.containsKey(x)){
                        if(i==1 && j==1){
                            if(b.getColor(0, 0)!=0) h+=1000;
                            else h-=5000;
                        } else if(i==1 && j==6){
                            if(b.getColor(0, 7)!=0) h+=1000;
                            else h-=5000;
                        } else if(i==6 && j==1){
                            if(b.getColor(7, 0)!=0) h+=1000;
                            else h-=5000;
                        } else if(i==6 && j==6){
                            if(b.getColor(7, 7)!=0) h+=1000;
                            else h-=5000;
                        }
                        
                    }
                }
            }
            //Tota la fila del mateix color
            if(row){
                if(i==0 || i==7)h+= 10000;
                else h += 500;
            }
        }
        //Incrementem per columna acumulada
        for(int i=0; i<WIDTH; ++i){
            if(cols[i]) h+=500;
        }
        if(cols[0]) h+= 10000;
        if(cols[7]) h+= 10000;
        //System.out.println("Heuristic:"+h);
            //A partir del torn 50 la diferencia de fitxes amb el contrari puntua
            if(57 < b.getQuantityOfPiecesOnBoard())h = h + 10*(b.getQuantityOfPieces(color)-b.getQuantityOfPieces(-color));
            //Entre torn 15 i 50 es valora limitar els moviments del contrari
           // if(15 < b.getQuantityOfPiecesOnBoard() && 50>b.getQuantityOfPiecesOnBoard()){
          //      if(my>6) h+=1000;
           // }
            //if(b.getQuantityOfPiecesOnBoard()>15) h*=my;
            return h;
    }

    public int profund(Board t, int turn, int color, int prof, boolean level){
        //Turn canvia color per afegir fitxa, color es el que avaluara heuristic
        if (prof < 1){
           return heuristic(t,color);            
        }else{
            //Demanar moviments possibles del tauler
            Vector<Movement> list = t.getMovements(color);
            Integer n;
            //Preparar nivell MIN o MAX
            if (level) n = Integer.MIN_VALUE;
            else n = Integer.MAX_VALUE;
            //Per cada moviment possible
            for (int i = 0; i < list.size(); ++i) {
                try {
                    //Copiem tauler i afegim fitxa al moviment
                    Board b = new Board(t);
                    b.add(i, turn);
                    //b.drawBoard();
                    //Crida recursiva canviant el color de torn i min/max
                    int x = profund(b, -turn, color, prof--, !level);
                    //Segons nivell n es maxim o minim
                    if ((level && x > n) || (!level && x < n )) {
                        n = x;
                    }
                }catch(Exception e){}
            }
            return n;
        }
    
    }
}
//comentario