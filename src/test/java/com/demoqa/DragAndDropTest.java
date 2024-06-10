package com.demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTest extends BaseTest {

    @Test
    void testDragAndDrop() {
        driver.get(appProperties.getBaseUrl() + "/droppable");

        var source = driver.findElement(By.id("draggable"));
        var target = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(source, target)
                .perform();

        var droppableMessage = driver.findElement(By.cssSelector("#droppable > p"));
        var actualMessage = droppableMessage.getText();
        assertEquals(actualMessage, "Dropped!");
    }

}
