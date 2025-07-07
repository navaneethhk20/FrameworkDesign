package org.example.tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import org.example.Pages.Page_Object_Model.ImprovedPOM.DashboardPage;
import org.example.Pages.Page_Object_Model.ImprovedPOM.LoginPage;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vwo_test_POM_PropertiesReader_DriverManager_ImprovedPom extends CommonToAllTest {

    @Test
    @Description("Test case verifies the negative scenraio when user name is wrong and gets the error message")
    @Owner("Navaneeth")
    public void LoginVwoNegative(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String errorMessage = loginPage.vwoLoginNegativeTestCase(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        Assert.assertEquals(errorMessage,PropertiesReader.readKey("error_message"), "error msg is not matching");
    }

    @Test
    @Description("Test case verifies the positive scenario when user name is logged in and we can see his name")
    @Owner("Navaneeth")
    public void LoginVwoPositive(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.vwoLoginPositiveTestCase(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String loggedInUserName = dashboardPage.loggedInUserName();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readKey("expected_username"),"username is not matching");
    }
}
