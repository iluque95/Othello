/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello;

import GUI.*;
import Player.*;
import Util.*;

/**
 *
 * @author marti
 */
public class Othello {
    
    static Player jugador1,jugador2;
    
    static GUI gui;
    
    
    public static void main (String [] args) throws InterruptedException
    {
        
        Thread m = Thread.currentThread();
        
        
        Thread t = new Thread()
        {
            public void run()
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI(m);
                gui.setVisible(true);
            }
            });
                
            }
        };
        
        t.start();
        
        try {
            System.out.println("Vaig a dormir");
            Thread.sleep(300000);
        } catch (InterruptedException ex) {
        System.out.println("I'm resumed");
        }
        
        System.out.println("HEHHEHSHS");
        
        
        
        
        
        
        
        
        
        
        
        
        
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI();
                gui.setVisible(true);
            }
        });*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
