package com.pagefile;

import com.commonmethods.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompendiumHomepage {
    CompendiumHomepage compendiumHomepage;
    public WebDriver driver;
    public CompendiumHomepage(WebDriver driver)
    {

        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]/a[text()='Contact']")
    WebElement contactbutton;
    @FindBy(xpath="//input[@name='name']")
    WebElement namefield;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailfield;
    @FindBy(xpath="//textarea[@name='message']")
    WebElement messagefield;
    @FindBy(xpath = "//div[@role='checkbox']")
    WebElement checkbox;
    @FindBy(xpath = "//div[@class='buttonIcon']")
    WebElement submitbutton;
    @FindBy(xpath = "//div[@class='Success']")
    WebElement verify;

    public void clickingOnContact(){
        contactbutton.click();

    }
    //this is for entering data
    public void detailsEntering() throws InterruptedException {
        Generics.sendKeysOnWebElement(namefield,"mythili");
        Generics.sendKeysOnWebElement(emailfield,"mythilibekkam@gmail.com");
        Generics.sendKeysOnWebElement(messagefield,"successfully entered");
        checkbox.click();
        Thread.sleep(5000);
        submitbutton.click();
    }
    //this is for verifying submission successfully
    public boolean verifyPage() throws InterruptedException {
        Thread.sleep(1000);
        return verify.isDisplayed();}
}
