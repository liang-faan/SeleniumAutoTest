package com.lfa.selenium.auto.test;

import com.relevantcodes.extentreports.ExtentReports;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static final String CHROME_DRIVER_PATH="./driver/chromedriver_mac64/chromedriver";
    protected static final String CHROME_LOG_PATH = "chromedriver.log";
    protected static final String EXTENT_REPORT_PATH = "ExtentReportResults.html";

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected static ExtentReports seleniumReports;

    /***
     * initial test report
     */
    @BeforeAll
    public static void startTestReport(){
        seleniumReports = new ExtentReports(EXTENT_REPORT_PATH);
    }

    /**
     * Initial webdriver with system properties
     * define window size
     */
    @BeforeEach
    public void initialWebDriver(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        System.setProperty("webdriver.chrome.logfile", CHROME_LOG_PATH);
        System.setProperty("webdriver.chrome.verboselogging", "true");
        webDriver = new ChromeDriver();
        webDriver.manage().window().setSize(new Dimension(1200, 1024));
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    /**
     * close webdriver after each test case
     */
    @AfterEach
    public void stopWebDriver(){
        // if only single testing, we can use webDriver.quit()
        // webDriver.quit();
        webDriver.close();
    }

    /**
     * Close test report and write to disk
     */
    @AfterAll
    public static void closeTestReport(){
        seleniumReports.flush();
        seleniumReports.close();
    }
}
