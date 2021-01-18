Feature: Vehicle Insurance Application

Scenario: fill all forms of vehicle insurance application and submit the application.

    Given I navigate to the Vehicle Insurance Application page
    When I fill all fields whithin all pages
    And I fill all forms and send quote
    Then I will be able to see a Success message in the screen