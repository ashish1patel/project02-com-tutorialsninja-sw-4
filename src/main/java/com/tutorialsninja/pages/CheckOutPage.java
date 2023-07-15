package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {

    By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");//2.16
    By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");//2.17
    By guestCheckOut = By.xpath("//input[@value='guest']");//2.18
    By continueButton = By.xpath("//input[@id='button-account']");//2.19
    By firstName = By.xpath("//input[@id='input-payment-firstname']");//2.20.1
    By lastName = By.xpath("//input[@id='input-payment-lastname']");//2.20.2
    By email = By.xpath("//input[@id='input-payment-email']");//2.20.3
    By telephone = By.xpath("//input[@id='input-payment-telephone']");//2.20.4
    By address1 = By.xpath("//input[@id='input-payment-address-1']");//2.20.5
    By city = By.xpath("//input[@id='input-payment-city']");//2.20.6
    By postcode = By.xpath("//input[@id='input-payment-postcode']");//2.20.7
    By country = By.xpath("//select[@id='input-payment-country']");//2.20.8
    By region = By.xpath("//select[@id='input-payment-zone']");//2.20.9
    By continueButtonLast = By.xpath("//input[@id='button-guest']");//2.21
    By comments = By.xpath("//textarea[@name='comment']");//2.22
    By agree = By.xpath("//input[@type='checkbox']");//2.23
    By guestContinueButton = By.xpath("//input[@name = 'agree']");//2.24
    By warningText = By.xpath("//div[@class='alert alert-warning alert-dismissible']");//2.25


    public String verifyCheckOutText() {
        return getTextFromElement(checkOutText);
    }//2.16

    public String verifyNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }//2.17

    public void clickOnGuestCheckOut() {
        clickOnElement(guestCheckOut);
    }//2.18

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }//2.19

    public void enterFirstName(String firstNme) {
        sendTextToElement(firstName, firstNme);
    }//2.20.1

    public void enterLastName(String lastname) {
        sendTextToElement(lastName, lastname);
    }//2.20.2

    public void enterEmail(String value) {
        sendTextToElement(email, value);
    }//2.20.3

    public void enterPhoneNumber(String value) {
        sendTextToElement(telephone, value);
    }//2.20.4

    public void enterAddress1(String value) {
        sendTextToElement(address1, value);
    }//2.20.5

    public void enterCity(String value) {
        sendTextToElement(city, value);
    }//2.20.6

    public void enterPostCode(String value) {
        sendTextToElement(postcode, value);
    }//2.20.7

    public void selectCountry(String value) {
        selectByVisibleTextFromDropDown(country, value);
    }//2.20.8

    public void selectRegion(String value) {
        selectByVisibleTextFromDropDown(region, value);
    }//2.20.9

    public void clickOnLastContinueCheckOutButton() {
        clickOnElement(continueButtonLast);
    }//2.21

    public void enterComments(String value) {
        sendTextToElement(comments, value);
    }//2.22

    public void clickOnAgree() {
        clickOnElement(agree);
    }//2.23

    public void clickOnGuestContinue() {
        clickOnElement(guestContinueButton);
    }//2.24

    public String verifyPaymentWarningText() {
        return getTextFromElement(warningText);
    }//2.25
}
