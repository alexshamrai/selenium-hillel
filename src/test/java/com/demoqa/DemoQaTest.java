package com.demoqa;

import com.demoqa.pagess.ButtonsPage;
import com.demoqa.pagess.MainPage;
import com.demoqa.pagess.SideMenuBar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoQaTest extends BaseTest {

    private static final By TEXT_BOX_TITLE = By.className("text-center");
    private static final String EXPECTED_MESSAGE = "You have done a dynamic click";
    private static final By FULL_NAME_FIELD = By.id("userName");
    private static final By EMAIL_FIELD = By.id("userEmail");
    private static final By CURRENT_ADDRESS = By.id("currentAddress");
    private static final By PERMANENT_ADDRESS = By.id("permanentAddress");
    private static final By SUBMIT_BUTTON = By.id("submit");
    private static final By SUBMITTED_NAME = By.id("name");
    private static final String FULL_NAME = "Charlie Parker";
    private static final String EMAIL = "charile@gmail.com";
    private static final String ADDRESS = "New York, 45 Avenue";

    MainPage mainPage;
    SideMenuBar sideMenuBar;
    ButtonsPage buttonsPage;

    @BeforeEach
    void precondition() {
        driver.get(appProperties.getBaseUrl());
        mainPage = new MainPage(driver);
        sideMenuBar = new SideMenuBar(driver);
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    void testButtonClick() {
        mainPage.clickElementsCard();

        sideMenuBar.clickButtonsMenuItem();

        buttonsPage.clickOnClickMeButton();

        String actualMessage = buttonsPage.getAfterClickMessage();
        assertEquals(EXPECTED_MESSAGE, actualMessage);
    }

    @Test
    void testTextBox() {
        mainPage.clickElementsCard();

        sideMenuBar.clickTextBoxMenuItem();

        WebElement textBoxTitle = driver.findElement(TEXT_BOX_TITLE);
        String actualText = textBoxTitle.getText();
        assertEquals("Text Box", actualText);

        WebElement fullNameField = driver.findElement(FULL_NAME_FIELD);
        fullNameField.sendKeys(FULL_NAME);

        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(EMAIL);

        WebElement currentAddress = driver.findElement(CURRENT_ADDRESS);
        currentAddress.sendKeys(ADDRESS);

        WebElement permanentAddress = driver.findElement(PERMANENT_ADDRESS);
        permanentAddress.sendKeys(ADDRESS);

        WebElement submitButton = driver.findElement(SUBMIT_BUTTON);
        submitButton.click();

        WebElement submittedName = driver.findElement(SUBMITTED_NAME);
        String actualSubmittedNameValue = submittedName.getText();
        assertTrue(actualSubmittedNameValue.contains(FULL_NAME));
    }
}
