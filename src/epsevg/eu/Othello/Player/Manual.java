/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Player;

import epsevg.eu.Othello.Player.Interface.Player;
import epsevg.eu.Othello.Logic.Board;
import epsevg.eu.Othello.Base.Movement;
import java.util.Vector;

/**
 *
 * @author marti
 */
public class Manual implements Player{
    
    public String name()
    {
        return "Manual";
        
    }
    
    @Override
    public int movement(Board t, int color)
    {       
          //Board ha de tener movimientos, los pasamos calculados o los recalculamos en player, los ponemos como atributo de board?
        Vector<Movement> list = t.getMovements(color);
        //Jelp to quitar this shit joder, me deja hacer import por que me dice que ya esta importado, y si no lo import no lo understend pa nah
        java.util.Random rnd = new java.util.Random();
        return rnd.nextInt(list.size()-1);
                
    }
    
    
    
}
