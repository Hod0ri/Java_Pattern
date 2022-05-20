package com.design.Proxy.AOP;

import com.design.Proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser browser = new AOPBrowser("www.foo.co.kr",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
                );
        browser.show();
        System.out.println("Loading Time : "+ end.get());

        browser.show();
        System.out.println("Loading Time : "+ end.get());

    }
}
