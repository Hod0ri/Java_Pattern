package com.design.Singleton;

public class SocketClient {

    // 싱글톤은 자기 자신을 가지고 있어야 함
    private static SocketClient socketClient = null;

    // 기본 생성자 사용 금지
    private SocketClient() { }

    public static SocketClient getInstance() {
        // Null인지 확인
        if(socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }

    public void connect() {
        System.out.println("Connect!");
    }

}
