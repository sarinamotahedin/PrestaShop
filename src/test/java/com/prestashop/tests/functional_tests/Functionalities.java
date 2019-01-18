package com.prestashop.tests.functional_tests;

import com.github.javafaker.Faker;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.LoginPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Functionalities extends TestBase {


//    @Test
//    public void positiveLogin() throws Exception{
//        goToSignInPage();
//        //Enter your username
//        login.enterUserName.sendKeys(fakeEmail);
//
//        //verify username is correct
//        String expectedUserName = fakeEmail;
//        String actualUserName = login.enterUserName.getAttribute("value");
//        System.out.println("Expected Username: " + expectedUserName + " | Actual username: " + actualUserName);
//        assertEquals(actualUserName, expectedUserName);
//
//        //enter password
//        login.enterPassword.sendKeys(fakePassword);
//
//        //verify password is correct
//        String expectedPassword = fakePassword;
//        String actualPassword = login.enterPassword.getAttribute("value");
//        System.out.println("Expected password: " + expectedPassword + " | Actual password: " + actualPassword);
//        assertEquals(actualPassword, expectedPassword);
//
//        //Sign in to your account
//        WebElement signIn = driver.findElement(By.id("SubmitLogin"));
//        signIn.click();
//        Thread.sleep(2000);
//    }
//
//    @Test(dependsOnMethods = {"positiveLogin"})
//    public void search() throws Exception {
//        //locate search and search for a t-shirt.
//        WebElement searchBox = driver.findElement(By.id("search_query_top"));
//        searchBox.sendKeys("T-shirt" + Keys.ENTER);
//
//        //verify page title contains Search
//        String expectedTitle = "Search";
//        String actualTitle = driver.getTitle();
//        System.out.println("Expected Title: " + expectedTitle + " | Actual Title: " + actualTitle);
//        Assert.assertTrue(actualTitle.contains(expectedTitle));
//
//
//        //Add the first item into cart
//        WebElement shirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
//        actions.moveToElement(shirt).perform();
//        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));
//        addToCart.click();
//
//        //proceed to checkout
//        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
//        Thread.sleep(1000);
//
//        //verify "Use the delivery address as the billing address" is checked
//        WebElement sameAddress = driver.findElement(By.id("addressesAreEquals"));
//        System.out.println(sameAddress.isSelected());
//        Assert.assertTrue(sameAddress.isSelected());
//
//        //proceed to checkout
//        driver.findElement(By.xpath("(//button)[2]")).click();
//
//        //check terms of service box
//        driver.findElement(By.id("cgv")).click();
//
//        //proceed to checkout
//        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
//
//        //select Pay by bank wire
//        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
//
//        //confirm my order
//        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
//
//        //verify confirmation
//        String expectedMsg = "Your order on My Store is complete.";
//        String actualMsg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
//        assertEquals(expectedMsg,actualMsg);
//
//    }
//




}
