package ru.cft.focusstart.Figure;

import java.util.ArrayList;

public class Circle extends GeometricFigure {
    private final static String NAME = "Круг";
    private int radius;

    public Circle(ArrayList<Integer> parameters) {
        //????????проверка параметра на наличие / больше нуля

        radius = parameters.get(0);
        calculateProperties();
    }

    public int getRadius(){
        return radius;
    }

    @Override
    void setName() {
        name = NAME;
    }

    @Override
    void setArea() {
        area = Math.PI * Math.pow(radius, 2);
    }

    @Override
    void setPerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    void setParameters() {
        parameters.add(radius);
    }

    @Override
    void setMaxSize() {
        maxSize = 2 * radius;
    }

    @Override
    void setParametersName() {
        parametersName.add("Радиус: ");
    }

    @Override
    void setMaxSizeName() {
        maxSizeName = "Диаметр: ";
    }
}