Feature: Single User Test
  @Tugas
  Scenario: Get Single User with valid parameter id
    Given Get single user with parameter validID 2
    When Send get single user request
    Then Status code should be 200 OK
    And Response body Page should return data id 2 email "janet.weaver@reqres.in" and first name "Janet"
    And Validate get single user json schema

  @Tugas
  Scenario Outline: Get Single User with valid parameter
    Given Get single user with parameter validID <ID>
    When Send get single user request
    Then Status code should be 200 OK
    And Response body Page should be <ID>
    And Validate get single user json schema
    Examples:
      | ID |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
  #@Tugas
  #Scenario: Get Single User with invalid path
    #Given Get single user with invalid URL and parameter validID 1
    #When Send get single user request with invalid URL
    #Then Status code should be 200 OK
    #Status code should be 404 Not Found
    #And Response body Page should be 1
    #And Validate get single user json schema
  @Tugas
  Scenario Outline: Get Single User with invalid parameter id
    Given Get single user with parameter inValidID "<ID>"
    When Send get single user request
    Then Status code should be 404 Not Found
    #And Validate get single user json schema
    Examples:
      | ID    |
      | GHJKL |
      | 3^&*r |
      | 3im   |