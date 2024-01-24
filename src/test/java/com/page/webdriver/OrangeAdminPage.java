package com.page.webdriver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrangeAdminPage {
    private final AppiumDriver driver;

    public OrangeAdminPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private final By addbtn=By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]");
    private final By roleDropDown=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");
    private final By adminRole=By.xpath("(//div[@role=\"option\"])[2]");
    private final By eSSRole=By.xpath("(//div[@role=\"option\"])[3]");
    private final By addEmployeeField =By.xpath("//input[@placeholder=\"Type for hints...\"]");
    private final By firstEmpSelect=By.xpath("(//div[@role=\"option\"])");
    private final By statusDropDown=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");
    private final By enableStatus=By.xpath("(//div[@role=\"option\"])[2]");
    private final By disableStatus=By.xpath("(//div[@role=\"option\"])[3]");
    private final By usernameField=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By passwordField=By.xpath("(//input[@type=\"password\"])[1]");
    private final By confirmPasswordField=By.xpath("(//input[@type=\"password\"])[2]");
    private final By saveEmpDetails=By.xpath("(//button[@type=\"submit\"])");
    String store;
    public void addEmployee(String name,String username,String password){
        WebElement addButton=driver.findElement(addbtn);
        addButton.click();
        WebElement roleDropDownBtn=driver.findElement(roleDropDown);
        roleDropDownBtn.click();
        WebElement adminRoleSelect=driver.findElement(adminRole);
        adminRoleSelect.click();
        WebElement addEmpInput=driver.findElement(addEmployeeField);
        addEmpInput.sendKeys("a");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement selectFirstDropDown=driver.findElement(firstEmpSelect);
        selectFirstDropDown.click();
        WebElement statusDropDownBtn=driver.findElement(statusDropDown);
        statusDropDownBtn.click();
        WebElement enableStatusSelect=driver.findElement(enableStatus);
        enableStatusSelect.click();
        WebElement usernameInput=driver.findElement(usernameField);
        usernameInput.sendKeys(username);
        WebElement passwordInput= driver.findElement(passwordField);
        passwordInput.sendKeys(password);
        WebElement confirmPasswordInput= driver.findElement(confirmPasswordField);
        confirmPasswordInput.sendKeys(password);
        WebElement saveEmpDetailsBtn=driver.findElement(saveEmpDetails);
        saveEmpDetailsBtn.click();
    }
}
