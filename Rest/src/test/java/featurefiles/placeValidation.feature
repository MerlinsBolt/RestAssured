Feature: validation of Place API

Scenario: verify place is being added using the AddPlaceAPI
Given Addplace Payload  
When user calls "addPlaceApi" with http POST request
Then the api call get hit with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"