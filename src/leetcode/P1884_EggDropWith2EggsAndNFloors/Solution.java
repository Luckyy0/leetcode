package leetcode.P1884_EggDropWith2EggsAndNFloors;

public class Solution {
    public int twoEggDrop(int n) {
        int moves = 0;
        int maxFloors = 0;
        while (maxFloors < n) {
            moves++;
            maxFloors += moves;
        }
        return moves;
    }
}
