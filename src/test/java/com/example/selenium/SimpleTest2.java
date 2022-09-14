package com.example.selenium;

import com.example.pages.WebTablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleTest2 {


    @Test
    public  void test2()
    {
        //System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        WebTablePage webTablePage = new WebTablePage();
        List<WebElement> fname= Setup.driver.findElements(webTablePage.fnanme);
             List<WebElement> delete=  Setup.driver.findElements(webTablePage.delete);
        for (int i = 0; i < fname.size(); i++) {
            if(fname.get(i).getText().equals("Tim")){
                delete.get(i).click();
            }
        }
        fname= Setup.driver.findElements(webTablePage.fnanme);
        Assert.assertEquals("Test","Test");
        Assert.assertEquals(fname.size(),3);

    }


}
