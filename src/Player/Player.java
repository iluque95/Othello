package Player;

import Logic.Board;
import Util.Point;

public interface Player {
    
    public Point movement(Board t, int color);
    public String name();
}