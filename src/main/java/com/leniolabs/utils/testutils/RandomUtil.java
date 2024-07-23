package com.leniolabs.utils.testutils;

import com.github.javafaker.Faker;

public final class RandomUtil {

    private RandomUtil() {
    }

    public static String getRandomName() {
        return new Faker().name().firstName().replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName().replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String getRandomTelephone() {
        return new Faker().phoneNumber().cellPhone();
    }

    public static String getRandomNumber(){
        String number = String.valueOf(new Faker().number().numberBetween(10, 100));
        return number;
    }

    public static String getRandomPassword(){
        Faker faker = new Faker();
        String uppercaseLetters = faker.lorem().characters(2, true, false);
        String lowercaseLetters = faker.lorem().characters(2, true, true);
        String numbers = faker.number().digits(4);

        return uppercaseLetters + lowercaseLetters + numbers;
    }
}
