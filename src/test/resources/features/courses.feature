Feature: courses functionality

  Background: user logged in
    Given user on the my courses page

  Scenario: user can see lessons of a course
    When user clicks on the course "Team5"
    Then user should see all lessons
    And close browser