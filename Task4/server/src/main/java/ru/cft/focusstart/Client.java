package ru.cft.focusstart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.cft.focusstart.dto.Notification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class Client implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ObjectMapper mapper = new ObjectMapper();
    private Server server;
    String userName;
    private Thread thread;

    @Override
    public void run() {

    }

    void notify(Notification notification) throws IOException {
        writer.write(mapper.writeValueAsString(notification));
        writer.write(System.lineSeparator());
        writer.flush();
    }
}
