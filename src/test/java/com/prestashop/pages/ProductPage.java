package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //String productPageName = driver.findElement(By.xpath("//h1[contains(text(),'Faded Short Sleeve')]"));
    @FindBy(xpath = "//h1[contains(text(),'Faded Short Sleeve')]")
    public WebElement productPageName;

    //String priceOnSecPage = driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
    @FindBy(xpath = "(//span[@id='our_price_display'])")
    public WebElement priceOnSecPage;

    //String defaultQuantity = driver.findElement(By.xpath("//input[@id='quantity_wanted']")).getAttribute("value");
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    public WebElement defaultQuantity;

    //WebElement selectElement = driver.findElement(By.xpath("//select[@name = 'group_1']"));
    @FindBy(xpath = "//select[@name = 'group_1']")
    public WebElement selectElement;
}
