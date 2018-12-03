/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import Logic.OthelloData;
import Util.EXIT_CODE;

/**
 *
 * @author itiel
 */
public class Board {
    public static void main(String args[]) {
        OthelloData od = new OthelloData();
        
       // od.add(2, 5, 2);
        
        //od.drawBoard();
        
        EXIT_CODE exit_code = new EXIT_CODE();
        
        System.out.println(exit_code.A);
    }
}
