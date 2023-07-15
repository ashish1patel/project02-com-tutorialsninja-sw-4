package com.tutorialsninja.laptopsandnotebooks;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooks = new LaptopsAndNotebooksPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    McBookPage mcBook = new McBookPage();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();
    CheckOutPage checkOut = new CheckOutPage();


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopNotebooks();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // Get all the products price and stored into array list
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.selectSortBy("Price (High > Low)");

        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);

        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(originalProductsPrice, afterSortByPrice);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // Select currency as £ Pound Sterling
        homePage.clickOnCurrency();
        homePage.selectPoundSterling();

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopNotebooks();

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooks.selectSortBy("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooks.selectProductMacBook();

        //2.5 Verify the text “MacBook”
        String actualMacBookText = mcBook.verifyMacBookText();
        Assert.assertEquals(actualMacBookText, "MacBook", "Product not match");

        //2.6 Click on ‘Add To Cart’ button
        mcBook.clickOnAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualAddToCartText = mcBook.addCartMessage();
        Assert.assertEquals(actualAddToCartText, "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Message is not match");

        //2.8 Click on link “shopping cart” display into success message
        mcBook.clickOnShoppingCart();

        //2.9 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCart.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartText, "Shopping Cart  (0.00kg)", "Text is not match");

        //2.10 Verify the Product name "MacBook"
        String actualMacBookText1 = shoppingCart.verifyProductName();
        Assert.assertEquals(actualMacBookText1, "MacBook", "Text not match");

        //2.11 Change Quantity "2"
        shoppingCart.changeTheQty();

        //2.12 Click on “Update” Tab
        shoppingCart.updateTheQty();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualModidyCartText = shoppingCart.verifyTheModifyCartText();
        Assert.assertEquals(actualModidyCartText, "Success: You have modified your shopping cart!\n" +
                "×", "Text is not match");

        //2.14 Verify the Total £737.45
        String actualTotalAmount = shoppingCart.verifyTheTotalAmount();
        Assert.assertEquals(actualTotalAmount, "£737.45", "Total amount is not match");

        //2.15 Click on “Checkout” button
        shoppingCart.clickOnCheckOutButton();

        //2.16 Verify the text “Checkout”
        String actualCheckoutText = checkOut.verifyCheckOutText();
        Assert.assertEquals(actualCheckoutText, "Checkout", "Text is not match");

        //2.17 Verify the Text “New Customer”
        String actualNewCustomerText = checkOut.verifyNewCustomerText();
        Thread.sleep(2000);
        Assert.assertEquals(actualNewCustomerText, "New Customer", "Text is not match");

        //2.18 Click on “Guest Checkout” radio button
        checkOut.clickOnGuestCheckOut();

        //2.19 Click on “Continue” tab
        checkOut.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        checkOut.enterFirstName("Prime");
        checkOut.enterLastName("Tesing");
        checkOut.enterEmail("prime1232@gmail.com");
        checkOut.enterPhoneNumber("01234567890");
        checkOut.enterAddress1("12 kings road");
        checkOut.enterCity("Harrow");
        checkOut.enterPostCode("HA2 9SG");
        checkOut.selectCountry("United Kingdom");
        checkOut.selectRegion("Hertfordshire");

        //2.21 Click on “Continue” Button
        checkOut.clickOnLastContinueCheckOutButton();

        //2.22 Add Comments About your order into text area
        checkOut.enterComments("Thank You");

        //2.23 Check the Terms & Conditions check box
        checkOut.clickOnAgree();

        //2.24 Click on “Continue” button
        checkOut.clickOnGuestContinue();

        //2.25 Verify the message “Warning: Payment method required!”
        String actualWarningMessage = checkOut.verifyPaymentWarningText();
        Assert.assertEquals(actualWarningMessage, "Warning: No Payment options are available. Please contact us for assistance!", "Warning text is not match");
    }
}
