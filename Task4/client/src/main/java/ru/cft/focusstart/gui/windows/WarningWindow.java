package ru.cft.focusstart.gui.windows;

import ru.cft.focusstart.controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class WarningWindow extends Window {
    private Label warning;
    private static WarningWindow warningWindow;

    private WarningWindow() {
    }

    public static WarningWindow getWarningWindow(){
        if (warningWindow==null){
            warningWindow=new WarningWindow();
        }
        return warningWindow;
    }

    public void setLabel(String label) {
        if (label == null) {
            warning = new Label("Something goes wrong...");
        }
        warning = new Label(label);
    }

    @Override
    void windowBuilder() {
        jFrame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        panel.add(warning, constraints);

        btnOK = new JButton("OK");
        btnOK.addActionListener(new ButtonListener(ButtonType.WARNING_OK));
        panel.add(btnOK, constraints);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ButtonListener(ButtonType.CANCEL));
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}
