package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By componentsText = By.xpath("//h2[contains(text(),'Components')]");//3.3

    public String verifyComponentsText() {
        return getTextFromElement(componentsText);//3.3
    }
}
