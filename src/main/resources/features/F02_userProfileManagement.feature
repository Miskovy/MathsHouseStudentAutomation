Feature: The Student is able to edit and update his profile

  Background: the Student is able to login
    When the user is in the login page
    And the user types "mazenkhairy200@gmail.com" in the email
    And the user types "123456789" in the password
    Then the user is able to login successfully
    When the user is in the profile page
    And the user presses the edit icon

  Scenario: The user is able to edit his name
    When the user changes his name to "Mazen"
    And the user changes his last name to "Khairy"
    And the user saves the changes
    Then the user name "Mazen Khairy" should be displayed

  Scenario: The user is able to change his email and password
    When the user changes his email to "mazenkhairy200@gmail.com"
    And the user saves the changes
#    Then the email "mazenkhairy200@gmail.com" should be displayed