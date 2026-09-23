package com.Selenium;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.DriverManagerClass;
import PageObject.Driverclass;
import PageObject.Loginpage;
import PageObject.customercration;
import Utilpackage.TestdataManagement;

public class Loginpagetest extends DriverManagerClass {

    public Loginpagetest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driverinilization();
    }

    @Test(dataProvider = "exceldta", priority = 1)
    public void logintestfunction(String username1, String password1) throws InterruptedException, IOException {
        Loginpage loginpage = new Loginpage(Driverclass.getDriver(), probs);
        loginpage.loginfunction(username1, password1);
        
        customercration cu = new customercration(Driverclass.getDriver());
        cu.customercreatyonmethod();
    }

    @DataProvider(name = "exceldta")
    public Object[][] dataprovider() throws IOException {
        return TestdataManagement.readexceldata();
    }

    // Explicit login included so test can run standalone on fresh browser session
    @Test(priority = 2)
    public void customercreationtest() throws InterruptedException, IOException {
        Loginpage loginpage = new Loginpage(Driverclass.getDriver(), probs);
        loginpage.loginfunction(probs.getProperty("username"), probs.getProperty("password"));

        customercration cu = new customercration(Driverclass.getDriver());
        cu.customercreatyonmethod();
    }

    @AfterMethod
    public void tearDown() {
        Driverclass.quitDriver();
    }
}