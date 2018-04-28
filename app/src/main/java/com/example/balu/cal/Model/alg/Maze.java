package com.example.balu.cal.Model.alg;

import java.util.ArrayList;

/**
 * Created by balu on 2/9/18.
 */

public class Maze {

    private static final int N = 4;
    int board[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };

    ArrayList<Node> listTrackedPath = new ArrayList();


    public boolean trackPath(int x, int y) {
        if ((x == N - 1) && (y == N - 1))
            return true;

        boolean b1 = trackPath(x - 1, y);
        boolean b2 = trackPath(x, y - 1);
        boolean b3 = trackPath(x + 1, y);
        boolean b4 = trackPath(x, y + 1);



        return true;


    }


    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
