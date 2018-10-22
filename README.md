# booking-jee
A simple JEE 7 application 
- To see the list of users:
curl http://localhost:8080/booking/users

- To add users:
curl -H "Content-Type: application/json" -X POST -d '{"name":"roberfroid", "firstName":"Vincent"}' http://localhost:8080/booking/users
