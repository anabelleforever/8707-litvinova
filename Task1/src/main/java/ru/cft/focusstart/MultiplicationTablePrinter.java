package ru.cft.focusstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MultiplicationTablePrinter {

    public static void main(String[] args) {
        printGreeting(System.out);
        printInConsole(readTableLength(new BufferedReader(new InputStreamReader(System.in))));
    }

    public static int readTableLength(BufferedReader reader) {
        int tableLength = 0;
        boolean correct = false;
        while (!correct) {
            try {
                tableLength = Integer.parseInt(reader.readLine());
                if (tableLength < 1 || tableLength > 32) {
                    printGreeting(System.out);
                } else {
                    correct = true;
                }
            } catch (Exception e) {
                printGreeting(System.out);
            }
        }
        return tableLength;
    }

    public static void printGreeting(PrintStream printStream) {
        try {
            printStream.println("Введите целое число в диапазоне от 1 до 32:");
        } catch (Exception e) {
        }
    }

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
            System.out.println();
        }
    }
}