Feature: Search city of employees

  Scenario: No employee is selected
    Given employee home page
    When no employee is selected
    Then selected data is empty

   Scenario: One or more employees are selected
     Given employee home page
     When one or more employees are selected
       |FirstName|LastName|Title                |
       |Andrew   |Fuller  |Vice President, Sales|
       |Nancy    |Davolio |Sales Representative |
       |Steven   |Buchanan|Sales Manager        |
     Then view city of employee selected
       |FirstName|City   |
       |Andrew   |Tacoma |
       |Nancy    |Seattle|
       |Steven   |London |

  Scenario: Search all cities of employees
    Given employee home page
    When select all employees
    Then view all cities of employees on selected data
      |FirstName|City    |
      |Andrew   |Tacoma  |
      |Nancy    |Seattle |
      |Janet    |Kirkland|
      |Margaret |Redmond |
      |Steven   |London  |
      |Michael  |London  |
      |Robert   |London  |
      |Anne     |London  |
      |Laura    |Seattle |