package com.nostratech.nostrafussion;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninStep {

	
    WebDriver driver;
    SigninPage signinPage;
    HomePage homePage;

    @Given("I use {string}")
    public void iuse(String browser) {
    	driver = WebDriverManager.getInstance(browser).create();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    
    }

    @When("I navigate to signin page")
    public void iNavigateTo() {
    	signinPage = new SigninPage(driver);
    }

    @And("^I signin with the email (.*) and password (.*)")
    public void iSignin(String email, String password) {
    	signinPage.input(email, password);

    }

    @And("I click signin button")
    public void iClickSigninButton() {
    	signinPage.clicksigninButton();
    }
    
   
    @Then("I navigate to home page")	
    public void iNavigateToHomePage() {
    	try {
        	homePage = new HomePage(driver);
        	boolean company = homePage.notif();
        	Assert.assertEquals(company, true);
        	
        	Thread.sleep(2500);
        	
    	}  catch (InterruptedException e) {
            Thread.currentThread().interrupt();}
    	finally {
    		driver.quit();
    	}
    }
    
    @Then("I should see invalid notif")
    public void i_should_see_invalid_notif() {
    	if(signinPage.invalidNotif()) {
    		System.out.print("Invalid");
    		
    	}
    	
    }
}