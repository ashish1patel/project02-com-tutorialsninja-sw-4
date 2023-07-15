package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utility {

    By productText = By.xpath("//h1[contains(text(),'HP LP3065')]");//2.5
    By addToCart = By.xpath("//button[@id='button-cart']");//2.8
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");//2.9
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");//2.10


    public String verifyProductText() {
        return getTextFromElement(productText);
    }//2.5

    public void datePicker() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }//2.6
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }//2.8

    public String verifyTheSuccessMessage() {
        return getTextFromElement(successMessage);
    }//2.9

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
    }//2.10
}
