package ru.cft.focusstart.model;

import ru.cft.focusstart.gui.windows.WarningWindow;
import ru.cft.focusstart.gui.windows.Window;

public final class WindowManager {
//private static WindowManager windowManager;
//
//private WindowManager(){}
//
//public static WindowManager getWindowManager(){
//    if(windowManager==null){
//        windowManager=new WindowManager();
//    }
//    return windowManager;
//}

    public static void displayWindow(Window window) {
        window.display();
    }

    public static void closeWindow(Window window) {
        window.close();
    }

    public static void makeWarningWindow(String label) {
        WarningWindow.getWarningWindow().setLabel(label);
        WarningWindow.getWarningWindow().display();
    }
}

