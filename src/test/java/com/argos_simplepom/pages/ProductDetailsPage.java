package com.argos_simplepom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductDetailsPage {
    WebDriver driver;
    public By btn_add_to_trolley=By.xpath("//button[@data-test='add-to-trolley-button-button']//span[text()='Add']");
    public By label_added_to_trolley_msg=By.xpath("//strong[text()='Added to trolley' ]");
    public By btn_close_message=By.xpath("//button[@data-test='component-att-modal-button-close']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_add_to_trolley(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(btn_add_to_trolley));
    }

    public void validate_and_click_close_message(){
        Assert.assertEquals(driver.findElement(label_added_to_trolley_msg).getText(),"Added to trolley");
        Assert.assertTrue(driver.findElement(label_added_to_trolley_msg).isDisplayed());
        driver.findElement(btn_close_message).click();
    }
}
