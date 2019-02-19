package com.prestashop.tests.functional_tests.Account;

import com.prestashop.pages.AddressPage;
import com.prestashop.pages.AddressesPage;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends TestBase {
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    AddressesPage addressesPage = new AddressesPage();
    AddressPage addressPage = new AddressPage();


    //Login: My addresses
    @Test
    public void myAddresses(){
        homePage.goToSignIn.click();
        loginRegisterPage.login("sarina.motahedin@gmail.com", "sarina123");

        //Click on My addresses
        myAccountPage.myAddressesBtn.click();

        //Click on Add a new address
        addressesPage.addNewAddressBtn.click();

        //Verify that first name and last name matches the full name on top
        String inputFirstName = addressPage.firstNameBox.getAttribute("value");
        String lastName = addressPage.LastNameBox.getAttribute("value");
        fullNameTop = loginRegisterPage.fullNameOnTopXpath.getText();
        String inputFullName = inputFirstName+ " " + lastName;
        System.out.println("Input full name: " + inputFullName + " | Actual full name: " + fullNameTop);
        Assert.assertEquals(fullNameTop,inputFullName);

        //Delete the first name
        addressPage.firstNameBox.clear();

        //Click save
        addressPage.saveAddressBtn.click();

        //Verify error message “firstname is required.”
        String  expectedNameError = "firstname is required.";
        String actualNameError = addressPage.firstNameError.getText();
        Assert.assertEquals(expectedNameError,actualNameError);
    }

}
