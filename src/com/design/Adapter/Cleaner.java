package com.design.Adapter;

public class Cleaner implements Electronic220V{


    @Override
    public void Connect() {
        System.out.println("청소기 220V ON");
    }
}
