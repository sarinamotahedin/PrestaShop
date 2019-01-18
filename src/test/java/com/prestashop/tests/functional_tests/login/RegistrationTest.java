package com.prestashop.tests.functional_tests.login;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.utilities.FakerRepo;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.prestashop.utilities.FakerRepo.*;

public class RegistrationTest extends TestBase {
    HomePage homePage = new HomePage();


    @Test
    public void Register_errorMessagesValidation_FirstName() throws InterruptedException{
        homePage.goToSignIn.click();

        //input an email address & hit create account button
        registrationPage.createEmail.sendKeys(fakeEmail + Keys.ENTER);
        Thread.sleep(1000);

        //find and select Mrs. button
        registrationPage.femaleRadioBtn.click();

        //verify Mrs. button is selected
        System.out.println(registrationPage.femaleRadioBtn.isSelected());

        //input last name, email and password
        registrationPage.lastName.sendKeys(fakeLastName);
        registrationPage.email.clear();
        registrationPage.email.sendKeys(fakeEmail);
        registrationPage.inputPassword.sendKeys(fakePassword);
        Thread.sleep(1000);

        //Enter your address information
        registrationPage.addressLine1.sendKeys(fakeAddress1);
        registrationPage.addressCity.sendKeys(fakeCity);
        Select state = new Select(registrationPage.state);
        state.selectByValue("46");
        registrationPage.zipCode.sendKeys(fakeZipCode.substring(0,5).replace("-", ""));
        registrationPage.mobilePhone.sendKeys(fakeMobilePhone);
        //click on create account
        registrationPage.submitButton.click();

        //Error Message Validation
        System.out.println(registrationPage.errorMsg.isSelected());
        Assert.assertTrue(registrationPage.errorMsg.isDisplayed());
        Thread.sleep(2000);

        //re-enter firstName and password
        registrationPage.firstName.sendKeys(fakeFirstName);
        registrationPage.inputPassword.sendKeys(fakePassword);

        //click on create account
        registrationPage.submitButton.click();
        //sign out
        registrationPage.signOut.click();
        Thread.sleep(2000);
        //hoolpo

    }

}
