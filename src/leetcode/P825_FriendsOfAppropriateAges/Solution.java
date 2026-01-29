package leetcode.P825_FriendsOfAppropriateAges;

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for (int a : ages)
            counts[a]++;

        int requests = 0;
        for (int x = 1; x <= 120; x++) {
            if (counts[x] == 0)
                continue;
            for (int y = 1; y <= 120; y++) {
                if (counts[y] == 0)
                    continue;

                // Condition simplified: y must be in (0.5x + 7, x]
                if (y <= 0.5 * x + 7)
                    continue;
                if (y > x)
                    continue;
                if (y > 100 && x < 100)
                    continue;

                requests += counts[x] * counts[y];
                if (x == y)
                    requests -= counts[x]; // Can't send request to yourself
            }
        }
        return requests;
    }
}
