<h1 align="center">🚚Inventory Control📦</h1>

## Description
🚚 Api for control of stock, Use Methods to create products in production 
example: a computer with price and verify quantity of products define product_status,
now access method GET: for request all products or use ID for request certain product,
POST: create a new product, Delete: delete product by ID, PUT: update product by breakpoint id.

🤔 Sorry, my english is not perfect!.

## Tools
- Spring / Spring boot
- Postgresql
- JDK 22
- Docker

## How To Use
```
Clone Git Repository
$ git clone
```
```
Run Docker-Compose in Project Folder
$ docker compose up
```
``Access in postman or other programming for test api or in browser``

```127.0.0.0.1:8080/ or localhost:8080/```

## Rest Methods
### GET
Use This BreakPoint to get all products.

``/product``

Use This BreakPoint to get certain product by ID.

``/product/id``
### POST
For Add product in api, use.

``/product``
### PUT
For Update certain Product by ID, use.

``/product/id``
### DELETE
And Delete product, use this.
``/product/id``

``!Remember to change Rest Method Type!``
## License

This project is under the MIT License. See the file LICENSE for more details.