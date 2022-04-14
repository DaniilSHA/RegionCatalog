## API instructions

* endpoint - GET http://localhost:8080/region-catalog/all <br>
  will return JSON with all records like: <br> 
  {
  "regionCatalogList": [
  {
  "id": 1,
  "title": "Еврейская автономная область",
  "shortTitle": "RU-YEV"
  },
  {
  "id": 2,
  "title": "Чукотский автономный округ",
  "shortTitle": "RU-CHU"
  }
  ]
  }

* endpoint - GET http://localhost:8080/region-catalog/2 <br>
  will return JSON with record by id like: <br>
  {
  "regionCatalogList": [
  {
  "id": 1,
  "title": "Еврейская автономная область",
  "shortTitle": "RU-YEV"
  }
  ]
  }

* endpoint - POST http://localhost:8080/region-catalog/create <br>
  need request body JSON like: <br>
  {
  "title" : "Ненецкий автономный округ",
  "shortTitle" : "RU-NEN"
  } <br>
  create new record in database

* endpoint - PUT http://localhost:8080/region-catalog/update/2
  need request body JSON like: <br>
  {
  "title" : "Ненецкий автономный округ",
  "shortTitle" : "RU-NEN"
  } <br>
  update record by id in database

* endpoint - DELETE http://localhost:8080/region-catalog/delete/1 <br>
  delete record by id in database