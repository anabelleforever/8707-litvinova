package ru.cft.focusstart.gui.windows;

import javax.swing.*;
import java.awt.*;

public class AuthorizationWindow extends Window {

    private JTextField tfServer;
    private Label lbServer;
    private JTextField tfUser;
    private Label lbUser;
    private String userName;
    private String serverAddress;
    private String serverName;
    private int port;

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
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.ipadx = 10;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(10, 0, 10, 10);
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    void btnOKOnClick() {
        btnOK.addActionListener(e -> {
            userName = tfUser.getText();
            serverAddress = tfServer.getText();
            verifyData();
            jFrame.setVisible(false);
        });
    }

    void verifyData() {

        if(userName.equals("")){
            WarningWindow warningWindow = new WarningWindow();
            warningWindow.display();
        } else {
            ChatWindow chat = new ChatWindow();
            chat.display();
        }
//        WarningWindow warningWindow = new WarningWindow("");
//        warningWindow.run();
    }


}
