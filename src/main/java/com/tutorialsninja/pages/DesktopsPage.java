package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopsPage extends Utility {

    By sortBy = By.id("input-sort");//1.2 and 2.2
    By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");//1.3
    By product = By.xpath("//a[contains(text(),'HP LP3065')]");//2.4


    public void clickOnSortBy(String sort) {
        selectByVisibleTextFromDropDown(sortBy, sort);
    }//1.2 and 2.2

    public String verifyDesktopsText() {
        return getTextFromElement(desktopsText);//1.3
    }

    public void clickOnProduct() {
        clickOnElement(product);
    }//2.4
}
