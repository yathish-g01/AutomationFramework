Feature: Login into Guru99 Bank

  Scenario: Successful login with valid credentials
    Given I am on the Guru99 Bank login page
    When I enter a valid username as "mngr578130" and password as "japYmYb"
    And I click on the login button
    Then I should be redirected to the home page with title "Guru99 Bank Manager HomePage"

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the Guru99 Bank login page
    When I enter an invalid username "<username>" and password "<password>"
    And I click on the login button
#    Then the login should be "<result>"
    Then I should see an alert with the message "User or Password is not valid"

    Examples:
      | username   | password |
      | mngr57813  | japYmYb  |
      | mngr578130 | japYmY   |

