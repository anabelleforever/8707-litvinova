package ru.cft.focusstart.controller;

import ru.cft.focusstart.gui.panels.ChatPanel;
import ru.cft.focusstart.gui.panels.UserListPanel;
import ru.cft.focusstart.gui.windows.AuthorizationWindow;

public class Client {
    public static void main(String[] args) {

        //переставить в connector
        AuthorizationWindow authorization = new AuthorizationWindow();
        authorization.display();
        PanelManager.addObserver(ChatPanel.getChatPanel());
        PanelManager.addObserver(UserListPanel.getUserListPanel());
//
    }
}


