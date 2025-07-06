package org.example.tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Pages.Page_Object_Model.DashboardPage;
import org.example.Pages.Page_Object_Model.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vwo_test_POM {

    @Test
    @Description("Test case verifies the negative scenraio when user name is wrong and gets the error message")
    @Owner("Navaneeth")
    public void LoginVwoNegative(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
       String errorMessage = loginPage.vwoLoginNegativeTestCase("admin@gmail.com", "nithu@123");
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match", "error msg is not matching");
    }

    @Test
    @Description("Test case verifies the positive scenario when user name is logged in and we can see his name")
    @Owner("Navaneeth")
    public void LoginVwoPositive(){
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.vwoLoginPositiveTestCase("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashboardPage = new DashboardPage(driver);
        String loggedInUserName =dashboardPage.loggedInUserName();
        Assert.assertEquals(loggedInUserName,"Aman","username is not matching");
    }
}
