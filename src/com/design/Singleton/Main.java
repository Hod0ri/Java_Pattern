package com.design.Singleton;

public class Main {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 객체가 동일한가?");
        if(aClient.equals(bClient)) {
            System.out.println("Same Object");
        } else {
            System.out.println("Difference Object");
        }
    }
}
