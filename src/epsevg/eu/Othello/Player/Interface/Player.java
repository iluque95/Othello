package epsevg.eu.Othello.Player.Interface;

import epsevg.eu.Othello.Logic.Board;
public interface Player {
    
    public int movement(Board t, int color);
    public String name();
}