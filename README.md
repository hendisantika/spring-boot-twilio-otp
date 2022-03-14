# spring-boot-twilio-otp

### Things todo list:

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-twilio-otp.git`
2. Navigate to the folder: `cd spring-boot-twilio-otp`
3. Replace Twilio Credentials with your own
4. Run the application: `mvn clean spring-boot:run`
5. Import the POSTMAN Collection file

Send OTP

```shell
curl --location --request POST 'localhost:8080/api/otp' \
--header 'Content-Type: application/json' \
--data-raw '{
    "to": "+6281321411881"
}'
```

Verify OTP

```shell
curl --location --request POST 'localhost:8080/otp' \
--header 'Content-Type: application/json' \
--data-raw '{
    "otp": "789444"
}'
```
