Feature: The Student is able to edit and update his profile

  Background: the Student is able to login
    When the user is in the login page
    And the user types "mazenkhairy200@gmail.com" in the email
    And the user types "12345678" in the password
    Then the user is able to login successfully
    When the user is in the profile page
    And the user presses the edit icon

  Scenario: The user is able to change his nickname
    When the user changes his nickname to "Mazen"
    And the user saves the changes
    Then the nickname should be displayed "Mazen"

#  Scenario: The user is able to change his grade
#    When the user chooses his grade "10"
#    And the user saves the changes
#    Then the grade should be displayed "10"

  Scenario: The user is able to edit his name
    When the user changes his name to "Mazen"
    And the user changes his last name to "Khairy"
    And the user saves the changes
    Then the user name "Mazen Khairy" should be displayed

  Scenario: The user is able to change his email
    When the user changes his email to "mazenkhairy200@gmail.com"
    And the user saves the changes
    Then the email "mazenkhairy200@gmail.com" should be displayed

  Scenario: The user is able to change his password
    When the user changes his password to "12345678"
    And the user confirms the password "12345678"
    And the user saves the changes
    Then the success message updated profile should be displayed

  Scenario: The user is able to change his phone number
    When the user changes his phone number to "01090258784"
    And the user saves the changes
    Then the phone number "01090258784" should be displayed

  Scenario: The user is able to change his profile photo
    When the user presses the change photo
    And the user chooses the image source
    And the user saves the changes


