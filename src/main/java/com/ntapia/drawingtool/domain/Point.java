package com.ntapia.drawingtool.domain;

/**
 * Domain to represent a coordinate (x, y)
 */
public class Point {

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y) {
        this(Integer.valueOf(x), Integer.valueOf(y));
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
