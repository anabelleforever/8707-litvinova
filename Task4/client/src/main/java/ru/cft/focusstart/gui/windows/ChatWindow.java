package ru.cft.focusstart.gui.windows;

import javax.swing.*;
import java.awt.*;

import static ru.cft.focusstart.gui.panels.ChatPanel.getChatPane;
import static ru.cft.focusstart.gui.panels.UserListPanel.getUserListPane;

public final class ChatWindow extends Window {
    private static ChatWindow chatWindow;
    private JTextField tfMessage;

    public ChatWindow getChatWindow() {
        if (chatWindow == null) {
            chatWindow = new ChatWindow();
        }
        return chatWindow;
    }

    public String getMessage(){
        return tfMessage.getText();
    }

    @Override
    public void windowBuilder() {
        jFrame = new JFrame();
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 3;
//        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(getChatPane(), constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 3;
//        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(getUserListPane(), constraints);

        tfMessage = new JTextField();
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
//        constraints.gridheight = 0;
        constraints.weightx = 1.0;
//        constraints.weighty = 0.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(tfMessage, constraints);

        btnOK = new JButton("OK");
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 5;
        constraints.ipadx = 50;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        panel.add(btnOK, constraints);

        btnCancel = new JButton("Cancel");
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 6;
        constraints.weightx = 1.0;
        constraints.ipadx = 10;
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(600, 300));
    }

//    @Override
//    void btnOKOnClick() {
//        btnOK.addActionListener(e -> {
//            String  message = tfMessage.getText();
//            tfMessage.setText("");
//            // передаем сообщение серверу+++++
////            chatPanel.update(message);
//        });
//    }
}
