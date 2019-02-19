package com.prestashop.tests.functional_tests.cart;

import com.prestashop.pages.*;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class AddtoCartTest extends TestBase {
    HomePage homePage = new HomePage();
    Login_Register_Page loginRegisterPage = new Login_Register_Page();
    MyAccountPage myAccountPage = new MyAccountPage();
    SearchPage searchPage = new SearchPage();
    OrderPage orderPage = new OrderPage();
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();



    @Test
    public void search() throws Exception {
        homePage.goToSignIn.click();
        loginRegisterPage.login("sarina.motahedin@gmail.com", "sarina123");

        //locate search and search for a t-shirt.
        myAccountPage.searchBox.sendKeys("T-shirt" + Keys.ENTER);

        // NOW ON SEARCH PAGE
        //verify page title contains Search
        String expectedTitle = "Search";
        String actualTitle = driver.getTitle();
        System.out.println("Expected Title: " + expectedTitle + " | Actual Title: " + actualTitle);
       Assert.assertTrue(actualTitle.contains(expectedTitle));

       //Add the first item into cart
        actions.moveToElement(searchPage.shirt).perform();
        searchPage.addToCart.click();

        //proceed to checkout
        searchPage.proceedToCheckOut1.click();
        orderPage.proceedToCheckOut2.click();
        Thread.sleep(1000);

        //verify "Use the delivery address as the billing address" is checked
        Assert.assertTrue(orderPage.sameAddressCheckBox.isSelected());

        //proceed to checkout
        orderPage.proceedToCheckOut3.click();

        //check terms of service box
        orderPage.TermsOfServiceCheckBox.click();

        //proceed to checkout
        orderPage.proceedToCheckOut4.click();

        //select Pay by bank wire
        orderPage.PayByBankWire.click();

        //I confirm my order button
        homePage.iConfirmBtn.click();

        //verify confirmation
        String expectedMsg = "Your order on My Store is complete.";
        String actualMsg = orderConfirmationPage.OrderComplete.getText();
        assertEquals(expectedMsg,actualMsg);

    }





}
