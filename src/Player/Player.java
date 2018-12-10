package Player;

import Logic.Board;
import Util.*;
public interface Player {
    
    public Movement movement(Board t, int color);
    public String name();
}