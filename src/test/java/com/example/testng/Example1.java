package com.example.testng;

import org.testng.annotations.*;

public class Example1 {


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    @Test(priority = 0)
    public void b() {
        System.out.println("Test b");
    }

    @Test(priority = 1)
    public void a() {
        System.out.println("Test a");
    }
}
