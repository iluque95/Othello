/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Logic.Board;
import Util.Movement;
import Util.Point;
import Util.Color;
import java.util.HashMap;
import java.util.Vector;

public class LloydC implements Player {

    HashMap<Point, Boolean> top;
    HashMap<Point, Boolean> frame;
    HashMap<Point, Boolean> bad;
    HashMap<Point, Boolean> middle;

    public LloydC() {
        this.top = new HashMap<Point, Boolean>() {
            {
                put(new Point(0, 0), true);
                put(new Point(0, 7), true);
                put(new Point(7, 0), true);
                put(new Point(7, 7), true);
            }
        };

        this.frame = new HashMap<Point, Boolean>() {
            {

                put(new Point(0, 1), true);
                put(new Point(0, 2), true);
                put(new Point(0, 3), true);
                put(new Point(0, 4), true);
                put(new Point(0, 5), true);
                put(new Point(0, 6), true);
                put(new Point(1, 0), true);
                put(new Point(1, 7), true);
                put(new Point(2, 0), true);
                put(new Point(2, 7), true);
                put(new Point(3, 0), true);
                put(new Point(3, 7), true);
                put(new Point(4, 0), true);
                put(new Point(4, 7), true);
                put(new Point(5, 0), true);
                put(new Point(5, 7), true);
                put(new Point(6, 0), true);
                put(new Point(6, 7), true);
                put(new Point(7, 1), true);
                put(new Point(7, 2), true);
                put(new Point(7, 3), true);
                put(new Point(7, 4), true);
                put(new Point(7, 5), true);
                put(new Point(7, 6), true);

            }
        };

        this.bad = new HashMap<Point, Boolean>() {
            {

                put(new Point(1, 1), true);
                put(new Point(1, 2), true);
                put(new Point(1, 3), true);
                put(new Point(1, 4), true);
                put(new Point(1, 5), true);
                put(new Point(1, 6), true);
                put(new Point(2, 1), true);
                put(new Point(2, 6), true);
                put(new Point(3, 1), true);
                put(new Point(3, 6), true);
                put(new Point(4, 1), true);
                put(new Point(4, 6), true);
                put(new Point(5, 1), true);
                put(new Point(5, 6), true);
                put(new Point(6, 1), true);
                put(new Point(6, 2), true);
                put(new Point(6, 3), true);
                put(new Point(6, 4), true);
                put(new Point(6, 5), true);
                put(new Point(6, 6), true);

            }
        };

        this.middle = new HashMap<Point, Boolean>() {
            {

                put(new Point(2, 2), true);
                put(new Point(2, 3), true);
                put(new Point(2, 4), true);
                put(new Point(2, 5), true);
                put(new Point(3, 2), true);
                put(new Point(3, 3), true);
                put(new Point(3, 4), true);
                put(new Point(3, 5), true);
                put(new Point(4, 2), true);
                put(new Point(4, 3), true);
                put(new Point(4, 4), true);
                put(new Point(4, 5), true);
                put(new Point(5, 2), true);
                put(new Point(5, 3), true);
                put(new Point(5, 4), true);
                put(new Point(5, 5), true);

            }
        };
    }

    public String name() {
        return "LloydC";

    }

    @Override
    public Movement movement(Board t, int color) {
        //Demanar moviments possibles del tauler
        Vector<Movement> list = t.getMovements(color);
        Integer n = Integer.MIN_VALUE;
        //Posició amb valor màxim
        int pos = 0;
        //Per cada moviment possible
        for (int i = 0; i < list.size(); ++i) {
            //add ficha
            int x = heuristic(t, color);
            if (x > n) {
                n = x;
                pos = i;
            }
        }
        return list.get(pos);

    }

    private int heuristic(Board b, int color) {

        int h = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Point x = new Point(i, j);
                int xColor = b.getColor(x);

                if (xColor != Color.WHITE.getColor()) {
                    if (top.containsKey(x)) {
                        h += 400 * (xColor * color);
                    } else if (frame.containsKey(x)) {
                        h += 200 * (xColor * color);
                    } else if (bad.containsKey(x)) {
                        h -= 100 * (xColor * color);
                    }
                } else if (middle.containsKey(x)) {
                    h += 50 * (xColor * color);
                }
            }
        }
        return h;
    }

}
