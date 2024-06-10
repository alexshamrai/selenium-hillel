package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IframeTest extends BaseTest {

    @Test
    void testIFrameContent() {
        driver.get(appProperties.getBaseUrl() + "/frames");
        var iFrame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iFrame);

        var header = driver.findElement(By.id("sampleHeading"));
        var actualHeaderText = header.getText();
        assertEquals("This is a sample page", actualHeaderText);

        driver.switchTo().defaultContent();
        var framePageHeader = driver.findElement(By.className("text-center"));
        framePageHeader.isDisplayed();
    }

}
