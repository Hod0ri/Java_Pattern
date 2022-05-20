package com.design.Observer;

public class Main {
    public static void main(String[] args) {
        Button button = new Button("버튼");
        button.addListner(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달 : Click 1");
        button.click("메시지 전달 : Click 2");
        button.click("메시지 전달 : Click 3");
        button.click("메시지 전달 : Click 4");
        button.click("메시지 전달 : Click 5");
    }
}
