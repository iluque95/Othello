/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Util.Point;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author itiel
 */
public class Test {
    public static void main(String args[]) {
        ArrayList<Point> v = new ArrayList<>();
        
        Point p1 = new Point(2,3);
        Point p2 = new Point(2,3);

        v.add(new Point(5,7));
        
        System.out.println("Contiene el punto? " + v.contains(new Point(5,7)));
        System.out.println("En que offset está? " + v.indexOf(new Point(5,7)));
        
        Iterator<Point> itr = v.iterator();
        while(itr.hasNext()){
            Point tmp = itr.next();
            System.out.println("Punto en "+tmp);
        }
    }
}
