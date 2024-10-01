package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.And;

public class ConfigurationStep {
	WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;
    UserPage userPage;
    ConfigurationPage configurationPage;
    
    @Given("I want to sign in with admin email {string} and password {string}")
    public void i_want_to_sign_in_with_admin_email_and_password(String email, String password) {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        signinPage = new SigninPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        signinPage.input(email, password);
    	signinPage.clicksigninButton();
    }

    @When("I click menu configuration")
    public void i_click_menu_configuration() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuConfiguration();
    }

    @And("I click company tab")
    public void i_click_company_tab() {
    	configurationPage = new ConfigurationPage(driver);
    	configurationPage.clickCompanyTab();
    }

    @And("I click create new company button")
    public void i_click_create_new_company() {
    	configurationPage.clickCreateNewCompanyButton();
    }

    @And("^I input the name of company (.*)")
    public void i_input_the_name_of_company(String companyname) {
        configurationPage.inputCompanyName(companyname);
    }

    @And("I select the type")
    public void i_select_the_type() {
        configurationPage.selectType();
    }

    @And("^I select bussiness line (.*)")
    public void i_select_bussiness_line(String line) {
        configurationPage.selectBusinessLine(line);
    }

    @And("^I select region (.*)")
    public void i_select_region(String region) {
        configurationPage.selectRegion(region);
    }

    @And("^I select timezone (.*)")
    public void i_select_timezone(String timezone) {
    	configurationPage.selectTimezone(timezone);
    }

    @And("^I input business number (.*)")
    public void i_input_business_number(String numberbusiness) {
    	configurationPage.inputBusinessNumber(numberbusiness);
    }

    @And("^I input company number(.*)")
    public void i_input_company_number(String numbercompany) {
        configurationPage.inputCompanyNumber(numbercompany);
    }

    @And("^I input contact information with email (.*), phone (.*), fax (.*), website (.*), and address (.*)")
    public void i_input_contact_information(String email, String phone, String fax, String website, String address) {
        configurationPage.inputContactInformation(email, phone, fax, website, address);
    }

    @And("I check the module")
    public void i_check_the_module() {
        configurationPage.clickCheckModule();
    }
    
    @Then("I click submit company")
    public void iClickSubmitCompany() {
        configurationPage.clickSubmitButton();
    }
    
    @When("I click the user management menu")
    public void i_click_the_user_management_menu() {
    	homePage = new HomePage(driver);
    	homePage.clickMenuUserManagement();

    }

    @And("I click tab user")
    public void i_click_tab_user() {
    	userPage = new UserPage(driver);
    	userPage.clickUserTab();
    }

    @And("^I search by input the firstname (.*) and the lastname (.*)")
    public void iSearchByInputTheFirstname(String firstname, String lastname) {
    	userPage.inputfirstname(firstname);
    	userPage.inpulastname(lastname);
    }

    @And("I click first user")
    public void i_click_first_user() {
    	try {
	        Thread.sleep(5000);
	    }
	    catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
    	userPage.clickfirstrowuser();
    }

    @And("I click button add new module and role")
    public void i_click_button_add_new_module_and_role() {
    	userPage.clickaddnewmodulesButton();
    }

    @And("^I select module (.*) and role (.*)")
    public void iSelectModule(String module, String role) {
    	userPage.selectModuleAndRole(module, role);
    }

    @And("I click button add save module and role")
    public void i_click_button_add_save_module_and_role() {
    	userPage.clickAddRoleButton();
    }

    @And("I click button add new company")
    public void i_click_button_add_new_company() {
    	userPage.clickaddnewcompanyButton();
    }

    @When("I choose company")
    public void i_choose_company() {
    	userPage.selectCompany();
    }

    @And("I click button add save company")
    public void i_click_button_add_save_company() {
    	userPage.clickAddCompanyButton();
    }

    @And("I click button submit user")
    public void i_click_button_submit_user() {
    	userPage.clickSubmitButton();
    }

    @And("I signout the admin account")
    public void i_signout_the_admin_account() {
    	userPage.clickprofileButton();
    	userPage.clickSignOutButton();
    	signinPage = new SigninPage(driver);
    }
    
    @And("^I signin with user email (.*) and user password (.*)")
    public void i_signin_with_user_email(String email, String password) {
    	signinPage.input(email, password);
    	signinPage.clicksigninButton();
    }

    @Then("Only show company list")
    public void only_show_company_list() {
    	try {
        configurationPage.companyList();
    	} finally {
    		driver.quit();
    	}
    }
    
    @Then("Show create success")
    public void showCreateSuccess() {
    	try {
        configurationPage.successToast();
    	} finally {
    		driver.quit();
    	}
    }
    
}
