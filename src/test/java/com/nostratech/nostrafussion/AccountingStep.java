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

public class AccountingStep {
	WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;
    AccountingPage accountingPage;
    UserPage userPage;
    

    @Given("I already in signin page")
    public void i_already_in_signin_page() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        signinPage = new SigninPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @When("I signin admin with email {string} and password {string}")
    public void i_signin_admin_with_email(String email, String password) {
    	signinPage.input(email, password);
    	signinPage.clicksigninButton();
    }


    @And("I click menu user management")
    public void i_click_menu_user_management() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuUserManagement();
    }

    @When("I click user tab")
    public void i_click_user_tab() {
    	userPage = new UserPage(driver);
    	userPage.clickUserTab();
    }

    @And("^I input search by firstname (.*) and lastname (.*)")
    public void iInputSearchByFirstname(String firstname, String lastname) {
    	userPage.inputfirstname(firstname);
    	userPage.inpulastname(lastname);
    }


    @And("I click first row user")
    public void i_click_first_row_user() {
    	try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	userPage.clickfirstrowuser();
    }

    @And("I click add new module and role button")
    public void i_click_add_new_module_and_role() {
    	userPage.clickaddnewmodulesButton();
    }
    
    @And("^I select module (.*) and select role (.*)")
    public void iSelectModule(String module, String role) {
    	userPage.selectModuleAndRole(module, role);
    }
 
    
    @And("I click add save module and role")
    public void i_click_add_save_module_and_role() {
    	userPage.clickAddRoleButton();
    }
    
   
    @And("I click add new company button")
    public void i_click_add_new_company_button() {
    	userPage.clickaddnewcompanyButton();
    }
    
    @And("I select company")
    public void i_select_company() {
    	userPage.selectCompany();
    }

    @And("I click add save company")
    public void i_click_add_save_company() {
    	userPage.clickAddCompanyButton();
    }

    @And("I click submit user")
    public void iClickSubmitUser() {
    	userPage.clickSubmitButton();
    }

    @And("I signout from admin account")
    public void i_signout_from_admin_account() {
    	userPage.clickprofileButton();
    	userPage.clickSignOutButton();
    	signinPage = new SigninPage(driver);
    }

    @And("^I signin user with email (.*) and password (.*)")
    public void iSigninUserWithUserEmail(String email, String password) {
    	signinPage.input(email, password);
    	signinPage.clicksigninButton();
    	}

    @And("I click menu accounting")
    public void iClickTheAccountingMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuAccounting();
    	
    }    

    @And("I select master tab")
    public void iSelectMasterTab() {
    	accountingPage = new AccountingPage(driver);
    	accountingPage.selectMaster();
    }
    
    @And("I click bank menu")
    public void iClickBankMenu() {
    	accountingPage.clickBank();
    }
    
    @And("I click button create new bank")
    public void iClickButtonCreate() {
    	accountingPage.clickCreateNewBankButton();
    }
    
    @And("I select bank")
    public void iSelectBank() {
    	accountingPage.selectBank();
    }
    
    @And("^I input bank acc number(.*)")
    public void iInputBankAccNumber(String bankaccnum) {
    	accountingPage.inputBankAccNum(bankaccnum);
    }
    
    @And("I select bank acc control")
    public void iSelectBankAccControl() {
    	accountingPage.selectBankAcc_Control();
    }
    
    @And("^I input bank code (.*)")
    public void iInputBankCode(String code) {
    	accountingPage.inputBankCode(code);
    }
    
    @And("^I input bank acc name (.*)")
    public void iInputBankAccName(String name) {
    	accountingPage.inputBankAccName(name);
    }
    
    @And("I click checkbox enable bills")
    public void iClickCheckboxEnableBills() {
    	accountingPage.clickEnableBilssCheckbox();
    }
    
    @And("I click submit button")
    public void iClickSubmitButton() {
    	accountingPage.clickSubmitButton();
    }
    
    @Then("I should see success toast")
    public void iShouldSeeSuccessToast() {
    	try {
    	accountingPage.successToast();	
    	} finally {
    		driver.quit();
    	}
    }
    
    @Then("I only see the bank list")
    public void iOnlySeeTheBankList() {
    	try {
    	accountingPage.banklist();	
    	} finally {
    		driver.quit();
    	}
    }
    
    @Then("Show the create new bank button")
    public void showCreateNewBankButton() {
    	
    	try {
    		accountingPage.DisplayCreateNewBankButton();
    		boolean button = accountingPage.DisplayCreateNewBankButton();
        	Assert.assertEquals(button, true);
    		
    		}
        	finally {
        		driver.quit();
        	}
    	
    }
}
