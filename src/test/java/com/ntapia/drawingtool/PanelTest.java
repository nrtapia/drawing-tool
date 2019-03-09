package com.ntapia.drawingtool;

import com.ntapia.drawingtool.exception.CanvasNotCreatedException;
import com.ntapia.drawingtool.exception.CommandArgumentsInvalidException;
import com.ntapia.drawingtool.exception.CommandNotSupportedException;

import org.junit.Test;

/**
 *
 */
public class PanelTest {

    private Panel panel = new Panel();

    @Test(expected = CommandNotSupportedException.class)
    public void testCommandNotSupported() {
        panel.addShape("X 2 3 4 5 6");
    }

    @Test(expected = CommandArgumentsInvalidException.class)
    public void testEmptyCommand() {
        panel.addShape(" ");
    }

    @Test(expected = CommandArgumentsInvalidException.class)
    public void testNullCommand() {
        panel.addShape(null);
    }

    @Test(expected = CanvasNotCreatedException.class)
    public void testAddCommandWithoutCanvas() {
        panel.addShape("L 1 2 3 5");
    }

    @Test(expected = CommandArgumentsInvalidException.class)
    public void testCreateCanvasWithInvalidArguments() {
        panel.addShape("C 2");
    }

    @Test(expected = CommandArgumentsInvalidException.class)
    public void tesAddLineWithInvalidArguments() {
        panel.addShape("C 2 3");
        panel.addShape("L 2");
    }
}
