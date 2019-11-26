package Figure;

public class Empty extends GeometricFigure {

    public Empty() {
        calculateProperties();
    }

    @Override
    void setName() {
        name = "Не указан";
    }

    @Override
    void setArea() {
        area = 0;
    }

    @Override
    void setPerimeter() {
        perimeter = 0;
    }

    @Override
    void setParameters() {
        parameters.add(0);
    }

    @Override
    void setMaxSize() {
        maxSize = 0;
    }

    @Override
    void setParametersName() {
        parametersName.add("Параметры не указаны: ");
    }

    @Override
    void setMaxSizeName() {
        maxSizeName = "Максимальный размер: ";
    }
}
