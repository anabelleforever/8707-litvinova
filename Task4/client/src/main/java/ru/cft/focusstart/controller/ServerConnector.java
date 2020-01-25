package ru.cft.focusstart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.cft.focusstart.dto.Notification;

import java.io.*;
import java.net.Socket;

import static ru.cft.focusstart.controller.Controller.getController;

class ServerConnector implements Runnable {
    private Socket clientSocket;
    private ObjectMapper mapper = new ObjectMapper();
    private String userName;
    private Thread thread;

    ServerConnector(Socket socket, String userName){
        clientSocket = socket;
        this.userName = userName;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (!thread.isInterrupted()) {
                Notification notification = null;
                if (reader.ready()) {
                    notification = mapper.readValue(reader.readLine(), Notification.class);
                }
                if (notification != null) {
                    getController().parseNotification(notification);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            }
            //описать все ошибки текстом
        } catch (JsonMappingException e) {
//            log.error(e.getMessage());
            System.out.println("ошибка маппинга реквеста");
        } catch (JsonProcessingException e) {
//            log.error(e.getMessage());
            System.out.println("не io ошибка json");
        } catch (IOException e) {
//            log.error(e.getMessage());
            System.out.println("io ошибка json");
        }
    }

    void notify(Notification notification) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            notification.setUserName(userName);
            writer.write(mapper.writeValueAsString(notification));
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
//            log.error("Ошибка при отправке сообщения. " + e.getMessage());
            System.out.println("Ошибка при отправке сообщения. ");
        }
    }

    void stop() {
        thread.interrupt();
        try {
            clientSocket.close();
        } catch (IOException e) {
//            log.error("Ошибка при закрытии сокета. " + e.getMessage());
            System.out.println("Ошибка при закрытии сокета. ");
        }
    }
}
