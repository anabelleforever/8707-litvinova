package ru.cft.focusstart.gui.windows;

import ru.cft.focusstart.controller.ButtonListener;
import ru.cft.focusstart.model.ButtonType;

import javax.swing.*;
import java.awt.*;

public final class AuthorizationWindow extends Window {
    private static AuthorizationWindow authorizationWindow;
    private JTextField tfServer;
    private Label lbServer;
    private JTextField tfUser;
    private Label lbUser;

    private AuthorizationWindow() {
    }

    public static AuthorizationWindow getAuthorizationWindow() {
        if (authorizationWindow == null) {
            authorizationWindow = new AuthorizationWindow();
        }
        return authorizationWindow;
    }

    public String getUserName() {
        return tfUser.getText();
    }

    public String getServerPort() {
        return tfServer.getText();
    }

    @Override
    void windowBuilder() {
        jFrame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        tfUser = new JTextField(20);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.insets = new Insets(10, 10, 0, 0);
        panel.add(tfUser, constraints);

        lbUser = new Label("User name");
        panel.add(lbUser, constraints);

        btnOK = new JButton("OK");
        btnOK.addActionListener(new ButtonListener(ButtonType.AUTHORIZATION));
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.ipadx = 30;
        constraints.insets = new Insets(10, 0, 0, 10);
        panel.add(btnOK, constraints);

        tfServer = new JTextField(20);
        constraints.ipadx = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 10, 10, 0);
        panel.add(tfServer, constraints);

        lbServer = new Label("Server address");
        panel.add(lbServer, constraints);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ButtonListener(ButtonType.CANCEL));
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.ipadx = 10;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

//    void verifyData() {
//
//        if(userName.equals("")){
//            WarningWindow warningWindow = new WarningWindow();
//            warningWindow.display();
//        } else {
//            ChatWindow chat = new ChatWindow();
//            chat.display();
//        }
////        WarningWindow warningWindow = new WarningWindow("");
//        warningWindow.run();
}
