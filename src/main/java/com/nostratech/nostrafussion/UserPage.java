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

public class UserPage {

	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec = 10;
	Action actions;
	
	By dashboardUser = By.id("page__title");
	By userTab = By.xpath("//a[@href='/user-module/user']");
	By createnewuserButton = By.name("btn-create");
	By firstnameinput = By.name("first_name");
	By lastnameinput = By.name("last_name");
	By emailinput = By.name("email");
	By submitButton = By.name("btn-submit");
	By addnewmodulesButton = By.name("btn-add-primary-module");
	By addnewcompanyButton = By.name("btn-add-company");
	By moduleSelect = By.xpath("//div[@aria-owns='listbox-new_module']");
	By roleSelect = By.xpath("//div[@aria-owns='listbox-new_role']");
	By moduleTextField = By.name("new_module");
	By roleTextField = By.name("new_role");
	By companySelect = By.xpath("//div[@aria-owns='listbox-new_company']");
	By companyTextField = By.name("new_company");
	By listuser = By.id("page__title");
	By addroleButton = By.name("btn-save-primary-module");
	By addcompanyButton = By.name("btn-save-company");
	By searchbyfirstnameInput = By.xpath("//input[@placeholder='Search by first name']");
	By searchbylastnameInput = By.xpath("//input[@placeholder='Search by last name']");
	By firstrowuser = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/a");
	By successNotif = By.xpath("//li[contains(@data-type, 'success')]");
	By profileButton = By.id("headlessui-menu-button-16");
	By signoutButton = By.id("headlessui-menu-item-23");
	By invalidNotif = By.xpath("//li[contains(@data-type, 'error')]");
	By resultsElement = By.cssSelector(".table__count span");
	
	By accountingMenu = By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div[2]/a");
	
	public UserPage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }
	
	public boolean dashboardDisplay() {
		return driver.findElement(dashboardUser).isDisplayed();
	}
	
	public void clickUserTab() {
		driver.findElement(userTab).click();
	}
	
	public void clickCreateNewUserButton() {
        driver.findElement(createnewuserButton).click();
    }
	
	public boolean DisplayCreateNewUserButton() {
        return driver.findElement(createnewuserButton).isDisplayed();
    }
	
    public void inputfullname(String first, String last) {
		driver.findElement(firstnameinput).sendKeys(first);
		driver.findElement(lastnameinput).sendKeys(last);
    }
    
    public void inputemail(String email) {

    	
    	if (email.trim().isEmpty()) {
            // Membuat instance Random
            Random random = new Random();

            // Menghasilkan angka acak
            int randomNumber = random.nextInt(1000); // Ubah rentang angka sesuai kebutuhan

            // Menyusun alamat email dengan format yang diinginkan
            String emailWithRandom = randomNumber + "Automation@gmail.com";

            // Mengisi alamat email ke elemen input
            driver.findElement(emailinput).sendKeys(emailWithRandom);
        } else {
            driver.findElement(emailinput).sendKeys(email);
        }
    } 
    
    public void clickaddnewmodulesButton() {
    	driver.findElement(addnewmodulesButton).click();
    }
    
    public void clickaddnewcompanyButton() {
    	driver.findElement(addnewcompanyButton).click();
    }
    
    public void selectModuleAndRole(String module, String role) {
    	//Select Module
    	driver.findElement(moduleSelect).click();
    	driver.findElement(moduleTextField).sendKeys(module);
    	
    	try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	driver.findElement(moduleTextField).sendKeys(Keys.ENTER);
    	//Select Role
    	try {
	        Thread.sleep(2000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	driver.findElement(roleSelect).click();
    	driver.findElement(roleTextField).sendKeys(role);
    	try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	driver.findElement(roleTextField).sendKeys(Keys.ENTER);
    }
    
    public void selectCompany() {
    	WebElement companyElement = driver.findElement(companySelect);
    	companyElement.click();
    	
    	WebElement companyOption = Wait.until(ExpectedConditions.elementToBeClickable(By.id("new_company-4")));
        companyOption.click();
    }
    
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    
    public boolean userList() {
		return driver.findElement(listuser).isDisplayed();
	}
    
    public void clickAddRoleButton() {
        driver.findElement(addroleButton).click();
    }
    
    public void clickAddCompanyButton() {
        driver.findElement(addcompanyButton).click();
    }
    
    public void inputfirstname(String firstname) {
    	driver.findElement(searchbyfirstnameInput).sendKeys(firstname);
    }
    
    public void inpulastname(String lastname) {
    	driver.findElement(searchbylastnameInput).sendKeys(lastname);
    }
    
    public void clickfirstrowuser() {
    	driver.findElement(firstrowuser).click();
    }
    
    public void updatefirstname(String firstname) {
    	WebElement firstnameField = Wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameinput));
        firstnameField.click();
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
    }
    
    public boolean successToast() {
		return driver.findElement(successNotif).isDisplayed();
	}
    
    public void clickprofileButton() {
    	driver.findElement(profileButton).click();
    }
    
    public void clickSignOutButton() {
    	driver.findElement(signoutButton).click();
    }
    
    public boolean invalidNotif() {
    	return driver.findElement(invalidNotif).isDisplayed();
    }
    
    public String resultElement() {
    	return driver.findElement(resultsElement).getText();
    }
    
 
    
	
    
   
     
}
