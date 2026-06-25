# Module 06 — Core Java

41 exercises spanning Java fundamentals through OOP, collections, concurrency, modern
language features (Java 16/21), JDBC, and JVM tooling. All code targets **JDK 21**.

## Layout

```
src/
├── basics/        ex01–11  fundamentals: I/O, conditionals, loops, recursion
├── oop/           ex12–21  overloading, classes, inheritance, interfaces, exceptions
├── io/            ex22–23  file write / read
├── collections/   ex24–25  ArrayList, HashMap
├── concurrency/   ex26,40,41  threads, virtual threads, ExecutorService
├── modern/        ex27–30  lambdas, streams, records, pattern-matching switch
├── jdbc/          ex31–33  connection, DAO, transactions
└── advanced/      ex35–39  sockets, HTTP client, javap, decompile, reflection
modules-ex34/      ex34     Java Platform Module System (separate build, has its own README)
```

## Compile & run (standard exercises)

```bash
cd 06-core-java
javac -d out $(find src -name "*.java")     # compile everything
java -cp out basics.HelloWorld              # run any class by its fully-qualified name
java -cp out modern.StreamDemo
```

Many exercises read from stdin (Scanner) — just type input when prompted.

## Exercise index

| # | Class | Topic |
|---|-------|-------|
| 01 | `basics.HelloWorld` | program structure |
| 02 | `basics.SimpleCalculator` | arithmetic, switch |
| 03 | `basics.EvenOrOdd` | modulus, ternary |
| 04 | `basics.LeapYear` | nested conditions |
| 05 | `basics.MultiplicationTable` | for loop |
| 06 | `basics.DataTypeDemo` | primitive types |
| 07 | `basics.TypeCasting` | widening / narrowing |
| 08 | `basics.OperatorPrecedence` | evaluation order |
| 09 | `basics.GradeCalculator` | if-else ladder |
| 10 | `basics.NumberGuessing` | Random, do-while |
| 11 | `basics.Factorial` | iterative loop |
| 12 | `oop.MethodOverloading` | overloading |
| 13 | `oop.RecursiveFibonacci` | recursion |
| 14 | `oop.ArraySumAverage` | arrays |
| 15 | `oop.StringReversal` | StringBuilder |
| 16 | `oop.PalindromeChecker` | string + regex |
| 17 | `oop.CarDemo` | classes & objects |
| 18 | `oop.InheritanceDemo` | inheritance, override |
| 19 | `oop.InterfaceDemo` | interfaces |
| 20 | `oop.TryCatchDemo` | exception handling |
| 21 | `oop.CustomExceptionDemo` | custom exception |
| 22 | `io.FileWriteDemo` | FileWriter |
| 23 | `io.FileReadDemo` | BufferedReader |
| 24 | `collections.ArrayListDemo` | dynamic list |
| 25 | `collections.HashMapDemo` | key-value map |
| 26 | `concurrency.ThreadDemo` | Thread |
| 27 | `modern.LambdaDemo` | lambda + sort |
| 28 | `modern.StreamDemo` | Stream filter |
| 29 | `modern.RecordDemo` | records (Java 16+) |
| 30 | `modern.PatternSwitchDemo` | pattern switch (Java 21) |
| 31 | `jdbc.JdbcConnectionDemo` | SELECT via JDBC |
| 32 | `jdbc.StudentDAO` | insert/update, PreparedStatement |
| 33 | `jdbc.TransactionDemo` | commit / rollback |
| 34 | `modules-ex34/` | JPMS modules — see its README |
| 35 | `advanced.TcpServer` / `advanced.TcpClient` | TCP sockets |
| 36 | `advanced.HttpClientDemo` | HttpClient (Java 11+) |
| 37 | `advanced.JavapDemo` | inspect bytecode with `javap -c` |
| 38 | `advanced.DecompileTarget` | decompile a `.class` |
| 39 | `advanced.ReflectionDemo` | Reflection API |
| 40 | `concurrency.VirtualThreadsDemo` | virtual threads (Java 21) |
| 41 | `concurrency.ExecutorCallableDemo` | ExecutorService + Callable |

## Notes

- **JDBC (31–33)** needs a running MySQL instance, the Connector/J jar on the classpath,
  and credentials updated in each file. Add the driver like:
  `java -cp "out:lib/mysql-connector-j.jar" jdbc.JdbcConnectionDemo`
- **TCP chat (35)** — run `TcpServer` in one terminal, then `TcpClient` in another.
- **javap (37)** — `cd out && javap -c advanced.JavapDemo`
- **HttpClient (36)** hits the public GitHub API and needs network access.
