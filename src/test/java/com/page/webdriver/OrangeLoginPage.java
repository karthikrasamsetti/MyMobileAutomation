package com.page.webdriver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrangeLoginPage {
    private final By logoImageTop = By.xpath("//img[@alt=\"company-branding\"]");
    private final By usernameField = By.xpath("//input[@name=\"username\"]");
    private final By passwordField = By.xpath("//input[@name=\"password\"]");
    private final By loginButton = By.xpath("//div[@class=\"oxd-form-actions orangehrm-login-action\"]");

    private final AppiumDriver driver;

    public OrangeLoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void orangeLogin(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameField);
        Assert.assertTrue(usernameInput.isDisplayed(), "Element is not displayed on the page.");
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordField);
        Assert.assertTrue(passwordInput.isDisplayed(), "Element is not displayed on the page.");
        passwordInput.sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        loginBtn.click();
    }

    public WebElement getLogo() {
        return driver.findElement(logoImageTop);
    }
}
