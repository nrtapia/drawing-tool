package com.ntapia.drawingtool.domain;

import com.ntapia.drawingtool.exception.LineOperationUnsupportedException;

import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 *
 */
public class LineTest {

    @Test(expected = LineOperationUnsupportedException.class)
    public void testUnsupportedLineType() {
        Canvas canvas = mock(Canvas.class);

        Line line = new Line(canvas, new Point(1, 2), new Point(3, 5));
        line.draw();
    }
}
