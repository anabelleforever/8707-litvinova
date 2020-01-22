package ru.cft.focusstart.gui.windows;

import javax.swing.*;

public abstract class Window implements Displayable{
    JFrame jFrame;
    JButton btnOK;
    JButton btnCancel;
    JPanel panel;

    public void display() {
        windowBuilder();

        btnOKOnClick();
        btnCancelOnClick();

        jFrame.add(panel);
        jFrame.setBounds(500, 300, 500, 500);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    abstract void windowBuilder();

    abstract void btnOKOnClick();

    void btnCancelOnClick() {
        btnCancel.addActionListener(e -> System.exit(0));
    }

}
