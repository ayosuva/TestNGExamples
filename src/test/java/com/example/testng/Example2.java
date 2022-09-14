package com.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example2 {

    @Test(groups = "Sanity")
    public void d() {
        System.out.println("Test d");
    }

    @Parameters({"fname","lname"})
    @Test(groups = "Regression")
    public void c(String fname, String lname) {
        System.out.println("Test c"+fname+" "+lname);
    }

    @Test(groups = "Regression",dataProvider = "dp")
    public void e(String username,String password) {
        System.out.println("Test e"+username+" "+password);
    }

    @Test(groups = "x")
    public void f() {
        System.out.println("Test f");
    }

    @DataProvider
    public Object[][] dp() {
        Object[][] d = new Object[3][2];
        //excel
        d[0][0] = "username1";
        d[0][1] = "password1";
        d[1][0] = "username2";
        d[1][1] = "password2";
        d[2][0] = "password3";
        d[2][1] = "password4";
        return d;
    }
}
