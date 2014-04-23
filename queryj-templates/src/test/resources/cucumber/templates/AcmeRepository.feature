Feature: Acme-wide classes compile

  Scenario Outline: Templates bound to <C.repository> compile

    Given the repository whose name is Acme, composed of:
      | table         | parent table | decorated | relationship |   static    |
      | G_CYCLE_TYPES |              | false     |  false        | false       |

    When I use the repository-wide <template>.stg for Oracle

    Then the generated repository-wide <output> file compiles successfully

  Examples:
    | template | output |
    | DataAccessManager| AcmeDataAccessManager.java |
