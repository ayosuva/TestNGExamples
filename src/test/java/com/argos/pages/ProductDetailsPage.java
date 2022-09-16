package com.argos.pages;

import org.openqa.selenium.By;

public class ProductDetailsPage {

    public By btn_add_to_trolley=By.xpath("//button[@data-test='add-to-trolley-button-button']//span[text()='Add']");
    public By label_added_to_trolley_msg=By.xpath("//strong[text()='Added to trolley' ]");
    public By btn_close_message=By.xpath("//button[@data-test='component-att-modal-button-close']");
}
