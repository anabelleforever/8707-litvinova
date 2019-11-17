import java.io.*;
import java.util.ArrayList;

public class FigureInfoReceiver {
    private ArrayList<String> fileContent = new ArrayList<>();
    private String info;
    private File output = null;

    FigureInfoReceiver(String[] args) throws IOException {
        File input = new File(args[0]);
        try (FileReader reader = new FileReader(input)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                fileContent.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден.");
            e.printStackTrace();
        }

        if(fileContent.size()>2) {
            info = GeometricFigure.valueOf(fileContent.get(0)).getAllInfo(fileContent.get(1), fileContent.get(2));
        } else {
            info = GeometricFigure.valueOf(fileContent.get(0)).getAllInfo(fileContent.get(1));
        }

        if(args.length>1){
            output = new File(args[1]);
        }
    }

    public FigureInfoReceiver() {
        System.out.println("Укажите в параметрах имя входного файла.");
    }

    public String getInfo() {
        return info;
    }

    public File getOutput() {
        return output;
    }
}
