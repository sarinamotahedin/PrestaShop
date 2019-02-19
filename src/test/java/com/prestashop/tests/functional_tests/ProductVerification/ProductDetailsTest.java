package com.prestashop.tests.functional_tests.ProductVerification;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductDetailsTest extends TestBase {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    //Product information - price:
    @Test
    public void price(){
        String productName  = homePage.product.getText();
        System.out.println(productName);

        String productPrice = homePage.price.getText();
        System.out.println(productPrice);

        //click on first product (Faded Short Sleeve T-shirts)
        homePage.product.click();

        //!!!!!!!GETTING TO PRODUCT PAGE
        //verify that same name and price are displayed as on the homepage

        String productPageName = productPage.productPageName.getText();
        String priceOnSecPage = productPage.priceOnSecPage.getText();

        System.out.println("HomePage product Name: " + productName + " | Product page product name: " + productPageName);
        System.out.println("HomePage product price: " + productPrice + " | Product page product price: " + priceOnSecPage);

        Assert.assertEquals(productName,productPageName);
        Assert.assertEquals(productPrice,priceOnSecPage);
    }



    //Product information - details:
    @Test
    public void details() {
        homePage.product.click();

        //verify that default quantity is 1
        ///locating the default quantity on product page and getting the value
        String defaultQuantity = productPage.defaultQuantity.getAttribute("value");

        ///printing what is expected and actual
        System.out.println("Expected quantity is 1 and actual quantity is: " + defaultQuantity);
        Assert.assertEquals("1", defaultQuantity);

        //verify that default size is S
        ///create select object for dropdown list
        Select list = new Select(productPage.selectElement);
        String actual = list.getFirstSelectedOption().getText();
        String expected = "S";
        Assert.assertEquals(actual,expected);

        //Verify that size options are S, M, L
        List<WebElement> options = list.getOptions();
        String[] size = new String[]{"S", "M", "L"};
        int count = 0;
        for (WebElement option : options) {
            Assert.assertEquals(size[count], option.getText());
            count++;
        }

    }

}
