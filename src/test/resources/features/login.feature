Feature: Login

  Scenario: Login with valid data
    Given Navigate to Login Page
    When Fill fields valid data
    And Click on Login button
    Then Check displayed Contact page