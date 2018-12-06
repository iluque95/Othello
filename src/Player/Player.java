package Player;

import Logic.Board;
import Util.Point;
import javafx.util.Pair;

public interface Player {
    
    public Pair<Point,Integer> movement(Board t, int color);
    public String name();
}