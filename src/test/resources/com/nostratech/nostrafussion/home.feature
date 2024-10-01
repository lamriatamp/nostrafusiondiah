Feature: Home Site

  Scenario: Klik User Management Menu
  	Given I already signin
  	When I am on the home page
  	And I click user management menu
  	And I navigate to page user management
  	Then I should see the user management dashboard
  	
  
  Scenario: Klik Accounting Menu
  	Given I already signin
  	When I am on the home page
  	And I click accounting menu
  	And I navigate to page accounting
  	Then I should see the accounting dashboard
  	
  Scenario: Klik Configuration Menu
  	Given I already signin
  	When I am on the home page
  	And I click configuration menu
  	And I navigate to page configuration
  	Then I should see the configuration dashboard
