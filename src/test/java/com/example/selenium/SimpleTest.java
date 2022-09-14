package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SimpleTest extends Setup{


    @Test
    public  void test1()
    {
        driver.get("https://the-internet.herokuapp.com/tables");
        Assert.assertEquals(driver.getTitle(),"The Internet");
        Reporter.log("Website launched successfully");
    }

}
