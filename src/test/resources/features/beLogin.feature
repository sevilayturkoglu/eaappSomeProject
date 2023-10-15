@endToend
Feature:As an admin I should be able to Create a new employee and delete the employee which I created
  Background:
    Given I should go to eaapp "url"
    Then  I should be login
    Then I should go to Employee List link


    Scenario:Create a new employee and verify if the name is in the list before and after deleting
      Then I should create new employee information
      When I should see which my created  employee information
      And I should delete which my created  employee information
      And close the browser




