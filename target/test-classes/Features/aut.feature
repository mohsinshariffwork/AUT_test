@aut
Feature: Draw flowchart scenarios

  @aut
  Scenario: Launch AUT url
    Given I want to launch the AUT url
    Then Verify application launched

  Scenario: Create a Flowchart
    Given Click on create option
    When Add "Oval" Shape in Flowchart
    And Add "parallelogram" Shape in Flowchart
    And Add "parallelogram" Shape in Flowchart
    And Add "Rectangle" Shape in Flowchart
    And Add "parallelogram" Shape in Flowchart
    And Add "Oval" Shape in Flowchart
    And Set in Horizontal flow
    And Set input values for the flowchart as "Start, Read A, Read B, C=A+B, Print C, End"
    Then verify Flowchart saved successfully

  Scenario: Update a Flowchart shape
    Given Open an existing flowchart
    When Update a shape from "ellipse" to "Rectangle" in flowchart
    Then verify shape updated to "Rectangle" successfully

  Scenario: Delete a Flowchart shape
    Given Open an existing flowchart
    When Delete a shape in flowchart
    Then verify shape deleted successfully

  Scenario: Update Flowchart text
    Given Open an existing flowchart
    When Set input values for the flowchart as "Start, Read A, Read B, D=A+B, Print D, End"
    Then verify Flowchart saved successfully

  Scenario: Delete Flowchart text
    Given Open an existing flowchart
    When Delete text of a shape
    Then verify text deleted successfully
    And verify Flowchart saved successfully

  Scenario: Negative validation for Shape search text field
    Given Open an existing flowchart
    When Add "12346" Shape in Flowchart
    Then verify No results message displayed

  Scenario: Delete Flowchart
    Given Open an existing flowchart
    When Delete flowchart
    Then verify deleted successfully
    And verify file saved successfully
