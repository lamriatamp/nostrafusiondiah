Feature: Sigin Site

  Scenario: Successful login
  	Given I use "Chrome"
    When I navigate to signin page
    And I signin with the email <email> and password <password>
    And I click signin button
    Then I navigate to home page
    
    Examples:
		|email											|password						|
		|cold15@warunkpedia.com			|Admin19951996!			|
		|anastasya.diah.22@gmail.com|Diah220803					|
    
  Scenario: Invalid login
  	Given I use "Chrome"
    When I navigate to signin page
    And I signin with the email <email> and password <password>
    And I click signin button
    Then I should see invalid notif
    
    Examples:
		|email											|password						|
		|cold15@warunkpedia					|Admin							|
		
		
		
   