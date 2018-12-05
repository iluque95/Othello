package Player;

import Logic.Board;

public interface Player {
    
    public int movement(Board t, int color);
    public String name();
}