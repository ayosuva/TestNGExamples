package com.argos_pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TrolleyPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@data-e2e='basket-total-price']")
    WebElement label_total_price;
    @FindBy(xpath = "//button[@data-test='basket-removeproduct']")
    WebElement link_remove_from_trolley;
    @FindBy(xpath = "//h3[@data-e2e='basket-emptytitle' ]")
    WebElement label_empty_trolley;


    public TrolleyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validate_total_price(String selected_product_price){
        Assert.assertEquals(label_total_price.getText().replace(",",""),selected_product_price);

    }

    public void click_link_remove_from_trolley_and_validate(){
        link_remove_from_trolley.click();
        Assert.assertEquals(label_empty_trolley.getText(),"Empty trolley!");
    }
}