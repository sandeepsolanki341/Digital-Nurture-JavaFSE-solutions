# 07 — Spring Core & Maven

Spring Framework fundamentals: Maven setup, the IoC container, dependency injection
(XML and annotation based), Spring AOP, and a first Spring Boot REST app.

Two projects:

| Project | Covers | Run |
|---------|--------|-----|
| [`LibraryManagement`](./LibraryManagement) | Ex 1–8 — Spring Core, XML + annotation config, DI, AOP | classic Spring, XML context |
| [`LibraryManagementBoot`](./LibraryManagementBoot) | Ex 9 — Spring Boot + Web + Data JPA + H2 | `mvn spring-boot:run` |

## Exercise map

| # | Exercise | Where |
|---|----------|-------|
| 1 | Configuring a basic Spring application | `applicationContext.xml`, `BookService`, `BookRepository` |
| 2 | Dependency injection (setter) | `applicationContext.xml` `<property>`, `BookService.setBookRepository` |
| 3 | Logging with Spring AOP | `aspect/LoggingAspect` (`@Around` execution-time log) |
| 4 | Maven project + plugins | `pom.xml` — Context/AOP/WebMVC deps, compiler plugin @ Java 1.8 |
| 5 | Configuring the Spring IoC container | `applicationContext.xml` bean definitions |
| 6 | Beans with annotations | `@Service`, `@Repository` + `<context:component-scan>` |
| 7 | Constructor & setter injection | `BookService` constructor + setter; XML `<constructor-arg>` note |
| 8 | Basic AOP (before/after advice) | `LoggingAspect` `@Before` + `<aop:aspectj-autoproxy>` |
| 9 | Spring Boot application | `LibraryManagementBoot` — `Book` entity, `BookRepository`, `BookController` |

## Run — LibraryManagement (Ex 1–8)
```bash
cd LibraryManagement
mvn compile exec:java -Dexec.mainClass=com.library.LibraryManagementApplication
```

## Run — LibraryManagementBoot (Ex 9)
```bash
cd LibraryManagementBoot
mvn spring-boot:run
# then:
curl -X POST localhost:8080/books -H "Content-Type: application/json" \
     -d '{"title":"Clean Code","author":"Robert C. Martin"}'
curl localhost:8080/books
```
