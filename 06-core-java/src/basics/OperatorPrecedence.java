package basics;

// Exercise 8 — Operator Precedence
public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;          // * before +  => 20
        System.out.println("10 + 5 * 2 = " + result);

        int grouped = (10 + 5) * 2;       // parentheses first => 30
        System.out.println("(10 + 5) * 2 = " + grouped);

        int mixed = 10 + 20 / 5 - 3 * 2;  // 10 + 4 - 6 => 8
        System.out.println("10 + 20 / 5 - 3 * 2 = " + mixed);
    }
}
