@endToend
Feature:
  Background:
    Given I should go to eaapp "url"
    Then  I should be login
    Then I should go to Employee List link


    Scenario:As a admin I should be login
      Then I should create new employee information
      When I should see which my created  employee information
      And I should delete which my created  employee information
      And close the browser




