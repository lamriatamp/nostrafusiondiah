package com.nostratech.nostrafussion;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountingPage {
	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec = 10;
	
	By masterSelect = By.id("headlessui-menu-button-7");
	By createnewbankButton = By.name("btn-create");
	By bankSelect = By.xpath("//*[@id=\"headlessui-dialog-panel-30\"]/div[2]/form/div[1]/div[1]/div[2]/div/div[2]/div/div[1]");
	By bankaccnumInput = By.name("account_number");
	By bankacc_controlSelect = By.xpath("//*[@id=\"headlessui-dialog-panel-30\"]/div[2]/form/div[1]/div[1]/div[4]/div/div[2]/div/div[1]");
	By bankcodeInput = By.name("branch");
	By bankaccnameInput = By.name("account_name");
	By EnableBillsCheck = By.id("headlessui-switch-36");
	By submitButton = By.name("btn-submit");
	By bankList = By.id("page__title");
	By dashboardAccounting = By.id("page__title");
	By successNotif = By.xpath("//li[contains(@data-type, 'success')]");
	
	

	public AccountingPage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
                
    }
	
	public boolean dashboardDisplay() {
		return driver.findElement(dashboardAccounting).isDisplayed();
	}
	
	public void clickCreateNewBankButton() {
        driver.findElement(createnewbankButton).click();
    }
	
	public boolean DisplayCreateNewBankButton() {
        return driver.findElement(createnewbankButton).isDisplayed();
    }

	public void selectMaster() {
		WebElement masterElement = driver.findElement(masterSelect);
	    masterElement.click();
	}
	    
	public void clickBank() {
		WebElement masterOption = Wait.until(ExpectedConditions.elementToBeClickable(By.id("headlessui-menu-item-20")));
	    masterOption.click();
		
	}
	
	public void selectBank() {
		WebElement bankElement = driver.findElement(bankSelect);
	    bankElement.click();
	    
	    try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }

	    // Tunggu hingga opsi modul yang diinginkan dapat diklik
	    WebElement bankOption = Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bank_name-1\"]")));
	    bankOption.click();
	    }
	
	public void inputBankAccNum(String bankaccnum) {
	    // Membuat instance Random
	    Random random = new Random();
	    
	    // Menghasilkan nomor acak dengan panjang 10 digit
	    long randomBankAccNum = 1000000000L + random.nextLong(9000000000L); // Rentang 10 digit
	    
	    // Mengisi nomor rekening acak ke elemen input
	    driver.findElement(bankaccnumInput).sendKeys(String.valueOf(randomBankAccNum));
	}
	
	
	public void selectBankAcc_Control() {
		WebElement controlElement = driver.findElement(bankacc_controlSelect);
	    controlElement.click();
	    
	    try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }

	    // Tunggu hingga opsi modul yang diinginkan dapat diklik
	    WebElement controlOption = Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account_control-6\"]")));
	    controlOption.click();
	  
	    }
	
	public void inputBankCode(String code) {
		driver.findElement(bankcodeInput).sendKeys(code);
	}
	
	public void inputBankAccName(String name) {
		driver.findElement(bankaccnameInput).sendKeys(name);
	}
	
	public void clickEnableBilssCheckbox() {
		driver.findElement(EnableBillsCheck).click();
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public boolean banklist() {
		return driver.findElement(bankList).isDisplayed();
	}
	
	public boolean successToast() {
		return driver.findElement(successNotif).isDisplayed();
	}
	
}


