package leetcode.P1419_MinimumNumberOfFrogsCroaking;

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // c, r, o, a, k
        int frogs = 0;
        int maxFrogs = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            int idx = "croak".indexOf(ch);
            if (idx == -1)
                return -1;

            if (idx == 0) { // 'c'
                count[0]++;
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            } else {
                if (count[idx - 1] > 0) {
                    count[idx - 1]--;
                    if (idx < 4)
                        count[idx]++;
                    if (idx == 4) { // 'k'
                        frogs--;
                    }
                } else {
                    return -1; // Sequence broken
                }
            }
        }

        if (frogs > 0)
            return -1; // Unfinished croaks
        return maxFrogs;
    }
}
