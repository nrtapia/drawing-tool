package com.ntapia.drawingtool.domain;

/**
 *
 */
public class Rectangle implements Shape {

    private final Point upperLeft;
    private final Point lowerRight;
    private final Canvas canvas;

    public Rectangle(Canvas canvas, Point upperLeft, Point lowerRight) {
        this.canvas = canvas;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    @Override
    public void draw() {
        Point upperRight = new Point(lowerRight.getX(), upperLeft.getY());
        Line upperLine = new Line(canvas, upperLeft, upperRight);
        upperLine.draw();

        Line lineRight = new Line(canvas, upperRight, lowerRight);
        lineRight.draw();

        Point lowerLeft = new Point(upperLeft.getX(), lowerRight.getY());
        Line lowerLine = new Line(canvas, lowerLeft, lowerRight);
        lowerLine.draw();

        Line lineLeft = new Line(canvas, upperLeft, lowerLeft);
        lineLeft.draw();
    }
}
