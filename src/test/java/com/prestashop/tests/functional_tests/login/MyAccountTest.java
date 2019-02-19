package com.prestashop.tests.functional_tests.login;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.Login_Register_Page;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase {
    HomePage homePage = new HomePage();
    Login_Register_Page loginRegisterPage = new Login_Register_Page();


    //Login: my account
    @Test
    public void myAccount_Login(){
        homePage.goToSignIn.click();
        loginRegisterPage.login("sarina.motahedin@gmail.com", "sarina123");

        //verify that title contains My account
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Verify that account holder full name is displayed next to the Sign out link
        fullNameTop = loginRegisterPage.fullNameOnTopXpath.getText();
        String expectedName = "sarina mt";
        Assert.assertEquals(expectedName,fullNameTop);
    }





}
