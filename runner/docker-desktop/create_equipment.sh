curl -X 'GET' 'http://localhost:6001/v1/equipment' -vv

echo create equipment...
curl -X 'POST' -vv \
  'http://localhost:6001/v1/equipment' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "uuid": "sdfsdf2f",
    "code": "fe2",
    "name": "string",
    "size": "41",
    "quality": "good"
  }' 
