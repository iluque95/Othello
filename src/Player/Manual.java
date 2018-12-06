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
public class Manual implements Player{
    
    public String name()
    {
        return "manual";      
        
    }
    
    public Point movement(Board t, int color)
    {
        
        return new Point(2,2);
                
    }
    
    
    
}
