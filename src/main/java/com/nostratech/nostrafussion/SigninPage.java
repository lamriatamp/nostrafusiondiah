package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPage {

	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec =10;
	
	By emailInput = By.name("email");
    By passwordInput = By.name("password");
    By signinButton = By.name("btn-login");
    By invalidNotif = By.xpath("//li[contains(@data-type, 'error')]");
    
    
    public SigninPage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        driver.get("https://accounting-devteam-b.nostratech.com/auth/login");
    }
    
    public void input(String email, String password) {
    	try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    	
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		
    }
    
    public void clicksigninButton() {
		driver.findElement(signinButton).click();
		
		try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public boolean invalidNotif() {
    	return driver.findElement(invalidNotif).isDisplayed();
    }
    
}
