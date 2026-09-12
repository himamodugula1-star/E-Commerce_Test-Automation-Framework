package com.ecommerce.utils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomdataUtils {

    private RandomdataUtils() {
    }

    public static String generateRandomEmail() {

        return "testuser_"
               + UUID.randomUUID().toString().substring(0, 8)
               + "@example.com";
    }

    public static String generateRandomString(int length) {

        String characters =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int index = ThreadLocalRandom.current()
                    .nextInt(characters.length());

            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static int generateRandomNumber(int min, int max) {

        return ThreadLocalRandom.current()
                .nextInt(min, max + 1);
    }
}