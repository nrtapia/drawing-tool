package com.ntapia.drawingtool;

import com.ntapia.drawingtool.domain.Canvas;
import com.ntapia.drawingtool.domain.Line;
import com.ntapia.drawingtool.domain.Point;
import com.ntapia.drawingtool.domain.Rectangle;
import com.ntapia.drawingtool.exception.CanvasAlreadyCreated;
import com.ntapia.drawingtool.exception.CanvasNotCreatedException;
import com.ntapia.drawingtool.exception.CommandArgumentsInvalidException;
import com.ntapia.drawingtool.exception.CommandNotSupportedException;

/**
 * Domain to represent the main container for shapes
 */
class Panel {

    private static final String NEW_LINE = "\n";
    private static final String EMPTY_SPACE = " ";

    private static final String COMMAND_CANVAS = "C";
    private static final String COMMAND_LINE = "L";
    private static final String COMMAND_RECTANGLE = "R";
    private static final String COMMAND_FILL_BUCKET = "B";

    private Canvas canvas;
    private int width;
    private int height;

    /**
     * Method to add a Shape to the Panel
     *
     * @param command
     *         string command
     */
    void addShape(String command) {
        if (command == null || command.trim().length() == 0) {
            throw new CommandArgumentsInvalidException();
        }

        String[] arguments = command.split(EMPTY_SPACE);

        try {
            switch (arguments[0]) {
                case COMMAND_CANVAS:
                    addCanvas(arguments);
                    break;
                case COMMAND_LINE:
                    addLine(arguments);
                    break;
                case COMMAND_RECTANGLE:
                    addRectangle(arguments);
                    break;
                case COMMAND_FILL_BUCKET:
                    fillBucked(arguments);
                    break;
                default:
                    throw new CommandNotSupportedException();
            }
        } catch (NumberFormatException e) {
            throw new CommandArgumentsInvalidException();
        }
    }

    /**
     * Operation to add a Canvas to the Panel
     *
     * @param arguments
     *         command as arguments
     */
    private void addCanvas(String[] arguments) {
        validateArguments(arguments, 3);
        if (canvas != null) {
            throw new CanvasAlreadyCreated();
        }

        width = Integer.valueOf(arguments[1]);
        height = Integer.valueOf(arguments[2]);

        canvas = new Canvas(width, height);
        canvas.draw();
    }

    /**
     * Operation to add a Line to the canvas
     *
     * @param arguments
     *         command as arguments
     */
    private void addLine(String[] arguments) {
        validateCanvasAndArguments(arguments, 5);

        Line line = new Line(canvas, new Point(arguments[1], arguments[2]), new Point(arguments[3], arguments[4]));
        line.draw();
    }

    /**
     * Operation to add a Rectangle to the canvas
     *
     * @param arguments
     *         command as arguments
     */
    private void addRectangle(String[] arguments) {
        validateCanvasAndArguments(arguments, 5);

        Rectangle rectangle = new Rectangle(canvas, new Point(arguments[1], arguments[2]),
                new Point(arguments[3], arguments[4]));
        rectangle.draw();
    }

    /**
     * Operation to fill the entire area connected
     *
     * @param arguments
     *         command as arguments
     */
    private void fillBucked(String[] arguments) {
        validateCanvasAndArguments(arguments, 4);
        canvas.fillBucket(new Point(arguments[1], arguments[2]), arguments[3]);
    }

    /**
     * Method to validate if the Canvas is not created
     */
    private void validateCanvas() {
        if (canvas == null) {
            throw new CanvasNotCreatedException();
        }
    }

    /**
     * Method to validate the amount of argument by command
     *
     * @param arguments
     *         command as arguments
     * @param length
     *         amount of arguments to validate
     */
    private void validateArguments(String[] arguments, int length) {
        if (arguments.length != length) {
            throw new CommandArgumentsInvalidException();
        }
    }

    /**
     * Method to valid the Canvas and the Arguments
     *
     * @param arguments
     *         command as arguments
     * @param length
     *         amount of arguments to validate
     */
    private void validateCanvasAndArguments(String[] arguments, int length) {
        validateCanvas();
        validateArguments(arguments, length);
    }

    /**
     * Operation to translate the Canvas to a String representation
     *
     * @return string representation
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String[][] matrix = canvas.getMatrix();

        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width + 2; x++) {
                String value = matrix[x][y];
                builder.append(value == null ? EMPTY_SPACE : value);
            }
            builder.append(NEW_LINE);
        }

        return builder.toString();
    }
}
