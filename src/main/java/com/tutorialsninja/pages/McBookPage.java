package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class McBookPage extends Utility {

    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]"); //2.5
    By addToCart = By.xpath("//button[@id='button-cart']");//2.6
    By successText = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");//2.7
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");//2.8

    public String verifyMacBookText() {
        return getTextFromElement(macBookText);
    }//2.5

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }//2.6

    public String addCartMessage() {
        return getTextFromElement(successText);
    }//2.7

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }//2.8
}
