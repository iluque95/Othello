/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author itiel
 * 
 * Este enum funciona con 8 bits representando todas las posibles direcciones.
 * Para determinar las direcciones simplemente se tendrá que hacer una or arithmetica
 * entre todas las posibles direcciones.
 * Para ir recuperando cada una de ellas es tan facil como aplicarle una and arithmetica
 * con la dirección que se quiere saber si existe solución.
 */
public enum Direction {
    LEFT(0x1), RIGHT(0x2), UP(0x4), DOWN(0x8), LEFTDUP(0x10), RIGHTDUP(0x20), LEFTDDOWN(0x40), RIGHTDDOWN(0x80);
    
    private int val;
    
    private Direction(int val)
    {
        this.val = val;
    }
    
    public int getVal()
    {
        return val;
    }
}
