package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "search_query_top")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@title='Information']")
    public WebElement myPersonalInfoBtn;

    @FindBy(linkText = "My addresses")
    public WebElement myAddressesBtn;






}
