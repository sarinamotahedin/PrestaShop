package com.prestashop.tests.functional_tests.Account;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.IdentityPage;
import com.prestashop.pages.Login_Register_Page;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IdentityTest extends TestBase {
    HomePage homePage = new HomePage();
    Login_Register_Page loginRegisterPage = new Login_Register_Page();
    MyAccountPage myAccountPage = new MyAccountPage();
    IdentityPage identityPage = new IdentityPage();

    @Test
    public void myPersonalInformation(){
        //Login: My personal information
        homePage.goToSignIn.click();
        loginRegisterPage.login("sarina.motahedin@gmail.com", "sarina123");

        //Click on My personal information button
        //**IDENTITY PAGE OPENS
        myAccountPage.myPersonalInfoBtn.click();

        //Verify title contains Identity
        String expectedPersonalInfoTitle = "Identity";
        String personalInfoTitle = driver.getTitle();
        Assert.assertTrue(personalInfoTitle.contains(expectedPersonalInfoTitle));

        //Verify that first name and last name matches the full name on top
        String firstName = identityPage.firstNameBox.getAttribute("value");
        String lastName = identityPage.LasNameBox.getAttribute("value");
        fullNameTop = loginRegisterPage.fullNameOnTopXpath.getText(); //getting fullname on top corner of page
        String inputFullName = firstName+ " " + lastName;
        System.out.println("Input full name: " + inputFullName + " | Actual full name: " + fullNameTop);
        Assert.assertEquals(inputFullName,fullNameTop);

        //Click on Save button
        identityPage.saveBtn.click();

        //Verify error message “The password you entered is incorrect.”
        String expectedErrorMSG = "The password you entered is incorrect.";
        String passwordErrorMSG = identityPage.passwordErrorMsg.getText();
        System.out.println("Expected error: " + expectedErrorMSG + " | Actual error: " + passwordErrorMSG);
        Assert.assertEquals(expectedErrorMSG,passwordErrorMSG);

        //Click on Back to your account
        identityPage.backToAcctBtn.click();

        //Verify that title contains My account
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
