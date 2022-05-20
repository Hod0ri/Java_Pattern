package com.design.Strategy;

public class AppendStrategy implements EncodingStrategy{

    @Override
    public String encode(String message) {
        return "ABCD" + message;
    }
}
