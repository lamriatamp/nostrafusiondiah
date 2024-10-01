package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec = 10;
	
	By home = By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div/div[1]");
	By usermanagementMenu = By.className("USER_MANAGEMENT");
	By accountingMenu = By.className("FINANCE_ACCOUNTING");
	By configurationMenu = By.className("CONFIGURATION");
	By successNotif = By.xpath("//li[contains(@data-type, 'success')]");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        //driver.get("https://accounting-devteam-b.nostratech.com/apps");
    }
	
	public void home() {
		driver.findElement(home).isDisplayed();
	}
	
	public void clickMenuUserManagement() {
		driver.findElement(usermanagementMenu).click();
		
	}
	
	public void clickMenuAccounting() {

		driver.findElement(accountingMenu).click();
	}
	
	public void clickMenuConfiguration() {

		driver.findElement(configurationMenu).click();
	}
	
	public boolean notif() {
		return driver.findElement(successNotif).isDisplayed();
		
	}
}
