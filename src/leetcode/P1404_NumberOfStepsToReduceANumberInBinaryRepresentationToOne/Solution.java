package leetcode.P1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        int n = s.length();

        // Iterate from LSB to index 1
        for (int i = n - 1; i > 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;

            if (digit % 2 == 1) {
                // Odd: Add 1 (1 step), results in even (with carry), then divide (1 step)
                // Total 2 steps. Carry becomes 1.
                steps += 2;
                carry = 1;
            } else {
                // Even (0 or 2): Divide (1 step).
                // If 0, carry 0. If 2, carry 1.
                steps += 1;
            }
        }

        // Final bit at index 0 is always '1' (no leading zeros).
        // If carry is 1: 1+1=10 -> one more division -> 1 step.
        // If carry is 0: 1 -> done (0 steps).
        if (carry == 1)
            steps++;

        return steps;
    }
}
