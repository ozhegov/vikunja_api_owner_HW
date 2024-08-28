package io.vikunja.utils;

import com.github.javafaker.Faker;
import io.vikunja.models.RegisterBodyModel;

public class TestData {

    private static final Faker faker = new Faker();

    public static String userName = getRandomUsername(),
            email = getRandomEmail(),
            password = getRandomPassword(),
            taskName = getRandomTaskName();

    public static int id = getRandomId();

    public static boolean longToken = true;

    public static String getRandomUsername() {
        return faker.name().firstName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static int getRandomId() {
        return faker.number().numberBetween(0, 100000);
    }

    public static String getRandomTaskName() {
        return faker.funnyName().name();
    }

    public static RegisterBodyModel regData = new RegisterBodyModel(email, id, password, userName);

}
