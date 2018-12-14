/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Tester;

import epsevg.eu.Othello.Logic.OthelloData;
import epsevg.eu.Othello.Logic.OthelloMove;
import epsevg.eu.Othello.Util.Point;
import java.util.Vector;
import javafx.util.Pair;
import epsevg.eu.Othello.Util.Color;
import epsevg.eu.Othello.Util.Direction;
import epsevg.eu.Othello.Base.Movement;
import java.util.Iterator;

/**
 *
 * @author marti
 */
public class Jugadas {
    public static void main(String args[]) {
        
        Vector<Pair<Point, Integer>> fichicas = new Vector();
        
        fichicas.add(new Pair(new Point(2,3), Color.BLACK.getColor()));
        fichicas.add(new Pair(new Point(2,4), Color.BLACK.getColor()));
        fichicas.add(new Pair(new Point(1,5), Color.BLACK.getColor()));
        fichicas.add(new Pair(new Point(3,3), Color.BLACK.getColor()));
        fichicas.add(new Pair(new Point(4,3), Color.BLACK.getColor()));
        
        fichicas.add(new Pair(new Point(3,4), Color.WHITE.getColor()));
        fichicas.add(new Pair(new Point(4,4), Color.WHITE.getColor()));
        

        OthelloData od = new OthelloData(fichicas);
        OthelloMove om = new OthelloMove(od);
        
        od.drawBoard();
        
        System.out.println("Black: "+Color.BLACK.getColor());
        System.out.println("White: "+Color.WHITE.getColor());
        
        Vector<Movement> moves = om.getMovements(Color.BLACK.getColor());
        
        System.out.println("\nSe han encontrado "+moves.size()+" movimientos;");
        
        Iterator<Movement> itr = moves.iterator();
        while(itr.hasNext()){
            Movement tmp = itr.next();
            System.out.println(tmp.getPosition() +" Con movimientos en las direcciones: " + Direction.getDirs(tmp.getDirections()));
        }
        
        
        //od.add(new Point(0,0), 130, Color.BLACK.getColor());
        
        //od.drawBoard();


        Vector<Movement> pichas = null;

        System.out.println("El vector tiene tamaño "+pichas.size());
    
        
        
    }
}
