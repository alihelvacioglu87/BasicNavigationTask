package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    static String OS = System.getProperty("os.name").toLowerCase();


    public static WebDriver getDriver(String browserType) {

        if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            return driver;
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            return driver;
        } else if (browserType.equals("edge")) {

            if (OS.contains("mac")) {
                return null;
            } else {
                WebDriverManager.edgedriver().setup();
                WebDriver driver = new EdgeDriver();
                return driver;
            }

        } else if (browserType.equals("safari")) {

            if (OS.contains("win")) {
                return null;
            } else {
                WebDriverManager.safaridriver().setup();
                WebDriver driver = new SafariDriver();
                return driver;
            }

        } else {
            System.err.println("browser not supported");
            return null;
        }

    }
}

