package com.nostratech.nostrafussion;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigurationPage {
	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec = 10;
	Action actions;
	
	By companyTab = By.xpath("//a[@href='/configuration-module/company']");
	By createnewcompanyButton = By.name("btn-create");
	By companynameInput = By.name("name");
	By typeSelect = By.xpath("//div[@aria-owns='listbox-type']");
	By businesslineSelect = By.xpath("//div[@aria-owns='listbox-businessLine']");
	By businesslineField = By.name("businessLine");
	By regionSelect = By.xpath("//div[@aria-owns='listbox-region']");
	By regionField = By.name("region");
	By timezoneSelect = By.xpath("//div[@aria-owns='listbox-timezone']");
	By timezoneField = By.name("timezone");
	By businessnumberInput = By.name("businessNumber");
	By companynumberInput = By.name("companyNumber");
	By emailInput = By.name("email");
	By phoneInput = By.name("phone");
	By faxInput = By.name("fax");
	By websiteInput = By.name("website");
	By addressInput = By.name("address");
	By checkModule = By.xpath("/html/body/div[1]/div/div[1]/main/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/form/div/div[6]/div[2]/div/div[1]");
	By submitButton = By.xpath("/html/body/div[1]/div/div[1]/main/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/form/div/div[7]/button[1]");
	By listcompany = By.id("page__title");
	By dashboardConfiguration = By.id("page__title");
	By successNotif = By.xpath("//li[contains(@data-type, 'success')]");

			
	
	public ConfigurationPage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }
	
	public boolean dashboardDisplay() {
		return driver.findElement(dashboardConfiguration).isDisplayed();
	}
	
	public void clickCompanyTab() {
		driver.findElement(companyTab).click();
	}
	
	public void clickCreateNewCompanyButton() {
        driver.findElement(createnewcompanyButton).click();
    }
	
	public void inputCompanyName(String companyname) {
	    // Membuat instance Random
	    Random random = new Random();
	    
	    // Menghasilkan angka acak
	    int randomNumber = random.nextInt(10000); // Ubah rentang angka sesuai kebutuhan
	    
	    // Menyusun nama perusahaan dengan format yang diinginkan
	    String companyNameWithRandom = randomNumber + " Automation Company in Indonesia";
	    
	    // Mengisi nama perusahaan ke elemen input
	    driver.findElement(companynameInput).sendKeys(companyNameWithRandom);
	}
	
	public void selectType() {
		driver.findElement(typeSelect).click();
		WebElement typeOption = Wait.until(ExpectedConditions.elementToBeClickable(By.id("type-1")));
		typeOption.click();
	}
	
	public void selectBusinessLine(String line) {
		driver.findElement(businesslineSelect).click();
		driver.findElement(businesslineField).sendKeys(line);
		try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		driver.findElement(businesslineField).sendKeys(Keys.ENTER);
	}
	
	public void selectRegion(String region) {
		driver.findElement(regionSelect).click();
		driver.findElement(regionField).sendKeys(region);
		try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		driver.findElement(regionField).sendKeys(Keys.ENTER);
	}
	
	public void selectTimezone(String timezone) {
		driver.findElement(timezoneSelect).click();
		driver.findElement(timezoneField).sendKeys(timezone);
		try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		driver.findElement(timezoneField).sendKeys(Keys.ENTER);
	}
	
	public void inputBusinessNumber(String numberbusiness) {
		driver.findElement(businessnumberInput).sendKeys(numberbusiness);
	}
	
	public void inputCompanyNumber(String numbercompany) {
		driver.findElement(businessnumberInput).sendKeys(numbercompany);
	}
	
	
	public void inputContactInformation(String email, String phone, String fax, String website, String address) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(phoneInput).sendKeys(phone);
		driver.findElement(faxInput).sendKeys(fax);
		driver.findElement(websiteInput).sendKeys(website);
		driver.findElement(addressInput).sendKeys(address);
	}
	
	public void clickCheckModule() {
		driver.findElement(checkModule).click();
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public boolean companyList() {
		return driver.findElement(listcompany).isDisplayed();
	}
	
	public boolean successToast() {
		return driver.findElement(successNotif).isDisplayed();
	}
	
	
	
}
