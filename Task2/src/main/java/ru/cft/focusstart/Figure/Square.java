package ru.cft.focusstart.Figure;

import ru.cft.focusstart.Figure.Rectangle;

import java.util.ArrayList;

public class Square extends Rectangle {
    private final static String NAME = "Квадрат";
    private int size;

    public Square(ArrayList<Integer> parameters) {
        super(parameters);
        size = parameters.get(0);
        calculateProperties();
    }

    public int getSize(){
        return size;
    }

    @Override
    void setName() {
        name = NAME;
    }

    @Override
    void setParameters() {
        parameters.clear();
        parameters.add(size);
    }

    @Override
    void setParametersName() {
        parametersName.clear();
        parametersName.add("Длина: ");
    }
}
