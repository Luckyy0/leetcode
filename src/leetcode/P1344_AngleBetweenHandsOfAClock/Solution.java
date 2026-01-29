package leetcode.P1344_AngleBetweenHandsOfAClock;

class Solution {
    public double angleClock(int hour, int minutes) {
        double mAngle = minutes * 6.0;
        double hAngle = (hour % 12) * 30.0 + minutes * 0.5;

        double diff = Math.abs(mAngle - hAngle);
        return Math.min(diff, 360.0 - diff);
    }
}
