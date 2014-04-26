Feature: Classes associated to custom results compile

  Scenario Outline: Custom result GCycleCount work

    Given the following custom result:
      | id | class |
      | cycle.count | GCycle |

    And the following custom result properties:
      | name       | index | type | nullable |
      | g_cycle_id | 1     | int  | false    |
      | count      | 2     | long | false    |

    When I use the custom result template <template> for Oracle

    Then the generated custom result-specific <output> file compiles successfully

  Examples:
    | template                 | output                        |
    | CustomResultSetExtractor | GCycleCountResultSetExtractor |