package com.argos.pages;

import org.openqa.selenium.By;

public class HomePage {

    public By txt_Product_Search=By.xpath("//input[@id='searchTerm']");
    public By btn_Search=By.xpath("//span[text()='Search']");
    public By label_trolley_count=By.xpath("//a[@data-test='trolley']//span");
    public By btn_cookie_accept=By.xpath("//button[@id='consent_prompt_submit']");


}
