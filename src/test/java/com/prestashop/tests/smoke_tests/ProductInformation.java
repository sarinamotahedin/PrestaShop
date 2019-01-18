package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductInformation extends TestBase {

//
//        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve')]"));
//        String productName  = product.getText();
//
//        WebElement price = driver.findElement(By.xpath("(//span[contains(text(),'$16.51')])[2]"));
//        String productPrice = price.getText();


    //Product information – Add to cart:
    @Test
    public void addToCart(){
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve')]"));
        String productName  = product.getText();

        WebElement price = driver.findElement(By.xpath("(//span[contains(text(),'$16.51')])[2]"));
        String productPrice = price.getText();

        //YOOO Im on the new page btw!!!!!
        driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");


        //Click on Add to cart
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();

        //Verify confirmation message “Product successfully added to your shopping cart”
        String confirmationMessage = "Product successfully added to your shopping cart";
        WebElement actualMessage = driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
        actualMessage.click();
        String actualMsg = actualMessage.getText();
        System.out.println("Expected confirmation msg: " + confirmationMessage + " | Actual confirmation msg: " + actualMsg );
        Assert.assertEquals(confirmationMessage,actualMsg);

        //verify that default quantity is 1
        String expectedQuantity = "1";
        String actualDefaultQuantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
        System.out.println("Expected quantity in cart: " + expectedQuantity + " | Actual quantity in cart: " + actualDefaultQuantity);
        Assert.assertEquals(actualDefaultQuantity,expectedQuantity);

        //Verify that default size is S
        String expectedSize = "S";
        String actualDefaultSize = driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText(); //Orange, S
        Assert.assertTrue(actualDefaultSize.substring(actualDefaultSize.indexOf(","),actualDefaultSize.length()).contains(expectedSize));
        System.out.println("Expected size in cart: " + expectedSize + " | Actual size in cart: " + actualDefaultSize);


        //Verify that same name and price displayed as on the home page
        String titleInCart = driver.findElement(By.id("layer_cart_product_title")).getText();
        String priceInCart = driver.findElement(By.id("layer_cart_product_price")).getText();
        System.out.println("Title in Cart: " + titleInCart + " | Title in Home Page: " + productName);
        System.out.println("Price in Cart: " + priceInCart + " | Price in Home Page: " + productPrice);
        Assert.assertEquals(titleInCart,productName);
        Assert.assertEquals(priceInCart,productPrice);
        }

}



