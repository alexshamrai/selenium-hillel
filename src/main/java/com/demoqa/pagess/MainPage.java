package com.demoqa.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementsCard() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        elementsCard.click();
    }
}
