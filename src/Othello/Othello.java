/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello;

import GUI.*;
import Logic.Board;
import Player.*;
import Util.*;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author marti
 */
public class Othello {
    
    static Player jugador1,jugador2;
    
    static volatile GUI gui;
    
    static Board start_gui_and_board()
    {
        Board b = new Board();
        Thread m = Thread.currentThread();        
        Thread t = new Thread()
        {
            public void run()
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI(m);
                gui.updateBoard(b);
                gui.setVisible(true);
            }
            });
                
            }
        };        
        t.start();
        
        
        return b;
        
    }
    
    public static String direccion(int dir)
    {
      
      if (dir==Direction.DOWN.getVal()) {
          return "Abj";
      }else if(dir==Direction.LEFT.getVal()) {
          return "Izq";
      }else if(dir==Direction.RIGHT.getVal()) {
          return "Der";
      }else if(dir==Direction.UP.getVal()) {
          return "Arr";
      }else if(dir==Direction.LEFTDDOWN.getVal()) {
          return "DiIzqAbj";
      }else if(dir==Direction.LEFTDUP.getVal()) {
          return "DiIzqArr";
      }else if(dir==Direction.RIGHTDDOWN.getVal()) {
          return "DiDerAbj";
      }else{
          return "DiDerArr";
      }
    }
    
    public static String direcciones(int dir)
    {
        int mask=0x1;
        
        String str="";

        for (int i=0; i<8; i++) {
           if ((dir & mask) != 0) str+= direccion(dir)+", ";
           mask = (mask << 1);
       }
        
        return str;
    }
    
    static void esperar_tirada()
    {
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {}
        
    }
    
    
    public static void main (String [] args) throws InterruptedException
    {
        // Declarar GUI
        Board b = start_gui_and_board();        
        esperar_tirada(); // Sincronitzacio threads
        
        
        // Declarar jugadors
        jugador1 = new Random();
        jugador2 = new Random();       
        gui.setPlayers(jugador1.name(), jugador2.name());
        
        int turn = 1; // 1 = jugador 1 / 0 = jugador 2
                             // 1 = color_j1 / -1 = color_j2
        
        boolean acabat = false;
        while (!acabat)
        {
            gui.setStatus(Integer.toString(b.getQuantityOfPiecesOnBoard())+" PECES");
            System.out.println("Turn num " + turn);
            Vector<Pair<Point, Integer>> moviments = b.getMovements(turn);
            gui.pinta_tauler(b,moviments);
            b.drawBoard();
            if (turn == 1) gui.setTurn(jugador1.name());
            else gui.setTurn(jugador2.name());
            if (turn==1)
            {
                
                
                if (jugador1 instanceof Manual){
                    System.out.println("MOVIMENTS POSSIBLES : ");
                    System.out.println(moviments);
                    esperar_tirada();
                    
                    //Vector<Pair<Point, Integer>> list = b.getMovements(turn);
                    //java.util.Random rnd = new java.util.Random();
                    //b.add(list.get(rnd.nextInt(list.size()-1)), turn);
                    System.out.println("Manual Ha tirat : ");
                    Point p = gui.getPoint();
                    
                    System.out.println("Punto elegido : " + p.toString());
                    
                    
                    boolean valid = false;
                    int i=0;                    
                    while (!valid){
                        System.out.println("moviments:"+moviments+" punt:"+p);
                        while (i<moviments.size() && !valid){
                            if (moviments.get(i).getKey().getX() == p.getX() && moviments.get(i).getKey().getY() == p.getY()){
                                valid = true;
                                System.out.println("ES VALID");
                            }
                            else ++i; 
                            
                        }
                        
                        if (!valid){
                            System.out.println("SOY ILEGAL");
                            esperar_tirada();
                            p = gui.getPoint();
                            i=0;
                        }                        
                                               
                    }
                    
                    System.out.println("Direcciones " + direcciones(moviments.get(i).getValue()));
                    b.add(new Pair(p,moviments.get(i).getValue()), turn);
                    System.out.println(p.toString());
                    
                }
                else{ // Qualsevol altre jugador
                    Pair<Point, Integer> aux=jugador1.movement(b, 1);
                    System.out.println(jugador1.name()+" ha tirat en " + aux.getKey().toString());
                    
                    b.add(aux, turn);
                    
                }
            }
            else{
                if (jugador2 instanceof Manual){
                    System.out.println("MOVIMENTS POSSIBLES : ");
                    System.out.println(moviments);
                    esperar_tirada();
                    
                    //Vector<Pair<Point, Integer>> list = b.getMovements(turn);
                    //java.util.Random rnd = new java.util.Random();
                    //b.add(list.get(rnd.nextInt(list.size()-1)), turn);
                    System.out.println("Manual Ha tirat : ");
                    Point p = gui.getPoint();
                    
                    boolean valid = false;
                    int i=0;                    
                    while (!valid){
                        while (i<moviments.size() && !valid){
                            if (moviments.get(i).getKey().getX() == p.getX() && moviments.get(i).getKey().getY() == p.getY()){
                                valid = true;
                                System.out.println("ES VALID");
                            }
                            else ++i; 
                            
                        }
                        
                        if (!valid){
                            esperar_tirada();
                            p = gui.getPoint();
                            i=0;
                        }                        
                                               
                    }
                    System.out.println("Punto elegido : " + p.toString());
                    System.out.println("Direcciones " + direcciones(moviments.get(i).getValue()));
                    
                    
                    b.add(new Pair(p,moviments.get(i).getValue()), turn);
                    System.out.println(p.toString());
                }
                else{
                    Pair<Point, Integer> aux=jugador2.movement(b, 1);
                    System.out.println(jugador2.name()+" ha tirat en " + aux.getKey().toString());
                    
                    b.add(aux, turn);
                    
                    
                    
                }
            }
            
            // COMPROVAR SI PUEDE TIRAR
            
            
            turn *= -1;
            
            if (b.isOver()) acabat = true;
            // COMPROVAR SI S'HA ACABAT EL JOC
            
            
        }
     
    }
    
}
