package ru.cft.focusstart;

class Consumer implements Runnable {
    final static int QUANTITY_M = 10;
    private final static int WORK_TIME_TM = 2000;
    private Thread consumer;

    Consumer(String consumerID) {
        consumer = new Thread(this);
        consumer.setName(consumerID);
    }

    @Override
    public void run() {
        Main.LOG.info("начал работать");
        while (!Thread.interrupted()) {
            try {
                long tempID = Main.storage.take().getProductID();
                Main.LOG.info("Ресурс №{} забран со склада", tempID);
                Thread.sleep(WORK_TIME_TM);
                Main.LOG.info("Ресурс №{} потреблен", tempID);
            } catch (InterruptedException e) {
                Main.LOG.error("Вызвано прерывание");
            }
        }
    }

    void start() {
        consumer.start();
    }
}