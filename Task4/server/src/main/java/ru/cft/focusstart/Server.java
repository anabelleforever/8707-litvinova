package ru.cft.focusstart;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Properties;

public class Server {
    private ServerSocket serverSocket;
    private boolean serverRunning;

    public Server(){
        start();
    }

    void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        try {
            int port = getPort();
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            //throw new SocketException("Не удалось открыть соединение! " + e.getMessage());
        }
    }

    private static int getPort(){
        Properties properties = new Properties();
        try (InputStream propertiesStream = Server.class.getResourceAsStream("/server.properties")) {
            if (propertiesStream != null) {
                properties.load(propertiesStream);
            }
            return Integer.valueOf(properties.getProperty("server.port"));
        } catch (NumberFormatException e) {
            //throw new IOException("Порт должен быть числом!", e);
        } catch (IOException e) {
            //throw new IOException("Не удалось получить порт из ресурсов!", e);
        }
    }

    public void close() {

    }
}
