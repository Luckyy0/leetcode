package basic_code;

public class Roman_To_Integer_3 {
    public static class Roman {
        public int getRomanValue(char c) {
            return switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        }


        public int romanToInt(String s) {
            int res = 0;
            int size = s.length();
            int pre = getRomanValue(s.charAt(0));
            int current = pre;
            for (int i = 1; i < size; i++) {
                current = getRomanValue(s.charAt(i));
                res += pre < current ? -pre : pre;
                pre = current;
            }
            return res + current;
        }
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        Roman roman = new Roman();
        System.out.println(roman.romanToInt(s));
    }
}
