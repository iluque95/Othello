/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Logic.Board;
import java.util.Vector;
import Util.*;
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
    
    
    
    public Movement movement(Board t, int color){
        //Board ha de tener movimientos, los pasamos calculados o los recalculamos en player, los ponemos como atributo de board?
        Vector<Movement> list = t.getMovements(color);
        
        Movement p;
        
        System.out.println("LIST.SIZE = " + list.size());
        
        
        p = list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
        
       // ThreadLocalRandom.current().nextI
        
        
        return p;
    }   
}
