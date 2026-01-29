package leetcode.P1694_ReformatPhoneNumber;

public class Solution {
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c))
                digits.append(c);
        }

        StringBuilder res = new StringBuilder();
        int n = digits.length();
        int i = 0;

        while (n - i > 4) {
            res.append(digits.substring(i, i + 3)).append("-");
            i += 3;
        }

        int remaining = n - i;
        if (remaining == 4) {
            res.append(digits.substring(i, i + 2)).append("-");
            res.append(digits.substring(i + 2, i + 4));
        } else {
            res.append(digits.substring(i, n));
        }

        return res.toString();
    }
}
