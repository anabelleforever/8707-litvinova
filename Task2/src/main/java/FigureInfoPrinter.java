import java.io.*;
import java.util.ArrayList;

public class FigureInfoPrinter {

    FigureInfoPrinter(String inf, File file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(inf);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден.");
            new FigureInfoPrinter(inf);
        }
    }

    FigureInfoPrinter(String inf) {
        System.out.println(inf);
    }
}
