package ru.cft.focusstart;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
    public static void main(String[] args) {
        try {
            new Server().start();
        } catch (SocketException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
