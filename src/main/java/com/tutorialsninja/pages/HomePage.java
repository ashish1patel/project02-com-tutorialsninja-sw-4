package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

      /*
    1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    1.2 This method should click on the menu whatever name is passed as parameter. Write the following Test:
     */

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }


    By selectCurrency = By.xpath("//span[contains(text(),'Currency')]");//2.15a
    By poundSterling = By.xpath("//button[normalize-space()='£Pound Sterling']");//2.15b
    By desktopLink = By.linkText("Desktops");//1.1
    By laptopNotebooks = By.linkText("Laptops & Notebooks");//2.1
    By components = By.linkText("Components");//3.1
    By accountOption = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");//1.2
    By muAccountLink = By.xpath("//span[contains(text(),'My Account')]");//1.1


    public void mouseHoverOnDesktops() {
        mouseHoverToElementAndClick(desktopLink);//1.1
    }

    public void mouseHoverOnLaptopNotebooks() {
        mouseHoverToElementAndClick(laptopNotebooks);//2.1
    }

    public void mouseHoverOnComponents() {
        mouseHoverToElementAndClick(components);//3.1
    }

    public void clickOnCurrency() {
        clickOnElement(selectCurrency);
    }//2.15a

    public void selectPoundSterling() {
        //selectByVisibleTextFromDropDown(poundSterling,"£Pound Sterling");
        mouseHoverToElementAndClick(poundSterling);
    }//2.15b

    /*
   1.1 create method with name "selectMyAccountOptions" it has one parameter name"option" of type string
   1.2 This method should click on the options whatever name is passed as parameter.
            (Hint: Handle List of Element and Select options)

    */
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(accountOption);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(accountOption);
        }
    }//1.2

    public void clickOnMyAccount() {
        clickOnElement(muAccountLink);
    }//1.1
}



