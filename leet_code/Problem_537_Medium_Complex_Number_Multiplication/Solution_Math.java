package leet_code.Problem_537_Medium_Complex_Number_Multiplication;

public class Solution_Math {

    /**
     * Multiplies complex numbers.
     * Strategy: Parse "real+imaginaryi". Apply (ac-bd) + (ad+bc)i.
     * Time: O(1), Space: O(1).
     */
    public String complexNumberMultiply(String num1, String num2) {
        int[] part1 = parse(num1);
        int[] part2 = parse(num2);

        int a = part1[0];
        int b = part1[1];
        int c = part2[0];
        int d = part2[1];

        // (a + bi)(c + di) = ac + adi + bci + bidi = (ac - bd) + (ad + bc)i
        int real = a * c - b * d;
        int imag = a * d + b * c;

        return real + "+" + imag + "i";
    }

    private int[] parse(String s) {
        // Format: "int+inti"
        String[] parts = s.split("\\+");
        int real = Integer.parseInt(parts[0]);
        int imag = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
        return new int[] { real, imag };
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        System.out.println("Result: " + solution.complexNumberMultiply("1+1i", "1+1i")); // "0+2i"
    }
}
