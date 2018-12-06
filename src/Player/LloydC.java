/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Logic.Board;
import Util.Point;

/**
 *
 * @author marti
 */
public class LloydC implements Player{
    
     public String name()
    {
        return "LloydC";      
        
    }
    
    public Point movement(Board t, int color)
    {
        
        return new Point(1,2);
                
    }
    
}
