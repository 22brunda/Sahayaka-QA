@Login
Feature: As a User I should be able to login 

@Login 
Scenario: User able to login
Given I am on Sahayaka login page
When I enter my username and Phonenumber and click on log in button
Then I should be able to see Pending ticket list successfully