package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountInformation extends TestBase {

    //Login using valid username and password
    public void login() {
        driver.findElement(By.linkText("Sign in")).click();
        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("sarina.motahedin@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("sarina123"+Keys.ENTER);

        fullNameTop =driver.findElement(By.xpath("//a[@class='account']//span")).getText();
}
    //Login: my account
    @Test
    public void myAccount(){
        login();
        //verify that title contains My account
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("Expected page title: " + expectedTitle + " | Actual page title: " + actualTitle);

        //Verify that account holder full name is displayed next to the Sign out link
        String expectedName = "sarina mt";
        System.out.println("Expected name: " + expectedName + " | Actual name: " + fullNameTop);
        Assert.assertEquals(expectedName,fullNameTop);
    }

    //Login: My personal information
    @Test
    public void myPersonalInformation(){
        login();
       //Click on My personal information button
       driver.findElement(By.xpath("//a[@title='Information']")).click();

       //Verify title contains Identity
       String expectedPersonalInfoTitle = "Identity";
       String personalInfoTitle = driver.getTitle();
       Assert.assertTrue(personalInfoTitle.contains(expectedPersonalInfoTitle));

       //Verify that first name and last name matches the full name on top
       String firstName = driver.findElement(By.id("firstname")).getAttribute("value");
       String lastName = driver.findElement(By.id("lastname")).getAttribute("value");
       String inputFullName = firstName+ " " + lastName;
       System.out.println("Input full name: " + inputFullName + " | Actual full name: " + fullNameTop);
       Assert.assertEquals(inputFullName,fullNameTop);

       //Click on Save button
       driver.findElement(By.name("submitIdentity")).click();

       //Verify error message “The password you entered is incorrect.”
       String expectedErrorMSG = "The password you entered is incorrect.";
       String passwordErrorMSG = driver.findElement(By.xpath("//ol//li")).getText();
       System.out.println("Expected error: " + expectedErrorMSG + " | Actual error: " + passwordErrorMSG);
       Assert.assertEquals(expectedErrorMSG,passwordErrorMSG);

       //Click on Back to your account
       driver.findElement(By.linkText("Back to your account")).click();

       //Verify that title contains My account
       String actualTitle = driver.getTitle();
       String expectedTitle = "My account";
       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //Login: My addresses
    @Test
    public void myAddresses(){
        login();
      //Click on My addresses
      driver.findElement(By.linkText("My addresses")).click();

      //Click on Add a new address
      driver.findElement(By.linkText("Add a new address")).click();

      //Verify that first name and last name matches the full name on top
      WebElement firstName = driver.findElement(By.id("firstname"));
      String inputFirstName = firstName.getAttribute("value");
      String lastName = driver.findElement(By.id("lastname")).getAttribute("value");
      String inputFullName = inputFirstName+ " " + lastName;
      System.out.println("Input full name: " + inputFullName + " | Actual full name: " + fullNameTop);
      Assert.assertEquals(inputFullName,fullNameTop);

      //Delete the first name
      firstName.clear();

      //Click save
      driver.findElement(By.id("submitAddress")).click();

      //Verify error message “firstname is required.”
      String  expectedNameError = "firstname is required.";
      String actualNameError = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol//li[1]")).getText();
      System.out.println("Expected error: " + expectedNameError + " | Actual error: " + actualNameError);
      Assert.assertEquals(expectedNameError,actualNameError);
    }

}
