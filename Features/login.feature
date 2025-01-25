Feature: Login

Background: User is on Login page
Given User is on Login Page

Scenario Outline: Valid Login
When User enters "<username>" username and "<password>" password
And User clicks login button
Then User should should land on Products page with title "<title>"
Examples:
|username|password|title|
|standard_user|secret_sauce|PRODUCTS|
