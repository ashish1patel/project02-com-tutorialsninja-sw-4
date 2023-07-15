package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");//2.3
    By sort = By.id("input-sort");//1.3
    By selectProduct = By.linkText("MacBook");//2.4


    public String verifyLaptopNotebooksText() {
        return getTextFromElement(laptopNotebooksText);//2.3
    }

    public void selectSortBy(String sortBy) {
        selectByVisibleTextFromDropDown(sort, sortBy);
    }//1.3

    public void selectProductMacBook() {
        clickOnElement(selectProduct);
    }//2.4
}


