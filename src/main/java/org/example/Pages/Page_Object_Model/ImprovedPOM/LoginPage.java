package org.example.Pages.Page_Object_Model.ImprovedPOM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPages {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordnameField = By.xpath("//input[@name='password']");
    private By LoginButton = By.xpath("//button[@type='submit']");
    private By error_messageField = By.xpath("//div[@id='js-notification-box-msg']");

    public String vwoLoginNegativeTestCase(String user , String pwd){
        openVWO();
        enterInput(usernameField,user);
        enterInput(passwordnameField,pwd);
        clickElement(LoginButton);
        customWait();
        presenceOfElement(error_messageField);
        return getText(error_messageField);
    }

    public void vwoLoginPositiveTestCase(String user , String pwd){
        openVWO();
        enterInput(usernameField,user);
        enterInput(passwordnameField,pwd);
        clickElement(LoginButton);
        customWait();
    }

}
