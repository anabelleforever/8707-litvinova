package ru.cft.focusstart.controller;

import ru.cft.focusstart.dto.Notification;
import ru.cft.focusstart.gui.panels.Observer;

import java.util.ArrayList;

final class PanelManager {
    private static ArrayList<Observer> observers;

    private PanelManager(){
    }

    static void addObserver(Observer observer){
        observers.add(observer);
    }

    static void updatePanels(Notification notification){
        for (Observer observer:observers) {
            observer.update(notification);
        }
    }
}
