package com.argos_pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver  driver;
    @FindBy(xpath = "//input[@id='searchTerm']")
    WebElement txt_Product_Search;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement btn_Search;
    @FindBy(xpath = "//a[@data-test='trolley']//span")
    WebElement label_trolley_count;
    @FindBy(xpath = "//button[@id='consent_prompt_submit']")
    WebElement btn_cookie_accept;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click_cookie_accept_btn(){
       btn_cookie_accept.click();
    }
    public void search_products(String search_value){
        txt_Product_Search.sendKeys(search_value);
        btn_Search.click();
        Assert.assertTrue(driver.getTitle().contains("Results for "+search_value));
    }

    public void validate_trolley_count(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(label_trolley_count,"1"));
        Assert.assertEquals(label_trolley_count.getText(),"1");

    }

    public void click_trolley_count(){
        label_trolley_count.click();
    }



}
