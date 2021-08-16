# online-retail-store-2
A sample Spring REST online store

### 1. View customers
```
curl -X GET http://localhost:8080/customers
```
Output:

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
curl -X PUT localhost:8080/customers/3 -H 'Content-type:application/json' -d '{"companyName": "XYZ Company", "address": "246 First St", "country": "Portugal"}'
```
Output:
```
{"id":3,"companyName":"XYZ Company","address":"246 First St","country":"Portugal"}
```
