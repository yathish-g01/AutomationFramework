Feature: Adding new Customer into the Application

  Scenario: Filling out the User registration form with user details
    Given I am on the Guru99 Bank login page
    When I enter a valid username as "mngr578130" and password as "japYmYb"
    And I click on the login button
    Then I should be redirected to the home page with title "Guru99 Bank Manager HomePage"
    And I click on the New Customer link
    Then I fill out the registration form with the following details
      | field    | value            |
      | name     | John             |
      | gender   | male             |
      | dob      | 01-01-1990       |
      | address  | 123 Street       |
      | city     | Town             |
      | state    | State            |
      | pin      | 123456           |
      | mobile   | 1234567890       |
      | email    | john102@example.com |
      | password | password1        |
    And I click on the submit button
    Then I should see a confirmation message "Customer Registered Successfully!!!"