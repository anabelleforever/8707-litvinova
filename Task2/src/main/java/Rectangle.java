import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rectangle extends Figures {
    private int length;
    private int width;

    public Rectangle(String first, String second) {
        length = Integer.parseInt(first);
        width = Integer.parseInt(second);
        calculateProperties();
    }

    void setArea() {
        area = length * width;
    }

    void setPerimeter() {
        perimeter = 2 * length + 2 * width;
    }

    void setParameters() {
        parameters = "Длина: " + length + "\n" +
                "Ширина: " + width;
    }

    void setMaxSize() {
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        double diagonal = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
        String formatDiagonal = new DecimalFormat("#.##", symbol).format(diagonal);
        maxSize = "Длина диагонали: " + formatDiagonal;
    }
}
