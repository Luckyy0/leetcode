package leetcode.P1176_DietPlanPerformance;

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += calories[i];
        }

        if (currentSum < lower)
            points--;
        else if (currentSum > upper)
            points++;

        for (int i = k; i < calories.length; i++) {
            currentSum += calories[i];
            currentSum -= calories[i - k];

            if (currentSum < lower)
                points--;
            else if (currentSum > upper)
                points++;
        }

        return points;
    }
}
