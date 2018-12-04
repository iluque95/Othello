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
    
    /**
    * Find out a valid movement in up direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchUp(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getY()-1;
        
        while (i>=0 && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,p.getY()));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            
            i--;
        }
        
        if (found) pt = new Point(p.getX()+1,p.getY());
        
        return pt;
    }
    
    /**
    * Find out a valid movement in down direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchDown(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getY()+1;
        
        while (i<oData.getSize() && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,p.getY()));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            
            i++;
        }
        
        if (found) pt = new Point(p.getX()-1,p.getY());
        
        return pt;
    }
  
    /**
    * Find out a valid movement in left direction while not find the same color of the
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
                found = true;
            }else{
                consecutives = false;
            }
            
            j--;
        }
        
        if (found) pt = new Point(p.getX(),p.getY()+1);
        
        return pt;
    }
    
    /**
    * Find out a valid movement in right direction while not find the same color of the
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
                found = true;
            }else{
                consecutives = false;
            }
            
            j++;
        }
        
        if (found) pt = new Point(p.getX(),p.getY()-1);
        
        return pt;
    }
    
    /**
    * Find out a valid movement in diagonal up right direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchRightUpDiagonal(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-1;
        int j = p.getY()+1;
        
        while ((i>=0 && j<oData.getSize()) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            i--;
            j++;
        }
        
        if (found) pt = new Point(p.getX()+1,p.getY()-1);
        
        return pt;
    }
    
    /**
    * Find out a valid movement in diagonal up left direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchLeftUpDiagonal(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-1;
        int j = p.getY()-1;
        
        while ((i>=0 && j>=0) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            i--;
            j--;
        }
        
        if (found) pt = new Point(p.getX()+1,p.getY()+1);
        
        return pt;
    }
    
    /**
    * Find out a valid movement in diagonal down right direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchRightDownDiagonal(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()+1;
        int j = p.getY()+1;
        
        while ((i<oData.getSize() && j<oData.getSize()) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            i++;
            j++;
        }
        
        if (found) pt = new Point(p.getX()+1,p.getY()+1);
        
        return pt;
    }
    
    /**
    * Find out a valid movement in diagonal down left direction while not find the same color of the
    * main color that we are looking for.
    * When it found a empty space, it will find a valid movement, otherwise returns invalid
    * point to callee.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return Valid point if exists a play, invalid point otherwise.
    */
    private Point searchLeftDownDiagonal(Point p)
    {
        Point pt = new Point(-1, -1);
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-1;
        int j = p.getY()+1;
        
        while ((i>=0 && j<oData.getSize()) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
            }else{
                consecutives = false;
            }
            i--;
            j++;
        }
        
        if (found) pt = new Point(p.getX()+1,p.getY()-1);
        
        return pt;
    }
    
    /**
    * Given a color, function will look for black or white array of pieces depending of the color
    * of the piece given from the parameter.
    * 
    * After that, it will check movements for the given point in all directions.
    * 
    * @param color is the color of piece which want know its possible movements.
    * 
    * @return Array of pairs with possible movements in each position and its direction found.
    */
    public Vector<Pair<Point, Integer>> getMovements(int color)
    {
        Vector<Pair<Point, Integer>> movements = new Vector();
        Vector<Point> pieces;
        Point tmp;
        
        if (color == Color.BLACK.getColor()) {
            pieces = oData.getWhitePieces();
        }else if(color == Color.WHITE.getColor()){
            pieces = oData.getBlackPieces();
                        
            for (int i=0; i<pieces.size(); i++) {
                
                int dirs=0x0;
                
                tmp = searchRight(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.RIGHT.getVal();
                
                tmp = searchLeft(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.LEFT.getVal();
                
                tmp = searchUp(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.UP.getVal();
                
                tmp = searchDown(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.DOWN.getVal();
                
                tmp = searchRightUpDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.RIGHTDUP.getVal();
                
                tmp = searchLeftUpDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.LEFTDUP.getVal();
                
                tmp = searchRightDownDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.RIGHTDDOWN.getVal();
                
                tmp = searchLeftDownDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) dirs |= Direction.LEFTDDOWN.getVal();
                
                if ((dirs & 0xFF)>0) movements.add(new Pair(tmp, dirs));

            }
        }
        
        return movements;
    }
    
    /**
    * Calls the function which add the piece in a given position and apply the movement modifing the board
    * with corresponding colors.
    * 
    * @param p is a empty point of the board
    * @param dir is in which direction it can be effect the movement.
    * @param color is the color of piece which it will put in the board.
    */
    public void applyMovement(Point p, int dir, int color)
    {
        oData.add(p, dir, color);
    }
    
    /**
    * Determines if given a piece it will be a solution.
    * To be a solution the board will be full or pieces black and white have to 
    * got the same amount and do not have any movement any of them.
    * 
    * @param  color is the color of piece.
    * @return true if is solution, false otherwise
    */
    public boolean isSolution(int color)
    {
        return (oData.getQuantityOfPiecesOnBoard()==64 || ((oData.getQuantityOfPieces(Color.BLACK.getColor()) == oData.getQuantityOfPieces(Color.WHITE.getColor())) && getMovements(color).isEmpty()));
    }
}
