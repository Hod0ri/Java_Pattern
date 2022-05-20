package com.design.Adapter;

public class AirConditioner implements Electronic220V{
    @Override
    public void Connect() {
        System.out.println("에어컨 220V ON");
    }
}
