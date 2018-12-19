/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Logic;

import epsevg.eu.Othello.Base.Movement;
import epsevg.eu.Othello.Util.Point;
import java.util.Vector;

/**
 *
 * @author marti
 */
public class Board {
    
    private OthelloData data;
    public OthelloMove move;
    private Vector<Movement> movements;
    
    private int turn;
    
    public Board()
    {
        turn = -1;
        data = new OthelloData();
        move = new OthelloMove(data);
        movements = null;
        
    }
    
    /**
     * 
     * @param b
     * @throws CloneNotSupportedException 
     */
    public Board(Board b) throws CloneNotSupportedException
    {
        
        try{
            data = new OthelloData(b.getData());
        }
        catch (Exception e){}
        move = new OthelloMove(data);

        movements = (Vector) b.movements.clone();
        
    }
    
    /**
     * 
     * @return 
     */
    public int[][] getBoard()
    {
        return data.getBoard();        
    }
    
    
    
    public OthelloData getData (){ return data;}
    
    
    public int[] getPieces()
    {
        return data.getPieces();
    }
      
    public boolean isEmpty(Point p)
    {
        return data.isEmpty(p);
    }
    
    // Cambiar esto por un puntero a un vector de movimientos.
    public void add (int i, int color)
    {
        //if (color==getTurn()) data.add(movements.elementAt(i).getPosition(), movements.elementAt(i).getDirections(), color);// ESTA PETABA ITIEL
        //movements = null;
        data.add(movements.elementAt(i).getPosition(), movements.elementAt(i).getDirections(), color);
        
    }
    
    public int getColor(Point p)
    {
        return data.getColor(p);
    }
    
    public int getColor(int x, int y)
    {
        return data.getColor(new Point(x,y));
    }
    
    public int getQuantityOfPieces(int color)
    {
        return data.getQuantityOfPieces(color);
    }
    
    public int getQuantityOfPiecesOnBoard()
    {
        return data.getQuantityOfPiecesOnBoard();
    }
    
    public int getEmptyPositions(){
        return data.getEmptyPositions();
    }
    
    public Vector<Point> getBlackPieces(){
        return data.getBlackPieces();
    }
    
    public Vector<Point> getWhitePieces(){
        return data.getWhitePieces();
    }

    public Movement getMovement(int i) { return movements.elementAt(i);}

    public void drawBoard()
    {
        data.drawBoard();
    }
    
    /**
     *
     * @param color
     * @return
     */

    // Pedir al othelloMove movimientos y guardarlos en un private y dsps el user escoger que
    // indice del vector aplicar movimiento.
    public Vector<Movement> getMovements(int color)
    {
       
        movements = move.getMovements(color);
       
        return movements;
    }
    
    public void reset() // RESET TO NEW GAME
    {
        turn = -1;
        data = new OthelloData();
        move = new OthelloMove(data);
        movements = null;
    }
    
    public int getPointPos(Point p)
    {
        return movements.indexOf(p);
    }
    
    public boolean isValid(Point p)
    {
        return movements.contains(p);
    }
    
    public void nextTurn(){
        turn*=-1;
    }
    
    public int getTurn(){
        return turn;
    }
    
}