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

public class DragAndDropTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    void testDragAndDrop() {
        var source = driver.findElement(By.id("draggable"));
        var target = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(source, target)
                .perform();

        var droppableMessage = driver.findElement(By.cssSelector("#droppable > p"));
        var actualMessage = droppableMessage.getText();
        assertEquals(actualMessage, "Dropped!");
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
