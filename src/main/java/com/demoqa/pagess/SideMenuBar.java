package com.demoqa.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuBar {

    private static final By BUTTONS_MENU_ITEM = By.id("item-4");
    private static final By TEXT_BOX_MENU_ITEM = By.id("item-0");

    WebDriver driver;

    public SideMenuBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonsMenuItem() {
        WebElement buttonsMenuItem = driver.findElement(BUTTONS_MENU_ITEM);
        buttonsMenuItem.click();
    }

    public void clickTextBoxMenuItem() {
        WebElement buttonsMenuItem = driver.findElement(TEXT_BOX_MENU_ITEM);
        buttonsMenuItem.click();
    }
}
