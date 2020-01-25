package ru.cft.focusstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    //    private static Server server;
    private static ServerSocket serverSocket;
    static boolean serverRunning;
    public Properties properties;
//    final static Logger log = LoggerFactory.getLogger(Server.class);

//    private Server() {
//    }

//    public static Server getServer() {
//        if (server == null) {
//            server = new Server();
//        }
//        return server;
//    }

    public void start() {
        Properties properties = new Properties();
        try (InputStream propertiesStream = Server.class.getResourceAsStream("/server.properties")) {
            if (propertiesStream != null) {
                properties.load(propertiesStream);
            }
            int port = Integer.valueOf(properties.getProperty("server.port"));
            System.out.println(port);
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
//            log.error("Не верно указан порт. " + e.getMessage());
            System.out.println("ошибка открытия порта");
        }

        } catch (NumberFormatException e) {
//            log.error("Не верно указан порт. " + e.getMessage());
            System.out.println("неверный формат порта");
        } catch (IOException e) {
//            log.error("Не удалось открыть соединение с сервером. " + e.getMessage());
            System.out.println("ошибка соединения");
        }
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        if(serverSocket!=null) {
            serverRunning = true;
            listenServerSocket();
        }
    }

    void close() {
        serverRunning = false;
        try {
            for (Client client : ClientManager.getClientManager().getClients()) {
                client.getClientSocket().close();
            }
            if (serverSocket != null) serverSocket.close();
//        } catch (NullPointerException e) {
//            log.error("");
        } catch (IOException e) {
//            log.error("Ошибка при закрытии соединения. " + e.getMessage());
            System.out.println("Ошибка при закрытии соединения. ");
        }
    }

    void listenServerSocket() {
        while (serverRunning) {
            try (Socket socket = serverSocket.accept()) {
                Client client = new Client(socket);
            } catch (IOException e) {
//                log.error("Ошибка соединения с клиентом. " + e.getMessage());
                System.out.println("Ошибка соединения с клиентом.");
            } finally {

            }
        }
    }
}

