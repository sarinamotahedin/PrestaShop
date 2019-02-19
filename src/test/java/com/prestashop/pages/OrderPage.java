package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    public WebElement proceedToCheckOut2;

    @FindBy(xpath = "//div[@class='checker']")
    public WebElement sameAddressCheckBox;

    @FindBy(xpath = "(//button)[2]")
    public WebElement proceedToCheckOut3;

    @FindBy(id = "cgv")
    public WebElement TermsOfServiceCheckBox;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    public WebElement proceedToCheckOut4;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    public WebElement PayByBankWire;


}
