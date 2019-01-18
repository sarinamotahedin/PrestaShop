package com.prestashop.tests.functional_tests.login;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.LoginPage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.utilities.TestBase;
import org.testng.annotations.Test;

import static com.prestashop.utilities.FakerRepo.fakeEmail;
import static com.prestashop.utilities.FakerRepo.fakePassword;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test   
    public void positiveLogin() throws Exception{

        homePage.goToSignIn.click();

        //Enter your username
        loginPage.enterUserName.sendKeys(fakeEmail);

        //verify username is correct
        String expectedUserName = fakeEmail;
        String actualUserName = loginPage.enterUserName.getAttribute("value");
        System.out.println("Expected Username: " + expectedUserName + " | Actual username: " + actualUserName);
        assertEquals(actualUserName, expectedUserName);
        Thread.sleep(1000);

        //enter password
        loginPage.enterPassword.sendKeys(fakePassword);

        //verify password is correct
        String expectedPassword = fakePassword;
        String actualPassword = loginPage.enterPassword.getAttribute("value");
        System.out.println("Expected password: " + expectedPassword + " | Actual password: " + actualPassword);
        assertEquals(actualPassword, expectedPassword);
        Thread.sleep(1000);

        //verify error message - authentication error
        assertTrue(loginPage.loginErrorMsg.isDisplayed());

        //Sign in to your account
        loginPage.signInBtn.click();
        Thread.sleep(2000);
    }


}
