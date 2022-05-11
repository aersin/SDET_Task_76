
Feature: Stats feature

  @wip
  Scenario Outline: verify the highest and lowest player with stats type
    Given the user is on the home page
    Then the user clicks on "Stats" tab
    When the user clicks on "<subStatsTab>"
    And the user selects "<year>" as a year
    Then the user should see "<highestPlayerName>" as highest on "<statsType>" with "<highestValue>" value
    Then the user should see "<lowestPlayerName>" as lowest on "<statsType>" with "<lowestValue>" value
    Examples:
      | subStatsTab | year | highestPlayerName | lowestPlayerName | statsType | highestValue | lowestValue |
      | Receiving   | 2020 | Stefon Diggs      | CeeDee Lamb      | Yds       | 1535         | 935         |
      | Rushing     | 2021 | Jonathan Taylor   | Aaron Jones      | Att       | 332          | 171         |
      | Tackles     | 2021 | Denzel Perryman   | Quincy Williams  | Solo      | 94           | 64          |