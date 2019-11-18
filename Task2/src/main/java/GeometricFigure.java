public enum GeometricFigure {
    CIRCLE("Круг") {
        @Override
        String getFigureInfo(String first, String second) {
            return new Circle(first).getFigureInfo();
        }
    },
    RECTANGLE("Прямоугольник") {
        @Override
        String getFigureInfo(String first, String second) {
            return new Rectangle(first, second).getFigureInfo();
        }
    },
    SQUARE("Квадрат") {
        @Override
        String getFigureInfo(String first, String second) {
            return new Square(first).getFigureInfo();
        }
    };

    private String name;

    GeometricFigure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract String getFigureInfo(String firstParameter, String secondParameter);

    public String getAllInfo(String firstParameter, String secondParameter) {
        String allInfo = "Тип фигуры: " + name + "\n" +
                getFigureInfo(firstParameter, secondParameter);
        return allInfo;
    }

    public String getAllInfo(String firstParameter) {
        return getAllInfo(firstParameter, firstParameter);
    }
}
