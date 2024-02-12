Feature: validate devlab application

  Scenario: validate devlab Home Page Header Navigation
    Given user launch Devlab application
    Then user validate the home page title
    And user validate devlab logo
    When user click on login button
    Then login popup screen displays
    When user gives input as user name and passowrd
    Then user close the login pop up
    Then user close the application

