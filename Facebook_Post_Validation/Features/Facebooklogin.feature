Feature: Testing the login for the Application

  Scenario Outline: Login validation for the Facebook Application
    Given User provides the facebook Application Url
    When User pass the Username as "<username>" and Password as "<password>" and cliks on submit button
    Then User should be able to see the facebook dashboard
    And User click on create New post button
    When User sends "<post>" notification it should be published

    Examples: 
      | username                 | password   | post        |
      | abhishekgaurpb@gmail.com | Abhishek7@ | Hello World |
