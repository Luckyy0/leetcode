package leet_code.Problem_458_Hard_Poor_Pigs;

public class Solution_InformationTheory {

    /**
     * Calculates the minimum number of pigs needed.
     * Strategy: Based on Information Theory, states per pig = rounds + 1.
     * Total buckets covered = (rounds+1)^pigs.
     * Time: O(1), Space: O(1).
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1)
            return 0;

        int rounds = minutesToTest / minutesToDie;
        int states = rounds + 1;

        // We want states^pigs >= buckets
        // pigs >= log(buckets) / log(states)
        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

    public static void main(String[] args) {
        Solution_InformationTheory solution = new Solution_InformationTheory();
        System.out.println("Result (4, 15, 15): " + solution.poorPigs(4, 15, 15)); // 2
        System.out.println("Result (1000, 15, 60): " + solution.poorPigs(1000, 15, 60)); // 5
    }
}
