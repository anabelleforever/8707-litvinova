import java.io.*;

class FigureFileWriter {
    private File outputFile;

    FigureFileWriter(String file) {
        outputFile = new File(file);
    }

    void write(String inf) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, true))) {
            bufferedWriter.write(inf);
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден.");
            System.out.println(inf);
        }
    }
}
