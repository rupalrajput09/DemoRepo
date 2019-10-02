package TestTry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TryClass {

    @BeforeMethod
    public void Session1(){
        System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
        WebDriver webDriver1 = new ChromeDriver();
        webDriver1.manage().window().maximize();
        webDriver1.manage().deleteAllCookies();

        webDriver1.get("https://freecrm.com/");
        webDriver1.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("Hello1");
    }



}
