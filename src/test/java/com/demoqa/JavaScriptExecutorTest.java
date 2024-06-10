package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JavaScriptExecutorTest extends BaseTest {

    private static final By BOOK_STORE_APPLICATION_CARD = By.xpath("//div[@class='card-body']/h5[text()='Book Store Application']");
    private static final By FORMS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Forms']");

    @BeforeEach
    void precondition() {
        driver.get(appProperties.getBaseUrl());
    }

    @Test
    void scrollToBookStoreApplication() {
        WebElement bookStoreApplicationCard = driver.findElement(BOOK_STORE_APPLICATION_CARD);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", bookStoreApplicationCard);
        bookStoreApplicationCard.click();
    }

    @Test
    void scrollToBookStoreApplicationViaActions() {
        WebElement bookStoreApplicationCard = driver.findElement(BOOK_STORE_APPLICATION_CARD);
        new Actions(driver)
                .scrollToElement(bookStoreApplicationCard)
                .pause(Duration.ofSeconds(2))
                .click()
                .perform();
    }

    @Test
    void captureContentsOfAPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageContent = js.executeScript("return document.documentElement.outerHTML;").toString();
        System.out.println(pageContent);
    }

    @Test
    void mouseOverAnElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement formsCard = driver.findElement(FORMS_CARD);
        String mouseOverScript = "var event = new MouseEvent('mouseover', {" +
                "view: window," +
                "bubbles: true," +
                "cancelable: true" +
                "}); arguments[0].dispatchEvent(event);";
        js.executeScript(mouseOverScript, formsCard);
    }

    @Test
    void openPopupWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://www.selenium.dev/";
        js.executeScript("window.open('" + url + "', '_blank');");
    }
}
