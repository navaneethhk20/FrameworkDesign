package org.example.Pages.Page_Object_Model.ImprovedPOM;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPages {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By loggedInUser = By.xpath("//span[@data-qa= \"lufexuloga\"]");

    public String loggedInUserName(){
        customWait();
        visibilityOfElement(loggedInUser);
        return getText(loggedInUser);

    }
}
