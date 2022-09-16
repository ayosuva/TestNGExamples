package com.example.selenium;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class SimpleTest extends Setup{

    @Test
    public  void test1()
    {
        driver.get("https://the-internet.herokuapp.com/tables");
        Assert.assertEquals(driver.getTitle(),"The Internet");
        Reporter.log("Website launched successfully");
    }

}
