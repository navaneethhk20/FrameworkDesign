package org.example.Pages.Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordnameField = By.xpath("//input[@name='password']");
    private By LoginButton = By.xpath("//button[@type='submit']");
    private By error_messageField = By.xpath("//div[@id='js-notification-box-msg']");

    public String vwoLoginNegativeTestCase(String user , String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordnameField).sendKeys(pwd);
        driver.findElement(LoginButton).click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String error_Message = driver.findElement(error_messageField).getText();
        return error_Message;
    }

    public void vwoLoginPositiveTestCase(String user , String pwd){
        driver.get("https://app.vwo.com/");
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordnameField).sendKeys(pwd);
        driver.findElement(LoginButton).click();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
