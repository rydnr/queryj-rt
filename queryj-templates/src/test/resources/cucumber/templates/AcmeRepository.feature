Feature: Acme-wide classes compile

  Scenario Outline: Templates bound to <C.repository> compile

    Given the repository whose name is Acme, composed of:
      | table | parent table | decorated | relationship |   static    |
  <tables:{ t | <cucumber_table_declaration(table=t)>}; separator="\n">

    When I use the repository-wide <template>.stg for Oracle

    Then the generated repository-wide <output> file compiles successfully

  Examples:
    | template           | output                            |
  queryj-templates/src/test/resources/cucumber/templates/AcmeRepository.feature
  <C.templateDefs:{ d | <indirect_template(def=d, engineName="Oracle", tableName="User")>}; separator="\n">
