package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//div[@id='content']//h1");//2.11
    By productNameText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");//2.12
    By deliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");//2.13
    By modelNameText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");//2.14
    By totalAmountText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");//2.15
    By changeQtyLink = By.xpath("//input[contains(@name, 'quantity')]");//2.11
    By updateQtyLink = By.xpath("//button[contains(@data-original-title, 'Update')]");//2.12
    By modifiedCartText = By.xpath("//div[@id='checkout-cart']/div[1]");//2.13
    By checkOut = By.xpath("//a[@class='btn btn-primary']");//2.15


    public String verifyShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }//2.11

    public String verifyProductName() {
        return getTextFromElement(productNameText);
    }//2.12

    public String verifyTheDeliveryDate() {
        return getTextFromElement(deliveryDateText);
    }//2.13

    public String verifyTheModelName() {
        return getTextFromElement(modelNameText);
    }//2.14

    public String verifyTheTotalAmount() {
        return getTextFromElement(totalAmountText);
    }//2.15c

    public void changeTheQty() {
        driver.findElement(changeQtyLink).clear();
        sendTextToElement(changeQtyLink, "2");
    }//2.11

    public void updateTheQty() {
        clickOnElement(updateQtyLink);
    }//2.12

    public String verifyTheModifyCartText() {
        return getTextFromElement(modifiedCartText);
    }//2.13

    public void clickOnCheckOutButton() {
        clickOnElement(checkOut);
    }//1.15
}
