package com.design.facade;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String message = String.format("Reader %s로 연결합니다.", fileName);
        System.out.println(message);
    }

    public void fileRead() {
        String message = String.format("Reader %s의 내용을 읽습니다.", fileName);
        System.out.println(message);
    }

    public void fileDisconnect() {
        String message = String.format("Reader %s에서의 연결을 종료합니다.", fileName);
        System.out.println(message);
    }
}
