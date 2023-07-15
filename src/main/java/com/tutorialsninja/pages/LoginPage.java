package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By loginLink = By.xpath("//h2[contains(text(),'Returning Customer')]");//2.3
    By emailField = By.id("input-email");//4.3
    By passwordField = By.id("input-password");//4.5
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");//4.6

    public String verifyTheLoginText() {
        return getTextFromElement(loginLink);
    }//2.3

    public void enterEmail1(String email1) {
        sendTextToElement(emailField, email1);
    }//4.3

    public void enterPassword1(String password1) {
        sendTextToElement(passwordField, password1);
    }//4.4

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }//4.6
}
