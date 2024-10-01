package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RolePage {
	WebDriver driver;
	WebDriverWait Wait;
	int timeoutSec = 10;
	Action actions;

	
	
	By dashboardRole = By.id("page__title");
	By rolesTab = By.xpath("/html/body/div[1]/div/div[1]/header/div[2]/div/div/div/div[2]/a");
	By createnewroleButton = By.name("btn-create");
	By rolenameInput = By.name("name");
	By moduleSelect = By.xpath("//div[@aria-owns='listbox-module']");
	By descriptionInput = By.name("description");
	By defaultCheck = By.name("isDefault");
	By roleSelect = By.name("btn-dropdown-00");
	By userSelect = By.name("btn-dropdown-01");
	By submitButton = By.name("btn-submit");
	By searchnameInput = By.name("searchName");
	By nameClick = By.name("btn-edit-0");
	By editButton = By.name("btn-edit");
	By settingButton = By.id("headlessui-menu-button-21");
	By deleteButton = By.name("btn-delete-0");
	By confirmDelete = By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div/button[1]");
	By roleslist = By.id("page__title");
	By resultsData = By.id("table-data-not-found");

	
	
	
	
	public RolePage(WebDriver driver) {
        this.driver = driver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        //driver.get("https://accounting-devteam-b.nostratech.com/user-module/dashboard");
        
    }
	
	public boolean dashboardDisplay() {
		return driver.findElement(dashboardRole).isDisplayed();
	}

	
	public void clickRolesMenu() {
		driver.findElement(rolesTab).click();
	}
	
	public void clickCreateNewRoleButton() {
        driver.findElement(createnewroleButton).click();
    }
	
	public void enterRoleName(String roleName) {
        driver.findElement(rolenameInput).sendKeys(roleName);
    }
	
	public void selectModule() {
		
		
		WebElement moduleElement = driver.findElement(moduleSelect);
        moduleElement.click();
        
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Tunggu hingga opsi modul yang diinginkan dapat diklik
        WebElement moduleOption = Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='module-0']/span")));
        moduleOption.click();
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionInput).sendKeys(description);
    }

    public void checkDefault() {
        driver.findElement(defaultCheck).click();
    }
    
    public void selectRole() {
    	WebElement roleElement = driver.findElement(roleSelect);
    	roleElement.click();
    	
    	WebElement roleOption = Wait.until(ExpectedConditions.elementToBeClickable(By.name("u_role_read")));
        roleOption.click();
    	
    	
    }
    
    public void selectUser() {
    	WebElement userElement = driver.findElement(userSelect);
    	userElement.click();
    	
    	WebElement userOption = Wait.until(ExpectedConditions.elementToBeClickable(By.name("u_user_read")));
        userOption.click();
    	
    	
    }
    
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    
    public void clickEditButton() {
    	driver.findElement(editButton).click();
    }
    
    public void searchbyname(String nama) {
        driver.findElement(searchnameInput).sendKeys(nama);
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void clikName() {
        driver.findElement(nameClick).click();
    }
    
   
    
    public void clickCheckBox() {
    	driver.findElement(defaultCheck).click();    
    	}
    
    public void clickSettingButton() {
        driver.findElement(settingButton).click();
    }
    
    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
	}
    
    public void clickConfirmDelete() {
        driver.findElement(confirmDelete).click();
	}
    
    public void roleslist() {
    	driver.findElement(roleslist).isDisplayed();
    }
    
    public void updatedescription(String description) {
    	WebElement descriptionField = Wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionInput));
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }
    
    public String resultRole() {
    	return driver.findElement(resultsData).getText();
    }
    

    
    
    
    
    
    
    
    
    
    
    
}
