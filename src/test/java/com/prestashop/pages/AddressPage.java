package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    public AddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstname")
    public WebElement firstNameBox;

    @FindBy(id = "lastname")
    public WebElement LastNameBox;

    @FindBy(id = "submitAddress")
    public WebElement saveAddressBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol//li[1]")
    public WebElement firstNameError;



}
