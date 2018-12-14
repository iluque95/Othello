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

import java.util.HashMap;
import java.util.Vector;

public class LloydC implements Player {

    HashMap<Point, Boolean> top;
    HashMap<Point, Boolean> frame;
    HashMap<Point, Boolean> bad;
    HashMap<Point, Boolean> middle;
    
    int prof;

    public LloydC(int profunditat) {
        prof = profunditat;
        this.top = new HashMap<Point, Boolean>() {
            {
                put(new Point(0, 0), true);
                put(new Point(0, 7), true);
                put(new Point(7, 0), true);
                put(new Point(7, 7), true);
            }
        };

        this.frame = new HashMap<Point, Boolean>() {
            {

                put(new Point(0, 1), true);
                put(new Point(0, 2), true);
                put(new Point(0, 3), true);
                put(new Point(0, 4), true);
                put(new Point(0, 5), true);
                put(new Point(0, 6), true);
                put(new Point(1, 0), true);
                put(new Point(1, 7), true);
                put(new Point(2, 0), true);
                put(new Point(2, 7), true);
                put(new Point(3, 0), true);
                put(new Point(3, 7), true);
                put(new Point(4, 0), true);
                put(new Point(4, 7), true);
                put(new Point(5, 0), true);
                put(new Point(5, 7), true);
                put(new Point(6, 0), true);
                put(new Point(6, 7), true);
                put(new Point(7, 1), true);
                put(new Point(7, 2), true);
                put(new Point(7, 3), true);
                put(new Point(7, 4), true);
                put(new Point(7, 5), true);
                put(new Point(7, 6), true);

            }
        };

        this.bad = new HashMap<Point, Boolean>() {
            {

                put(new Point(1, 1), true);
                put(new Point(1, 2), true);
                put(new Point(1, 3), true);
                put(new Point(1, 4), true);
                put(new Point(1, 5), true);
                put(new Point(1, 6), true);
                put(new Point(2, 1), true);
                put(new Point(2, 6), true);
                put(new Point(3, 1), true);
                put(new Point(3, 6), true);
                put(new Point(4, 1), true);
                put(new Point(4, 6), true);
                put(new Point(5, 1), true);
                put(new Point(5, 6), true);
                put(new Point(6, 1), true);
                put(new Point(6, 2), true);
                put(new Point(6, 3), true);
                put(new Point(6, 4), true);
                put(new Point(6, 5), true);
                put(new Point(6, 6), true);

            }
        };

        this.middle = new HashMap<Point, Boolean>() {
            {

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
            //add ficha
            try {
                Board b = new Board(t);
                System.out.println("Soy el tablero MAX movement con la i"+i);
                b.drawBoard();
                b.add(i, color);
                int x = profund(b, -color, color, prof/*****/, false);//prof   
                System.out.println("Heristico de MAX movement:"+x);
                if (x > n) {
                    n = x;
                    pos = i;
                }
            }catch(Exception e){}
            
        }
        System.out.println("Vector de movimientos movement MAX"+list);
        System.out.println("Movement MAX Elige posicion"+pos);
        return pos;
    }

    private int heuristic(Board b, int color) {
        
        if(20 > b.getQuantityOfPieces(color)+b.getQuantityOfPieces(-color)) return b.getMovements(color).size();
        System.out.println("Soy un tablero del heuristico");
        b.drawBoard();
        int h = 0;
        //int OtherMoves= b.getMovements(-color).size();
        //if(0 == OtherMoves && b.getQuantityOfPieces(color)>b.getQuantityOfPieces(-color)) return Integer.MAX_VALUE;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Point x = new Point(i, j);
                int xColor = b.getColor(x);

                if (xColor != Color.EMPTY.getColor()) {
                    if (top.containsKey(x)) {
                        h += 700 * (xColor * color);
                    } else if (frame.containsKey(x)) {
                        
                        // AÑADIMOS LO NUEVO DE LA HEURISTICA DONDE EVITAMOS QUE UNA PIEZA
                        // ASEGURADA, NO SEA COMESTIBLE POR EL OPONENTE
                        
                        if (i==0 || i==7) {
                            if ((b.getColor(i, j-1) != xColor) && (b.getColor(i, j-1) != b.getColor(i, j+1))) h-=100 * (xColor * color);
                            else h+=400 * (xColor * color); // Incluye al lado de una nuestra
                        }
                        
                        if (j==0 || j==7) {
                            if ((b.getColor(i-1, j) != xColor) && (b.getColor(i-1, j) != b.getColor(i+1, j))) h-=100 * (xColor * color);
                            else h+=400 * (xColor * color); // Incluye al lado de una nuestra
                        }
                            
                        
                    } else if (bad.containsKey(x)) {
                        
                        // AÑADIMOS LO NUEVO DE LA HEURISTICA DONDE SALVAMOS MARCOS
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
                                if (b.getColor(0,0)==0 || b.getColor(0, 1)==0 || b.getColor(0, 2)==0 || b.getColor(1,0)==0 || b.getColor(2,0)==0) h-= 200 * (xColor * color);
                                else h+=200 * (xColor * color); 
                            }else if(i==1 && j==6) {
                                if (b.getColor(0,7)==0 || b.getColor(0, 5)==0 || b.getColor(0, 6)==0 || b.getColor(1,7)==0 || b.getColor(2,7)==0) h-= 200 * (xColor * color);
                                else h+=200 * (xColor * color); 
                            }else if(i==6 && j==1) {
                                if (b.getColor(7,0)==0 || b.getColor(5, 0)==0 || b.getColor(6, 0)==0 || b.getColor(7,1)==0 || b.getColor(7,2)==0) h-= 200 * (xColor * color);
                                else h+=200 * (xColor * color);
                            }else if(i==6 && j==6) {
                                if (b.getColor(7,7)==0 || b.getColor(5, 7)==0 || b.getColor(6, 7)==0 || b.getColor(7,5)==0 || b.getColor(7,6)==0) h-= 200 * (xColor * color);
                                else h+=200 * (xColor * color);
                            }
                        }
                        
                    } else if (middle.containsKey(x)) {
                        h += 50 * (xColor * color);
                    }
                }
            }
        }
        //System.out.println("Heuristic:"+h);
            if(25 > b.getQuantityOfPiecesOnBoard())h = h + 20*b.getQuantityOfPieces(color);
            System.out.println("Soy el resultado del heuristico con valor:"+h);
            return h;
    }

    public int profund(Board t, int turn, int color, int prof, boolean level){
        //Turn canvia color per afegir fitxa
        if (prof < 1){
            //Demanar moviments possibles del tauler
           return heuristic(t,color);            
        }else{
            //Demanar moviments possibles del tauler
            Vector<Movement> list = t.getMovements(color);
            Integer n;
            if (level) n = Integer.MIN_VALUE;
            else n = Integer.MAX_VALUE;
            //Per cada moviment possible
            for (int i = 0; i < list.size(); ++i) {
                //add ficha
                try {
                    Board b = new Board(t);
                    b.add(i, turn);
                    b.drawBoard();
                    int x = profund(b, -turn, color, prof--, !level);
                    if ((level && x > n) || (!level && x < n )) {
                        n = x;
                    }
                }catch(Exception e){}

            }
            //System.out.println("Heuristic:"+n);
            if(25 < t.getQuantityOfPiecesOnBoard())return n;
            else return n+10*t.getQuantityOfPieces(color);
    
        }
    
    }
}