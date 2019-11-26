package ru.cft.focusstart;

import ru.cft.focusstart.Figure.GeometricFigure;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        DataCorrector dataCorrector = new DataCorrector(args);
        dataCorrector.correct();
        String figure = dataCorrector.getFigure();
        ArrayList<Integer> parameters = dataCorrector.getParameters();
        FigureFactory factory = new FigureFactory();
        GeometricFigure geometricFigure = factory.getFigure(FigureType.valueOf(figure), parameters);
        String info = geometricFigure.toString();
        if (args.length > 1) {
            FigureFileWriter fileWriter = new FigureFileWriter(args[1]);
            fileWriter.write(info);
        } else {
            System.out.println(info);
        }
    }
}