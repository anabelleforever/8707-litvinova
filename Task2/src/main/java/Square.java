public class Square extends Rectangle {
    private int length;

    public Square(String first) {
        super(first, first);
        length = Integer.parseInt(first);
        calculateProperties();
    }

    @Override
    void setParameters() {
        parameters = "Длина: " + length;
    }
}
