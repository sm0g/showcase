# showcase app

This sample app provides an API endpoint (http://localhost:9080/api/va?types=Language) that returns 
a list of lists of ValueAssistance objects. These are supported VA types: BusinessModel, Language. 
Swagger docs are also available: http://localhost:9080/swagger-ui.html. Example response:
```
{
  "Language": [
    {
      "value": "EN",
      "label": "English"
    },
    ...
  ]
}
```

VA data can be stored as Enums or as as records in "value_assistance" DB table. API endpoint provides a unified access to both types.
Application uses H2 database and Liquibase for data population.

There are a few unit/integration tests.

