import java.awt.*;

public enum GeometricFigure implements FigureInfo {
    CIRCLE("Круг") {
        @Override
        void calculateProperties(int firstParameter, int secondParameter) {
            area = Math.PI * Math.pow(firstParameter, 2);
            perimeter = 2 * Math.PI * firstParameter;
            parameters = "Радиус: " + firstParameter;
            maxSize = "Диаметр: " + 2*firstParameter;
        }
    },
    RECTANGLE("Прямоугольник") {
        @Override
        void calculateProperties(int firstParameter, int secondParameter) {
            area = firstParameter * secondParameter;
            perimeter = 2 * firstParameter + 2 * secondParameter;
            parameters = "Длина: " + firstParameter +
                         "Ширина: " + secondParameter;
            maxSize = String.format("Длина диагонали: %.2f", Math.sqrt(Math.pow(firstParameter,2) + Math.pow(secondParameter,2)));
        }
    },
    SQUARE("Квадрат") {
        @Override
        void calculateProperties(int firstParameter, int secondParameter) {
            area = Math.pow(firstParameter, 2);
            perimeter = 4 * firstParameter;
            parameters = "Длина: " + firstParameter;
            maxSize = String.format("Длина диагонали: %.2f", Math.sqrt(2)*firstParameter);
        }
    };

    private String name;
    double area;
    double perimeter;
    String parameters;
    String maxSize;


    GeometricFigure(String name) {
        this.name = name;
    }

    abstract void calculateProperties(int firstParameter, int secondParameter);

    public String getName() {
        return "Тип фигуры: " + name;
    }

    public String getStringArea(){
        String formatArea = String.format("%.2f", area);
        return "Площадь: " + formatArea;
    }

    public String getStringPerimeter() {
        String formatPerimeter = String.format("%.2f", perimeter);
        return "Периметр: " + formatPerimeter;
    }

    public String getStringParameters() {
        return parameters;
    }

    public String getStringMaxFigureSize() {
        return maxSize;
    }

    public String getAllInfo(String first, String second){
        calculateProperties(Integer.parseInt(first), Integer.parseInt(second));
        StringBuffer allInfo = new StringBuffer();
        allInfo.append(getName()).append("\n");
        allInfo.append(getStringArea()).append("\n");
        allInfo.append(getStringPerimeter()).append("\n");
        allInfo.append(getStringParameters()).append("\n");
        allInfo.append(getStringMaxFigureSize()).append("\n");
        return String.valueOf(allInfo);
    }

    public String getAllInfo(String first){
        return getAllInfo(first, first);
    }
}
