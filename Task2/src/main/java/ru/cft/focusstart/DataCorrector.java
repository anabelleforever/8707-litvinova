package ru.cft.focusstart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DataCorrector {
    private String[] args;
    private String figure = null;
    private ArrayList<Integer> parameters = new ArrayList<>();

    DataCorrector(String[] args){
        this.args = args;
    }

    String getFigure() {
        return figure;
    }

    ArrayList<Integer> getParameters() {
        return parameters;
    }

    void correct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file = "";
        if (args.length > 0) {
            file = args[0];
        } else {
            while (file.isEmpty()) {
                System.out.println("Не указан входной файл. Введите путь к файлу:");
                file = scanner.nextLine();
            }
        }
        FigureFileReader fileReader = new FigureFileReader(file);
        ArrayList<String> fileContent = fileReader.read();

        while (fileContent.isEmpty()) {
            System.out.println("Отсутствует информация. Введите необходимые данные с каждой новой строки. Для окончания введите END.");
            String temp;
            while (!(temp = scanner.nextLine()).equals("END")) {
                fileContent.add(temp);
            }
        }
        while (fileContent.size() == 1) {
            System.out.println("Не указаны параметры фигуры. Введите необходимые данные с каждой новой строки. " +
                    "Для окончания введите END.");
            String temp;
            while (!(temp = scanner.nextLine()).equals("END")) {
                fileContent.add(temp);
            }
        }
        figure = fileContent.get(0);
        if (figure.isBlank()) {
            figure = "NULL";
        }
        for (int i = 1; i < fileContent.size(); i++) {
            String s = fileContent.get(i);
            boolean isNumber = false;
            int parameter = -1;
            while (!isNumber) {
                try {
                    parameter = Integer.parseInt(s);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("Неверно указан тип параметра фигуры: " + s + ". Введите целое число:");
                    s = scanner.nextLine();
                }
            }
            while (parameter < 0) {
                System.out.println("Неверно указан параметр фигуры: " + s + ". Введите целое положительное число:");
                s = scanner.nextLine();
                parameter = Integer.parseInt(s);
            }
            parameters.add(parameter);
        }
    }
}
