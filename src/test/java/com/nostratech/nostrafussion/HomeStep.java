package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeStep {
	WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;
    UserPage userPage;
    RolePage rolePage;
    AccountingPage accountingPage;
    ConfigurationPage configurationPage;
    
    
    @Given("I already signin")
    public void iAlreadySignin() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        signinPage = new SigninPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        signinPage.input("cold15@warunkpedia.com", "Admin19951996!");
        signinPage.clicksigninButton();
        homePage = new HomePage(driver);

    }
    
    @When("I am on the home page")
    public void iAmOnTheHomePage() {
    	homePage = new HomePage(driver);
    }
    
    @And("I click user management menu")
    public void iClickUserManagementMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuUserManagement();
    	userPage = new UserPage(driver);
    }
    
    @And("I navigate to page user management")
    public void iNavigateToPageUserManagement() {
    	rolePage = new RolePage(driver);
    }
    
    @Then("I should see the user management dashboard")
    public void iShouldSeeTheUserManagementDashboard() {
    	try {
    		rolePage.dashboardDisplay();
        	boolean dashboard = rolePage.dashboardDisplay();
        	Assert.assertEquals(dashboard, true);}
        	finally {
        		driver.quit();
        	}
    }
    
    @And("I click accounting menu")
    public void iClickAccountingMenu() {
    	homePage.clickMenuAccounting();
    }
    
    @And("I navigate to page accounting")
    public void iNavigateToPageAccounting() {
    	accountingPage = new AccountingPage(driver);
    }
    
    @Then("I should see the accounting dashboard")
    public void iShouldSeeTheAccountingDashboard() {
    	try {
    		accountingPage.dashboardDisplay();
        	boolean dashboard = accountingPage.dashboardDisplay();
        	Assert.assertEquals(dashboard, true);
        	}
        	finally {
        		driver.quit();
        	}
    	
    }
    
    @And("I click configuration menu")
    public void iClickConfigurationMenu() {
    	homePage.clickMenuConfiguration();
    }
    
    @And("I navigate to page configuration")
    public void iNavigateToPageConfiguration() {
    	configurationPage = new ConfigurationPage(driver);
    }
    
    @Then("I should see the configuration dashboard")
    public void iShouldSeeTheConfigurationDashboard() {
    	try {
    		configurationPage.dashboardDisplay();
        	boolean dashboard = configurationPage.dashboardDisplay();
        	Assert.assertEquals(dashboard, true);
        	}
        	finally {
        		driver.quit();
        	}
    
    
    }
}
