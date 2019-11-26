package ru.cft.focusstart;

import ru.cft.focusstart.Figure.*;

import java.util.ArrayList;

import static ru.cft.focusstart.FigureType.*;
import static ru.cft.focusstart.FigureType.CIRCLE;

class FigureFactory {

    GeometricFigure getFigure(FigureType type, ArrayList<Integer> parameters) {
        GeometricFigure figure;
        switch (type) {
            case CIRCLE:
                figure = new Circle(parameters);
                break;
            case RECTANGLE:
                figure = new Rectangle(parameters);
                break;
            case SQUARE:
                figure = new Square(parameters);
                break;
            case NULL:
                figure = new Empty();
                break;
            default:
                throw new IllegalArgumentException("Неверно указан тип: " + type);
        }
        return figure;
    }
}
