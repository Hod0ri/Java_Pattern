package com.design.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String message = String.format("Writer %s로 연결합니다.", fileName);
        System.out.println(message);
    }

    public void fileDisconnect() {
        String message = String.format("Writer %s에서의 연결을 종료합니다.", fileName);
        System.out.println(message);
    }

    public void write() {
        String message = String.format("Writer %s를 작성합니다.", fileName);
        System.out.println(message);
    }
}
