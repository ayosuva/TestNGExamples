package com.argos.pages;

import org.openqa.selenium.By;

public class SearchResultPage {

    public By link_price_showMore = By.xpath("//button[text()='Show more' and @data-test='price-facet-button-show-more']");
    public By check_price_1000_to_2000 = By.xpath("//span[text()='£1000 - £2000' ]");
    public By link_all_product_titles = By.xpath("//a[@data-test='component-product-card-title']");
    public By label_all_product_price = By.xpath("//div[@data-test='component-product-card-price']/strong");

}
