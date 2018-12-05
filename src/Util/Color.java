/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author itiel
 */

public enum Color {
    WHITE(-1),
    BLACK(1),
    EMPTY(0);
    
    private final int color;
    
    Color(int color) 
    {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
  
    public boolean equals(int color)
    {
        return color == getColor();
    }
}


