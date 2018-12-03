/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author heri
 */
public class OthelloData {
    
    private int [][] a;
    
    public OthelloData(){
        a = new int [8][8];
        
        for (int i=0;i<8;++i)
            for (int j=0;j<8;++j)
                a[i][j] = 0;
        
    }
    
    public void afegir_fitxa(int f, int c){
        a[f][c] = 1;
        System.out.println("Fitxa afegida a :"+f+" "+c);
    }
    
    public int get_color(int f,int c){return a[f][c];}
    
    
    
}
