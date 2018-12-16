/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.Base;

// CLASE PARA GUARDAR SOLO LOS EXJUGADORES YA QUE HAY VARIOS ATRIBUTOS

import epsevg.eu.Othello.Player.Interface.Player;

public class Options {
    
    private String p1,p2;
    private int prof1,prof2;
    private boolean poda1,poda2;
    
    public Options(String[] players,int[] prof, boolean[] poda)
    {
        p1 = players[0];
        p2 = players[1];
        prof1 = prof[0];
        prof2 = prof[1];
        poda1 = poda[0];
        poda2 = poda[1];
    }
    
    /* GETTERS */
    
    public String getFirstPlayer(){return p1;}
    public String getSecondPlayer(){return p2;}
    public int getP1Prof(){return prof1;}
    public int getP2Prof(){return prof2;}
    public boolean getP1Poda(){return poda1;}
    public boolean getP2Poda(){return poda2;}
    
    
}
