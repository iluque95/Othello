/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello;

import epsevg.eu.Othello.Player.Random;
import epsevg.eu.Othello.Player.Manual;
import epsevg.eu.Othello.Player.LloydC;
import epsevg.eu.Othello.GUI.Repeat;
import epsevg.eu.Othello.GUI.GUI;
import epsevg.eu.Othello.GUI.Pick;
import epsevg.eu.Othello.Player.Interface.Player;
import epsevg.eu.Othello.Util.Color;
import epsevg.eu.Othello.Base.Movement;
import epsevg.eu.Othello.Util.Point;
import epsevg.eu.Othello.Logic.Board;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javazoom.jl.decoder.JavaLayerException;

public class Othello {
    /* CLASE PRINCIPAL*/
    
    public Othello(){
        
    }
    
    static Player jugador1,jugador2;
    static String exjugadors[];
    public boolean go = false;
    
    static volatile GUI gui;
    static Repeat p;
    
    static Thread t;
    static Pick pi;
    
    static int n_turnos;
    
    
    static Board start_gui_and_board()
    {
        Board b = new Board();
        Thread m = Thread.currentThread();        
        t = new Thread()
        {
            public void run()
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    gui = new GUI(m);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();                                        
                    gui.setLocation(dim.width/2-gui.getSize().width/2,dim.height/2-gui.getSize().height/2);
                } catch (IOException ex) {
                    Logger.getLogger(Othello.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Othello.class.getName()).log(Level.SEVERE, null, ex);
                }
                gui.updateBoard(b);        
                
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
    private static int ManPlay(Board b){
        esperar_tirada();
        Point p = gui.getPoint();
        while(!b.isValid(p)){
            esperar_tirada();
            p = gui.getPoint();
            System.out.println(p);
            
        }
       
        return b.getPointPos(p);
    }
    
     private static void tirar_jugada(Board b, int turn, Vector<Movement> moviments, Player jugador) {
        if (jugador instanceof Manual){
            b.add(ManPlay(b),turn);
        }
        else{ // Qualsevol altre jugador
            b.add(jugador.movement(b, turn), turn);

        }
    }
    
    private static boolean checkNextGame(Board b, Player j1, Player j2)
    {
         Thread mainThread = Thread.currentThread();
         
         String[] statistics = new String[5];
         
         statistics[0] = Integer.toString(n_turnos);
         statistics[1] = Integer.toString(b.getBlackPieces().size());
         statistics[2] = Integer.toString(b.getWhitePieces().size());
         statistics[3] = getWinner(b,j1,j2);
         statistics[4] = Integer.toString(b.getQuantityOfPiecesOnBoard());
         
         
        
         // statistics[0] = num_turnos
         // statistics[1] = num_pieces_black
         // statistics[2] = num_pieces_white
         // statistics[3] = guanyador
         // statistics[4] = num_pieces_total
         
         new Thread()
         {
             public void run()
             {
                 java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run(){
                         p = new Repeat(gui, true,mainThread,statistics);
                         p.setLocation(gui.getX()+40,gui.getY()+100);
                         p.setVisible(true);
                         
                     }
                 });
             }
         }.start();
         
        try{ // ESPERANT CONSTRUCCIO
            Thread.sleep(Integer.MAX_VALUE);
            }
        catch(Exception e){
            System.out.println("JA CONSTRUIT");}
        
        try{
            Thread.sleep(Integer.MAX_VALUE);
            }
            catch(Exception e){
                System.out.println("VALOR JA TRIAT");}
        
        
        boolean exit = !gui.getRepeat();
        p.dispatchEvent(new WindowEvent(p, WindowEvent.WINDOW_CLOSING));
        if (!exit) b.reset(); // RESETEAMOS ATRIBUTOS OTHELLO DATA
        
        return exit;
        
    }
    
    static private void pickPlayers() throws IOException, FileNotFoundException, JavaLayerException, InterruptedException
    {
        // Crear Thread
         Thread currentThread = Thread.currentThread();
         
        
        Thread tr = new Thread()
         {
             public void run()
             {
                 java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run(){
                         
                         try {
                             pi = new Pick(gui,true,currentThread,exjugadors);
                         } catch (IOException ex) {
                             Logger.getLogger(Othello.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         pi.setLocation(gui.getX()+40,gui.getY()+100);
                         pi.setVisible(true);
                         
                         
                     }
                 });
             }
         };
        
        tr.start();
        
        esperar_tirada(); // ESPERAR CONSTRUCCIO
        
        esperar_tirada(); // ESPERAR PER PICKEJAR
        
        System.out.println("TIRADA FETA");
        
        Pair<String,String> s=null;
        
        s = pi.getChoice();
        
        
        System.out.println("S = " + s);
        
        
        
        String u1 = s.getKey();
        String u2 = s.getValue();
        
        String user1,user2;
        int prof1=-1,prof2=-1;
        
        
        
        if (u1.length()>6){
            user1 = u1.substring(0,u1.indexOf("-"));
            System.out.println(u1.substring(u1.indexOf("-")+1,u1.length()));
            prof1 = Integer.parseInt(u1.substring(u1.indexOf("-")+1,u1.length()));            
        }
        
        else user1 = u1;
        
        if (u2.length()>6){
            user2 = u2.substring(0,u2.indexOf("-"));
            prof2 = Integer.parseInt(u2.substring(u2.indexOf("-")+1,u2.length()));
            
        }
        else user2 = u2;
        
        
        if (null != s.getKey()) switch (user1) {
            case "Manual":
                jugador1 = new Manual();
                break;
            case "Random":
                jugador1 = new Random();
                break;
            case "LloydC":
                jugador1 = new LloydC(prof1);
                break;
            default:
                break;
        }
        
        if (null != s.getValue()) switch (user2) {
            case "Manual":
                jugador2 = new Manual();
                break;
            case "Random":
                jugador2 = new Random();
                break;
            case "LloydC":
                jugador2 = new LloydC(prof2);
                break;
            default:
                break;
        }
        
        
        // RESTABLECER ETIQUETAS
        
        gui.resetLabels();
        
    }
    
    
    
    
    public static void main (String [] args) throws InterruptedException, CloneNotSupportedException, IOException, FileNotFoundException, JavaLayerException
    {
        
        
        boolean exit = false;
        
        // Declarar GUI
        Board b = start_gui_and_board();        
        esperar_tirada(); // Sincronitzacio threads
        
        exjugadors = new String[2];
        
        exjugadors[0] = exjugadors[1] = null;
        
        
        

        while (!exit)
        {
            
            pickPlayers();
            
            n_turnos = 0;
            
            gui.setPlayers(jugador1.name(), jugador2.name());

            int turn = 1; // 1 = jugador 1 / 0 = jugador 2
                                 // 1 = color_j1 / -1 = color_j2
            boolean acabat = false;
            while (!acabat)
            {
                
                ++n_turnos;
                /* ESTABLECER PARAMETROS GUI */
                gui.setStatus(Integer.toString(b.getQuantityOfPiecesOnBoard())+" PECES");
                Vector<Movement> moviments = b.getMovements(turn);
                gui.pinta_tauler(b,moviments);
                if (turn == 1) gui.setTurn("J1 : "+jugador1.name(),turn);
                else gui.setTurn("J2 : "+jugador2.name(),turn);
                gui.setNumPieces(b.getQuantityOfPieces(Color.BLACK.getColor()), b.getQuantityOfPieces(Color.WHITE.getColor()));
                /* FIN ESTABLECER PARAMETROS GUI */
                
                
                gui.setVisible(true);
                
                

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
                
            exit = checkNextGame(b,jugador1,jugador2);
            
            exjugadors[0] = jugador1.name();
            exjugadors[1] = jugador2.name();

        }
        gui.dispatchEvent(new WindowEvent(gui,WindowEvent.WINDOW_CLOSING));
    }

   int processors = Runtime.getRuntime().availableProcessors();

}
