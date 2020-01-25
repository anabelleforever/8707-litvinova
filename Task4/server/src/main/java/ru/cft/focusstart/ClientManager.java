package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.cft.focusstart.NotificationFactory.getNotification;

final class ClientManager {
    private static ClientManager clientManager;
    private List<Client> clients;
    private List<String> userList;

    private ClientManager() {
        clients = Collections.synchronizedList(new ArrayList<>());
        userList = Collections.synchronizedList(new ArrayList<>());
    }

    static ClientManager getClientManager() {
        if (clientManager == null) {
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    List<String> getUserList() {
        return userList;
    }

    List<Client> getClients() {
        return clients;
    }

    private void addClient(Client client) {
        clients.add(client);
        userList.add(client.getUserName());
    }

    private void deleteClient(Client client) {
        clients.remove(client);
        userList.remove(client.getUserName());
    }

    void parseNotification(Notification notification, Client client) {
        switch (notification.getNotificationType()) {
            case USER_VERIFICATION:
                if (userList.contains(notification.getUserName())) {
                    Notification invalidUsername = getNotification(NotificationType.INVALID_USERNAME);
                    client.notify(invalidUsername);
                } else {
                    client.setUserName(notification.getUserName());
                    addClient(client);

                    Notification validUsername = getNotification(NotificationType.VALID_USERNAME);
                    client.notify(validUsername);

                    Notification userConnected = getNotification(NotificationType.CONNECTED);
                    notifyClients(userConnected);
                }
                break;
            case MESSAGE:
                Notification userMessage = getNotification(NotificationType.MESSAGE);
                userMessage.setMessage(notification.getMessage());
                notifyClients(userMessage);
            case DISCONNECTED:
                deleteClient(client);
                Notification userDisconnected = getNotification(NotificationType.DISCONNECTED);
                notifyClients(userDisconnected);
                client.stop();
        }
    }

    private void notifyClients(Notification notification) {
        for (Client client : clients) {
            client.notify(notification);
        }
    }
}
