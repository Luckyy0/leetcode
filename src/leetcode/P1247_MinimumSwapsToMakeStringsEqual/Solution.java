package leetcode.P1247_MinimumSwapsToMakeStringsEqual;

class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2)
                continue;

            if (c1 == 'x')
                xy++;
            else
                yx++;
        }

        if ((xy + yx) % 2 != 0)
            return -1;

        return xy / 2 + yx / 2 + (xy % 2) * 2;
    }
}
