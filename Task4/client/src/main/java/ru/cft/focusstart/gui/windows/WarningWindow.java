package ru.cft.focusstart.gui.windows;

import javax.swing.*;
import java.awt.*;

public class WarningWindow extends Window {
    private Label warning;

    WarningWindow() {
        warning = new Label("Something goes wrong...");
    }

    WarningWindow(String msg) {
        warning = new Label(msg);
    }


    @Override
    void windowBuilder() {
        jFrame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        panel.add(warning, constraints);

        btnOK = new JButton("OK");
        panel.add(btnOK, constraints);

        btnCancel = new JButton("Cancel");
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    @Override
    void btnOKOnClick() {
        btnOK.addActionListener(e -> jFrame.setVisible(false));
    }
}
