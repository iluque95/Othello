package Player;

import Logic.Board;
import Util.*;
public interface Player {
    
    public int movement(Board t, int color);
    public String name();
}