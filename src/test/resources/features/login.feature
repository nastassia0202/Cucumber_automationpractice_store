Feature: I want to test the authorization field

  Scenario: login with valid options
    Given browser is opened
    And login page is opened
    And email field is displayed
    When user "nastya.kozeka@mail.ru" with password "testpassword" logged in
    Then username is "Anastasia Kozeka"
    And welcome message "Welcome to your account. Here you can manage all of your personal information and orders." is displayed

  Scenario Outline: login with invalid options
    Given browser is opened
    And login page is opened
    And email field is displayed
    When user "<email>" with password "<password>" logged in
    Then error massage "<errorMessage>"
    Examples:
      | email                 | password  | errorMessage           |
      | nastya.kozeka@mail.ru | 123456789 | Authentication failed. |