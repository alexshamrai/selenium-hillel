package com.demoqa.pagess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPageViaPageFactory extends BasePage {

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;
    @FindBy(id = "dynamicClickMessage")
    private WebElement afterClickMessage;

    WebDriver driver;

    public ButtonsPageViaPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnClickMeButton() {
        clickMeButton.click();
    }

    public String getAfterClickMessage() {
        return afterClickMessage.getText();
    }
}
