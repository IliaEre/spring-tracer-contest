echo create equipment...
curl -X 'POST' -vv \
  'http://localhost:6001/v1/equipment' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "uuid": "123123123123123",
    "code": "`1`",
    "name": "stri1ng",
    "size": "1",
    "quality": "good"
  }' 
echo create one more...
curl -X 'POST' -vv \
  'http://localhost:6001/v1/equipment' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "uuid": "34534534534534534",
    "code": "2",
    "name": "2",
    "size": "2",
    "quality": "good"
  }' 

echo create order...
    curl -X 'POST' \
  'http://localhost:6002/v1/orders' \
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
    "123123123123123", "34534534534534534"
  ],
  "timeStamp": "2022-01-21T17:21:42.172Z"
}'

echo "that's all =)"