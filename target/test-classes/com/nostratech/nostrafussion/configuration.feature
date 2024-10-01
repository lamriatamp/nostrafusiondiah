Feature: Configuration Site

	Scenario Outline: Create new company
		Given I want to sign in with admin email "cold15@warunkpedia.com" and password "Admin19951996!"
		When I click menu configuration
		And I click company tab
		And I click create new company button
		And I input the name of company <company name>
		And I select the type
		And I select bussiness line <business line>
		And I select region <region>
		And I select timezone <timezone>
		And I input business number <business number>
		And I input company number <company number>
		And I input contact information with email <email>, phone <phone>, fax <fax>, website <website>, and address <address>
		And I check the module
		And I click submit company
		Then Show create success
		
		Examples:
		|company name				|business line|region			|timezone	|business number|company number	|email										|phone				|fax		|website						|address			|
		|										|others				|indonesia	|jakarta	|1000056				|5467896				|diahanastasya24@gmail.com|081234567890	|222333	|https://google.com	|Jakarta Pusat|	
		
		
	Scenario Outline: Assign user with module configuration and role read only configuration
		Given I want to sign in with admin email "cold15@warunkpedia.com" and password "Admin19951996!"
		When I click the user management menu
		And I click tab user
		And I search by input the firstname <firstname> and the lastname <lastname>
		And I click first user
		And I click button add new module and role				
		And I select module <select module> and role <select role>
		And I click button add save module and role
		And I click button add new company
		And I choose company
		And I click button add save company
		And I click button submit user
		And I signout the admin account
		And I signin with user email <user email> and user password <user password>
		And I click menu configuration
		And I click company tab
		Then Only show company list
		
		Examples: 
		|user email									|user password					|firstname			|lastname				|select module		|select role								|
		|anastasya.diah.22@gmail.com|Diah220803							|Diah						|anastasya			|Configuration		|read only configuration		|
