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
    
    
    public static void main (String [] args)
    {
        
        GUI gui = new GUI();
        gui.setVisible(true);
        
        jugador1 = new Manual();
        jugador2 = new Manual();
        
        Point p = null;
        
        while (p==null) p = gui.getMovement();
        
        System.out.println("Surto amb punt : ");
        System.out.println(p.getX()+" " + p.getY());
        
        
        
        
        
        
        
        
        
        
    }
    
}
