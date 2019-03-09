package com.ntapia.drawingtool.domain;

/**
 *
 */
public class Rectangle extends Shape {

    private final Point upperLeft;
    private final Point lowerRight;

    public Rectangle(String[][] matrix, Point upperLeft, Point lowerRight) {
        super(matrix);
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    @Override
    public void draw() {
        Point upperRight = new Point(lowerRight.getX(), upperLeft.getY());
        Line upperLine = new Line(matrix, upperLeft, upperRight);
        upperLine.draw();

        Line lineRight = new Line(matrix, upperRight, lowerRight);
        lineRight.draw();

        Point lowerLeft = new Point(upperLeft.getX(), lowerRight.getY());
        Line lowerLine = new Line(matrix, lowerLeft, lowerRight);
        lowerLine.draw();

        Line lineLeft = new Line(matrix, upperLeft, lowerLeft);
        lineLeft.draw();
    }
}
