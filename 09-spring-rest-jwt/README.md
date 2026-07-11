# 09 — Spring REST & JWT

One `spring-learn` Spring Boot project built across five hands-on docs: Spring Core (XML
bean config), RESTful web services (GET/POST/PUT/DELETE), a Controller→Service→Dao layered
design, bean validation with a global exception handler, and JWT authentication via Spring
Security.

Single project: [`spring-learn`](./spring-learn) — runs on port **8090**.

## Exercise map

| Doc | Topic | Where |
|-----|-------|-------|
| 1 | Spring Core — SimpleDateFormat / Country beans, singleton vs prototype, country list | `SpringLearnApplication` (displayDate/Country/Countries), `date-format.xml`, `country.xml` |
| 2 | REST GET — Hello, Country, all countries, by-code, 404 exception, MockMVC | `HelloController`, `CountryIndiaController`, `CountryController`, `CountryNotFoundException` |
| 3 | Controller→Service→Dao — employees & departments from XML | `EmployeeController`/`Service`/`Dao`, `DepartmentController`/`Service`/`Dao`, `employee.xml` |
| 4 | POST/PUT/DELETE + validation + global handler | `Country`/`Employee` validation annotations, `GlobalExceptionHandler`, `EmployeeNotFoundException` |
| 5 | JWT — Spring Security, in-memory users, /authenticate, Bearer filter | `security/SecurityConfig`, `AuthenticationController`, `security/JwtAuthorizationFilter` |

## Run
```bash
cd spring-learn
mvn spring-boot:run
```

## Try it
```bash
# Doc 2 — open GET endpoints
curl http://localhost:8090/hello
curl http://localhost:8090/country
curl -u user:pwd http://localhost:8090/countries          # Doc 5: needs auth

# Doc 5 — get a JWT, then call a secured service with it
TOKEN=$(curl -s -u user:pwd http://localhost:8090/authenticate | sed 's/.*"token":"\([^"]*\)".*/\1/')
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries

# Doc 4 — validation error (code must be 2 chars)
curl -i -H 'Content-Type: application/json' -X POST \
     -d '{"code":"I","name":"India"}' http://localhost:8090/countries
```

> Spring Boot 2.7 / Java 8 — matches the docs' `WebSecurityConfigurerAdapter`,
> `javax.validation`, and `jjwt 0.9.0`. MockMVC test exercises from Doc 2/4 are
> omitted (source only, per the portfolio convention).
