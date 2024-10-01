	Feature: User Test 

	Scenario Outline: Create new user
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I click button create new user
		And I input firstname <firstname> and lastname <lastname>
		And I input email <input email>
		And I click the submit user
		And Shows the success toast
		Then Shows user list
	
		Examples: 
		|firstname			|lastname				|input email|
		|Grace					|Dahliana				|						|
		
	Scenario Outline: Create new user with error Email already registered
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I click button create new user
		And I input firstname <firstname> and lastname <lastname>
		And I input email <input email>
		And I click the submit user
		Then Show error email already registered
		
		Examples: 
		|firstname			|lastname				|input email								|
		|Diah						|Sihombing			|anastasya.diah.22@gmail.com|
		
		
	Scenario Outline: Read User
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I input search by the firstname <firstname> and the lastname <lastname>
		Then Shows user list
		
		Examples: 
		|firstname			|lastname				|
		|Diah						|anastasya			|	

	
	
	Scenario Outline: Read Invalid User
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I input search by the firstname <firstname> and the lastname <lastname>
		Then Show the result
	
		Examples: 
		|firstname			|lastname				|
		|Lamria					|magdalena			|
		
	Scenario Outline: Create new user become multiple module and role
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I click button create new user
		And I input firstname <firstname> and lastname <lastname>
		And I input email <input email>
		And I click the add new module and role button
		And I select the module <select module> and select the role <select role>
		And I click the add save module and role
		And I click the add new module and role button
		And I select another module <another module> and another role <another role>
		And I click the add save module and role
		And I click the submit user
		And Shows the success toast
		Then Shows user list
		
		Examples: 
		|firstname				|lastname				|input email	|select module					|select role									|another module	|another role					|
		|Ruth							|Marelisa				|							|user management				|user management admin				|accounting			|read only accounting	|
	
	Scenario Outline: Assign user with module user management and role user management admin
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I input search by the firstname <firstname> and the lastname <lastname>
		And I click the first row user
		And I click the add new module and role button				
		And I select the module <select module> and select the role <select role>
		And I click the add save module and role
		And I click the add new company button
		And I select the company
		And I click the add save company
		And I click the submit user
		And I signout from the admin account
		And I signin user with the user email <user email> and password <user password>
		And I click the menu user management
		And I click the user tab
		Then Show the create new user button
		
		Examples: 
		|user email									|user password					|firstname			|lastname				|select module					|select role										|
		|anastasya.diah.22@gmail.com|Diah220803							|Diah						|anastasya			|User Management				|user management admin					|

		
	Scenario Outline: Assign user with module user management and role user management admin
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I input search by the firstname <firstname> and the lastname <lastname>
		And I click the first row user
		And I click the add new module and role button				
		And I select the module <select module> and select the role <select role>
		And I click the add save module and role
		And I click the add new company button
		And I select the company
		And I click the add save company
		And I click the submit user
		And I signout from the admin account
		And I signin user with the user email <user email> and password <user password>
		And I click the menu user management
		And I click the user tab
		Then Only can see the user list
		Examples: 
		|user email									|user password					|firstname				|lastname				|select module					|select role											|
		|tommyleonardo2910@gmail.com|291010TommyLeo					|Tommy						|Leonardo				|User Management				|read only user user management AT|


	Scenario Outline: Assign User with error Role Already Exist
		Given I already on signin page
		When I signin the admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click the menu user management
		And I click the user tab
		And I input search by the firstname <firstname> and the lastname <lastname>
		And I click the first row user
		And I click the add new module and role button
		And I select the module <select module> and select the role <select role>
		And I click the add save module and role
		And I click the add new module and role button
		And I select another module <another module> and another role <another role>
		And I click the add save module and role
		Then Show error notif role exist
		
		Examples: 
		|firstname	|lastname	|select module		|select role						|another module	|another role					|	
		|Grace			|Dahliana	|user management	|user management admin	|user management|user management admin	|
#	