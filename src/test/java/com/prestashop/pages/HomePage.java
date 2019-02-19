package com.prestashop.pages;


import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage{

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve')]"));
    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve')]")
    public WebElement product;

    //WebElement price = driver.findElement(By.xpath("(//span[contains(text(),'$16.51')])[2]"));
    @FindBy(xpath = "(//span[contains(text(),'$16.51')])[2]")
    public WebElement price;

    //Sign in link
    @FindBy(linkText = "Sign in")
    public  WebElement goToSignIn;

    //I confirm my order button
    @FindBy(linkText = "//*[@id=\"cart_navigation\"]/button/span")
    public  WebElement iConfirmBtn;

}



