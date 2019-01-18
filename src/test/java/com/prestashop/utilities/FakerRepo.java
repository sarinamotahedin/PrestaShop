package com.prestashop.utilities;

import com.github.javafaker.Faker;
import com.prestashop.tests.functional_tests.login.LoginTest;

public class FakerRepo{

    //faker stuff
    public static Faker faker = new Faker();
    public static String fakeEmail = faker.internet().emailAddress();
    public static String fakeFirstName = faker.name().firstName();
    public static String fakeLastName = faker.name().lastName();
    public static String fakePassword = faker.internet().password();
    public static String fakeAddress1 = faker.address().streetAddress();
    public static String fakeCity = faker.address().city();
    public static String fakeZipCode = faker.address().zipCode();
    public static String fakeMobilePhone = faker.phoneNumber().cellPhone();


}
