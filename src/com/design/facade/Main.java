package com.design.facade;

public class Main {
    public static void main(String[] args) {
        /*
        // Facade 사용 전
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("test.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();
         */
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "test.tmp");
        sftpClient.Connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }
}
