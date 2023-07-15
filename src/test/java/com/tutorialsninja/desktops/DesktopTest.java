package com.tutorialsninja.desktops;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopTest extends BaseTest {

    HomePage topMenuPage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    ProductPage product = new ProductPage();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        topMenuPage.mouseHoverOnDesktops();

        //1.2 Click on “Show All Desktops”
        topMenuPage.selectMenu("Show AllDesktops");

        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.clickOnSortBy("Name (Z - A)");

        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName);
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // Select currency as £ Pound Sterling
        topMenuPage.clickOnCurrency();
        topMenuPage.selectPoundSterling();

        //2.1 Mouse hover on Desktops Tab. and click
        topMenuPage.mouseHoverOnDesktops();

        //2.2 Click on “Show AllDesktops”
        topMenuPage.selectMenu("Show AllDesktops");

        //2.3 Select Sort By position "Name: A to Z"
        Thread.sleep(2000);
        desktopsPage.clickOnSortBy("Name (A - Z)");

        //2.4 Select product “HP LP3065”
        desktopsPage.clickOnProduct();

        //2.5 Verify the Text "HP LP3065"
        String actualText = product.verifyProductText();
        Assert.assertEquals(actualText, "HP LP3065", "text not match");

        //2.6 Select Delivery Date "2022-11-30"
        product.datePicker();

        //2.7.Enter Qty "1” using Select class.

        //2.8 Click on “Add to Cart” button
        product.clickOnAddToCart();

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        String actualMessage = product.verifyTheSuccessMessage();
        Assert.assertEquals(actualMessage, "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", "message not match");

        // 2.10 Click on link “shopping cart” display into success message
        product.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCart.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartText, "Shopping Cart  (1.00kg)", "Text is not match");

        //2.12 Verify the Product name "HP LP3065"
        String actualProductName = shoppingCart.verifyProductName();
        Assert.assertEquals(actualProductName, "HP LP3065", "Product name is not match");

        //2.13 Verify the Delivery Date "2022-11-30"
        Thread.sleep(2000);
        String actualDeliveryDate = shoppingCart.verifyTheDeliveryDate();
        Assert.assertEquals(actualDeliveryDate, "Delivery Date:2023-11-30", "Delivery date is not match");

        //2.14 Verify the Model "Product21"
        Thread.sleep(2000);
        String actualModelName = shoppingCart.verifyTheModelName();
        Assert.assertEquals(actualModelName, "Product 21", "Model name is not match");

        //2.15 Verify the Total "£74.73"
        String actualTotalAmount = shoppingCart.verifyTheTotalAmount();
        Assert.assertEquals(actualTotalAmount, "£74.73", "Total amount is not match");
    }
}
