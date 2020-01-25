package ru.cft.focusstart.controller;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;
import ru.cft.focusstart.gui.windows.AuthorizationWindow;
import ru.cft.focusstart.gui.windows.ChatWindow;
import ru.cft.focusstart.model.WindowManager;

//import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static ru.cft.focusstart.controller.NotificationFactory.getNotification;
import static ru.cft.focusstart.gui.windows.AuthorizationWindow.getAuthorizationWindow;
import static ru.cft.focusstart.gui.windows.ChatWindow.getChatWindow;
import static ru.cft.focusstart.model.PanelManager.updatePanels;
import static ru.cft.focusstart.model.WindowManager.*;

public final class Controller {
    private static Controller controller;
    //    private Logger log = Logger.getLogger("Controller: ");
    private String userName;
    private String serverAddress;
    private int serverPort;
    private String serverHost;
    private ServerConnector serverConnector;
    private Socket socket;


    private Controller() {
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    void start() {
        displayWindow(getAuthorizationWindow());
    }

    void authorizeUser() {
        userName = getAuthorizationWindow().getUserName();
        serverAddress = getAuthorizationWindow().getServerPort();
        serverAddress = serverAddress.replaceAll(" ", "");
        String[] address = serverAddress.split(":");
        if (address.length != 2) {
            makeWarningWindow("Wrong server address, please try again.");
            clearData();
        } else {
            serverHost = address[0];
            serverPort = Integer.valueOf(address[1]);
            connect();


            closeWindow(getAuthorizationWindow());
        }
    }

    private void connect() {
        try {
//            socket = new Socket(serverHost, serverPort);
            socket = new Socket("localhost", 2525);
            serverConnector = new ServerConnector(socket, userName);
            Notification userVerification = getNotification(NotificationType.USER_VERIFICATION);
            serverConnector.notify(userVerification);
        } catch (IllegalArgumentException e) {
            makeWarningWindow("Wrong server address, please try again.");
            clearData();
        } catch (UnknownHostException e) {
            makeWarningWindow("Host could not be determined.");
            clearData();
        } catch (IOException e) {
            makeWarningWindow("Something goes wrong...");
//            log.error("Ошибка соединения с сервером. " + e.getMessage());
        }
    }

    private void clearData() {
        userName = null;
        serverHost = null;
        serverAddress = null;
        serverPort = 0;
    }

    void parseNotification(Notification notification) {
        switch (notification.getNotificationType()) {
            case INVALID_USERNAME:
                makeWarningWindow(notification.getMessage());
                serverConnector.stop();
                clearData();
                break;
            case VALID_USERNAME:
                displayWindow(getChatWindow());
                break;
            case CONNECTED:
            case MESSAGE:
            case DISCONNECTED:
                updatePanels(notification);
        }

    }

    void sendMessage() {
        String message = getChatWindow().getMessage();
        Notification userMessage = getNotification(NotificationType.MESSAGE);
        userMessage.setMessage(message);
        serverConnector.notify(userMessage);
    }

    void disconnect() {
        try {
            Notification disconnected = getNotification(NotificationType.DISCONNECTED);
            serverConnector.notify(disconnected);
            socket.close();
            clearData();
            System.exit(0);
        } catch (IOException e) {
//            log.error("Ошибка закрытия соединения. " + e.getMessage());
        }
    }
}


