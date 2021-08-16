# online-retail-store-2
A sample Spring REST online store

### 1. View customers
```
curl -X GET http://localhost:8080/customers
```
Output:
```
{
  "_embedded": {
    "customerList": [
      {
        "id": 1,
        "companyName": "ABC Company",
        "address": "221B Baker St",
        "country": "United Kingdom",
        "_links": {
          "self": {
            "href": "http://localhost:8080/customers/1"
          },
          "customers": {
            "href": "http://localhost:8080/customers"
          }
        }
      },
      {
        "id": 2,
        "companyName": "DEF Company",
        "address": "742 Evergreen Terrace",
        "country": "United States of America",
        "_links": {
          "self": {
            "href": "http://localhost:8080/customers/2"
          },
          "customers": {
            "href": "http://localhost:8080/customers"
          }
        }
      },
      {
        "id": 3,
        "companyName": "XYZ Company",
        "address": "246 First St",
        "country": "Portugal",
        "_links": {
          "self": {
            "href": "http://localhost:8080/customers/3"
          },
          "customers": {
            "href": "http://localhost:8080/customers"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/customers"
    }
  }
}
```

### 2. Create a customer
```
curl -X POST localhost:8080/customers -H "Content-Type:application/json" -d '{"companyName": "XYZ Company", "address": "246 First St", "country": "Spain"}'
```
Output:
```
{"id":3,"companyName":"XYZ Company","address":"246 First St","country":"Spain"}
```

### 3. Update a customer
```
curl -X PUT localhost:8080/customers/3 -H 'Content-type:application/json' -d '{"companyName": "FGH Company", "address": "221A Baker St", "country": "Switzerland"}'
```
Output:
```
{
  "id": 3,
  "companyName": "FGH Company",
  "address": "221A Baker St",
  "country": "Switzerland"
}
```
