package com.argos.tests;

import com.argos.Utils.TestSetup;
import com.argos.pages.HomePage;
import com.argos.pages.ProductDetailsPage;
import com.argos.pages.SearchResultPage;
import com.argos.pages.TrolleyPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TrollyTest1 extends TestSetup {


    @Test()
    public void launchArgos() {
        driver.get("https://www.argos.co.uk/");
        Assert.assertEquals(driver.getTitle(), "Argos | Order online today for fast home delivery");


    }
    @Test()
    public void testTrolly() {
        HomePage homePage = new HomePage();
        driver.findElement(homePage.btn_cookie_accept).click();
        String search_value="iphone 13 pro max";
        driver.findElement(homePage.txt_Product_Search).sendKeys(search_value);
        driver.findElement(homePage.btn_Search).click();
        Assert.assertTrue(driver.getTitle().contains("Results for "+search_value));

        SearchResultPage searchResultPage = new SearchResultPage();
        driver.findElement(searchResultPage.link_price_showMore).click();
        driver.findElement(searchResultPage.check_price_1000_to_2000).click();
        /*WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));*/
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> list_all_product_titles=driver.findElements(searchResultPage.link_all_product_titles);
        List<WebElement> list_all_prices=driver.findElements(searchResultPage.label_all_product_price);
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

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(productDetailsPage.btn_add_to_trolley));
        WebElement avatar=driver.findElement(productDetailsPage.btn_add_to_trolley);
        new Actions(driver).moveToElement(avatar).perform();
        driver.findElement(productDetailsPage.btn_add_to_trolley).click();

        Assert.assertEquals(driver.findElement(productDetailsPage.label_added_to_trolley_msg).getText(),"Added to trolley");
        Assert.assertTrue(driver.findElement(productDetailsPage.label_added_to_trolley_msg).isDisplayed());
        driver.findElement(productDetailsPage.btn_close_message).click();

        Assert.assertEquals(driver.findElement(homePage.label_trolley_count).getText(),"1");

        driver.findElement(homePage.label_trolley_count).click();
        TrolleyPage trolleyPage = new TrolleyPage();
        Assert.assertEquals(driver.findElement(trolleyPage.label_total_price).getText().replace(",",""),selected_product_price);
        driver.findElement(trolleyPage.link_remove_from_trolley).click();
        Assert.assertEquals(driver.findElement(trolleyPage.label_empty_trolley).getText(),"Empty trolley!");




    }

}
