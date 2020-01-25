package ru.cft.focusstart.gui.panels;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.model.PanelManager;

import javax.swing.*;

public final class UserListPanel implements Observer {
    private static UserListPanel userListPanel;
    private static JTextArea userListWindow = new JTextArea();
    private static JScrollPane userListPane = new JScrollPane();

    private UserListPanel() {
    }

    public static UserListPanel getUserListPanel() {
        if (userListPanel == null) {
            userListPanel = new UserListPanel();
        }
        PanelManager.addObserver(userListPanel);
        return userListPanel;
    }

    public JScrollPane getUserListPane() {
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
