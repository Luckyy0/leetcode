package leetcode.P1518_WaterBottles;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            int rem = empty % numExchange;
            drunk += newFull;
            empty = newFull + rem;
        }

        return drunk;
    }
}
