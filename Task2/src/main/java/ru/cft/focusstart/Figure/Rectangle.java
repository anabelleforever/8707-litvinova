package ru.cft.focusstart.Figure;

import java.util.ArrayList;

public class Rectangle extends GeometricFigure {
    private final static String NAME = "Прямоугольник";
    private int length;
    private int width;

    public Rectangle(ArrayList<Integer> parameters) {
        if(parameters.size()==1) {
            length = width = parameters.get(0);
        } else {
            length = parameters.get(0);
            width = parameters.get(1);
        }
        calculateProperties();
    }

    @Override
    void setName() {
        name = NAME;
    }

    @Override
    void setArea() {
        area = length * width;
    }

    @Override
    void setPerimeter() {
        perimeter = 2 * length + 2 * width;
    }

    @Override
    void setParametersName() {
        parametersName.add("Длина: ");
        parametersName.add("Ширина: ");
    }

    @Override
    void setParameters() {
        parameters.add(length);
        parameters.add(width);
    }

    @Override
    void setMaxSizeName() {
        maxSizeName = "Длина диагонали: ";
    }

    @Override
    void setMaxSize() {
        maxSize = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }
}
