package leetcode.P1227_AirplaneSeatAssignmentProbability;

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
}
