package com.argos_simplepom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TrolleyPage {
    WebDriver driver;
    public By label_total_price=By.xpath("//div[@data-e2e='basket-total-price']");
    public By link_remove_from_trolley=By.xpath("//button[@data-test='basket-removeproduct']");
    public By label_empty_trolley=By.xpath("//h3[@data-e2e='basket-emptytitle' ]");


    public TrolleyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validate_total_price(String selected_product_price){
        Assert.assertEquals(driver.findElement(label_total_price).getText().replace(",",""),selected_product_price);

    }

    public void click_link_remove_from_trolley_and_validate(){
        driver.findElement(link_remove_from_trolley).click();
        Assert.assertEquals(driver.findElement(label_empty_trolley).getText(),"Empty trolley!");
    }
}