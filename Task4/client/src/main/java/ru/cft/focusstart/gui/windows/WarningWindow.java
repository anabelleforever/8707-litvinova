package ru.cft.focusstart.gui.windows;

import ru.cft.focusstart.controller.ButtonListener;
import ru.cft.focusstart.model.ButtonType;

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

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.weightx = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(warning, constraints);

        btnOK = new JButton("OK");
        btnOK.addActionListener(new ButtonListener(ButtonType.WARNING_OK));
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.ipadx = 20;
        constraints.insets = new Insets(5, 150, 5, 5);
        panel.add(btnOK, constraints);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ButtonListener(ButtonType.CANCEL));
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.ipadx = 0;
        constraints.insets = new Insets(5, 5, 5, 150);
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(400, 100));
    }
}
