public class Circle extends Figures {
    private int radius;

    Circle(String first) {
        radius = Integer.parseInt(first);
        calculateProperties();
    }

    void setArea() {
        area = Math.PI * Math.pow(radius, 2);
        ;
    }

    void setPerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    void setParameters() {
        parameters = "Радиус: " + radius;
    }

    void setMaxSize() {
        maxSize = "Диаметр: " + 2 * radius;
    }
}

