package org.example.Pages.Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By loggedInUser = By.xpath("//span[@data-qa= \"lufexuloga\"]");

    public String loggedInUserName(){
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            throw new RuntimeException (e);
        }

        String loggedusername = driver.findElement(loggedInUser).getText();
        return loggedusername;
    }
}
