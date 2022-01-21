# Order-api server

### swagger
http://localhost:9095/swagger-ui/index.html

### zipkin 
http://localhost:9411/zipkin/

### mongo express
http://localhost:9081

--- 
### example:

```
    curl -X 'POST' \
  'http://localhost:9096/v1/orders' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "userInfo": {
    "userUuid": "1231",
    "time": "2022-01-21T17:21:42.172Z",
    "token": "dsd"
  },
  "skiPassId": "string",
  "rentType": "FULL_BOARD",
  "equipmentUuids": [
    "sdfsdf2f", "131dsadas"
  ],
  "timeStamp": "2022-01-21T17:21:42.172Z"
}'
```