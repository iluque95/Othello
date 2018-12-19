/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Player;

import epsevg.eu.Othello.Player.Interface.Player;
import epsevg.eu.Othello.Base.Movement;
import epsevg.eu.Othello.Logic.Board;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author heri
 */
public class Random implements Player {
    @Override
    public String name()
    {
        return "Random";      
    }
    
    @Override
    
    
    
    public int movement(Board t, int color){
        //Board ha de tener movimientos, los pasamos calculados o los recalculamos en player, los ponemos como atributo de board?
        Vector<Movement> list = t.getMovements(color);        
        return ThreadLocalRandom.current().nextInt(0, list.size());
    }   
}
