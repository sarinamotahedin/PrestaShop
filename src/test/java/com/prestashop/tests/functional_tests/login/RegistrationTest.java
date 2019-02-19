package com.prestashop.tests.functional_tests.login;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.Login_Register_Page;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase {
    HomePage homePage = new HomePage();
    Login_Register_Page loginRegisterPage = new Login_Register_Page();
    public static String saveEmail;
    public static String savePassword;


    @Test
    public void Register_errorMessagesValidation_FirstName() throws InterruptedException{
        homePage.goToSignIn.click();

        //input an email address & hit create account button
        loginRegisterPage.createEmail.sendKeys(fakeEmail + Keys.ENTER);
        Thread.sleep(1000);

        //find and select Mrs. button
        loginRegisterPage.femaleRadioBtn.click();

        //verify Mrs. button is selected
        System.out.println(loginRegisterPage.femaleRadioBtn.isSelected());

        //input last name, email and password
        loginRegisterPage.lastName.sendKeys(fakeLastName);
        loginRegisterPage.email.clear();
        loginRegisterPage.email.sendKeys(fakeEmail);
        loginRegisterPage.inputPassword.sendKeys(fakePassword);

        saveEmail = fakeEmail;
        System.out.println(saveEmail);
        savePassword = fakePassword;
        System.out.println(savePassword);

        Thread.sleep(1000);

        //Enter your address information
        loginRegisterPage.addressLine1.sendKeys(fakeAddress1);
        loginRegisterPage.addressCity.sendKeys(fakeCity);
        Select state = new Select(loginRegisterPage.state);
        state.selectByValue("46");
        loginRegisterPage.zipCode.sendKeys(fakeZipCode.substring(0,5).replace("-", ""));
        loginRegisterPage.mobilePhone.sendKeys(fakeMobilePhone);

        //click on create account
        loginRegisterPage.submitButton.click();

        //Error Message Validation
        System.out.println(loginRegisterPage.errorMsg.isSelected());
        Assert.assertTrue(loginRegisterPage.errorMsg.isDisplayed());
        Thread.sleep(2000);

        //re-enter firstName and password
        loginRegisterPage.firstName.sendKeys(fakeFirstName);
        loginRegisterPage.inputPassword.sendKeys(fakePassword);

        //click on create account
        loginRegisterPage.submitButton.click();

        //Sign out
        loginRegisterPage.signOut.click();
        Thread.sleep(2000);


    }

}
