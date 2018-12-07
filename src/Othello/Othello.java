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
    /**
    * Asks to GUI for a valid movement of manual player
    */
    private static Pair<Point, Integer> ManPlay(Vector<Pair<Point, Integer>> moviments){
        esperar_tirada();
        Point p = gui.getPoint();
        boolean valid = false;
        int i = 0;
        while(!valid){
            i = 0;
            while (i<moviments.size() && !valid){
                if (moviments.get(i).getKey().getX() == p.getX() && moviments.get(i).getKey().getY() == p.getY()){
                    valid = true;
                }
                else ++i; 
            }
            if (!valid){
                esperar_tirada();
                p = gui.getPoint();                
            } 
        }
        return moviments.get(i);
    }
    
    public static void main (String [] args) throws InterruptedException
    {
        // Declarar GUI
        Board b = start_gui_and_board();        
        esperar_tirada(); // Sincronitzacio threads
        
        
        // Declarar jugadors
        jugador1 = new Manual();
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
            if (turn==1 && !moviments.isEmpty())
            {
                
                
                if (jugador1 instanceof Manual){
                    
                    b.add(ManPlay(moviments),turn);                    
                }
                else{ // Qualsevol altre jugador
                    Pair<Point, Integer> aux=jugador1.movement(b, 1);
                    System.out.println(jugador1.name()+" ha tirat en " + aux.getKey().toString());
                    b.add(aux, turn);
                    
                }
            }
            else if( !moviments.isEmpty()){
                if (jugador2 instanceof Manual){
                    b.add(ManPlay(moviments),turn);                    
                }
                else{
                    Pair<Point, Integer> aux=jugador2.movement(b, 1);
                    System.out.println(jugador2.name()+" ha tirat en " + aux.getKey().toString());
                    
                    b.add(aux, turn);
                    
                    
                    
                }
            }
            
            // COMPROVAR SI PUEDE TIRAR Hacer notificar a GUI de modo visual
            if(moviments.isEmpty()){
                System.out.println("No moves for this player");
                if(b.getMovements(-turn).isEmpty()){
                    System.out.println("Geim ober. There's no moves for any player");
                    break; //Bernie :****
                }
            }
            turn *= -1;
            
            if (b.isOver()) acabat = true;
            // COMPROVAR SI S'HA ACABAT EL JOC
            
            
        }
     
    }
    
}
