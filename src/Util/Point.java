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
public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean validPoint()
    {
        return getX()!=-1 && getY()!=-1;
    }
    
    
    
    @Override
    public boolean equals(Object obj){ 
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return this.x + (this.y<<1);
    }
    
    @Override
    public String toString()
    {
        return "("+x+", "+y+")";
    }
    
    
}
