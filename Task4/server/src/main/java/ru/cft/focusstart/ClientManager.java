package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;

import java.io.IOException;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ClientManager {
    private static ClientManager clientManager;
    private List<Client> clients;
    private ArrayList<String> userList = new ArrayList<>();
    private boolean setChanges = false;

    private ClientManager() {
        clients = Collections.synchronizedList(new ArrayList<>());
    }

    public static ClientManager getClientManager() {
        if (clientManager == null) {
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    void addClient(Client client) {
        clients.add(client);
        userList.add(client.userName);
    }

    void deleteClient(Client client) {
        clients.remove(client);
        userList.remove(client.userName);
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    public void interpretNotification(Notification notification, Client client) {
//switch все виды уведомлений от клиента
        switch (notification.getNotificationType()) {
            case USER_VERIFICATION:
                if (userList.contains(notification.getUserName())) {
                    //создать ЕМУ уведомление об invalid имени  ++ подумать удалить клиента или как получить от него новое имя
                } else {
                    client.userName = notification.getUserName();
                    addClient(client);
                    //послать ЕМУ уведомление о верном имени пользователя
                    //послать ВСЕМ уведомление о присоединении клиента
                }
                break;
            case MESSAGE:
                //послать ВСЕМ уведомление о сообщении от юзера
            case DISCONNECTED:
                deleteClient(client);
                //послать ВСЕМ сообщение об отключении
                client.stop();
        }
    }

    void notifyClients(Notification notification) throws IOException {
        for (Client client : clients) {
            client.notify(notification);
        }
    }
}
