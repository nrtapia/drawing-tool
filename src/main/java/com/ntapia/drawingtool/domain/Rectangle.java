package com.ntapia.drawingtool.domain;

/**
 * Domain to represent a Rectangle with two points
 *
 *   upperLeftPoint  o-----------o  upperRightPoint
 *                   -           -
 *                   -           -
 *   lowerLeftPoint  o-----------o  lowerRightPoint
 *
 */
public class Rectangle implements Shape {

    private final Point upperLeftPoint;
    private final Point lowerRightPoint;
    private final Canvas canvas;

    public Rectangle(Canvas canvas, Point upperLeftPoint, Point lowerRightPoint) {
        this.canvas = canvas;
        this.upperLeftPoint = upperLeftPoint;
        this.lowerRightPoint = lowerRightPoint;
    }

    @Override
    public void draw() {
        Point upperRightPoint = new Point(lowerRightPoint.getX(), upperLeftPoint.getY());
        Line upperLine = new Line(canvas, upperLeftPoint, upperRightPoint);
        upperLine.draw();

        Line lineRight = new Line(canvas, upperRightPoint, lowerRightPoint);
        lineRight.draw();

        Point lowerLeftPoint = new Point(upperLeftPoint.getX(), lowerRightPoint.getY());
        Line lowerLine = new Line(canvas, lowerLeftPoint, lowerRightPoint);
        lowerLine.draw();

        Line lineLeft = new Line(canvas, upperLeftPoint, lowerLeftPoint);
        lineLeft.draw();
    }
}
