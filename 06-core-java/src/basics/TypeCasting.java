package basics;

// Exercise 7 — Type Casting
public class TypeCasting {
    public static void main(String[] args) {
        double d = 9.78;
        int i = (int) d;              // narrowing (explicit)
        System.out.println("double " + d + " -> int " + i);

        int n = 5;
        double back = n;              // widening (implicit)
        System.out.println("int " + n + " -> double " + back);
    }
}
