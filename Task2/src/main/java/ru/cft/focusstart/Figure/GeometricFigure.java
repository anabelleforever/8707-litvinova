package ru.cft.focusstart.Figure;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public abstract class GeometricFigure {
    String name;
    double area;
    double perimeter;
    ArrayList<Integer> parameters = new ArrayList<>();
    double maxSize;

    ArrayList<String> parametersName = new ArrayList<>();
    String maxSizeName;

    void calculateProperties() {
        setName();
        setArea();
        setPerimeter();
        setParameters();
        setMaxSize();
        setParametersName();
        setMaxSizeName();
    }

    abstract void setName();

    abstract void setArea();

    abstract void setPerimeter();

    abstract void setParameters();

    abstract void setMaxSize();

    abstract void setParametersName();

    abstract void setMaxSizeName();

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public ArrayList<Integer> getParameters() {
        return parameters;
    }

    public double getMaxSize() {
        return maxSize;
    }

    private String getStringName() {
        return "Тип фигуры: " + name;
    }

    private String getStringArea() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        String formatArea = new DecimalFormat("#.##", symbol).format(area);
        return "Площадь: " + formatArea;
    }

    private String getStringPerimeter() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        String formatPerimeter = new DecimalFormat("#.##", symbol).format(perimeter);
        return "Периметр: " + formatPerimeter;
    }

    private String getStringParameters() {
        ArrayList<String> temp = parametersName;
        StringBuilder parameterBuilder = new StringBuilder();
        for (Integer param : parameters) {
            for (String name : temp) {
                parameterBuilder.append(name).append(param).append(System.lineSeparator());
                temp.remove(name);
                break;
            }
        }
        return String.valueOf(parameterBuilder);
    }

    private String getStringMaxFigureSize() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        String formatMaxSize = new DecimalFormat("#.##", symbol).format(maxSize);
        return maxSizeName + formatMaxSize;
    }

    @Override
    public String toString() {
        StringBuilder figInfo = new StringBuilder();
        figInfo.append(getStringName()).append(System.lineSeparator());
        figInfo.append(getStringArea()).append(System.lineSeparator());
        figInfo.append(getStringPerimeter()).append(System.lineSeparator());
        figInfo.append(getStringParameters());
        figInfo.append(getStringMaxFigureSize()).append(System.lineSeparator());
        return String.valueOf(figInfo);
    }
}