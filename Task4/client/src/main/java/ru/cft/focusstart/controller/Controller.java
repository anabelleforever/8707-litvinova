package ru.cft.focusstart.controller;

import ru.cft.focusstart.gui.windows.AuthorizationWindow;
import ru.cft.focusstart.model.WindowManager;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

final class Controller {
    private static Controller controller;
    private Logger log = Logger.getLogger("Controller: ");
    private String userName;
    private String serverAddress;
    private int serverPort;
    private String serverHost;

    private Socket socket;


    private Controller() {
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void start() {
        AuthorizationWindow.getAuthorizationWindow().display();
    }


    public void connect() {
        try {
            socket = new Socket(serverHost, serverPort);
        }catch (IllegalArgumentException e){
            WindowManager.makeWarningWindow("Wrong server address, please try again.");
            clearData();
        }catch (UnknownHostException e){
            WindowManager.makeWarningWindow("Host could not be determined.");
            clearData();
        }catch (IOException e) {
            WindowManager.makeWarningWindow(null);
            log.error("Ошибка соединения с сервером. " + e.getMessage());
        }
    }

    void authorizeUser() {
        userName = AuthorizationWindow.getAuthorizationWindow().getUserName();
        serverAddress= AuthorizationWindow.getAuthorizationWindow().getServerPort();
        String[] address = serverAddress.split(":");
        if (address.length != 2) {
            WindowManager.makeWarningWindow("Wrong server address, please try again.");
            clearData();
        } else {
            serverHost = address[0];
            serverPort = Integer.valueOf(address[1]);
            connect();
            WindowManager.closeWindow(AuthorizationWindow.getAuthorizationWindow());
        }
    }

    private void clearData() {
        userName = null;
        serverHost = null;
        serverHost = null;
        serverPort = 0;
    }
}


