package com.ntapia.drawingtool.domain;

import org.junit.Test;

/**
 *
 */
public class CanvasTest {

    @Test
    public void testDraw() {

        Canvas canvas = new Canvas(20, 4);
        canvas.draw();
        System.out.println(canvas.toString());

        /*
        new Line(canvas, new Point(1, 2), new Point(6, 2));
        System.out.println(canvas.toString());

        new Line(canvas, new Point(6, 3), new Point(6, 4));
        System.out.println(canvas.toString());

        new Rectangle(canvas, new Point(16, 1), new Point(20, 3));
        System.out.println(canvas.toString());

        canvas.fillBucket(new Point(10, 3), "o");
        System.out.println(canvas.toString());
        */
    }
}
