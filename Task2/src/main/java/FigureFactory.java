import Figure.*;

import java.util.ArrayList;

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
