package com.ntapia.drawingtool.domain;

import com.ntapia.drawingtool.exception.LineOperationUnsupportedException;

/**
 *
 */
public class Line extends Shape {

    private static final String FILL = "x";

    private final Point point1;
    private final Point point2;

    public Line(String[][] matrix, Point point1, Point point2) {
        super(matrix);
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public void draw() {
        if (point1.getX() == point2.getX()) {
            drawVertical();
        } else {
            if (point1.getY() == point2.getY()) {
                drawHorizontal();
            } else {
                throw new LineOperationUnsupportedException();
            }
        }
    }

    private void drawHorizontal() {
        final int y = point1.getY();

        for (int x = point1.getX(); x < point2.getX() + 1; x++) {
            matrix[x][y] = FILL;
        }
    }

    private void drawVertical() {
        final int x = point1.getX();

        for (int y = point1.getY(); y < point2.getY() + 1; y++) {
            matrix[x][y] = FILL;
        }
    }
}
