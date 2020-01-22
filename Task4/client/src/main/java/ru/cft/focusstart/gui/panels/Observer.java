package ru.cft.focusstart.gui.panels;

import ru.cft.focusstart.dto.Notification;

public interface Observer {
    void update(Notification message);
}
