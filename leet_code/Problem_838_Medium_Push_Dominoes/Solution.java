package leet_code.Problem_838_Medium_Push_Dominoes;

public class Solution {

    /**
     * Determines the final state of pushed dominoes.
     * Strategy: Calculate "forces" from both directions and find the net force.
     * Time: O(N), Space: O(N).
     */
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        // forces[i] represents net force at index i. Positive for R, negative for L.
        int[] forces = new int[n];

        // Pass 1: Scan Left to Right to find rightward force
        int currentForce = 0;
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                currentForce = n;
            } else if (c == 'L') {
                currentForce = 0;
            } else {
                currentForce = Math.max(currentForce - 1, 0);
            }
            forces[i] += currentForce;
        }

        // Pass 2: Scan Right to Left to find leftward force
        currentForce = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                currentForce = n;
            } else if (c == 'R') {
                currentForce = 0;
            } else {
                currentForce = Math.max(currentForce - 1, 0);
            }
            forces[i] -= currentForce;
        }

        // Translate net forces back to characters
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0)
                result.append('R');
            else if (f < 0)
                result.append('L');
            else
                result.append('.');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.pushDominoes("RR.L")); // RR.L
        System.out.println("Result 2: " + sol.pushDominoes(".L.R...LR..L..")); // LL.RR.LLRRLL..
    }
}
