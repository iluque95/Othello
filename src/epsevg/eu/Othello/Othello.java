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
import epsevg.eu.Othello.Base.Options;
import epsevg.eu.Othello.Util.Point;
import epsevg.eu.Othello.Logic.Board;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javazoom.jl.decoder.JavaLayerException;

public class Othello {
     
   /* RELACIONATS AMB EL JOC*/
    
    private static Player jugador1,jugador2;    
    private static Options exjugadors;   
    private static int n_turnos;
    
    /* FUNCIONAMENT DEL JOC */
    
    private static volatile GUI gui;
    private static Repeat p;    
    private static Thread t;
    private static Pick pi;
    
    /* TESTING */
    private static boolean testing;
    
    
    
    /**
     * Private method its goal is to set up GUI
     * and a brand new board
     * @return Returns the new board
     */
    private static Board start_gui_and_board()
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
    
    
    /**
     * Private method its goal is to wait
     * for the Manual player to chose a position
     */    
    private static void esperar_tirada()
    {
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {}
    }
    
    /**
     * 
     * @param b Games' board
     * @param j1 First Player
     * @param j2 Seond Player
     * @return Game's winner
     */
    private static String getWinner(Board b, Player j1, Player j2)
    {
        int p_j1 = b.getQuantityOfPieces(Color.BLACK.getColor()); // Peces jugador negre
        int p_j2 = b.getQuantityOfPieces(Color.WHITE.getColor()); // Peces jugador blanc
        
        if (p_j1 > p_j2) return "J1 "+j1.name();
        else if (p_j1 < p_j2) return "J2 "+j2.name();
        else return "DRAW";
    }
    
    
    /**
     * Private method its aim is to return the Point which
     * a Manual Player has chosen.
     * @param b Board
     * @return Point chosen by a manual player
     */
    private static int ManPlay(Board b){
        esperar_tirada();
        Point p = gui.getPoint();
        while(!b.isValid(p)){
            esperar_tirada();
            p = gui.getPoint();
        }
        return b.getPointPos(p);
    }
    
    /**
     * Private method its aim is to control the flow
     * of the turns
     * @param b Board
     * @param turn Most recent turn
     * @param moviments Vector of possible movements
     * @param jugador Player which turn belong to him
     * @throws CloneNotSupportedException 
     */
    private static void tirar_jugada(Board b, int turn, Vector<Movement> moviments, Player jugador) throws CloneNotSupportedException {
        if (jugador instanceof Manual){
            b.add(ManPlay(b),turn);
        }
        else{ // Qualsevol altre jugador
            b.add(jugador.movement(b, turn), turn);

        }
    }
    
    /**
     * 
     * @param b Actual Board
     * @param j1 Player 1
     * @param j2 Player 2
     * @return Whether there's gonna be a next game
     */
    private static boolean checkNextGame(Board b, Player j1, Player j2)
    {
         Thread mainThread = Thread.currentThread();
         
         String[] statistics = new String[5];
         
         statistics[0] = Integer.toString(n_turnos); 
         statistics[1] = Integer.toString(b.getBlackPieces().size());
         statistics[2] = Integer.toString(b.getWhitePieces().size());
         statistics[3] = getWinner(b,j1,j2);
         statistics[4] = Integer.toString(b.getQuantityOfPiecesOnBoard());
         
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
        catch(Exception e){}
        
        try{ // ESPERANT ELECCIÓ
            Thread.sleep(Integer.MAX_VALUE);
            }
            catch(Exception e){}
        
        
        boolean exit = !gui.getRepeat();
        p.dispatchEvent(new WindowEvent(p, WindowEvent.WINDOW_CLOSING));
        if (!exit) b.reset(); // RESET OTHELLO DATA ATRIBUTOS        
        return exit;
        
    }
    
    
    /**
     * Private method its aim is to chose the players
     * which will take part into the game
     * @throws IOException
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws InterruptedException 
     */
    private static void pickPlayers() throws IOException, FileNotFoundException, JavaLayerException, InterruptedException
    {
        // Crear Thread
         Thread currentThread = Thread.currentThread();         
        // Encarregat de crear Pick Object
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
        
        
        Pair <String[],String[]> aux = pi.getChoice();
        
        if (null != aux.getKey()) switch (aux.getKey()[0]) {
            case "Manual":
                jugador1 = new Manual();
                break;
            case "Random":
                jugador1 = new Random();
                break;
            case "LloydC":
                jugador1 = new LloydC(Integer.parseInt(aux.getKey()[1]));
                break;
            default:
                break;
        }
        
        if (null != aux.getValue()) switch (aux.getValue()[0]) {
            case "Manual":
                jugador2 = new Manual();
                break;
            case "Random":
                jugador2 = new Random();
                break;
            case "LloydC":
                jugador2 = new LloydC(Integer.parseInt(aux.getValue()[1]));
                break;
            default:
                break;
        }
        
        
        // ACTUALITZAR PER SI ES TORNA A JUGAR
        String[] jugadors_a = new String[2];
        jugadors_a[0] = jugador1.name();
        jugadors_a[1] = jugador2.name();
        
        int[] profunditats = new int[2];
        profunditats[0] = Integer.parseInt(aux.getKey()[1]);
        profunditats[1] = Integer.parseInt(aux.getValue()[1]);
        
        
        exjugadors = new Options (jugadors_a,profunditats);
        
        
        // REESTABLIR ETIQUETES        
        gui.resetLabels();
        
    }
    
    
    /**
     * Public method which controls all the flow 
     * of the execution of Othello
     * @param args Empty
     * @throws InterruptedException
     * @throws CloneNotSupportedException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws JavaLayerException 
     */
    public static void main (String [] args) throws InterruptedException, CloneNotSupportedException, IOException, FileNotFoundException, JavaLayerException
    {        
        boolean exit = false;        
        /* ATRIBUTS TESTING*/
        testing = false; // SET THIS TO TRUE TO TEST
        int v = 1000; // Nombre de vegades bucle (Testing)
        int g1 = 0;
        int g2 = 0;
        int draw = 0;
        /* FI ATRIBUTS TESTING*/        
        // Declarar GUI
        Board b = start_gui_and_board();        
        esperar_tirada(); // Sincronitzacio threads        
        exjugadors = null; // NO tenim exjugadors
        
        while (!exit)
        {
            if (!testing) pickPlayers(); // Assignem nous jugadors i ens els guardem per la seguent partida 
            else{
                // --------------- TESTING ----------------------Establim jugadors per a fer estadistiques
               jugador1 = new LloydC(0);
               jugador2 = new Random();
               
               //   jugador1 = new Random();
               //   jugador2 = new LloydC(0,false);
               
            }            
            n_turnos = 0;            
            gui.setPlayers(jugador1.name(), jugador2.name());
            
            boolean acabat = false;
            while (!acabat)
            {
                b.nextTurn();
                ++n_turnos;
                /* ESTABLECER PARAMETROS GUI */
                gui.setStatus(Integer.toString(b.getQuantityOfPiecesOnBoard())+" PECES");
                Vector<Movement> moviments = b.getMovements(b.getTurn());
                gui.pinta_tauler(b,moviments);
                if (b.getTurn() == 1) gui.setTurn("J1 : "+jugador1.name(),b.getTurn());
                else gui.setTurn("J2 : "+jugador2.name(),b.getTurn());
                gui.setNumPieces(b.getQuantityOfPieces(Color.BLACK.getColor()), b.getQuantityOfPieces(Color.WHITE.getColor()));
                /* FIN ESTABLECER PARAMETROS GUI */                
                gui.setVisible(true);
                
                // COMPROVAR SI PUEDE TIRAR Hacer notificar a GUI de modo visual
                if(moviments.isEmpty()){
                    System.out.println("No moves for this player");
                    if(b.getMovements(-b.getTurn()).isEmpty()){
                        System.out.println("Geim ober. There's no moves for any player");
                        acabat = true;
                    }
                }
                else{
                    if (b.getTurn()==1 && !moviments.isEmpty())
                    {
                        tirar_jugada(b, b.getTurn(), moviments, jugador1);
                    }
                    else if( !moviments.isEmpty()){ // Tira jugador2
                        tirar_jugada(b, b.getTurn(), moviments, jugador2);
                    }
                }
            }
            --v;
            gui.setWinner(getWinner(b,jugador1,jugador2));                
            if (!testing) exit = checkNextGame(b,jugador1,jugador2);
            else exit = (v==0);            
            if (testing)
            {                
                String gu = getWinner(b,jugador1,jugador2);
                if (gu.substring(gu.indexOf(' ')+1,gu.length()).equals(jugador1.name())) g1++;
                else if (gu.substring(gu.indexOf(' ')+1,gu.length()).equals(jugador2.name())) g2++;                
                else if(gu.equals("DRAW")) draw++;                
                if (v==0)
                {// Escriure estadistiques
                    try {
                        final Path path = Paths.get("Statistics "+jugador1.name()+" VS "+jugador2.name()+".txt");
                        Files.write(path, Arrays.asList(" J1 "+jugador1.name()+": "+g1+" WINS | J2 "+jugador2.name()+": "+g2+" WINS | DRAW : "+draw), StandardCharsets.UTF_8,
                        Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
                        }
                        catch (final IOException ioe) {}                    
                }
                else{
                    b.reset();
                    gui.resetLabels();
                }                
            }                
        }
        gui.dispatchEvent(new WindowEvent(gui,WindowEvent.WINDOW_CLOSING));        
    }    
}