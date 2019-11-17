import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length>0) {
                FigureInfoReceiver data = new FigureInfoReceiver(args);
                if(data.getOutput()!=null){
                    new FigureInfoPrinter(data.getInfo(), data.getOutput());
                } else {
                    new FigureInfoPrinter(data.getInfo());
                }
            } else {
                new FigureInfoReceiver();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
