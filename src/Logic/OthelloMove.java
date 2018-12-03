/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Util.Point;
import Util.Color;
import Util.Direction;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author itiel
 */
public class OthelloMove {
    OthelloData oData;
    
    public OthelloMove(OthelloData oData)
    {
        this.oData = oData;
    }
    
    private Point searchUp(Point p)
    {
        Point pt = new Point(-1, -1);
        
        for (int i=0; i<; i++) {
            
        }
        
        return pt;
    }
    
    private Point searchDown(Point p)
    {
        
    }
  
    /**
    * Find out a valid play in left direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchLeft(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int j = p.getY()-1;
        
        while (j>=0 && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(p.getX(),j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                pt = new Point(p.getX(),j);
                found = true;
            }else{
                consecutives = false;
            }
            
            j--;
        }
        
        return pt;
    }
    
     /**
    * Find out a valid play in right direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchRight(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int j = p.getY()+1;
        
        while (j<oData.getSize() && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(p.getX(),j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                pt = new Point(p.getX(),j);
                found = true;
            }else{
                consecutives = false;
            }
            
            j++;
        }
        
        return pt;
    }
    
    private Point searchRightDiagonal(Point p)
    {
        
    }
    
    private Point searchLeftDiagonal(Point p)
    {
        
    }
    
    /**
    * Given a point function will look for black or white array of pieces depending of the color
    * of the piece which is given from the parameter which is a point in the board.
    * 
    * After that, it will check movements for the given point in all directions.
    * 
    * @return Array of pairs with possible movements in each position and its direction found.
    */
    public Vector<Pair<Point, Direction>> getMovements(Point p)
    {
        Vector<Pair<Point, Direction>> plays = new Vector();
        Vector<Point> pieces;
        Point tmp;
        
        if (oData.getColor(p) == Color.BLACK.getColor())
            pieces = oData.getBlackPieces();
        else
            pieces = oData.getWhitePieces();
            
            
            for (int i=0; i<pieces.size(); i++) {
                
                tmp = searchRight(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.RIGHT));
                
                tmp = searchLeft(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.LEFT));
                
                tmp = searchUp(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.UP));
                
                tmp = searchDown(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.DOWN));
                
                tmp = searchRightDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.RIGHTD));
                
                tmp = searchLeftDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) plays.add(new Pair(tmp, Direction.LEFTD));

            }
        
        return plays;
    }
    
    /**
    * Determines if given a piece it will be a solution.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return true if is solution, false otherwise
    */
    public boolean isSolution(Point p)
    {
        return true;
    }
}
