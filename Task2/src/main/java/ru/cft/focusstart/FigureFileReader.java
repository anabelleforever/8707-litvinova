package ru.cft.focusstart;

import java.io.*;
import java.util.ArrayList;

class FigureFileReader {
    private File inputFile;

    FigureFileReader(String file) {
        inputFile = new File(file);
    }

    ArrayList<String> read() throws IOException {
        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден.");
        }
        return fileContent;
    }
}