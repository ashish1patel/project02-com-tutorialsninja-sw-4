package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {

    By registerAccountText = By.xpath("//h1[normalize-space()='Register Account']");//1.3
    By firstNameField = By.xpath("//input[@id='input-firstname']");//3.3
    By lastNameField = By.xpath("//input[@id='input-lastname']");//3.4
    By emailField = By.xpath("//input[@id='input-email']");//3.5
    By telephoneField = By.xpath("//input[@id='input-telephone']");//3.6
    By passwordField = By.xpath("//input[@id='input-password']");//3.7
    By passwordConfirmField = By.xpath("//input[@id='input-confirm']");//3.8
    By subscribeRadioButtonField = By.xpath("//label[normalize-space()='Yes']");//3.9
    By privacyPolicyBox = By.xpath("//input[@name='agree']");//3.10
    By continueButton = By.xpath("//input[@value='Continue']");//3.11
    By accountCreateText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");//3.12
    By continueButton1 = By.xpath("//a[contains(text(),'Continue')]");//3.13


    public String verifyTheRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }//1.3

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
    }//3.3

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
    }//3.4

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
    }//3.5

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
    }//3.6

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }//3.7

    public void enterPasswordConfirm(String passwordConfirm) {
        sendTextToElement(passwordConfirmField, passwordConfirm);
    }//3.8

    public void clickOnSubscribeRadioButtonField() {
        clickOnElement(subscribeRadioButtonField);
    }//3.9

    public void clickOnPrivacyPolicyBox() {
        clickOnElement(privacyPolicyBox);
    }//3.10

    public void clickOnContinueButton1() {
        clickOnElement(continueButton1);
    }//3.13

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }//3.11

    public String verifyTheAccountCreateText() {
        return getTextFromElement(accountCreateText);
    }//3.12
}
