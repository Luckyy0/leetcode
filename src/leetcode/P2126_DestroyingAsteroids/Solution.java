package leetcode.P2126_DestroyingAsteroids;

import java.util.Arrays;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;

        for (int ast : asteroids) {
            if (currentMass >= ast) {
                currentMass += ast;
            } else {
                return false;
            }
        }
        return true;
    }
}
