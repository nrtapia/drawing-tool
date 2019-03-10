package com.ntapia.drawingtool;

import com.ntapia.drawingtool.exception.DrawingInputFileNotFound;
import com.ntapia.drawingtool.exception.DrawingReadFileException;
import com.ntapia.drawingtool.exception.DrawingWriteToFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Application entry point
 */
public class DrawingToolApplication {

    private static final String OUTPUT_FILE = "output.txt";
    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {

        Path inputFile = Paths.get(INPUT_FILE);
        if (!Files.exists(inputFile)) {
            throw new DrawingInputFileNotFound();
        }

        StringBuilder builder = new StringBuilder();
        Panel panel = new Panel();

        try (Stream<String> stream = Files.lines(inputFile)) {
            System.out.printf("Start reading the file %s%n", INPUT_FILE);

            stream.forEach(line -> {
                System.out.printf("Run command: %s%n", line);
                panel.addShape(line);
                builder.append(panel.toString());
            });
        } catch (IOException e) {
            throw new DrawingReadFileException(e);
        }

        writeToFile(builder.toString());
    }

    private static void writeToFile(String values) {
        System.out.printf("Start write the file %s%n", OUTPUT_FILE);
        try {
            Files.write(Paths.get(OUTPUT_FILE), values.getBytes());
        } catch (IOException e) {
            throw new DrawingWriteToFileException(e);
        }
    }
}
