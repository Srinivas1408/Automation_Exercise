package com.krct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class baseTest
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        driver=new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void get()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("""
           document.querySelectorAll('.adsbygoogle')
                .forEach(el => el.remove());
        """);
    }


    @AfterMethod
    public void teardowm()
    {
        driver.quit();
    }

}
