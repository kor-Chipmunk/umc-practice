package com.umc.practice;

import java.util.Random;

public class RandomCodeGenerator {
    public static String getRandomCode() {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'

        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit,rightLimit + 1)
                .filter(i -> i >= 65 && i <= 90)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
