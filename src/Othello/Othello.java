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
    
    static void esperar_tirada()
    {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException ex) {}
        
    }
    
    
    public static void main (String [] args) throws InterruptedException
    {
        // Declarar GUI
        Board b = start_gui_and_board();
        
        esperar_tirada(); // Sincronitzacio threads
        
        
        
        
        
        // Declarar jugadors
        jugador1 = new LloydC();
        jugador2 = new Manual();
        
        boolean turn = true; // 1 = jugador 1 / 0 = jugador 2
                             // 1 = color_j1 / -1 = color_j2
        
        boolean acabat = false;
        while (!acabat)
        {
            if (turn)
            {
                if (jugador1 instanceof Manual){
                    esperar_tirada();
                    System.out.println("Manual Ha tirat : ");
                    Point p = gui.getPoint();
                    System.out.println(p.toString());
                    
                }
                else{ // Qualsevol altre jugador
                    Point p = jugador1.movement(b, 1);
                    System.out.println(jugador1.name()+" ha tirat en " + p.toString());
                    
                    gui.pinta_tauler(b);
                }
            }
            else{
                if (jugador2 instanceof Manual){
                    esperar_tirada();
                    System.out.println("Manual Ha tirat : ");
                    Point p = gui.getPoint();
                    System.out.println(p.toString());
                }
                else{
                    Point p = jugador2.movement(b, -1);
                    System.out.println(jugador2.name()+" ha tirat en " + p.toString());
                    gui.pinta_tauler(b);
                    
                    
                }
            }
            turn = !turn;
            
            
        }
     
    }
    
}
