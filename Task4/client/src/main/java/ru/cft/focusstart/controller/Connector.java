package ru.cft.focusstart.controller;

public class Connector {
    private static Connector connector;
    private Connector(){}

    public static Connector getConnector(){
        if (connector==null){
            connector = new Connector();
        }
        return connector;
    }




}
