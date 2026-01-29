package leetcode.P1103_DistributeCandiesToPeople;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0;
        int give = 1;
        while (candies > 0) {
            int amount = Math.min(give, candies);
            res[i % num_people] += amount;
            candies -= amount;
            give++;
            i++;
        }
        return res;
    }
}
