package com.ntapia.drawingtool.domain;

import com.ntapia.drawingtool.exception.LineOperationUnsupportedException;

/**
 * Domain to represent a Line between two points
 *
 * startPoint   o------------o  endPoint
 */
public class Line implements Shape {

    private static final String DEFAULT_FILL = "x";

    private final Point startPoint;
    private final Point endPoint;
    private final Canvas canvas;
    private final String fillCharacter;

    Line(Canvas canvas, Point startPoint, Point endPoint, String fillCharacter) {
        this.canvas = canvas;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.fillCharacter = fillCharacter;
    }

    public Line(Canvas canvas, Point startPoint, Point endPoint) {
        this(canvas, startPoint, endPoint, DEFAULT_FILL);
    }

    @Override
    public void draw() {
        if (startPoint.getX() == endPoint.getX()) {
            drawVerticalLine();
        } else {
            if (startPoint.getY() == endPoint.getY()) {
                drawHorizontalLine();
            } else {
                throw new LineOperationUnsupportedException();
            }
        }
    }

    /**
     * Operation to draw a horizontal line
     */
    private void drawHorizontalLine() {
        final int y = startPoint.getY();
        String[][] matrix = canvas.getMatrix();

        for (int x = startPoint.getX(); x < endPoint.getX() + 1; x++) {
            matrix[x][y] = fillCharacter;
        }
    }

    /**
     * Operation to draw a verticals line
     */
    private void drawVerticalLine() {
        final int x = startPoint.getX();
        String[][] matrix = canvas.getMatrix();

        for (int y = startPoint.getY(); y < endPoint.getY() + 1; y++) {
            matrix[x][y] = fillCharacter;
        }
    }
}
