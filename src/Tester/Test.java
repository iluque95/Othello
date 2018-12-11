/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Util.Point;
import Util.Direction;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javafx.util.Pair;

import Logic.*;
import Util.Movement;


/**
 *
 * @author itiel
 */
public class Test {
    public static void main(String args[]) throws CloneNotSupportedException {
        /*ArrayList<Point> v = new ArrayList<>();
        
        Point p1 = new Point(2,3);
        Point p2 = new Point(2,3);

        v.add(new Point(5,7));
        
        System.out.println("Contiene el punto? " + v.contains(new Point(5,7)));
        System.out.println("En que offset está? " + v.indexOf(new Point(5,7)));
        
        Iterator<Point> itr = v.iterator();
        while(itr.hasNext()){
            Point tmp = itr.next();
            System.out.println("Punto en "+tmp);
        }*/
        
        /* PRUEBAS CLONE */
        
        System.out.println("CLONAMOS TABLERO");
        
        
        Logic.Board b = new Logic.Board ();
        
        Movement c = new Movement (new Point(2,4), Direction.DOWN.getVal());
        b.add(c, -1);
        
        System.out.println("PRIMER TABLERO : ");
        System.out.println("WHITE : " + b.getWhitePieces());
        System.out.println("BLACK : " + b.getBlackPieces());
        b.drawBoard();
        
        
        Logic.Board copia = new Logic.Board(b);
        System.out.println("SEGUNDo TABLERO : ");
        System.out.println("WHITE : " + copia.getWhitePieces());
        System.out.println("BLACK : " + copia.getBlackPieces());
        
        
        //System.out.println("SEGUNDO TABLERO : ");
        copia.drawBoard();
        
        copia.add(new Movement (new Point(4,2), Direction.RIGHT.getVal()), 1);
        System.out.println("PRIMER TABLERO : ");
        System.out.println("WHITE : " + b.getWhitePieces());
        System.out.println("BLACK : " + b.getBlackPieces());
        
        
        System.out.println("SEGUNDo TABLERO : ");
        System.out.println("WHITE : " + copia.getWhitePieces());
        System.out.println("BLACK : " + copia.getBlackPieces());
        
        
        copia.drawBoard();
        
        System.out.println("PRIMERO ");
        b.drawBoard();
        
        
        
        
        
        //Movement c2 = new Movement (new Point(4,2),2);
       // copia.add(c2,1);
        
       // System.out.println("SEGUNDO TABLERO : ");
       // copia.drawBoard();
        
      //  System.out.println("PRIMER TABLERO:");
      //  b.drawBoard();
        
        
        
        

        
        
        
        
        
        
    }
}
