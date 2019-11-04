import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tableLength = scanner.nextInt();                                   //получаем размер таблицы

        //проверка входных данных
        boolean correct = false;
        while (!correct) {
            if (tableLength < 1 || tableLength > 32) {
                System.out.println("Введите число в диапазоне от 1 до 32");
                tableLength = scanner.nextInt();
            } else correct = true;
        }

        int cellLength = String.valueOf(tableLength * tableLength).length();    //рассчитали размер ячейки

        //в этом цикле формируем построчно таблицу, где l - количество строк таблицы + разделители
        for (int l = 1; l < tableLength * 2; l++) {
            //в этом цикле формируем выводимые строки, где с - количество ячеек таблицы + разделители
            for (int c = 1; c < tableLength * 2; c++) {
                //если строка четная - состоит из цифр
                if (l % 2 > 0) {
                    //если ячейка четная, содержит число
                    if (c % 2 > 0) {
                        int content = (l + 1) / 2 * (c + 1) / 2;
                        //форматирование ширины ячейки
                        switch (cellLength) {
                            case (1):
                                System.out.printf("%1d", content);
                                break;
                            case (2):
                                System.out.printf("%2d", content);
                                break;
                            case (3):
                                System.out.printf("%3d", content);
                                break;
                            default:
                                System.out.printf("%4d", content);
                                break;
                        }
                    }
                    //если ячейка четная, содержит вертикальный разделитель
                    else System.out.print("|");
                }
                //если строка нечетная - состоит из разделителей
                else {
                    //если ячейка нечетная - ставится простой горизонтальный разделитель
                    if (c % 2 > 0) {
                        for (int i = 0; i < cellLength; i++) {
                            System.out.print("-");
                        }
                    }
                    //если ячейка четная - содержит угловой разделитель
                    else System.out.print("+");
                }
            }
            System.out.println("");
        }
    }
}
