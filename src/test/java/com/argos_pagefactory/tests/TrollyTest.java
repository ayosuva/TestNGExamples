package com.argos_pagefactory.tests;

import com.argos_pagefactory.Utils.TestSetup;
import com.argos_pagefactory.pages.HomePage;
import com.argos_pagefactory.pages.ProductDetailsPage;
import com.argos_pagefactory.pages.SearchResultPage;
import com.argos_simplepom.pages.TrolleyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrollyTest extends TestSetup {

    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;
    TrolleyPage trolleyPage;
    @Test()
    public void launchArgos() {
        driver.get("https://www.argos.co.uk/");
        Assert.assertEquals(driver.getTitle(), "Argos | Order online today for fast home delivery");


    }
    @Test()
    public void testTrolly() {
        homePage = new HomePage(driver);
        homePage.click_cookie_accept_btn();
        homePage.search_products("iphone 13 pro max");

        searchResultPage = new SearchResultPage(driver);
        searchResultPage.click_price_filter_showMore_link();
        searchResultPage.click_checkbox_price_1000_to_2000();
        String selected_product_price=searchResultPage.click_a_product_get_price();

        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.click_add_to_trolley();
        productDetailsPage.validate_and_click_close_message();

        homePage.validate_trolley_count();
        homePage.click_trolley_count();

        trolleyPage = new TrolleyPage(driver);
        trolleyPage.validate_total_price(selected_product_price);
        trolleyPage.click_link_remove_from_trolley_and_validate();
    }

}
