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
import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    @FindBy(xpath = "//button[text()='Show more' and @data-test='price-facet-button-show-more']")
    WebElement link_price_showMore_filter;
    @FindBy(xpath = "//span[text()='£1000 - £2000' ]")
    WebElement check_price_1000_to_2000;
    @FindBy(xpath = "//a[@data-test='component-product-card-title']")
    List<WebElement> link_all_product_titles;
    @FindBy(xpath = "//div[@data-test='component-product-card-price']/strong")
    List<WebElement> label_all_product_price;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click_price_filter_showMore_link() {
        link_price_showMore_filter.click();
    }

    public void click_checkbox_price_1000_to_2000() {
        check_price_1000_to_2000.click();
        /*new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.pre(link_all_product_titles));*/

    }

    public String click_a_product_get_price() {
        List<WebElement> list_all_product_titles=link_all_product_titles;
        List<WebElement> list_all_prices=label_all_product_price;
        String selected_product_price="";
        Assert.assertTrue(list_all_product_titles.size() > 0);
        for (int i = 0; i < list_all_product_titles.size(); i++) {

            String title=list_all_product_titles.get(i).getText();
            if(title.contains("iPhone 13 Pro Max") && title.contains("256GB") && title.contains("Gold")){
                selected_product_price=list_all_prices.get(i).getText();
                list_all_product_titles.get(i).click();
                break;
            }

        }
        return selected_product_price;
    }
}
