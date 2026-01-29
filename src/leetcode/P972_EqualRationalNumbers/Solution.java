package leetcode.P972_EqualRationalNumbers;

class Solution {
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(convertToDouble(s) - convertToDouble(t)) < 1e-12;
    }

    private double convertToDouble(String s) {
        int leftParen = s.indexOf('(');
        if (leftParen == -1)
            return Double.parseDouble(s);

        String nonRepeating = s.substring(0, leftParen);
        String repeating = s.substring(leftParen + 1, s.indexOf(')'));

        StringBuilder sb = new StringBuilder(nonRepeating);
        // Expand the repeating part enough times for double precision
        for (int i = 0; i < 20; i++)
            sb.append(repeating);
        return Double.parseDouble(sb.toString());
    }
}
