package com.argos.pages;

import org.openqa.selenium.By;

public class TrolleyPage {
    public By label_total_price=By.xpath("//div[@data-e2e='basket-total-price']");
    public By link_remove_from_trolley=By.xpath("//button[@data-test='basket-removeproduct']");
    public By label_empty_trolley=By.xpath("//h3[@data-e2e='basket-emptytitle' ]");
}
