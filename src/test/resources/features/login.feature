Feature: Authorization field testing

  Background:
    Given I open a browser and go to desktop login page

  Scenario: Login with valid options
    When User "nastya.kozeka@mail.ru" with password "testpassword" logged in
    Then Username is "Anastasia Kozeka"
    And Welcome message "Welcome to your account. Here you can manage all of your personal information and orders." is displayed

  Scenario Outline: Login with invalid options
    When User "<email>" with password "<password>" logged in
    Then Error massage "<errorMessage>" is displayed
    Examples:
      | email                 | password  | errorMessage           |
      | nastya.kozeka@mail.ru | 123456789 | Authentication failed. |