package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.dto.NotificationType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ClientManager {
    private static ClientManager clientManager;
    private List<Client> clients;
    private List<String> userList;

    private ClientManager() {
        clients = Collections.synchronizedList(new ArrayList<>());
        userList = Collections.synchronizedList(new ArrayList<>());
    }

    public static ClientManager getClientManager() {
        if (clientManager == null) {
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    public List<String> getUserList(){
        return userList;
    }

    public List<Client> getClients(){
        return clients;
    }

    void addClient(Client client) {
        clients.add(client);
        userList.add(client.userName);
    }

    void deleteClient(Client client) {
        clients.remove(client);
        userList.remove(client.userName);
    }

    public void interpretNotification(Notification notification, Client client) {
        switch (notification.getNotificationType()) {
            case USER_VERIFICATION:
                if (userList.contains(notification.getUserName())) {
                    Notification invalidUsername = NotificationFactory.getNotification(NotificationType.INVALID_USERNAME);
                    client.notify(invalidUsername);
                } else {
                    client.userName = notification.getUserName();
                    addClient(client);

                    Notification validUsername = NotificationFactory.getNotification(NotificationType.VALID_USERNAME);
                    client.notify(validUsername);

                    Notification userConnected = NotificationFactory.getNotification(NotificationType.CONNECTED);
                    notifyClients(userConnected);
                }
                break;
            case MESSAGE:
                Notification userMessage = NotificationFactory.getNotification(NotificationType.MESSAGE);
                notifyClients(userMessage);
            case DISCONNECTED:
                deleteClient(client);
                Notification userDisconnected = NotificationFactory.getNotification(NotificationType.DISCONNECTED);
                notifyClients(userDisconnected);
                client.stop();
        }
    }

    void notifyClients(Notification notification){
        for (Client client : clients) {
            client.notify(notification);
        }
    }
}
