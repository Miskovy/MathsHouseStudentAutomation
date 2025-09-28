Feature: The Student is able to edit and update his profile

  Background: the Student is able to login
    When the user is in the login page
    And the user types "mazenkhairy200@gmail.com" in the email
    And the user types "123456789" in the password
    Then the user is able to login successfully
    When the user is in the profile page
    And the user presses the edit icon

  Scenario: The user is able to edit his name
    When the user changes his name to "Mazen2"
    And the user changes his last name to "Khairy2"
    And the user saves the changes
    Then the name is changed to "Mazen2" and the last name to "Khairy2"