/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Logic;

import epsevg.eu.Othello.Util.Point;
import epsevg.eu.Othello.Util.Color;
import epsevg.eu.Othello.Util.Direction;
import epsevg.eu.Othello.Base.Movement;
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
        if (p.getX() < 1) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX()-1,p.getY()));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while (i>=0 && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,p.getY()));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,p.getY());
            }else if(tmpColor==color) {
                consecutives = false;
            }
            
            i--;
        }
        
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
        if (p.getX() > 6) return pt;
        
        
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()+2;
        int color = oData.getColor(p); // REVISAR POC PROBABLE
        
        int nextColor = oData.getColor(new Point(p.getX()+1,p.getY())); // REVISAR HA PETAO
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while (i<oData.getSize() && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,p.getY())); // REVISAR
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,p.getY());
            }else if(tmpColor==color){
                consecutives = false;
            }
            
            i++;
        }
        
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
        if (p.getY() < 1) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int j = p.getY()-2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX(),p.getY()-1));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while (j>=0 && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(p.getX(),j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(p.getX(),j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            
            j--;
        }
        
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
        if (p.getY() > 6) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int j = p.getY()+2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX(),p.getY()+1));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
       
        while (j<oData.getSize() && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(p.getX(),j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(p.getX(),j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            
            j++;
        }
        
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
        if (p.getX() < 1 || p.getY() > 6 ) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-2;
        int j = p.getY()+2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX()-1,p.getY()+1));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while ((i>=0 && j<oData.getSize()) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            i--;
            j++;
        }
        
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
        if (p.getX() < 1 || p.getY() < 1 ) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()-2;
        int j = p.getY()-2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX()-1,p.getY()-1));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while ((i>=0 && j>=0) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            i--;
            j--;
        }
        
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
        if (p.getX() > 6 || p.getY() > 6) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()+2;
        int j = p.getY()+2;
        int color = oData.getColor(p);
        int nextColor = oData.getColor(new Point(p.getX()+1,p.getY()+1)); 
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while ((i<oData.getSize() && j<oData.getSize()) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            i++;
            j++;
        }
        
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
        if (p.getX() > 6 || p.getY() < 1) return pt;
        
        boolean consecutives = true;
        boolean found = false;
        int i = p.getX()+2;
        int j = p.getY()-2;
        int color = oData.getColor(p);
        
        int nextColor = oData.getColor(new Point(p.getX()+1,p.getY()-1));
        
        if (nextColor==Color.EMPTY.getColor() || nextColor==color) consecutives = false;
        
        while ((i< oData.getSize() && j>=0) && consecutives && !found)
        {
            int tmpColor = oData.getColor(new Point(i,j));
            
            if (tmpColor==Color.EMPTY.getColor()) {
                found = true;
                pt = new Point(i,j);
            }else if(tmpColor==color) {
                consecutives = false;
            }
            i++;
            j--;
        }
        
        return pt;
    }
    
    /**
    * Given a color, function will look for black or white array of pieces depending of the color
    * of the piece given from the parameter.
    * After that, it will check movements for the given color in all directions focusing its pieces with same
    * color as paramater introduced and then it will insert in to a separate vectors positions found and directions
    * because one point can be found more times and its only necessary update the directions that the position can do movement.
    * 
    * @param color is the color of piece which want know its possible movements.
    * 
    * @return Array of pairs with possible movements in each position and its direction found.
    */
    public Vector<Movement> getMovements(int color)
    {
        Vector<Movement> mov = new Vector();
        Vector<Point> pieces=null;
        Point tmp;
        
        if (color == Color.BLACK.getColor()) {
            pieces = oData.getBlackPieces();
        }else if(color == Color.WHITE.getColor()){
            pieces = oData.getWhitePieces();
        }
                        
        for (int i=0; i<pieces.size(); i++) {

            int dir, pos;

            tmp = searchRight(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.LEFT.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchLeft(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.RIGHT.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }


            tmp = searchUp(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.DOWN.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchDown(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.UP.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchRightUpDiagonal(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.LEFTDDOWN.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchLeftUpDiagonal(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.RIGHTDDOWN.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchRightDownDiagonal(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.LEFTDUP.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

            tmp = searchLeftDownDiagonal(pieces.get(i));
            if (tmp.validPoint()) {
                pos = mov.indexOf(tmp);
                dir = Direction.RIGHTDUP.getVal();

                if (pos >= 0) {
                    mov.set(pos, new Movement(tmp, mov.get(pos).getDirections() | dir));
                } else {
                    mov.add(new Movement(tmp, dir));
                }
            }

        }
        
        return mov;
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
        return (oData.getQuantityOfPiecesOnBoard()==64 || 
                ((oData.getQuantityOfPieces(Color.BLACK.getColor()) == oData.getQuantityOfPieces(Color.WHITE.getColor())) 
                && getMovements(color).isEmpty()));
    }
}
