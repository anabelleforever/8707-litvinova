package ru.cft.focusstart.controller;

import ru.cft.focusstart.gui.windows.AuthorizationWindow;
import ru.cft.focusstart.gui.windows.ButtonType;
import ru.cft.focusstart.gui.windows.WarningWindow;
import ru.cft.focusstart.model.WindowManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private ButtonType buttonType;

    public ButtonListener(ButtonType type) {
        buttonType = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (buttonType) {
            case CANCEL:
                System.exit(0);
                break;
            case AUTHORIZATION:
                Controller.getController().authorizeUser();
                break;
            case WARNING_OK:
                WindowManager.closeWindow(WarningWindow.getWarningWindow());
                WindowManager.displayWindow(AuthorizationWindow.getAuthorizationWindow());
                break;
}

    }
}

