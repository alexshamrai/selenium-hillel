package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SliderTest extends BaseTest {

    @Test
    void testSlider() {
        driver.get("https://demoqa.com/slider");
        var slider = driver.findElement(By.className("range-slider"));

        new Actions(driver)
                .clickAndHold(slider)
                .moveByOffset(100, 0)
                .pause(Duration.ofSeconds(1))
                .release()
                .perform();

        var sliderValue = driver.findElement(By.id("sliderValue"));
        var actualValue = sliderValue.getAttribute("value");
        assertEquals("75", actualValue);
    }
}
