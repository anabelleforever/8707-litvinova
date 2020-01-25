package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;

import java.util.ArrayList;
import java.util.Observer;

import static ru.cft.focusstart.ClientManager.getClientManager;

final class NotificationFactory {

    static Notification getNotification(NotificationType type) {
        Notification notification;
        switch (type) {
            case VALID_USERNAME:
                notification = new Notification(NotificationType.VALID_USERNAME);
                break;
            case INVALID_USERNAME:
                notification = new Notification(NotificationType.INVALID_USERNAME);
                notification.setMessage("Username is invalid. Try another one.");
                break;
            case CONNECTED:
                notification = new Notification(NotificationType.CONNECTED);
                break;
            case MESSAGE:
                notification = new Notification(NotificationType.MESSAGE);
                break;
            case DISCONNECTED:
                notification = new Notification(NotificationType.DISCONNECTED);
                break;
            default:
                throw new IllegalArgumentException("Неверно указан тип: " + type);
        }
        return notification;
    }

    static Notification getNotification(NotificationType type, Client client) {
        Notification notification;
        switch (type) {
            case VALID_USERNAME:
                notification = new Notification(NotificationType.VALID_USERNAME);
                break;
            case INVALID_USERNAME:
                notification = new Notification(NotificationType.INVALID_USERNAME);
                notification.setMessage("Username is invalid. Try another one.");
                break;
            case CONNECTED:
                notification = new Notification(NotificationType.CONNECTED);
                notification.setUserName(client.getUserName());
                notification.setUserList((ArrayList<String>) getClientManager().getUserList());
                break;
            case MESSAGE:
                notification = new Notification(NotificationType.MESSAGE);
                notification.setUserName(client.getUserName());
                notification.setUserList((ArrayList<String>) getClientManager().getUserList());
                break;
            case DISCONNECTED:
                notification = new Notification(NotificationType.DISCONNECTED);
                notification.setUserName(client.getUserName());
                notification.setUserList((ArrayList<String>) getClientManager().getUserList());
                break;
            default:
                throw new IllegalArgumentException("Неверно указан тип: " + type);
        }
        return notification;
    }
}
