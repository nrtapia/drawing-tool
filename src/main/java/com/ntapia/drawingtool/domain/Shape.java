package com.ntapia.drawingtool.domain;

/**
 *
 */
abstract class Shape {

    final String[][] matrix;

    Shape(String[][] matrix) {
        this.matrix = matrix;
    }

    public abstract void draw();
}
