package ru.cft.focusstart.gui.panels;

import ru.cft.focusstart.dto.Notification;

import javax.swing.*;

public final class UserListPanel implements Observer {
//    private static UserListPanel userListPanel;
    private static JTextArea userListWindow;
    private static JScrollPane userListPane;

    private UserListPanel() {}

    public static JScrollPane getUserListPanel() {
        userListPane = new JScrollPane();
        userListWindow = new JTextArea();
        userListWindow.setEditable(false);
        userListPane.setViewportView(userListWindow);
        return userListPane;
    }

    public void update(Notification notification) {
        userListWindow.setText("");
        for (String user : notification.getUserList()) {
            userListWindow.append(user);
            userListWindow.append(System.lineSeparator());
        }
    }
}
