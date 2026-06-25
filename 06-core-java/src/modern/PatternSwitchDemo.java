package modern;

// Exercise 30 — Pattern Matching for switch (Java 21)
public class PatternSwitchDemo {
    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer with value " + i;
            case String s  -> "String of length " + s.length();
            case Double d  -> "Double with value " + d;
            case null      -> "It is null";
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        Object[] items = { 42, "hello", 3.14, true, null };
        for (Object o : items) {
            System.out.println(describe(o));
        }
    }
}
