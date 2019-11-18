import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Figures {
    double area;
    double perimeter;
    String parameters;
    String maxSize;

    void calculateProperties() {
        setArea();
        setPerimeter();
        setParameters();
        setMaxSize();
    }

    abstract void setArea();

    abstract void setPerimeter();

    abstract void setParameters();

    abstract void setMaxSize();

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String getStringArea() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        String formatArea = new DecimalFormat("#.##", symbol).format(area);
        return "Площадь: " + formatArea;
    }

    public String getStringPerimeter() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        String formatPerimeter = new DecimalFormat("#.##", symbol).format(perimeter);
        return "Периметр: " + formatPerimeter;
    }

    public String getStringParameters() {
        return parameters;
    }

    public String getStringMaxFigureSize() {
        return maxSize;
    }

    public String getFigureInfo() {
        StringBuffer figInfo = new StringBuffer();
        figInfo.append(getStringArea()).append("\n");
        figInfo.append(getStringPerimeter()).append("\n");
        figInfo.append(getStringParameters()).append("\n");
        figInfo.append(getStringMaxFigureSize()).append("\n");
        return String.valueOf(figInfo);
    }
}
