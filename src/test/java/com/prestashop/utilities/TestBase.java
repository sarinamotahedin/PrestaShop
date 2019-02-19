package com.prestashop.utilities;

import com.github.javafaker.Faker;
import com.prestashop.pages.Login_Register_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String fullNameTop;
    protected Actions actions;
    protected Random random;
    protected Login_Register_Page loginRegisterPage;


    public static Faker faker;
    public static String fakeEmail;
    public static String fakeFirstName;
    public static String fakeLastName;
    public static String fakePassword;
    public static String fakeAddress1;
    public static String fakeCity;
    public static String fakeZipCode;
    public static String fakeMobilePhone;



    @BeforeSuite
    public void fakerSetUp(){

           faker = new Faker();
           fakeEmail = faker.internet().emailAddress();
           fakeFirstName = faker.name().firstName();
           fakeLastName = faker.name().lastName();
           fakePassword = faker.internet().password();
           fakeAddress1 = faker.address().streetAddress();
           fakeCity = faker.address().city();
           fakeZipCode = faker.address().zipCode();
           fakeMobilePhone = faker.phoneNumber().cellPhone();
    }


    @BeforeClass
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void accessories(){
        Driver.getDriver().get("http://automationpractice.com/index.php");
        loginRegisterPage = new Login_Register_Page();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDownMethod() {
       // driver.quit();
    }
}
