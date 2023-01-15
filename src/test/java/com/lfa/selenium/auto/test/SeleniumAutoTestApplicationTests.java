package com.lfa.selenium.auto.test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleniumAutoTestApplicationTests extends BaseTest {

    private final static String URL="https://academylearn.smu.edu.sg/";
    private final static String URL_SUCCESS_LOGIN="https://academylearn.smu.edu.sg/dashboard";
    private final static String USER_NAME = "your_account";
    private final static String PASS_CREDENTIAL="your_acct_pwd";

    //Test login SMU lms portal via selenium
    @Test
    public void testLogin(){
        ExtentTest test = seleniumReports.startTest("Test Login");
        test.log(LogStatus.INFO, "Start access web URL");
        webDriver.get(URL);
        test.log(LogStatus.PASS, "Success Open Website");

        test.log(LogStatus.INFO, "Start finding login button");
        WebElement loginLink = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("tl-cms-nav-login")));
        assertNotNull(loginLink);
        test.log(LogStatus.PASS, "Success find login link");
        loginLink.click();
        test.log(LogStatus.PASS, "Success open Login page");

        //to start xpath https://www.w3schools.com/xml/xpath_intro.asp
        test.log(LogStatus.INFO, "Start finding login username text box");
        WebElement loginUserName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"tl-shared-username\"]")));
        assertNotNull(loginUserName);
        test.log(LogStatus.PASS, "Success find login username text box");
        test.log(LogStatus.INFO, "Enter user name");
        loginUserName.sendKeys(USER_NAME);
        test.log(LogStatus.PASS, "Success Enter username");

        test.log(LogStatus.INFO, "Start finding password text box");
        WebElement loginPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        assertNotNull(loginPassword);
        test.log(LogStatus.PASS, "Success find password text box");
        test.log(LogStatus.INFO, "Enter password");
        loginPassword.sendKeys(PASS_CREDENTIAL);
        test.log(LogStatus.PASS, "Success Enter password");

        test.log(LogStatus.INFO, "Start find login button");
        WebElement loginSubmit = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
        assertNotNull(loginSubmit);
        test.log(LogStatus.PASS, "Success find login button");
        test.log(LogStatus.INFO, "Start Click Login button");
        loginSubmit.click();
        test.log(LogStatus.PASS, "Success click Login button");

        test.log(LogStatus.INFO, "Validate Success Login URL: "+URL_SUCCESS_LOGIN);
        assertTrue(webDriverWait.until(ExpectedConditions.urlMatches(URL_SUCCESS_LOGIN)));
        test.log(LogStatus.PASS, "Success Login URL matched");

        seleniumReports.endTest(test);

    }

}
