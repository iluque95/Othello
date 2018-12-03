/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Random;

/**
 *
 * @author itiel
 */
public class OthelloData {
    
    int color;
    int spaces;
    int[][] board;
    
    public OthelloData()
    {
        spaces=64;
        board = new int[8][8];

        Random rnd = new Random();
        
        if ((1+rnd.nextInt(2))==1) {
            board[3][3]=1; 
            board[3][4]=2;
            board[4][3]=2;
            board[4][4]=1;
        }else{
            board[3][3]=2; 
            board[3][4]=1;
            board[4][3]=1;
            board[4][4]=2;
        }
        
    }
    
    
    /**
    * Looks if the piece given is valid for the policies
    * established.
    * 
    * @param  color of piece
    * @return   true if is a valid color of piece, false otherwise.
    */
    private boolean validColor(int color)
    {
        return color==1 && color==2;
    }
    
    /**
    * Looks if movement is valid from given position.
    * 
    * @param  x abcissa coordinate
    * @param  y ordinate coordinate
    * @return   true if can effect movement, false otherwise.
    */
    public boolean isEmpty(int x, int y)
    {
        return this.board[x][y]==0;
    }
    
    /**
    * Add a given piece into the board.
    * 
    * @param  x abcissa coordinate
    * @param  y ordinate coordinate
    * @param color piece
    */
    public void add(int x, int y, int color)
    {
        if (validColor(color)) this.board[x][y] = color;
    }
    
    /**
    * Get the color of piece in a given position.
    * 0 for empty positions.
    * 1 for black color.
    * 2 for white color.
    * 
    * @param  x abcissa coordinate
    * @param  y ordinate coordinate
    * @return color of piece
    */
    public int getColor(int x, int y)
    {
        return this.board[x][y];
    }
    
    /**
    * Determines if given a piece it will be a solution.
    * 
    * @param  x abcissa coordinate
    * @param  y ordinate coordinate
    * @return true if is solution, false otherwise
    */
    public boolean isSolution(int x, int y)
    {
        return true;
    }
    
    /**
    * Board is square therefore the size is the same in height
    * and width so returns any of them.
    * 
    * @return size of board
    */
    public int getSize()
    {
        return 8;
    }
    
    
    /**
    * Draw the board in the system output.
    * 
    */
    public void drawBoard()
    {
        System.out.print("   ");
        for (int i=0; i<getSize(); i++) System.out.print(i+" ");
        
        System.out.println("\n   - - - - - - - -");
        
        for (int i=0; i<getSize(); i++) {
            System.out.print(i+"| ");
            for (int j=0; j<getSize(); j++) {
                System.out.print(getColor(i,j)+" ");
            }
            System.out.println("");
        }
    }
}
