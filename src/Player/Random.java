/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Logic.Board;
import Util.Direction;
import Util.Point;
import java.util.Vector;
import javafx.util.Pair;

public class Random implements Player{
    private final String name = "Random";
    public movement(Board t, int color){
        //Pedir movimientos posibles con BOARD
        Vector<Pair<Point, Direction>> moves;//Pedir en board;
        java.util.Random rnd = new java.util.Random();
        return moves.get(0+rnd.nextInt(moves.size()-1));  
    }
}
