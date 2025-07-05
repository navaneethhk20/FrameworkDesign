package org.example.tests.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class vwo_test {
    @Test
    public void vwoNegativeLoginTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://app.vwo.com/");
        WebElement acc = driver.findElement(By.xpath("//div[@data-qa=\"qewoqoleka\" and normalize-space(text() =\"\tDon't have an account? \")]"));
        WebElement vwoLogo = driver.findElement(By.xpath("//img[@id=\"vow-login-logo\"]"));
        Assert.assertTrue(vwoLogo.isDisplayed());
        Assert.assertTrue(acc.isDisplayed());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement error_msg = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-notification-box-msg']")));
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match", "error msg is not matching");
        driver.close();
    }

    @Test
    public void vwoPositiveLoginTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://app.vwo.com/");
        WebElement acc = driver.findElement(By.xpath("//div[@data-qa=\"qewoqoleka\" and normalize-space(text() =\"\tDon't have an account? \")]"));
        WebElement vwoLogo = driver.findElement(By.xpath("//img[@id=\"vow-login-logo\"]"));
        Assert.assertTrue(vwoLogo.isDisplayed());
        Assert.assertTrue(acc.isDisplayed());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("contact+aug@thetestingacademy.com");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("TtxkgQ!s$rJBk85");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class=\"page-heading\" and contains(text(), \"Dashboard\")]")));
        wait.until(ExpectedConditions.visibilityOf(dashboard));
        Assert.assertEquals(dashboard.getText(),"Dashboard","dashboard is not visible");
        driver.close();

    }
}
