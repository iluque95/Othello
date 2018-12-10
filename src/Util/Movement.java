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
 * Determina qué es un movimiento.
 * 
 * Un movimiento es aquella jugada que el usuario puede realizar en su turno
 * formado de, una posición, una serie de direcciones en las que hace la jugada
 * y la cantidad de fichas que suma al realizar dicho movimiento.
 * 
 */
public class Movement {
    private Point position;
    private int color;
    private int directions;
    
    public Movement(Point position, int directions)
    {
       this.position = position;
       this.directions = directions;
    }

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @return the directions
     */
    public int getDirections() {
        return directions;
    }
    
    @Override
    public boolean equals(Object obj){ 
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return (this.getPosition().getX()<<4) + this.getPosition().getY();
    }
}
