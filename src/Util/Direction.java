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
    
    private static String dirToString(int dir)
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
      }else if (dir==Direction.RIGHTDUP.getVal()) {
          return "DiDerArr";
      }else{
          return "Undefined dir 0x"+Integer.toHexString(dir);
      }
    }
    
    public static String getDirs(int dir)
    {
        int mask=0x1;
        
        String str="";

        for (int i=0; i<8; i++) {
           if ((dir & mask) != 0) str+= dirToString(mask)+", ";
           mask = (mask << 1);
       }
        
        return str;
    }
}
