package ru.cft.focusstart.dto;

import java.util.ArrayList;

public class Notification {
    private ArrayList<String> userList = new ArrayList<>();
    private String userName;
    private String message;
    private NotificationType notificationType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    public String getMessage() {
        return message;
    }

    public void setNotificationType(NotificationType notificationType){
        this.notificationType = notificationType;
    }

    public NotificationType getNotificationType(){
        return notificationType;
    }
}
