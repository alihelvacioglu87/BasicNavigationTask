package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtilities;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigationTests {

    static WebDriver driver;

    public static void main(String[] args) {
        testChrome();
        testFirefox();
        testEdge();
    }

    @AfterTest
    public static void MethodTearDown(){
        System.out.println("test finished");
        driver.quit();
    }


    @Test
    public static void testChrome() {
        System.out.println("testChrome started");
        //1. Open browser
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test();

    }

    @Test
    public static void testFirefox() {
        System.out.println("testFirefox started");
        //1. Open browser
        driver = BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test();

    }

    @Test
    public static void testEdge() {
        System.out.println("testEdge started");
        //1. Open browser
        driver = BrowserFactory.getDriver("edge");

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test();
        }catch (NullPointerException e){
            System.err.println("!!!!!Browser not supported!!!!!");
            e.printStackTrace();
        }

    }

    @Test
    public static void testSafari() {
        System.out.println("testSafari started");
        //1. Open browser
        driver = BrowserFactory.getDriver("safari");

       try {
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           test();
       }catch (NullPointerException e){
           System.err.println("!!!!!Browser not supported!!!!!");
           e.printStackTrace();
       }

    }


    public static void test() {

        //2. Go to website https://google.com
        driver.get("https://google.com");


        //3. Save the title in a string variable
        String googleTitle = driver.getTitle();

        //4. Go to https://www.etsy.com/
        driver.get("https://www.etsy.com");

        //5. Save the title in a string variable
        String etsyTitle = driver.getTitle();

        //6. Navigate back to previous page
        driver.navigate().back();

        //7. Verify that title is same is in step 3
        String actualTitle = driver.getTitle();
        StringUtilities.verifyEquals(googleTitle, actualTitle);

        //8. Navigate forward to previous page
        driver.navigate().forward();

        //9. Verify that title is same is in step 5
        actualTitle = driver.getTitle();
        StringUtilities.verifyEquals(etsyTitle, actualTitle);

        driver.quit(); // !!!!!! MY AFTERTEST DOES NOT WORK !!!!!!

    }

}
