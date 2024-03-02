# API Specification

## Create Product

Request :
- Method : POST
- Endpoint : `/api/products`
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
    "id" : "id product, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer"
}
```

- Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```

## Get Product

Request :
- Method : GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept : application/json
- Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```

## Update Product

Request :
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
    "name" : "string",
    "price" : "long",
    "quantity" : "integer"
}
```

- Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "id product, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```

## List Product

Request :
- Method : Get
- Endpoint : `/api/products`
- Header :
    - Accept : application/json
- Query Params :
  - size : number,
  - page : number
- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "id": "id product, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "id product, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}

```
## Delete Product

Request :
- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept : application/json
- Response :

```json
{
  "code" : "number",
  "status" : "string"
}

```