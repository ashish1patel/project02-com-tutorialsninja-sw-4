package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {

    By logOutText = By.xpath("//h1[contains(text(),'Account Logout')]");//3.16
    By continueButton2 = By.xpath("//a[contains(text(),'Continue')]");//3.17
    By myAccountText = By.xpath("//h2[normalize-space()='My Account']");//4.7
    By continueButton3 = By.xpath("//a[@class= 'btn btn-primary']");


    public String verifyTheLogOutText() {
        return getTextFromElement(logOutText);
    }//3.16

    public void clickOnContinueButton2() {
        clickOnElement(continueButton2);
    }//3.17

    public String verifyMyAccountText() {
        return getTextFromElement(myAccountText);
    }//4.7

    public void clickOnContinue3() {
        clickOnElement(continueButton3);
    }
}
