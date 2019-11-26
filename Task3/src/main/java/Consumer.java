import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

class Consumer implements Runnable {
    public final static int QUANTITY_M = 8;
    public final static int WORK_TIME_TM = 2000;
    private Thread consumer;
    final static Logger LOG = LoggerFactory.getLogger("Потребитель");

    public Consumer(String consumerID, ConcurrentLinkedQueue storage) {
        consumer = new Thread(consumerID);
    }

    @Override
    public void run() {
        System.out.printf("Потребитель %s начал работать", consumer.getName());
        while (!Thread.interrupted()) {
            try {
                while (Main.storage.size() == 0) {
                    consumer.wait();
                }
                Product product = null;
                boolean taken = false;
                while (!taken) {
                    product = Main.storage.poll();
                    if (product.equals(null)) {
                        consumer.wait();
                    } else {
                        taken = true;
                    }
                }
                int tempID = product.getProductID();
                System.out.printf("Продукт %d взят со склада\n", tempID);
                Thread.sleep(WORK_TIME_TM);
                product = null;
                System.out.printf("Продукт %d потреблен", tempID);
                notifyAll();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void start() {
        consumer.start();
    }
}