/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Logic.OthelloData;
import Logic.OthelloMove;
import Util.Point;
import Util.Color;
import Util.Direction;
import java.util.Iterator;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author itiel
 */
public class Board {
    
    
    public static String direccion(int dir)
    {
      
      if (dir==Direction.DOWN.getVal()) {
          return "Abj";
      }else if(dir==Direction.LEFT.getVal()) {
          return "Izq";
      }else if(dir==Direction.RIGHT.getVal()) {
          return "Der";
      }else if(dir==Direction.UP.getVal()) {
          return "Arr";
      }else if(dir==Direction.LEFTDDOWN.getVal()) {
          return "DiIzqAbj";
      }else if(dir==Direction.LEFTDUP.getVal()) {
          return "DiIzqArr";
      }else if(dir==Direction.RIGHTDDOWN.getVal()) {
          return "DiDerAbj";
      }else{
          return "DiDerArr";
      }
    }
    
    public static String direcciones(int dir)
    {
        int mask=0x1;
        
        String str="";

        for (int i=0; i<8; i++) {
           if ((dir & mask) != 0) str+= direccion(dir)+", ";
           mask = (mask << 1);
       }
        
        return str;
    }
    
    public static void main(String args[]) {
        OthelloData od = new OthelloData();
        OthelloMove om = new OthelloMove(od);
        
       // od.add(2, 5, 2);
        
        //od.drawBoard();
        
        
        
        // PRUEBAS CON BITS Y MASCARAS

        int mask = 0xFE;

        /*
        1000 0000

        0000 0001
        ---------
        1000 0001

        */

        int valor = 0x1 | 0x2 | 0x4 | 0x8 | 0x10 | 0x20 | 0x40 | 0x80;
        int mascara = 0x1;

        System.out.println("Valor es " + valor + ", aplicando máscara: " + (valor & mascara));

        for (int i=0; i<8; i++) {
           System.out.println("Mask: " + mask + " Val: " + (mask % 2) ); 
           mask = mask >> 1;
        }
        
        
        
        
        System.out.println("\nOthello moves: ");
        
        od.drawBoard();
        System.out.println("Black: "+Color.BLACK.getColor());
        System.out.println("White: "+Color.WHITE.getColor());
        
        Vector<Pair<Point,Integer>> moves = om.getMovements(Color.BLACK.getColor());
        
        System.out.println("\nSe han encontrado "+moves.size()+" movimientos;");
        
        Iterator<Pair<Point,Integer>> itr = moves.iterator();
        while(itr.hasNext()){
            Pair<Point,Integer> tmp = itr.next();
            System.out.println(tmp.getKey() +" Con movimientos en las direcciones: " + direcciones(tmp.getValue()));
        }
         
        
    }
}
