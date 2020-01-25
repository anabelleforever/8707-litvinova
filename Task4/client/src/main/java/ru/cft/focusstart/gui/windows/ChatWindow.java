package ru.cft.focusstart.gui.windows;

import ru.cft.focusstart.controller.Controller;

import javax.swing.*;
import java.awt.*;

import static ru.cft.focusstart.gui.panels.ChatPanel.getChatPanel;
import static ru.cft.focusstart.gui.panels.UserListPanel.getUserListPanel;

public final class ChatWindow extends Window {
    private static ChatWindow chatWindow;
    private JTextField tfMessage;

    public static ChatWindow getChatWindow() {
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

        JScrollPane chatPane = getChatPanel().getChatPane();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(chatPane, constraints);


        JScrollPane userListPane = getUserListPanel().getUserListPane();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 3;
        constraints.weightx = 0.1;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(userListPane, constraints);

        tfMessage = new JTextField();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(tfMessage, constraints);

        btnOK = new JButton("OK");
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 3;
        constraints.ipadx = 20;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.1;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(btnOK, constraints);

        btnCancel = new JButton("Cancel");
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.1;
        constraints.ipadx = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(btnCancel, constraints);

        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(600, 300));
    }
}
