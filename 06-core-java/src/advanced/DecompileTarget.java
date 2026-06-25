package advanced;

// Exercise 38 — Decompile a class file
// Compile this, then open advanced/DecompileTarget.class in JD-GUI or run:  cfr DecompileTarget.class
public class DecompileTarget {
    private final String secret = "decompile-me";

    public String reveal() {
        return secret.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(new DecompileTarget().reveal());
    }
}
