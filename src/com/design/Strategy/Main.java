package com.design.Strategy;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        // BASE 64 전략
        EncodingStrategy base64 = new Base64Strategy();

        // Normal 전략
        EncodingStrategy normal = new NormalStrategy();

        String message = "Hello Python";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        // Append 전략
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }
}