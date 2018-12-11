/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Util.Movement;
import Util.Point;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author marti
 */
public class Board {
    
    private OthelloData data;
    public OthelloMove move;
    
    public Board()
    {
        data = new OthelloData();
        move = new OthelloMove(data);
        
    }
    
    
    public Board(Board b) throws CloneNotSupportedException
    {
        
        try{
            data = new OthelloData(b.getData());
        }
        catch (Exception e){}
        move = new OthelloMove(data);
        
    }
    
    public int[][] getBoard()
    {
        return data.board;        
    }
    
    
    public OthelloData getData (){ return data;}
    
    
    public int[] getPieces()
    {
        return data.pieces;
    }
      
    public boolean isEmpty(Point p)
    {
        return data.isEmpty(p);
    }
    
    public void add (Movement m, int color)
    {
        data.add(m.getPosition() , m.getDirections(), color);
    }
    
    public int getColor(Point p)
    {
        return data.getColor(p);
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

    public void drawBoard()
    {
        data.drawBoard();
    }
    
    /**
     *
     * @param color
     * @return
     */
    public Vector<Movement> getMovements(int color)
    {
        return move.getMovements(color);
    }
    

}
