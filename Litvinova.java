import java.util.Scanner;

public class Litvinova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tableLength = scanner.nextInt();                    //размер таблицы

        //простая проверка
        boolean correct = false;
        while (!correct) {
            if (tableLength < 1 || tableLength > 32) {
                System.out.println("Введите число в диапазоне от 1 до 32.");
                tableLength = scanner.nextInt();
            } else correct = true;
        }

        int maxNumber = tableLength * tableLength;              //максимальное число таблицы
        int cellLength = String.valueOf(maxNumber).length();    //размер ячеек таблицы

        int cellContent = 0;                                    //содержимое ячейки
        //в этом цикле наполняем наш лист готовыми строками, l - количество всех строк таблицы + разделения
        for (int l = 1; l < tableLength * 2; l++) {
            //в этом цикле формируем строку таблицы, с - количество всех ячеек + разделения
            for (int c = 1; c < tableLength * 2; c++) {
                //если строка нечетная - содержит цифры
                if (l % 2 > 0) {
                    //если ячейка нечетная - содержит цифры
                    if (c % 2 > 0) {
                        //форматирование размера ячейки
                        cellContent = (c + 1) / 2 * (l + 1) / 2;
                        switch (cellLength) {
                            case (1):
                                System.out.printf("%1d", cellContent);
                                break;
                            case (2):
                                System.out.printf("%2d", cellContent);
                                break;
                            case (3):
                                System.out.printf("%3d", cellContent);
                                break;
                            default:
                                System.out.printf("%4d", cellContent);
                                break;
                        }
                    }

                    //если ячейка четная - содержит знак разделения
                    else System.out.printf("|");
                }

                //если четная строка - содержит знаки разделения
                else {
                    //если ячейка нечетная - содержит простое разделение
                    if (c % 2 > 0) {
                        for (int i = 0; i < cellLength; i++) {
                            System.out.printf("-");
                        }
                    }

                    //если четная - угловое
                    else System.out.printf("+");
                }
            }
            System.out.println("");
        }
    }
}
