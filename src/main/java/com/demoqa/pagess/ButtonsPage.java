package com.demoqa.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePage {

    private static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']");
    private static final By MESSAGE = By.id("dynamicClickMessage");

    WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnClickMeButton() {
        WebElement clickMeButton = driver.findElement(CLICK_ME_BUTTON);
        clickMeButton.click();
    }

    public String getAfterClickMessage() {
        WebElement message = driver.findElement(MESSAGE);
        return message.getText();
    }
}
