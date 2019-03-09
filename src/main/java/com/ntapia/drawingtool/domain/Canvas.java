package com.ntapia.drawingtool.domain;

/**
 *
 */
public class Canvas implements Shape {

    private static final String LINE = "-";
    private static final String PIPE = "|";

    private final int width;
    private final int height;
    private String[][] matrix;

    public Canvas(int width, int height) {
        this.matrix = new String[width + 2][height + 2];
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

        for (int x = 0; x < width + 2; x++) {
            matrix[x][0] = LINE;
            matrix[x][height + 1] = LINE;
        }

        for (int y = 1; y < height + 1; y++) {
            matrix[0][y] = PIPE;
            matrix[width + 1][y] = PIPE;
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void fillBucket(Point point, String color) {
        String value = matrix[point.getX()][point.getY()];
        if (value == null) {
            matrix[point.getX()][point.getY()] = color;
        } else {
            return;
        }

        if (point.getX() < 0 || point.getX() > width || point.getY() < 0 || point.getY() > height) {
            return;
        }

        fillBucket(new Point(point.getX(), point.getY() + 1), color);
        fillBucket(new Point(point.getX(), point.getY() - 1), color);
        fillBucket(new Point(point.getX() + 1, point.getY()), color);
        fillBucket(new Point(point.getX() - 1, point.getY()), color);
    }
}
