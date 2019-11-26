import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private final static int STORAGE_S = 20;
    static LinkedBlockingQueue<Product> storage = new LinkedBlockingQueue<>(STORAGE_S);
    final static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        for (int p = 1; p <= Producer.QUANTITY_N; p++) {
            new Producer("Производитель №" + p).start();
        }
        for (int c = 1; c <= Consumer.QUANTITY_M; c++) {
            new Consumer("Потребитель №" + c).start();
        }
    }
}