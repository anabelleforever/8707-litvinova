package ru.cft.focusstart.model;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.gui.panels.Observer;

import java.util.ArrayList;

public final class PanelManager {
    private static ArrayList<Observer> observers = new ArrayList<>();

    private PanelManager() {
    }

    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    public static void updatePanels(Notification notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
}
