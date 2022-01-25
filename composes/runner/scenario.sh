echo create equipment...
curl -X 'POST' -vv \
  'http://localhost:9095/v1/equipment' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "uuid": "sdfsdf2f",
    "code": "fe2",
    "name": "string",
    "size": "41",
    "quality": "good"
  }' 
echo create one more...
curl -X 'POST' -vv \
  'http://localhost:9095/v1/equipment' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "uuid": "131dsadas",
    "code": "12",
    "name": "string",
    "size": "string",
    "quality": "good"
  }' 

echo create order...
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

echo "that's all =)"