import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

class Producer implements Runnable {
    public final static int QUANTITY_N = 4;
    public final static int WORK_TIME_TN = 1000;
    private Thread producer;
    final static Logger LOG = LoggerFactory.getLogger("Производитель");

    //private static final Logger log = Logger.getLogger();

    Producer(String producerID) {
        producer = new Thread(producerID);
    }

    @Override
    public void run() {
        LOG.info("{} начал работать", producer.getName());
        while (!Thread.interrupted()) {
            try {
                while (Main.storage.size() == Main.STORAGE_S) {
                    producer.wait();
                }
                Product product = new Product();
                System.out.printf("Продукт № %d создан\n", product.getProductID());
                Thread.sleep(WORK_TIME_TN);
                boolean added = false;
                while (!added) {
                    added = Main.storage.offer(product);
                    if (!added) {
                        producer.wait();
                    }
                }
                System.out.printf("Продукт № %d добавлен на склад\n", product.getProductID());
                notifyAll();
            } catch (InterruptedException e) {
                System.out.println(e);
                // запись в логи e.printStackTrace();
            }
        }
    }

    public void start() {
        producer.start();
    }
}