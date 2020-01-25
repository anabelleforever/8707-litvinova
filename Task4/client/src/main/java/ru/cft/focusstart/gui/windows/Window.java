package ru.cft.focusstart.gui.windows;

import javax.swing.*;
import java.io.Closeable;

public abstract class Window implements Displayable, Closeable {
    JFrame jFrame;
    JButton btnOK;
    JButton btnCancel;
    JPanel panel;

    public void display() {
        windowBuilder();
        jFrame.add(panel);
        jFrame.setBounds(500, 500, 500, 500);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void close(){
        jFrame.setVisible(false);
    }

    abstract void windowBuilder();

}
