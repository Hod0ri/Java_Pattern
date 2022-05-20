package com.design.Proxy;

public class Main {
    public static void main(String[] args) {
        /*
        Browser browser = new Browser("www.foo.co.kr");

        // 캐싱 기능 없음
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */
        IBrowser browser = new BrowserProxy("www.foo.co.kr");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();
    }
}
