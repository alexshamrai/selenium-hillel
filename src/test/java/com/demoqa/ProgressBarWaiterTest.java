package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class ProgressBarWaiterTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @Test
    void testProgressBarExplicit() {
        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(textToBe(By.id("progressBar"), "100%"));

        WebElement resetButton = driver.findElement(By.id("resetButton"));
        assertTrue(resetButton.isDisplayed());
    }

    @Test
    void testProgressBarImplicit() {
        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebElement resetButton = driver.findElement(By.id("resetButton"));
        assertTrue(resetButton.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
