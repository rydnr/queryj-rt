$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/templates/GCycleType.feature");
formatter.feature({
  "id": "g-cycle-types-code-compiles",
  "description": "",
  "name": "G_CYCLE_TYPES code compiles",
  "keyword": "Feature",
  "line": 1
});
formatter.uri("cucumber/templates/PerTableTemplates.feature");
formatter.feature({
  "id": "per-table-templates",
  "description": "",
  "name": "Per-table templates",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "per-table-templates;per-table-templates-compile-for-a-type-1-table;;2",
  "description": "",
  "name": "Per-table templates compile for a type 1 table",
  "keyword": "Scenario Outline",
  "line": 55,
  "type": "scenario"
});
formatter.step({
  "name": "the following tables:",
  "keyword": "Given ",
  "line": 5,
  "rows": [
    {
      "cells": [
        "table",
        "parent table",
        "decorated",
        "relationship",
        "static"
      ],
      "line": 6
    },
    {
      "cells": [
        "g_draws",
        "",
        "",
        "",
        ""
      ],
      "line": 7
    },
    {
      "cells": [
        "g_draw_types",
        "",
        "",
        "",
        "description"
      ],
      "line": 8
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineInputTables(DataTable)"
});
formatter.result({
  "duration": 134894755,
  "status": "passed"
});
formatter.step({
  "name": "the following columns:",
  "keyword": "And ",
  "line": 10,
  "rows": [
    {
      "cells": [
        "table",
        "column",
        "type",
        "pk",
        "allows null",
        "readonly",
        "sequence",
        "keyword",
        "boolean",
        "length",
        "precision"
      ],
      "line": 11
    },
    {
      "cells": [
        "g_draws",
        "g_draw_id",
        "number",
        "true",
        "false",
        "false",
        "seq_g_draws",
        "",
        "",
        "10",
        "0"
      ],
      "line": 12
    },
    {
      "cells": [
        "g_draws",
        "g_draw_type_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "10",
        "0"
      ],
      "line": 13
    },
    {
      "cells": [
        "g_draws",
        "drawing_date",
        "date",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "",
        ""
      ],
      "line": 14
    },
    {
      "cells": [
        "g_draws",
        "g_draw_state_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "10",
        "0"
      ],
      "line": 15
    },
    {
      "cells": [
        "g_draws",
        "last_modified",
        "timestamp",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "",
        ""
      ],
      "line": 16
    },
    {
      "cells": [
        "g_draws",
        "creation_date",
        "timestamp",
        "false",
        "false",
        "false",
        "",
        "sysdate",
        "",
        "",
        ""
      ],
      "line": 17
    },
    {
      "cells": [
        "g_draw_types",
        "g_draw_type_id",
        "number",
        "true",
        "false",
        "false",
        "seq_g_draws",
        "",
        "",
        "10",
        "0"
      ],
      "line": 18
    },
    {
      "cells": [
        "g_draw_types",
        "description",
        "varchar",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "40",
        ""
      ],
      "line": 19
    },
    {
      "cells": [
        "g_draw_types",
        "g_lottery_provider_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "sysdate",
        "",
        "",
        ""
      ],
      "line": 20
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineInputColumns(DataTable)"
});
formatter.result({
  "duration": 4236457,
  "status": "passed"
});
formatter.step({
  "name": "the following foreign keys:",
  "keyword": "And ",
  "line": 22,
  "rows": [
    {
      "cells": [
        "source table",
        "source columns",
        "target table",
        "allows null"
      ],
      "line": 23
    },
    {
      "cells": [
        "g_draws",
        "g_draw_type_id",
        "d_draw_types",
        "false"
      ],
      "line": 24
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineForeignKeys(DataTable)"
});
formatter.result({
  "duration": 1337687,
  "status": "passed"
});
formatter.step({
  "name": "the following queries:",
  "keyword": "And ",
  "line": 26,
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "dao",
        "type",
        "matches",
        "value",
        "validate"
      ],
      "line": 27
    },
    {
      "cells": [
        "first.select",
        "first-select",
        "g_draws",
        "select",
        "single",
        "select * from g_draws where g_draw_id \u003d ?",
        "true"
      ],
      "line": 28
    },
    {
      "cells": [
        "second.select",
        "second-select",
        "g_draws",
        "select",
        "multiple",
        "select * from g_draws where drawing_date \u003e sysdate - 7",
        "true"
      ],
      "line": 29
    },
    {
      "cells": [
        "third.select",
        "third-select",
        "g_draw_types",
        "select",
        "multiple",
        "select * from g_draw_types where description like ?",
        "true"
      ],
      "line": 30
    },
    {
      "cells": [
        "fourth.select",
        "fourth-select",
        "g_draws",
        "select",
        "multiple",
        "select * from g_draws where drawing_date \u003d ?",
        "true"
      ],
      "line": 31
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineSql(DataTable)"
});
formatter.result({
  "duration": 9187926,
  "status": "passed"
});
formatter.step({
  "name": "the following query parameters:",
  "keyword": "And ",
  "line": 33,
  "rows": [
    {
      "cells": [
        "id",
        "sql",
        "index",
        "type",
        "name",
        "validation-value"
      ],
      "line": 34
    },
    {
      "cells": [
        "g_draws.g_draw_id",
        "first.select",
        "1",
        "long",
        "drawId",
        "1"
      ],
      "line": 35
    },
    {
      "cells": [
        "g_draw_types.description",
        "third.select",
        "1",
        "String",
        "description",
        "\u0027Euromillones\u0027"
      ],
      "line": 36
    },
    {
      "cells": [
        "g_draws.drawing_date",
        "fourth.select",
        "1",
        "Date",
        "drawingDate",
        "\u00272014/02/15\u0027"
      ],
      "line": 37
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineParameters(DataTable)"
});
formatter.result({
  "duration": 25011697,
  "status": "passed"
});
formatter.step({
  "name": "the following contents:",
  "keyword": "And ",
  "line": 39,
  "rows": [
    {
      "cells": [
        "table",
        "row"
      ],
      "line": 40
    },
    {
      "cells": [
        "g_draw_types",
        "1, \"Euromillions\", 1"
      ],
      "line": 41
    },
    {
      "cells": [
        "g_draw_types",
        "2, \"El_Gordo\",     1"
      ],
      "line": 42
    },
    {
      "cells": [
        "g_draw_types",
        "3, \"Primitiva\",    1"
      ],
      "line": 43
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineRows(DataTable)"
});
formatter.result({
  "duration": 3726795,
  "status": "passed"
});
formatter.step({
  "name": "I generate with per-table CucumberTableFeature.stg for Oracle",
  "keyword": "When ",
  "line": 45,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "CucumberTableFeature",
      "offset": 26
    },
    {
      "val": "Oracle",
      "offset": 55
    }
  ],
  "location": "PerTableTemplatesTest.generateFile(String,String)"
});
formatter.result({
  "duration": 362670393,
  "status": "passed"
});
formatter.step({
  "name": "the generated per-table .feature file compiles successfully",
  "keyword": "Then ",
  "line": 47,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": ".feature",
      "offset": 24
    }
  ],
  "location": "PerTableTemplatesTest.checkGeneratedFileCompiles(String)"
});
formatter.result({
  "duration": 728951,
  "status": "passed"
});
formatter.step({
  "name": "the queries are validated correctly using the following database:",
  "keyword": "Then ",
  "line": 49,
  "rows": [
    {
      "cells": [
        "driver",
        "url",
        "userName",
        "password"
      ],
      "line": 50
    },
    {
      "cells": [
        "oracle.jdbc.driver.OracleDriver",
        "jdbc:oracle:thin:@(DESCRIPTION\u003d(ADDRESS\u003d(PROTOCOL\u003dTCP)(HOST\u003d10.34.10.249)(PORT\u003d1521))(CONNECT_DATA\u003d(SERVER\u003ddedicated)(SERVICE_NAME\u003dPRE2)))",
        "QUERYJGAMES",
        "QUERYJGAMES"
      ],
      "line": 51
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.validateQueries(DataTable)"
});
formatter.result({
  "duration": 3279501766,
  "status": "passed"
});
formatter.scenario({
  "id": "per-table-templates;per-table-templates-compile-for-a-type-1-table;;3",
  "description": "",
  "name": "Per-table templates compile for a type 1 table",
  "keyword": "Scenario Outline",
  "line": 56,
  "type": "scenario"
});
formatter.step({
  "name": "the following tables:",
  "keyword": "Given ",
  "line": 5,
  "rows": [
    {
      "cells": [
        "table",
        "parent table",
        "decorated",
        "relationship",
        "static"
      ],
      "line": 6
    },
    {
      "cells": [
        "g_draws",
        "",
        "",
        "",
        ""
      ],
      "line": 7
    },
    {
      "cells": [
        "g_draw_types",
        "",
        "",
        "",
        "description"
      ],
      "line": 8
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineInputTables(DataTable)"
});
formatter.result({
  "duration": 314955,
  "status": "passed"
});
formatter.step({
  "name": "the following columns:",
  "keyword": "And ",
  "line": 10,
  "rows": [
    {
      "cells": [
        "table",
        "column",
        "type",
        "pk",
        "allows null",
        "readonly",
        "sequence",
        "keyword",
        "boolean",
        "length",
        "precision"
      ],
      "line": 11
    },
    {
      "cells": [
        "g_draws",
        "g_draw_id",
        "number",
        "true",
        "false",
        "false",
        "seq_g_draws",
        "",
        "",
        "10",
        "0"
      ],
      "line": 12
    },
    {
      "cells": [
        "g_draws",
        "g_draw_type_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "10",
        "0"
      ],
      "line": 13
    },
    {
      "cells": [
        "g_draws",
        "drawing_date",
        "date",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "",
        ""
      ],
      "line": 14
    },
    {
      "cells": [
        "g_draws",
        "g_draw_state_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "10",
        "0"
      ],
      "line": 15
    },
    {
      "cells": [
        "g_draws",
        "last_modified",
        "timestamp",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "",
        ""
      ],
      "line": 16
    },
    {
      "cells": [
        "g_draws",
        "creation_date",
        "timestamp",
        "false",
        "false",
        "false",
        "",
        "sysdate",
        "",
        "",
        ""
      ],
      "line": 17
    },
    {
      "cells": [
        "g_draw_types",
        "g_draw_type_id",
        "number",
        "true",
        "false",
        "false",
        "seq_g_draws",
        "",
        "",
        "10",
        "0"
      ],
      "line": 18
    },
    {
      "cells": [
        "g_draw_types",
        "description",
        "varchar",
        "false",
        "false",
        "false",
        "",
        "",
        "",
        "40",
        ""
      ],
      "line": 19
    },
    {
      "cells": [
        "g_draw_types",
        "g_lottery_provider_id",
        "number",
        "false",
        "false",
        "false",
        "",
        "sysdate",
        "",
        "",
        ""
      ],
      "line": 20
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineInputColumns(DataTable)"
});
formatter.result({
  "duration": 1646212,
  "status": "passed"
});
formatter.step({
  "name": "the following foreign keys:",
  "keyword": "And ",
  "line": 22,
  "rows": [
    {
      "cells": [
        "source table",
        "source columns",
        "target table",
        "allows null"
      ],
      "line": 23
    },
    {
      "cells": [
        "g_draws",
        "g_draw_type_id",
        "d_draw_types",
        "false"
      ],
      "line": 24
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineForeignKeys(DataTable)"
});
formatter.result({
  "duration": 146531,
  "status": "passed"
});
formatter.step({
  "name": "the following queries:",
  "keyword": "And ",
  "line": 26,
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "dao",
        "type",
        "matches",
        "value",
        "validate"
      ],
      "line": 27
    },
    {
      "cells": [
        "first.select",
        "first-select",
        "g_draws",
        "select",
        "single",
        "select * from g_draws where g_draw_id \u003d ?",
        "true"
      ],
      "line": 28
    },
    {
      "cells": [
        "second.select",
        "second-select",
        "g_draws",
        "select",
        "multiple",
        "select * from g_draws where drawing_date \u003e sysdate - 7",
        "true"
      ],
      "line": 29
    },
    {
      "cells": [
        "third.select",
        "third-select",
        "g_draw_types",
        "select",
        "multiple",
        "select * from g_draw_types where description like ?",
        "true"
      ],
      "line": 30
    },
    {
      "cells": [
        "fourth.select",
        "fourth-select",
        "g_draws",
        "select",
        "multiple",
        "select * from g_draws where drawing_date \u003d ?",
        "true"
      ],
      "line": 31
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineSql(DataTable)"
});
formatter.result({
  "duration": 192760,
  "status": "passed"
});
formatter.step({
  "name": "the following query parameters:",
  "keyword": "And ",
  "line": 33,
  "rows": [
    {
      "cells": [
        "id",
        "sql",
        "index",
        "type",
        "name",
        "validation-value"
      ],
      "line": 34
    },
    {
      "cells": [
        "g_draws.g_draw_id",
        "first.select",
        "1",
        "long",
        "drawId",
        "1"
      ],
      "line": 35
    },
    {
      "cells": [
        "g_draw_types.description",
        "third.select",
        "1",
        "String",
        "description",
        "\u0027Euromillones\u0027"
      ],
      "line": 36
    },
    {
      "cells": [
        "g_draws.drawing_date",
        "fourth.select",
        "1",
        "Date",
        "drawingDate",
        "\u00272014/02/15\u0027"
      ],
      "line": 37
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineParameters(DataTable)"
});
formatter.result({
  "duration": 732553,
  "status": "passed"
});
formatter.step({
  "name": "the following contents:",
  "keyword": "And ",
  "line": 39,
  "rows": [
    {
      "cells": [
        "table",
        "row"
      ],
      "line": 40
    },
    {
      "cells": [
        "g_draw_types",
        "1, \"Euromillions\", 1"
      ],
      "line": 41
    },
    {
      "cells": [
        "g_draw_types",
        "2, \"El_Gordo\",     1"
      ],
      "line": 42
    },
    {
      "cells": [
        "g_draw_types",
        "3, \"Primitiva\",    1"
      ],
      "line": 43
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.defineRows(DataTable)"
});
formatter.result({
  "duration": 768614,
  "status": "passed"
});
formatter.step({
  "name": "I generate with per-table DAO.stg for Oracle",
  "keyword": "When ",
  "line": 45,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "DAO",
      "offset": 26
    },
    {
      "val": "Oracle",
      "offset": 38
    }
  ],
  "location": "PerTableTemplatesTest.generateFile(String,String)"
});
formatter.result({
  "duration": 896165149,
  "status": "passed"
});
formatter.step({
  "name": "the generated per-table DAO.java file compiles successfully",
  "keyword": "Then ",
  "line": 47,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "DAO.java",
      "offset": 24
    }
  ],
  "location": "PerTableTemplatesTest.checkGeneratedFileCompiles(String)"
});
formatter.result({
  "duration": 204106,
  "status": "passed"
});
formatter.step({
  "name": "the queries are validated correctly using the following database:",
  "keyword": "Then ",
  "line": 49,
  "rows": [
    {
      "cells": [
        "driver",
        "url",
        "userName",
        "password"
      ],
      "line": 50
    },
    {
      "cells": [
        "oracle.jdbc.driver.OracleDriver",
        "jdbc:oracle:thin:@(DESCRIPTION\u003d(ADDRESS\u003d(PROTOCOL\u003dTCP)(HOST\u003d10.34.10.249)(PORT\u003d1521))(CONNECT_DATA\u003d(SERVER\u003ddedicated)(SERVICE_NAME\u003dPRE2)))",
        "QUERYJGAMES",
        "QUERYJGAMES"
      ],
      "line": 51
    }
  ]
});
formatter.match({
  "location": "PerTableTemplatesTest.validateQueries(DataTable)"
});
formatter.result({
  "duration": 2879747799,
  "status": "passed"
});
});