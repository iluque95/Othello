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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;

public class Othello {
    /* CLASE PRINCIPAL*/
    
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
                try {
                    gui = new GUI(m);
                } catch (IOException ex) {
                    Logger.getLogger(Othello.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Othello.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {}
        
    }
    
    
    static String getWinner(Board b, Player j1, Player j2)
    {
        int p_j1 = b.getQuantityOfPieces(Color.BLACK.getColor()); // Peces jugador negre
        int p_j2 = b.getQuantityOfPieces(Color.WHITE.getColor()); // Peces jugador blanc
        
        if (p_j1 > p_j2) return "J1 "+j1.name();
        else if (p_j1 < p_j2) return "J2 "+j2.name();
        else return "DRAW";
    }
    /**
    * Asks to GUI for a valid movement of manual player
    */
    private static Movement ManPlay(Vector<Movement> moviments){
        esperar_tirada();
        Point p = gui.getPoint();
        boolean valid = false;
        int i = 0;
        while(!valid){
            i = 0;
            while (i<moviments.size() && !valid){
                if (moviments.get(i).getPosition().getX() == p.getX() && moviments.get(i).getPosition().getY() == p.getY()){
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
    
    public static void main (String [] args) throws InterruptedException, CloneNotSupportedException
    {
        // Declarar GUI
        Board b = start_gui_and_board();        
        esperar_tirada(); // Sincronitzacio threads
        
        
        // Declarar jugadors
        jugador1 = new Random();
        jugador2 = new Manual();       
        gui.setPlayers(jugador1.name(), jugador2.name());
        
        int turn = 1; // 1 = jugador 1 / 0 = jugador 2
                             // 1 = color_j1 / -1 = color_j2
                            
        
        boolean acabat = false;
        while (!acabat)
        {
            /* ESTABLECER PARAMETROS GUI */
            gui.setStatus(Integer.toString(b.getQuantityOfPiecesOnBoard())+" PECES");
            Vector<Movement> moviments = b.getMovements(turn);
            gui.pinta_tauler(b,moviments);
            if (turn == 1) gui.setTurn("J1 : "+jugador1.name(),turn);
            else gui.setTurn("J2 : "+jugador2.name(),turn);
            gui.setNumPieces(b.getQuantityOfPieces(Color.BLACK.getColor()), b.getQuantityOfPieces(Color.WHITE.getColor()));
            /* FIN ESTABLECER PARAMETROS GUI */
            
            // COMPROVAR SI PUEDE TIRAR Hacer notificar a GUI de modo visual
            if(moviments.isEmpty()){
                System.out.println("No moves for this player");
                if(b.getMovements(-turn).isEmpty()){
                    System.out.println("Geim ober. There's no moves for any player");
                    acabat = true;
                }
            }
            
            else{
                
                if (turn==1 && !moviments.isEmpty())
                {
                    tirar_jugada(b, turn, moviments, jugador1);
                }
                else if( !moviments.isEmpty()){ // Tira jugador2
                    tirar_jugada(b, turn, moviments, jugador2);
                }
                
            }
            
            turn*=-1;
            
        }
        
        gui.setWinner(getWinner(b,jugador1,jugador2));
        
        
        
        
        
        
        
    }

    private static void tirar_jugada(Board b, int turn, Vector<Movement> moviments, Player jugador) {
        if (jugador instanceof Manual){
            b.add(ManPlay(moviments),turn);
            Point p = gui.getPoint();
            System.out.println("Punto elegido : " + p.toString());

        }
        else{ // Qualsevol altre jugador
            Movement aux= jugador.movement(b, turn);
            System.out.println(jugador1.name()+" ha tirat en " + aux.getPosition().toString());
            b.add(aux, turn);

        }
    }

}
