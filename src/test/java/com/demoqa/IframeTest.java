package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IframeTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    void testIFrameContent() {
        var iFrame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iFrame);

        var header = driver.findElement(By.id("sampleHeading"));
        var actualHeaderText = header.getText();
        assertEquals("This is a sample page", actualHeaderText);

        driver.switchTo().defaultContent();
        var framePageHeader = driver.findElement(By.className("text-center"));
        framePageHeader.isDisplayed();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
