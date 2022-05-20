package com.design.Adapter;

public class HairDryer implements Electronic110V{
    @Override
    public void PowerOn() {
        System.out.println("헤어 드라이기 110V ON");
    }
}
