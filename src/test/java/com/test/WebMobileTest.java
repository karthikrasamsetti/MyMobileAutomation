package com.test;

import com.aventstack.extentreports.Status;
import com.base.Base;
import com.page.webdriver.OrangeAdminPage;
import com.page.webdriver.OrangeDashboardPage;
import com.page.webdriver.OrangeLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebMobileTest extends Base {
    private static final Logger logger = LogManager.getLogger(WebMobileTest.class);
    private OrangeLoginPage loginPage;
    private OrangeDashboardPage dashboardPage;
    private OrangeAdminPage adminPage;

    @BeforeTest
    public void beforeEach() {
        loginPage = new OrangeLoginPage(driver);
        dashboardPage = new OrangeDashboardPage(driver);
        adminPage=new OrangeAdminPage(driver);
    }

    @Test(priority = 1)
    public void orangeLoginTest() {
        logger.info("orangeLoginTest has Started");
        try {
            test = extent.createTest("Login", "LogIn Page Test with Valid credentials").assignAuthor("karthik").assignCategory("functional Test Cases").assignDevice("Android");
        //  Assertion 1
//            WebElement title= loginPage.getLogo();
//            Assert.assertTrue(title.isDisplayed());
//            test.log(title.isDisplayed()? Status.PASS: Status.FAIL,title.isDisplayed()? "logo image is displayed" : "logo image is not displayed");
            String userName = jsonUserData.get("userName").getAsString();
            String password = jsonUserData.get("password").getAsString();
            loginPage.orangeLogin(userName,password);
            test.log(Status.PASS, "Entering valid login credentials ");
            test.log(Status.PASS, "Clicking login button");
            // Assertion 2
            test.log(Status.INFO, "Verifying if Dashboard Title is displayed");
            WebElement titleDashboard= dashboardPage.getDashboardTile();
            Assert.assertTrue(titleDashboard.isDisplayed());
            test.log(titleDashboard.isDisplayed()? Status.PASS: Status.FAIL,titleDashboard.isDisplayed()? "logo image is displayed" : "logo image is not displayed");
            logger.info("LogIn Page Test Ended");

        } catch (Exception e) {
            logger.info("orangeLoginTest failed : " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void addEmployeeTest() {
        logger.info("addEmployeeTest has Started");
//        try {
            test = extent.createTest("Add Employee", "Adding new Employee").assignAuthor("karthik").assignCategory("functional Test Cases").assignDevice("Android");
            String userName = jsonUserData.get("userName").getAsString();
            String password = jsonUserData.get("password").getAsString();
            loginPage.orangeLogin(userName,password);
            test.log(Status.PASS, "Entering valid login credentials ");
            test.log(Status.PASS, "Clicking login button");
            // Assertion 2
            test.log(Status.INFO, "Verifying if Dashboard Title is displayed");
            WebElement titleDashboard= dashboardPage.getDashboardTile();
            Assert.assertTrue(titleDashboard.isDisplayed());
            test.log(titleDashboard.isDisplayed()? Status.PASS: Status.FAIL,titleDashboard.isDisplayed()? "logo image is displayed" : "logo image is not displayed");
            dashboardPage.adminOpen();
            String name = jsonUserData.get("name").getAsString();
            String userNameNew = jsonUserData.get("usernameAdd").getAsString();
            String passwordNew=jsonUserData.get("passwordNew").getAsString();
            adminPage.addEmployee(name,userNameNew,passwordNew);
            logger.info("addEmployeeTest Ended");
//        } catch (Exception e) {
//            logger.info("addEmployeeTest failed : " + e.getMessage());
//        }
    }
    @AfterMethod
    public void afterEach() {
        dashboardPage.orangeLogOut();
    }
}
