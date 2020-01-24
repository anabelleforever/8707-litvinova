package ru.cft.focusstart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.log4j.Logger;
import ru.cft.focusstart.dto.Notification;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
    private Socket clientSocket;
    private ObjectMapper mapper = new ObjectMapper();
    String userName;
    private Thread thread;
    private Logger log = Logger.getLogger("Client: ");

    Client(Socket socket) {
        clientSocket = socket;
        mapper.registerModule(new JavaTimeModule());
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (!thread.isInterrupted()) {
                Notification notification = mapper.readValue(reader.readLine(), Notification.class);
                ClientManager.getClientManager().interpretNotification(notification, this);
            }
            //описать все ошибки текстом
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///отловить ошибки выше
    void notify(Notification notification) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            notification.setUserName(userName);
            writer.write(mapper.writeValueAsString(notification));
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            log.error("Ошибка при отправке сообщения. " + e.getMessage());
        }
    }

    public void stop() {
        thread.interrupt();
    }
}
