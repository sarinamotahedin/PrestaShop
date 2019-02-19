package com.prestashop.pages;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(), 'Faded Short')]")
    public WebElement anyProduct;

    @FindBy(xpath = "//*[@class='icon-plus']")
    public WebElement enterRandomQuantity;

    @FindBy(id = "group_1")
    public WebElement selectSizeId;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    public WebElement addToCart;

    @FindBy(tagName = "h2")
    public WebElement h2Tag;

    @FindBy(xpath = "//span[@class='cross']")
    public WebElement xIcon;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    public WebElement companyLogo;



    public void cartDetail() throws InterruptedException {
        //3.Click on any product that is not on sale
        anyProduct.click();

        //4.Enter a random quantity between 2and 5
        enterRandomQuantity.click();

        //5.Select a different size
        WebElement selectSize = selectSizeId;
        Select list = new Select(selectSize);
        list.selectByVisibleText("M");

        //6.Click on add to cart
        addToCart.click();
        Thread.sleep(2000);

        //7.Verify confirmation message Product successfully added to your shopping cart
        String actual = h2Tag.getText();
        //*[@id='layer_cart']/div[1]/div[1]/h2
        System.out.println("actual@@@@@: "+actual);
        assertEquals(actual, "Product successfully added to your shopping cart");

        //8.Dismiss the confirmation window by clicking on the x icon
        xIcon.click();
        Thread.sleep(2000);

        //9.Click on the company logo
        companyLogo.click();

    }
    @Test
    public void productOnSale() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");

//             WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@id,'fancybox')"));
//             driver.switchTo().frame(iframe);
//             // driver.findElement(By.xpath("//input[@id='quantity_wanted']")).click();
//             //driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
//             //driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
//
//             driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]/span/i")).click();
//             //Thread.sleep(3000);



        //10.Click on any product that is on sale
        Actions act = new Actions(driver);
        WebElement pi = driver.findElement(By.xpath("(//img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg'])[1]"));

        act.moveToElement(pi).build().perform();
        Thread.sleep(2000);
        WebElement c = driver.findElement(By.xpath("(//span[.='Quick view'])[5]"));
        c.click();

        WebElement frame1 = driver.findElement(By.xpath("//div[@class='fancybox-outer']//iframe"));
        driver.switchTo().frame(frame1);

        //11.Enter a random quantity between 2 and 5
        WebElement element = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
        String be = element.getAttribute("value");
        element.clear();
        System.out.println("check1");
        int quantityRandom = random.nextInt(5)+2;

        element.sendKeys("" +quantityRandom );

//          12.Select a different size
        WebElement selectSize2 = driver.findElement(By.id("group_1"));
        Select list = new Select(selectSize2);
        list.selectByVisibleText("M");
        Thread.sleep(1000);
        System.out.println("check2");
//          13.Click on add to cart
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();

//         14.Verify confirmation message Product successfully added to your shopping cart
        String actual = driver.findElement(By.tagName("h2")).getText();
        Thread.sleep(500);
        assertEquals(actual, "Product successfully added to your shopping cart");
        Thread.sleep(500);
        System.out.println("check3");
//         15.Dismiss the confirmation window by clicking on the x icon
        driver.findElement(By.xpath("//span[@class='cross']")).click();
        Thread.sleep(500);

//         16.Hover over the CartPage icon
        WebElement cart = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt_s unvisible']"));
        actions.moveToElement(cart).perform();
        Thread.sleep(500);
        System.out.println("check5");
//         17.Verify that correct total is displayed
        String quantityCart = driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).getText();
        Thread.sleep(500);
        System.out.println("actual:"+ quantityCart);
        System.out.println("expected:" + quantityRandom);
        Thread.sleep(500);
        String n = "" + quantityRandom;
        assertEquals(n,quantityCart);
        System.out.println("check6");
//         18.Verify that total is correct based on the price and item count of the products you added to cart.
//         (Shipping is always $2)
        driver.findElement(By.xpath("//span[@class='ajax_cart_quantity unvisible']")).click();
        String total = driver.findElement(By.id("total_price")).getText();
        String total2 = total.substring(1);
        System.out.println(total);
        double total3 = Double.parseDouble(total2);
        String productPrice = driver.findElement(By.xpath("//*[.='$28.98']")).getText();
        String productPrice2 = productPrice.substring(1);
        System.out.println(productPrice2);
        double productPrice3 = Double.parseDouble(productPrice2);
        System.out.println("check7");
        double totalExpected = (productPrice3*quantityRandom)+2;
        Thread.sleep(500);
        System.out.println(total2+" || "+totalExpected);
        assertEquals(total3,totalExpected);



    }
}
