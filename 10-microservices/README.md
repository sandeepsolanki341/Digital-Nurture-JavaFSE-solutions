# 10 — Microservices (Spring Boot 3 + Spring Cloud)

Splitting a monolith into independent Spring Cloud microservices: REST services, Eureka
service discovery, and a Spring Cloud Gateway with a global logging filter.

Built with **Spring Boot 3.2 / Java 17 / Spring Cloud 2023.0.x**.

## Projects

| Project | Port | Role |
|---------|------|------|
| [`eureka-discovery-server`](./eureka-discovery-server) | 8761 | Eureka service registry (`@EnableEurekaServer`) |
| [`account`](./account) | 8080 | `GET /accounts/{number}` — dummy account, registers with Eureka |
| [`loan`](./loan) | 8081 | `GET /loans/{number}` — dummy loan, registers with Eureka |
| [`greet-service`](./greet-service) | 8080 | `GET /greet` → "Hello World!!", registers with Eureka |
| [`api-gateway`](./api-gateway) | 9090 | Spring Cloud Gateway, discovery-locator routing + global `LogFilter` |

> `account` and `greet-service` both default to 8080 — run them in separate exercises,
> or override `server.port`. They come from two different hands-on flows in the doc.

## Run order
1. `cd eureka-discovery-server && mvn spring-boot:run` → open http://localhost:8761
2. Start `account` (and `loan` on 8081) — they appear under *Instances currently registered with Eureka*.
3. For the gateway flow: start `greet-service`, then `api-gateway`.

## Try it
```bash
# direct
curl http://localhost:8080/accounts/00987987973432
curl http://localhost:8081/loans/H00987987972342
curl http://localhost:8080/greet

# through the gateway (discovery-locator routes by lower-cased service id)
curl http://localhost:9090/greet-service/greet
# api-gateway console logs: ====>Request URL http://localhost:9090/greet-service/greet
```

## Exercise mapping

| Doc | Covered by |
|-----|-----------|
| Composite handson — account & loan microservices | `account`, `loan` |
| Composite handson — Eureka discovery + registration | `eureka-discovery-server` + eureka-client in each service |
| Composite handson — API Gateway + global filter | `greet-service`, `api-gateway` (`LogFilter`) |

## Reference exercises (theory / partial snippets)

The remaining source docs are sample/reference exercises whose solutions are code
fragments rather than complete runnable projects. They are captured in
[`reference-exercises.md`](./reference-exercises.md) so the guidance isn't lost:

- **Microservices with Spring Boot 3** — User/Order (WebClient/OpenFeign), Inventory + Config Server, API Gateway rate-limiting, Resilience4j circuit breaker.
- **Edge Services & API Gateway** — routing/filtering, `RandomLoadBalancer`, Resilience4j in the gateway.
- **Centralized Auth & SSO** — OAuth 2.1/OIDC login, authorization/resource servers, JWT.

These target the same Boot 3 / Spring Cloud stack as the projects above; the snippets
in `reference-exercises.md` drop into a gateway or security project as shown.
