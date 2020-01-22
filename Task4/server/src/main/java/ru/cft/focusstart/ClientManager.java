package ru.cft.focusstart;

import ru.cft.focusstart.dto.Notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientManager {
    private List<Client> clients;
    private ArrayList<String> userList = new ArrayList<>();
    private boolean setChangers = false;

ClientManager(){
    clients = Collections.synchronizedList(new ArrayList<>());
}

    void addClient(Client client) {
        clients.add(client);
        userList.add(client.userName);
    }

    void deleteClient(Client client) {
        clients.remove(client);
        userList.remove(client.userName);
//        Message message = makeUserDisconnectedMsg();
//        try { // тут как-то поправить
//            server.sendMsgToAll(message);
//        } catch (IOException ex) {
//            log.error("IOException in ClientManager in method destroyCurrentClient()");
//        }
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    void notifyClients(Notification notification) throws IOException {
        for (Client client : clients) {
            client.notify(notification);
        }
    }
}
