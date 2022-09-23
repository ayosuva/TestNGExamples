package com.argos_simplepom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver  driver;
    public By txt_Product_Search=By.xpath("//input[@id='searchTerm']");
    public By btn_Search=By.xpath("//span[text()='Search']");
    public By label_trolley_count=By.xpath("//a[@data-test='trolley']//span");
    public By btn_cookie_accept=By.xpath("//button[@id='consent_prompt_submit']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void click_cookie_accept_btn(){
        driver.findElement(btn_cookie_accept).click();
    }
    public void search_products(String search_value){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(txt_Product_Search).sendKeys(search_value);
        driver.findElement(btn_Search).click();
        Assert.assertTrue(driver.getTitle().contains("Results for "+search_value));
    }

    public void validate_trolley_count(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(label_trolley_count,"1"));
        Assert.assertEquals(driver.findElement(label_trolley_count).getText(),"1");

    }

    public void click_trolley_count(){
        driver.findElement(label_trolley_count).click();
    }



}
