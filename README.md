# GenC Full-Stack Exercises — Local Community Event Portal

Hands-on exercises completed as part of the **Cognizant GenC / NURTURE** full-stack training track.
All front-end and database modules share a single running theme — a **Local Community Event Portal**
that lets residents browse events, register, leave feedback, and access resources.

---

## Modules

| # | Module | Topic | Exercises | Status |
|---|--------|-------|-----------|--------|
| 01 | [HTML5](./01-html5) | Semantic markup, forms, media, storage, geolocation | 10 | 🔲 |
| 02 | [CSS3](./02-css3) | Selectors, box model, typography, responsive design | 11 | 🔲 |
| 03 | [JavaScript](./03-javascript) | Core JS, DOM, async, ES6+, forms, fetch | 14 | 🔲 |
| 04 | [Bootstrap 5](./04-bootstrap5) | Grid, components, utilities, plugins, Sass | 19 | 🔲 |
| 05 | [ANSI SQL (MySQL)](./05-sql-mysql) | Schema design, joins, aggregation, subqueries | 25 | 🔲 |
| 06 | [Core Java](./06-core-java) | Fundamentals → OOP → collections → concurrency → JDBC | 41 | 🔲 |

> Update the **Status** column as you complete each module: 🔲 not started · 🚧 in progress · ✅ done.

---

## Repository structure

```
genc-fullstack-exercises/
├── 01-html5/            one folder per exercise (ex01 … ex10), each self-contained
├── 02-css3/             one folder per exercise (ex01 … ex11)
├── 03-javascript/       one folder per exercise (ex01 … ex14)
├── 04-bootstrap5/       one folder per exercise (ex01 … ex19)
├── 05-sql-mysql/        schema.sql + seed.sql + solutions/q01 … q25
└── 06-core-java/        src/ grouped by topic (basics, oop, io, …)
```

Each module has its own `README.md` restating the exercise prompts and linking to the solution files.

---

## Getting started

### Front-end modules (01–04)
No build step needed for most exercises — open the `index.html` in a browser:

```bash
# from any exercise folder
open index.html        # macOS
start index.html       # Windows
xdg-open index.html    # Linux
```

For a smoother experience use the **VS Code Live Server** extension.
Bootstrap exercise 19 (Sass) requires Node — see `04-bootstrap5/ex19-sass-customization/README.md`.

### SQL module (05)
```bash
mysql -u root -p < 05-sql-mysql/schema.sql
mysql -u root -p < 05-sql-mysql/seed.sql
# then run any solution
mysql -u root -p event_portal < 05-sql-mysql/solutions/q01-user-upcoming-events.sql
```

### Java module (06)
Requires **JDK 21** (uses records, pattern-matching switch, and virtual threads).
```bash
cd 06-core-java
javac -d out src/basics/HelloWorld.java
java -cp out HelloWorld
```
JDBC exercises (31–33) need a running MySQL instance and the Connector/J jar on the classpath —
see `06-core-java/README.md`.

---

## Conventions

- **Exercise numbering** (`ex01`, `q01`) is zero-padded and maps 1:1 to the official exercise lists.
- **Self-contained exercises** — each front-end exercise folder runs on its own.
- **Commit per exercise** where practical, e.g. `feat(html5): ex05 registration form`.

---

## Tech stack

HTML5 · CSS3 · JavaScript (ES6+) · jQuery · Bootstrap 5 · MySQL 8 · Java 21 · JDBC

---

*Training project. Sample data is intentionally small; some SQL exercises specify thresholds
(e.g. "≥ 10 feedback submissions") that the seed data won't satisfy — queries are written correctly
against the schema regardless, with notes where relevant.*
