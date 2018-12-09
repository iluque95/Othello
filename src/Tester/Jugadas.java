/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Logic.OthelloData;
import Logic.OthelloMove;
import static Tester.Board.direcciones;
import Util.Point;
import java.util.Vector;
import javafx.util.Pair;
import Util.Color;
import Util.Direction;
import java.util.Iterator;

/**
 *
 * @author marti
 */
public class Jugadas {
    public static void main(String args[]) {
        
        Vector<Pair<Point, Integer>> fichicas = new Vector();
        
        fichicas.add(new Pair(new Point(2,2), Color.BLACK.getColor()));
        
        fichicas.add(new Pair(new Point(3,2), Color.WHITE.getColor()));


        fichicas.add(new Pair(new Point(2,3), Color.WHITE.getColor()));
        
        fichicas.add(new Pair(new Point(1,2), Color.WHITE.getColor()));
        
        fichicas.add(new Pair(new Point(1,1), Color.WHITE.getColor()));
        
        fichicas.add(new Pair(new Point(0,1), Color.WHITE.getColor()));
        
        fichicas.add(new Pair(new Point(0,2), Color.WHITE.getColor()));
        
        fichicas.add(new Pair(new Point(0,3), Color.BLACK.getColor()));
        
        
        
        OthelloData od = new OthelloData(fichicas);
        OthelloMove om = new OthelloMove(od);
        
        od.drawBoard();
        
                System.out.println("Black: "+Color.BLACK.getColor());
        System.out.println("White: "+Color.WHITE.getColor());
        
        Vector<Pair<Point,Integer>> moves = om.getMovements(Color.BLACK.getColor());
        
        System.out.println("\nSe han encontrado "+moves.size()+" movimientos;");
        
        Iterator<Pair<Point,Integer>> itr = moves.iterator();
        while(itr.hasNext()){
            Pair<Point,Integer> tmp = itr.next();
            System.out.println(tmp.getKey() +" Con movimientos en las direcciones: " + Direction.getDirs(tmp.getValue()));
        }
        
        
        od.add(new Point(0,0), 130, Color.BLACK.getColor());
        
        od.drawBoard();
        
        
    
        
        
    }
}
