Feature: Role Site

	Scenario Outline: create new role
		Given I already on user management page
		When I click roles tab
		And I click button create new role
		And I input role name <names>
		And I select module
		And I input description <description>
		And I click checkbox
		And I select role
		And I select user 
		And I click submit
		Then I should see roles list
		
		Examples:
		| names											 				| description 												|
		| Diah User Management-Read QA    	| Testing User Management 						|
		| Lamria User Management-None Role  | Automation Testing User Management 	|
		
		
	Scenario Outline: read and update role
		Given I already on user management page
		When I click roles tab
		And I input name role <names>
		And I click name 
		And I click edit
		And I update description <update description>
		And I click submit
		Then I should see roles list
		
		Examples:
		| names											 						| update description 									|
		| Diah User Management-Read QA    			| Automation Testing User Management 	|
		| Lamria User Management-None Role  		| Testing User Management 						|
		
		
	Scenario Outline: Delete role
		Given I already on user management page
		When I click roles tab
		And I input name role <names>
		And I click setting
		And I click delete button
		And I click confirm delete
		Then I should see roles list
		
		Examples:
		| names											 						|
		| Diah User Management-Read QA    			|
		| Lamria User Management-None Role  		|
		
		
	Scenario Outline: Invalid read role
		Given I already on user management page
		When I click roles tab
		And I input name role <names>
		Then Show zero result
		
		Examples:
		|names				|
		|Jaka Sembung	|
