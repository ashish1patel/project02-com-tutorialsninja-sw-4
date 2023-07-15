package com.tutorialsninja.homepage;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {


    HomePage topMenu = new HomePage();
    DesktopsPage desktops = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooks = new LaptopsAndNotebooksPage();
    ComponentsPage components = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        topMenu.mouseHoverOnDesktops();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        topMenu.selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        String actualDesktopsText = desktops.verifyDesktopsText();
        Assert.assertEquals(actualDesktopsText, "Desktops", "text not match");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        topMenu.mouseHoverOnLaptopNotebooks();

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        topMenu.selectMenu("Show AllLaptops & Notebooks");

        // 2.3 Verify the text ‘Laptops & Notebooks’
        String actualLaptopNotebooksText = laptopsAndNotebooks.verifyLaptopNotebooksText();
        Assert.assertEquals(actualLaptopNotebooksText, "Laptops & Notebooks", "Text not match");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        topMenu.mouseHoverOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        topMenu.selectMenu("Show AllComponents");

        // 3.3 Verify the text ‘Components’
        String actualComponentsText = components.verifyComponentsText();
        Assert.assertEquals(actualComponentsText, "Components", "Text not match");
    }
}
