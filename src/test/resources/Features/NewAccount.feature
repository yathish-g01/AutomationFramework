Feature: Creating new Account

  Scenario: Create new Account
    Given I am on the Guru99 Bank login page
    When I enter a valid username as "mngr578130" and password as "japYmYb"
    And I click on the login button
    Then I should be redirected to the home page with title "Guru99 Bank Manager HomePage"
    Then Go to the new account page
    And Fill the new account form with the following details
      | field          | value   |
      | CustomerId     | 82531   |
      | AccountType    | Savings |
      | InitialDeposit | 1000    |
    And I click on the account submit button
    Then I should see the account created message