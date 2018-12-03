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
    * Given a point, function will look for black or white array of pieces depending of the color
    * of the piece given from the parameter which is a point in the board.
    * 
    * After that, it will check movements for the given point in all directions.
    * 
    * @param p is a point of board which can not be empty position.
    * 
    * @return Array of pairs with possible movements in each position and its direction found.
    */
    public Vector<Pair<Point, Direction>> getMovements(Point p)
    {
        Vector<Pair<Point, Direction>> movements = new Vector();
        Vector<Point> pieces;
        Point tmp;
        
        if (oData.getColor(p) == Color.BLACK.getColor()) {
            pieces = oData.getBlackPieces();
        }else if(oData.getColor(p) == Color.WHITE.getColor()){
            pieces = oData.getWhitePieces();
                        
            for (int i=0; i<pieces.size(); i++) {
                
                tmp = searchRight(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.RIGHT));
                
                tmp = searchLeft(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.LEFT));
                
                tmp = searchUp(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.UP));
                
                tmp = searchDown(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.DOWN));
                
                tmp = searchRightUpDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.RIGHTDUP));
                
                tmp = searchLeftUpDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.LEFTDUP));
                
                tmp = searchRightDownDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.RIGHTDDOWN));
                
                tmp = searchLeftDownDiagonal(pieces.get(i));
                if (tmp.getX()!=-1 && tmp.getY()!=-1) movements.add(new Pair(tmp, Direction.LEFTDDOWN));

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
    public void applyMovement(Point p, Direction dir, int color)
    {
        oData.add(p, dir, color);
    }
    
    /**
    * Determines if given a piece it will be a solution.
    * To be a solution the board will be full or pieces black and white have to 
    * got the same amount and do not have any movement any of them.
    * 
    * @param  p is a point which contains x abcissa coordinate
    *         and y ordinate coordinate.
    * @return true if is solution, false otherwise
    */
    public boolean isSolution(Point p)
    {
        return (oData.getQuantityOfPiecesOnBoard()==64 || ((oData.getQuantityOfPieces(Color.BLACK.getColor()) == oData.getQuantityOfPieces(Color.WHITE.getColor())) && getMovements(p).isEmpty()));
    }
}
