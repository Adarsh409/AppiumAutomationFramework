Feature: Products

Background: User is on Products page
Given User is on Login Page
When User enters "standard_user" username and "secret_sauce" password
And User clicks login button


Scenario Outline: Validate Products on Products page
When User clicks on product with title "<product_title>"
Then Product price "<product_price>" should appear in Product Details page
And Add to cart button should be visible
Examples:
|product_title|product_price|
|Sauce Labs Onesie|$7.99|