package ru.cft.focusstart.gui.panels;

import ru.cft.focusstart.dto.Notification;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ChatPanel implements Observer {
    private static ChatPanel chatPanel;
    private static JScrollPane chatPane = new JScrollPane();
    private static JTextArea tfChat = new JTextArea();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    private ChatPanel() {}

    public static Observer getChatPanel() {
        if (chatPanel==null){
            chatPanel = new ChatPanel();
        }
        return chatPanel;
    }

    public static JScrollPane getChatPane() {
        tfChat.setEditable(false);
        chatPane.setViewportView(tfChat);
        return chatPane;
    }

    public void update(Notification notification) {
        String date = dateFormat.format(new Date());
        tfChat.append(date + " " + notification.getUserName() + " : " + notification.getMessage());
        tfChat.append(System.lineSeparator());
    }
}
