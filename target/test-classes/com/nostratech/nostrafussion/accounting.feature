Feature: Accounting Site


	Scenario Outline: Create New Bank
		Given I already in signin page
		When I signin admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click menu accounting
		And I select master tab
		And I click bank menu
		And I click button create new bank
		And I select bank
		And I input bank acc number <number>
		And I select bank acc control
		And I input bank code <code>
		And I input bank acc name <name>
		And I click submit button
		Then I should see success toast
		
		Examples: 
	|number	|code	|name			|
	|				|221	|Anastasya|

 
	
	Scenario Outline: Assign User as With Accounting, Read Only Accounting
		Given I already in signin page
		When I signin admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click menu user management
		And I click user tab
		And I input search by firstname <firstname> and lastname <lastname>
		And I click first row user
		And I click add new module and role button
		And I select module <select module> and select role <select role>
		And I click add save module and role
		And I click add new company button
		And I select company
		And I click add save company
		And I click submit user
		And I signout from admin account
		And I signin user with email <user email> and password <user password>
		And I click menu accounting
		And I select master tab
		And I click bank menu
		Then I only see the bank list
		
		Examples: 
		|user email									|user password					|firstname			|lastname				|select module					|select role									|
		|anastasya.diah.22@gmail.com|Diah220803							|Diah						|anastasya			|Accounting							|read only accounting					|

	Scenario Outline: Assign User as With Accounting, Finance Accounting Admin
		Given I already in signin page
		When I signin admin with email "cold15@warunkpedia.com" and password "Admin19951996!"	
		And I click menu user management
		And I click user tab
		And I input search by firstname <firstname> and lastname <lastname>
		And I click first row user
		And I click add new module and role button
		And I select module <select module> and select role <select role>
		And I click add save module and role
		And I click add new company button
		And I select company
		And I click add save company
		And I click submit user
		And I signout from admin account
		And I signin user with email <user email> and password <user password>
		And I click menu accounting
		And I select master tab
		And I click bank menu
		Then Show the create new bank button
		
		Examples: 
		|user email									|user password					|firstname				|lastname				|select module					|select role										|
		|tommyleonardo2910@gmail.com|291010TommyLeo					|Tommy						|Leonardo				|Accounting							|Finance												|
#		