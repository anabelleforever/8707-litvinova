package ru.cft.focusstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MultiplicationTablePrinter {

    static int min = 1;
    static int max = 32;

    public static void main(String[] args) {
        printGreeting(System.out);
        printInConsole(readTableLength(new BufferedReader(new InputStreamReader(System.in))));
    }

    public static int readTableLength(BufferedReader reader) {
        //добиваемся от пользователя корректных входных данных
        int tableLength = 0;
        boolean correct = false;
        String input;
        while (!correct) {
            try {
                tableLength = Integer.parseInt(input = reader.readLine());
                if (tableLength < min || tableLength > max) {
                    printGreeting(System.out);
                } else {
                    correct = true;
                }
            } catch (Exception e) {
                //e.printStackTrace();
                printGreeting(System.out);
            }
        }
        return tableLength;
    }

    public static void printGreeting(PrintStream printStream) {
        try {
            printStream.println("Введите целое число в диапазоне от " + min + " до " + max + ":");
        } catch (Exception e) {
        }
    }

    //разбить на 2 метода: формирование двумерного массива и вывод в консоль?
    public static void printInConsole(int tableLength) {
        int cellLength = String.valueOf(tableLength * tableLength).length();
        for (int l = 1; l < tableLength * 2; l++) {
            for (int c = 1; c < tableLength * 2; c++) {
                if (l % 2 > 0) {
                    if (c % 2 > 0) {
                        int content = (l + 1) / 2 * (c + 1) / 2;
                        System.out.printf("%" + cellLength + "d", content);
                    } else {
                        System.out.print("|");
                    }
                } else {
                    if (c % 2 > 0) {
                        for (int i = 0; i < cellLength; i++) {
                            System.out.print("-");
                        }
                    } else {
                        System.out.print("+");
                    }
                }
            }
            System.out.println("");
        }
    }
}
