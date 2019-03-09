package com.ntapia.drawingtool.domain;

/**
 *
 */
public class Point {

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y) {
        this.x = Integer.valueOf(x);
        this.y = Integer.valueOf(y);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
