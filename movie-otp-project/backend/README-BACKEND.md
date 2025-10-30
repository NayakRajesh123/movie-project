# Movie OTP Backend (Spring Boot)

## Quick start (demo with H2 in-memory DB)
1. Install JDK 17+ and Maven.
2. Open terminal in `backend` folder.
3. Run: `mvn spring-boot:run`
4. H2 console available at: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:movieapp)

## Twilio SMS
- By default Twilio credentials are empty; the app prints OTP to console for demo.
- To enable real SMS, set `twilio.accountSid`, `twilio.authToken`, and `twilio.phoneNumber` in `application.properties`.

## Oracle
- To use Oracle, update `application-oracle.properties` with credentials and run with:
  `mvn spring-boot:run -Dspring-boot.run.profiles=oracle`
