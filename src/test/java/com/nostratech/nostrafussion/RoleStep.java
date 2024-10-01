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

public class RoleStep {
	WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;
    RolePage rolePage;
    
    @Given("I already on user management page")
    public void iAlreadyOnUserManagementPage() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        rolePage = new RolePage(driver);
        homePage = new HomePage(driver);
        signinPage = new SigninPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        signinPage.input("cold15@warunkpedia.com", "Admin19951996!");
        signinPage.clicksigninButton();
        homePage.clickMenuUserManagement();
    }
    
    @When("I click roles tab")
    public void iClickRoleTab() {
    	rolePage.clickRolesMenu();
    }
    
    @And("I click button create new role")
    public void iClickButtonCreateNewRole() {
    	rolePage.clickCreateNewRoleButton();
    }
    
    @And("^I input role name (.*)")
    public void i_input_name_role_names(String name) {
    	rolePage.enterRoleName(name);
    }
    
    @And("I select module")
    public void iSelectModule() {
    	rolePage.selectModule();
    }
    
    @And("^I input description (.*)")
    public void iInputDescription(String description) {
    	rolePage.enterDescription(description);
    }
    
    @And("I click checkbox")
    public void iClickCheckBox() {
    	rolePage.clickCheckBox();
    }
    
    @And("I select role")
    public void iSelectRole() {
    	rolePage.selectRole();
    }
    
    @And("I select user")
    public void iSelectUser() {
    	rolePage.selectUser();
    }
    
    @And("I click submit")
    public void iClickSubmit() {
    	rolePage.clickSubmitButton();
    }
    
    @Then("I should see roles list")
    public void iShouldSeeRolesList() {
    	try {
    	rolePage.roleslist();
    	} finally {
    		driver.quit();
    	}
    	
    }
    
    @And("^I input name role (.*)")
    public void i_input_name_role_namas(String nama) {
    	rolePage.searchbyname(nama);
    }
    
    
    @And("I click name")
    public void iClickName() {
    	rolePage.clikName();
    }
    
    @And("I click edit")
    public void iClickEdit() {
    	rolePage.clickEditButton();
    }
    
    @And("^I update description (.*)")
    public void iUpdate(String description) {
    	rolePage.updatedescription(description);
    }
   
    @And("I click setting")
    public void iClickSetting() {
    	rolePage.clickSettingButton();
    }
    
    @And("I click delete button")
    public void iClickDeleteButton() {
    	rolePage.clickDeleteButton();
    }
    
    @And("I click confirm delete")
    public void iClickDelete() {
    	rolePage.clickConfirmDelete();
    }
    
    @Then("Show zero result")
    public void showZeroResult() {
    	try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	try {
    		rolePage.resultRole();
    		String resultRoleText = rolePage.resultRole();
            Assert.assertEquals("Data not found", resultRoleText);
        	}
        	finally {
        		driver.quit();
        	}
    }
    
    
     
}


