package com.prestashop.utilities;

import com.prestashop.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String fullNameTop;
    protected Actions actions;
    protected Random random;
    protected RegistrationPage registrationPage;
    protected static FakerRepo fakerRepo;


    @BeforeClass
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //I'll make my UtilGeneric Class Later...
        fakerRepo = new FakerRepo();
        random = new Random();
    }

    @BeforeMethod
    public void accessories(){
        Driver.getDriver().get("http://automationpractice.com/index.php");
        registrationPage = new RegistrationPage();
        actions = new Actions(driver);
    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
