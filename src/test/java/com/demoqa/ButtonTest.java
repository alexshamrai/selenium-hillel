package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonTest {

    WebDriver driver;

    private static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']");
    private static final By MESSAGE = By.id("dynamicClickMessage");
    private static final String EXPECTED_MESSAGE = "You have done a dynamic click";


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    void testButtonClick() {
        var clickMeButton = driver.findElement(CLICK_ME_BUTTON);
        new Actions(driver)
                .click(clickMeButton)
                .pause(Duration.ofSeconds(2))
                .perform();

        var message = driver.findElement(MESSAGE);
        var actualMessage = message.getText();
        assertEquals(EXPECTED_MESSAGE, actualMessage);
    }


    @Test
    void testDoubleClick() {
        var doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver)
                .doubleClick(doubleClickMeButton)
                .pause(Duration.ofSeconds(2))
                .perform();

        var message = driver.findElement(By.id("doubleClickMessage"));
        var actualMessage = message.getText();
        assertEquals("You have done a double click", actualMessage);
    }

    @Test
    void testButtonRightClick() {
        var rightClickButton = driver.findElement(By.id("rightClickBtn"));
        new Actions(driver)
                .contextClick(rightClickButton)
                .pause(Duration.ofSeconds(2))
                .perform();

        var message = driver.findElement(By.id("rightClickMessage"));
        var actualMessage = message.getText();
        assertEquals("You have done a right click", actualMessage);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
