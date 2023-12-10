Feature: Verify Number of Records after Adding/Removing one

  Scenario: user login with valid data
    Given user navigate to "https://opensource-demo.orangehrmlive.com/"
    When user login with "Admin" and "admin123"
    And user click on login button
    Then user logged in successfully

  Scenario: logged in user gets number of records found
    When user click on Admin tab
    Then get the number of records

  Scenario: Add new Record and Verify Number of Records
    Given user click on Add Button
    When user fill the required data
    And user click on Save Button
    Then Verify number of records increased by 1

  Scenario: Remove Record and Verify Number of Records
    Given user search with the new username
    When user Delete the new user
    Then Verify number of records Decreased by 1