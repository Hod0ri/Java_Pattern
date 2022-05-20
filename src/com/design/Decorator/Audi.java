package com.design.Decorator;

public class Audi implements ICar{

    private int price;

    public Audi(int cost) {
        this.price = cost;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi 가격 : "+ this.price);
    }
}
