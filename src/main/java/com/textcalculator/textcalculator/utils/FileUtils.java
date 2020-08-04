package com.textcalculator.textcalculator.utils;

import com.textcalculator.textcalculator.model.MathematicalOperation;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Stream;

@Slf4j
public class FileUtils {
    public static LinkedList<MathematicalOperation> readFile(String filePath){
        LinkedList<MathematicalOperation> result = new LinkedList<>();
        Path path = Paths.get(filePath);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> result.add(new MathematicalOperation(line)));
        } catch (IOException e) {
            log.error("Error reading file.", e);
        }

        return result;
    }
}
