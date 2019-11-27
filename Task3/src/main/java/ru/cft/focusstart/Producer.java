package ru.cft.focusstart;

class Producer implements Runnable {
    final static int QUANTITY_N = 5;
    private final static int WORK_TIME_TN = 1000;
    private Thread producer;

    Producer(String producerID) {
        producer = new Thread(this);
        producer.setName(producerID);
    }

    @Override
    public void run() {
        Main.LOG.info("начал работать");
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(WORK_TIME_TN);
                Product product = new Product();
                Main.LOG.info("Ресурс №{} произведен", product.getProductID());
                Main.storage.put(product);
                Main.LOG.info("Ресурс №{} помещен на склад", product.getProductID());
            } catch (InterruptedException e) {
                Main.LOG.error("Возникло прерывание.");
            }
        }
    }

    void start() {
        producer.start();
    }
}