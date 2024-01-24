package com.page.webdriver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrangeDashboardPage {
    private final By dashboardTitle= By.xpath("//h6[text()=\"Dashboard\"]");
    private final By logOutProfile = By.xpath("//img[@src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]");
    private final By logOutButton = By.xpath("//a[@href=\"/web/index.php/auth/logout\"]");
    private final By dashBoardButton = By.xpath("//i[@class=\"oxd-icon bi-list oxd-topbar-header-hamburger\"]");
    private final By AdminPannel = By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]");
    private final By globalSearch=By.xpath("(//input[@placeholder=\"Search\"])");
    private final AppiumDriver driver;

    public OrangeDashboardPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public WebElement getDashboardTile(){
        return driver.findElement(dashboardTitle);
    }

    public void orangeLogOut(){
        WebElement viewProfileBtn = driver.findElement(logOutProfile);
        viewProfileBtn.click();
        WebElement logOutBtn = driver.findElement(logOutButton);
        logOutBtn.click();
    }
    public void dashboardhamburgerOpen(){
        WebElement menuBarBtn = driver.findElement(dashBoardButton);
        Assert.assertTrue(menuBarBtn.isDisplayed(), "Element is not displayed on the page.");
        menuBarBtn.click();
    }
    public void adminOpen() {
        dashboardhamburgerOpen();
        WebElement adminSelect = driver.findElement(AdminPannel);
        Assert.assertTrue(adminSelect.isDisplayed(), "Element is not displayed on the page.");
        adminSelect.click();
    }
}
