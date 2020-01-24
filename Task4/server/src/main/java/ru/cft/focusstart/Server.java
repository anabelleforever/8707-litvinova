package ru.cft.focusstart;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

final class Server {
    private static Server server;
    private static ServerSocket serverSocket;
    static boolean serverRunning;
    private static Logger log = Logger.getLogger("Server: ");

    private Server(){}

    public static Server getServer(){
        if(server==null){
            server = new Server();
        }
        return server;
    }

    void start() {
//        if (server == null) {
//            server = new Server();
//        }
        Runtime.getRuntime().addShutdownHook(new Thread(server::close));
        Properties properties = new Properties();
        try (InputStream propertiesStream = Server.class.getResourceAsStream("/server.properties")) {
            if (propertiesStream != null) {
                properties.load(propertiesStream);
            }
            serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty("server.port")));
        } catch (IOException e) {
            log.error("Не удалось открыть соединение с сервером! " + e.getMessage());
        }

        listenServerSocket();

    }

    void close() {
        serverRunning = false;
        try {
            serverSocket.close();
            //добавить закрытие сокетов клиентов
//            for (Socket socket : clients) {
//                socket.close();
//            }
        } catch (IOException e) {
            log.error("Ошибка при закрытии соединения. " + e.getMessage());
        }
    }

    void listenServerSocket() {
        while (serverRunning) {
            try(Socket socket = serverSocket.accept()) {
                Client client = new Client(socket);
            } catch (IOException e) {
                log.error("Ошибка соединения с клиентом. " + e.getMessage());
            }
        }
    }
}

