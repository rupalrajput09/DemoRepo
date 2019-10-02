package com.freesite.qa.base;

import com.freesite.qa.util.TestUtil;
//import com.freesite.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver webDriver;
    public static Properties properties;
    //public static EventFiringWebDriver eventFiringWebDriver;
   // public static WebEventListener webEventListener;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Rupal\\IdeaProjects\\AutomateSelProject\\src\\main\\java\\com\\freesite\\qa\\config\\config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = properties.getProperty("browser");
        System.out.println(browserName);
        System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
//        if (browserName.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
//            webDriver = new ChromeDriver();
//        } else if
//        (browserName.equals("FireFox")) {
//            System.setProperty("webdriver.gecko.driver", "src\\Drivers\\geckodriver.exe");
//            webDriver = new FirefoxDriver();
//        }

     /*   eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        // Now create object of EventListenerHandler to register it with EventFiringDriver
       // webEventListener = new WebEventListener(); getting error cant create object of abstract class
        eventFiringWebDriver.register(webEventListener);
        webDriver = eventFiringWebDriver;*/

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad_TimeOut, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);

        webDriver.get(properties.getProperty("url"));
    }
}
