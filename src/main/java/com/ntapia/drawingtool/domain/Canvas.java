package com.ntapia.drawingtool.domain;

/**
 * Domain to represent a Canvas and manage the data to fill shapes
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

    public String[][] getMatrix() {
        return matrix;
    }

    @Override
    public void draw() {
        fillHorizontalLines();
        fillVerticalLines();
    }

    /**
     * Operation to fill the horizontal lines in the canvas
     *
     *  upperLine  ------------------
     *
     *  lowerLine  ------------------
     */
    private void fillHorizontalLines() {
        Line upperLine = new Line(this, new Point(0, 0), new Point(width + 1, 0), LINE);
        upperLine.draw();

        Line lowerLine = new Line(this, new Point(0, height + 1), new Point(width + 1, height + 1), LINE);
        lowerLine.draw();
    }

    /**
     * Operation to fill the vertical lines in the canvas
     *   leftLine        rightLine
     *    |               |
     *    |               |
     */
    private void fillVerticalLines() {
        Line leftLine = new Line(this, new Point(0, 1), new Point(0, height), PIPE);
        leftLine.draw();

        Line rightLine = new Line(this, new Point(width + 1, 1), new Point(width + 1, height), PIPE);
        rightLine.draw();
    }

    /**
     * Method to fill the area connected with a point
     *
     * @param point
     *         start point to fill
     * @param color
     *         color to fill
     */
    public void fillBucket(Point point, String color) {
        int x = point.getX();
        int y = point.getY();

        String value = matrix[x][y];
        if (value == null) {
            matrix[x][y] = color;
        } else {
            return;
        }

        if (x < 0 || x > width || y < 0 || y > height) {
            return;
        }

        // One step to the down
        fillBucket(new Point(x, y + 1), color);
        // One step to the up
        fillBucket(new Point(x, y - 1), color);
        // One step to the right
        fillBucket(new Point(x + 1, y), color);
        // One step to the left
        fillBucket(new Point(x - 1, y), color);
    }
}
