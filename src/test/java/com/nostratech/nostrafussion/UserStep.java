package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserStep {
	WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;
    RolePage rolePage;
    UserPage userPage;
    
    @Given("I already on signin page")
    public void iAlreadyOnSigninPage() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        signinPage = new SigninPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    
    @When("I signin the admin with email {string} and password {string}")
    public void iSigninTheAdminWithEmail(String email, String password) {
    	signinPage.input(email, password);
    	signinPage.clicksigninButton();
    	}
    
    @And("I click the menu user management")
    public void iClickTheMenuUserManagement() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuUserManagement();

    }
    
    @And("I click the user tab")
    public void iClickTheUserTab() {
    	userPage = new UserPage(driver);
    	userPage.clickUserTab();
    }
    
    
    @And("I click button create new user")
    public void iClickButtonCreateNewUser() {
    	userPage.clickCreateNewUserButton();
    }
    
    @And("^I input firstname (.*) and lastname (.*)")
    public void iInputFirstname(String firstname, String lastname) {
    	userPage.inputfullname(firstname, lastname);
    }
    
    @And("^I input email(.*)")
    public void iInputEmail(String email) {
    	userPage.inputemail(email);
    }
    
    
    @And("I click the add new module and role button")
    public void i_click_the_add_new_module_and_role() {
    	userPage.clickaddnewmodulesButton();
    }
    
    @And("^I select the module (.*) and select the role (.*)")
    public void iSelectTheModule(String module, String role) {
    	userPage.selectModuleAndRole(module, role);
    }
 
    
    @And("I click the add save module and role")
    public void i_click_the_add_save_module_and_role() {
    	userPage.clickAddRoleButton();
    }
    
    @And("^I select another module (.*) and another role (.*)")
    public void iSelectAnotherModule(String module, String role) {
    	userPage.selectModuleAndRole(module, role);
    }

    
    @And("I click the add new company button")
    public void i_click_the_add_new_company_button() {
    	userPage.clickaddnewcompanyButton();
    }
    
    @And("I select the company")
    public void i_select_the_company() {
    	userPage.selectCompany();
    }
    
    @And("I click the add save company")
    public void i_click_the_add_save_company() {
    	userPage.clickAddCompanyButton();
    }
    
    @And("I click the submit user")
    public void iClickTheSubmitUser() {
    	userPage.clickSubmitButton();
    }
    
    @Then("Shows user list")
    public void showsUserList() {
    	try {
    	userPage.userList();}
    	finally {
    		driver.quit();
    	}
    }
    
    @And("^I input search by the firstname (.*) and the lastname (.*)")
    public void iInputSearchByTheFirstname(String firstname, String lastname) {
    	userPage.inputfirstname(firstname);
    	userPage.inpulastname(lastname);
    	
    }
        
    

    @And("I click the first row user")
    public void i_click_the_first_row_user() {
    	try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	userPage.clickfirstrowuser();
    }
    
    
    
    @And("Shows the success toast")
    public void showTheSuccessToast() {
    	userPage.successToast();
    	boolean success = userPage.successToast();
    	Assert.assertEquals(success, true);
    }
    
    @And("I signout from the admin account")
    public void iSignoutFromTheAdminAccount() {
    	userPage.clickprofileButton();
    	userPage.clickSignOutButton();
    	signinPage = new SigninPage(driver);
    	
    }
    
//    @And("I click profile")
//    public void i_click_profile() {
//    	userPage.clickprofileButton();
//    }
//    
//    @And("I click sign out button")
//    public void iClickSignOutButton() {
//    	userPage.clickSignOutButton();
//    }
//    
//    @Then("I navigate to singin page")
//    public void iNavigateToSigninPage() {
//    	signinPage = new SigninPage(driver);
//    }
    
    @Then("Show the result")
    public void showTheResult() {
    	try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	
    	try {
    		userPage.resultElement();
    		String resultsText = userPage.resultElement();
            Assert.assertEquals("0 results", resultsText);
        	}
        	finally {
        		driver.quit();
        	}
    	
    }
    
    @Then("Show error email already registered")
    public void showErrorNotif() {
    	
    	try {
    		userPage.invalidNotif();
    		String errorEmail = driver.findElement(By.xpath("//li[contains(@data-type, 'error')]")).getText();
    		Assert.assertEquals(errorEmail, "Email already registered.");
    		
    		}
        	finally {
        		driver.quit();
        		
        	}
    	
    }
    
    
    @Then("Show the create new user button")
    public void showCreateNewUserButton() {
    	
    	try {
    		userPage.DisplayCreateNewUserButton();
    		boolean button = userPage.DisplayCreateNewUserButton();
        	Assert.assertEquals(button, true);
    		
    		}
        	finally {
        		driver.quit();
        	}
    	
    }
    
    @And("^I signin user with the user email (.*) and password (.*)")
    public void iSigninUserWithTheUserEmail(String email, String password) {
    	signinPage.input(email, password);
    	signinPage.clicksigninButton();
    	}
    
    @Then("Only can see the user list")
    public void onlyCanSeeTheUserList() {
    	try {
    	userPage.userList();
    	}
    	finally {
    		driver.quit();
    	}
    }
    
    
    
    @Then("Show error notif role exist")
    public void showErrorNotifRoleExist() {
    	
    	try {
    		userPage.invalidNotif();
    		String errorText = driver.findElement(By.xpath("//li[contains(@data-type, 'error')]")).getText();
    		Assert.assertEquals(errorText, "Role exist\n"
    				+ "Role already exist or has been previously used.");
    	}
        	finally {
        		driver.quit();
        	}
    	
    }
        
}
    
    

