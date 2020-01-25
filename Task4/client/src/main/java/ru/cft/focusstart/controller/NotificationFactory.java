package ru.cft.focusstart.controller;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;

final class NotificationFactory {

    static Notification getNotification(NotificationType type) {
        Notification notification;
        switch (type) {
            case USER_VERIFICATION:
                notification = new Notification(NotificationType.USER_VERIFICATION);
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
}
