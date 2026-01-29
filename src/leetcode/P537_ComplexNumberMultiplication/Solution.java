package leetcode.P537_ComplexNumberMultiplication;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse num1 = "real1+imaginary1i"
        // Phân tích num1
        String[] parts1 = num1.split("\\+");
        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1].substring(0, parts1[1].length() - 1));

        // Parse num2 = "real2+imaginary2i"
        // Phân tích num2
        String[] parts2 = num2.split("\\+");
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1].substring(0, parts2[1].length() - 1));

        // Multiplication formula: (a+bi)(c+di) = (ac - bd) + (ad + bc)i
        // Công thức nhân: (a+bi)(c+di) = (ac - bd) + (ad + bc)i
        int real = a * c - b * d;
        int imaginary = a * d + b * c;

        return real + "+" + imaginary + "i";
    }
}
