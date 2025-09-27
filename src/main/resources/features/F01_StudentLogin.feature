Feature: a user is able to login successfully
  Scenario: the Student is able to login
  When the user is in the login page
  And the user types "mazenkhairy200@gmail.com" in the email
  And the user types "123456789" in the password
  Then the user is able to login successfully