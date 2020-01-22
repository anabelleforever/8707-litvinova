package ru.cft.focusstart.dto;

import java.util.ArrayList;

public class Notification {
    private ArrayList<String> userList = new ArrayList<>();
    private String userName;
    private String message;

    public String getUserName() {
        return userName;
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    public String getMessage() {
        return message;
    }
}
