Feature:
  As an API consumer
  I want to be able retrieve API root resource
  So that i can navigate to other resources


Scenario: Retrieve root resource
    Given Authorization header is set to proper token
    When I execute GET method on /
    Then Hello World should be returned