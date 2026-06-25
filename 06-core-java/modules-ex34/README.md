# Exercise 34 — Java Platform Module System (JPMS)

Two modules: `com.utils` exports a utility class that `com.greetings` consumes.

## Compile
```bash
javac -d out/com.utils \
    com.utils/module-info.java com.utils/com/utils/StringUtil.java
javac --module-path out -d out/com.greetings \
    com.greetings/module-info.java com.greetings/com/greetings/Main.java
```

## Run
```bash
java --module-path out -m com.greetings/com.greetings.Main
# -> HELLO MODULES!
```
