package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.demoqa.ConfigFileReader.getBaseUrl;
import static com.demoqa.ConfigFileReader.getProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoQaTest {

    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private static final By BUTTONS_MENU_ITEM = By.id("item-4");
    private static final By TEXT_BOX_MENU_ITEM = By.id("item-0");
    private static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']");
    private static final By MESSAGE = By.id("dynamicClickMessage");
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

    WebDriver driver;

    @Test
    void testButtonClick() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement buttonsMenuItem = driver.findElement(BUTTONS_MENU_ITEM);
        buttonsMenuItem.click();

        WebElement clickMeButton = driver.findElement(CLICK_ME_BUTTON);
        clickMeButton.click();

        WebElement message = driver.findElement(MESSAGE);
        String actualMessage = message.getText();
        assertEquals(EXPECTED_MESSAGE, actualMessage);
    }

    @Test
    void testTextBox() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();

        WebElement buttonsMenuItem = driver.findElement(TEXT_BOX_MENU_ITEM);
        buttonsMenuItem.click();

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

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
//        driver.get(getBaseUrl());
//        driver.get(getProperty("base.url"));
        var configFileReader = new NonStaticConfigFileReader();
        driver.get(configFileReader.getBaseUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
