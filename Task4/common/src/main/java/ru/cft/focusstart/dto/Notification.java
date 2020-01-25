package ru.cft.focusstart.dto;

import java.util.ArrayList;
import java.util.Date;

public class Notification {
    private ArrayList<String> userList = new ArrayList<>();
    private String userName;
    private String message;
    private Date date;
    private NotificationType notificationType;

    public Notification(){
        date = new Date();
    }

    public Notification(NotificationType type){
        date = new Date();
        notificationType = type;
        message = notificationType.toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<String> userList){
        this.userList = userList;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getNotificationType(){
        return notificationType;
    }
}
