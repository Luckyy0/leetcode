package leet_code.Problem_481_Medium_Magical_String;

public class Solution_Constructive {

    /**
     * Counts '1's in the first n numbers of the magical string.
     * Strategy: Generate the string using an array and two pointers.
     * Time: O(N), Space: O(N).
     */
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1; // "1" -> 1, "12" -> 1, "122" -> 1

        int[] s = new int[n + 1]; // +1 buffer for safety
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2; // Pointer to the number indicating count
        int tail = 3; // Pointer to append new numbers
        int numOnes = 1; // Already have '1' at index 0
        int nextChar = 1; // Next char to append (alternates 1 and 2)

        // "122" already set. Head points to s[2]=2.
        // It means append two '1's.

        while (tail < n) {
            int count = s[head]; // How many copies to add

            for (int i = 0; i < count && tail < n; i++) {
                s[tail] = nextChar;
                if (nextChar == 1)
                    numOnes++;
                tail++;
            }

            // Toggle next char
            nextChar = (nextChar == 1) ? 2 : 1;
            head++;
        }

        return numOnes;
    }

    public static void main(String[] args) {
        Solution_Constructive solution = new Solution_Constructive();
        System.out.println("Result (6): " + solution.magicalString(6)); // 3
        System.out.println("Result (1): " + solution.magicalString(1)); // 1
    }
}
