package advanced;

// Exercise 37 — Using javap to inspect bytecode
// Compile, then run:  javap -c advanced.JavapDemo
public class JavapDemo {
    public int addOne(int x) {
        int y = x + 1;
        return y;
    }

    public static void main(String[] args) {
        System.out.println(new JavapDemo().addOne(41));
        System.out.println("Now run: javap -c advanced.JavapDemo");
    }
}
