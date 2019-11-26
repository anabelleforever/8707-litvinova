import org.slf4j.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public final static int STORAGE_S = 10;
    public static ConcurrentLinkedQueue<Product> storage = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        for (int p = 1; p <= Producer.QUANTITY_N; p++) {
            new Producer("Производитель №" + p).start();
            System.out.println("Создан производитель №"+p);
        }

        for (int c = 1; c <= Consumer.QUANTITY_M; c++) {
            new Consumer("Потребитель №" + c, storage).start();
            System.out.println("Создан потребитель №"+c);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}