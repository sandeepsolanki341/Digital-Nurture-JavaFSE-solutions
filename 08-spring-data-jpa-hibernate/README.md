# 08 — Spring Data JPA & Hibernate

ORM with Spring Data JPA and Hibernate: entities, repositories, CRUD, derived + `@Query`
methods, pagination/sorting, auditing, projections, entity relationships, HQL/JPQL,
native queries, and Criteria Query.

Two projects:

| Project | Backing | Covers |
|---------|---------|--------|
| [`orm-learn`](./orm-learn) | MySQL | The 3 `spring-data-jpa-handson` docs — Country CRUD, Stock query methods, Employee/Department/Skill relationships, HQL, native queries |
| [`EmployeeManagementSystem`](./EmployeeManagementSystem) | H2 (in-memory) | The `Spring_Data_JPA_and_Hibernate` doc — 10 exercises, REST CRUD, pagination, auditing, projections |

## orm-learn exercise map

| Doc / Hands-on | Feature | Where |
|----------------|---------|-------|
| 1 · HO1 | Quick example, `findAll` | `CountryService.getAllCountries` |
| 1 · HO5–9 | Country CRUD + search + custom exception | `CountryService`, `CountryNotFoundException` |
| 2 · HO1 | Query Methods on country (contains / order / startsWith) | `CountryRepository` |
| 2 · HO2 | Query Methods on stock (between / greater-than / top-3) | `StockRepository`, `Stock` |
| 2 · HO3 | Payroll schema + bean mapping | `Employee`, `Department`, `Skill`, `sql/03-payroll.sql` |
| 2 · HO4 | `@ManyToOne` Employee→Department | `Employee.department` |
| 2 · HO5 | `@OneToMany` Department→Employee | `Department.employeeList` |
| 2 · HO6 | `@ManyToMany` Employee↔Skill | `Employee.skillList`, `Skill.employeeList` |
| 3 · HO2 | HQL with `join fetch` | `EmployeeRepository.getAllPermanentEmployees` |
| 3 · HO4 | Aggregate (`AVG`) + `@Param` | `EmployeeRepository.getAverageSalary` |
| 3 · HO5 | Native query | `EmployeeRepository.getAllEmployeesNative` |
| 3 · HO6 | Criteria Query (concept) | see note below |

> **Criteria Query (Doc 3, HO6)** is a concept exercise — no fixed code. The dynamic-filter
> use case is documented; add a `CriteriaBuilder`-based method to `EmployeeRepository`
> (custom impl) when needed.

## EmployeeManagementSystem exercise map

| Ex | Feature | Where |
|----|---------|-------|
| 1 | Project + H2 config | `pom.xml`, `application.properties` |
| 2 | Entities + relationship | `Employee`, `Department` |
| 3 | Repositories | `EmployeeRepository`, `DepartmentRepository` |
| 4 | CRUD + REST | `EmployeeService`, `EmployeeController`, `DepartmentController` |
| 5 | Query methods + `@Query` | `EmployeeRepository.findByName`, `findByEmailDomain` |
| 6 | Pagination & sorting | `EmployeeController.getPage` (`Page`/`Pageable`) |
| 7 | Entity auditing | `@EnableJpaAuditing`, `@CreatedDate`/`@LastModifiedDate` on `Employee` |
| 8 | Projections | `EmployeeNameView`, `findByDepartmentName` |
| 9 | Data source config | `application.properties` |
| 10 | Hibernate-specific features | dialect/ddl-auto config; add Hibernate annotations as needed |

## Run — orm-learn (needs MySQL)
```bash
mysql -u root -p < orm-learn/sql/01-country.sql
mysql -u root -p < orm-learn/sql/02-stock.sql
mysql -u root -p < orm-learn/sql/03-payroll.sql
cd orm-learn && mvn spring-boot:run
```

## Run — EmployeeManagementSystem (H2, no external DB)
```bash
cd EmployeeManagementSystem && mvn spring-boot:run
# H2 console: http://localhost:8080/h2-console  (jdbc:h2:mem:testdb)
curl -X POST localhost:8080/departments -H "Content-Type: application/json" -d '{"name":"Engineering"}'
curl -X POST localhost:8080/employees   -H "Content-Type: application/json" -d '{"name":"Alice","email":"alice@corp.com"}'
curl "localhost:8080/employees/page?page=0&size=5&sortBy=name"
```
