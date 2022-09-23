package com.argos_pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetailsPage {
    WebDriver driver;
    @FindBy(xpath = "//button[@data-test='add-to-trolley-button-button']//span[text()='Add']")
    WebElement btn_add_to_trolley;
    @FindBy(xpath = "//strong[text()='Added to trolley' ]")
    WebElement label_added_to_trolley_msg;
    @FindBy(xpath = "//button[@data-test='component-att-modal-button-close']")
    WebElement btn_close_message;


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click_add_to_trolley(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btn_add_to_trolley);
    }

    public void validate_and_click_close_message(){
        Assert.assertEquals(label_added_to_trolley_msg.getText(),"Added to trolley");
        Assert.assertTrue(label_added_to_trolley_msg.isDisplayed());
        btn_close_message.click();
    }
}
