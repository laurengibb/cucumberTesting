Feature: Creating a user on the demoSite
  As a user
  I want to register
  So that I can login

  Scenario: Registering with correct details
    Given correctly formatted deatils
    When i navigate to demosite.com
    And I click create User
    And I fill in the details
    And I click register
    And I try to login
    Then I am successfully logged in