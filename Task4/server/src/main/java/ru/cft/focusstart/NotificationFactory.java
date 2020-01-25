package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;

import java.util.ArrayList;
import java.util.Observer;

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
                notification.setUserList((ArrayList<String>) ClientManager.getClientManager().getUserList());
                break;
            case MESSAGE:
                notification = new Notification(NotificationType.MESSAGE);
                notification.setUserList((ArrayList<String>) ClientManager.getClientManager().getUserList());
                break;
            case DISCONNECTED:
                notification = new Notification(NotificationType.DISCONNECTED);
                notification.setUserList((ArrayList<String>) ClientManager.getClientManager().getUserList());
                break;
            default:
                throw new IllegalArgumentException("Неверно указан тип: " + type);
        }
        return notification;
    }
}
