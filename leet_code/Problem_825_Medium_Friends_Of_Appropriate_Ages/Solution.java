package leet_code.Problem_825_Medium_Friends_Of_Appropriate_Ages;

public class Solution {

    /**
     * Calculates the total number of friend requests.
     * Strategy: Use the small age range (1-120). Count people per age and iterate
     * age pairs.
     * Time: O(N + 120^2), Space: O(1) extra.
     */
    public int numFriendRequests(int[] ages) {
        // Step 1: Count frequency of each age
        int[] ageCounts = new int[121];
        for (int age : ages) {
            ageCounts[age]++;
        }

        int totalRequests = 0;

        // Step 2: Iterate through all pairs of ages (ageX -> ageY)
        for (int ageX = 1; ageX <= 120; ageX++) {
            if (ageCounts[ageX] == 0)
                continue;

            for (int ageY = 1; ageY <= 120; ageY++) {
                if (ageCounts[ageY] == 0)
                    continue;

                // If x sends request to y based on the condition logic
                if (canSendRequest(ageX, ageY)) {
                    if (ageX == ageY) {
                        // All people of ageX can send to all other people of ageX
                        totalRequests += ageCounts[ageX] * (ageCounts[ageX] - 1);
                    } else {
                        // Each person of ageX can send to all people of ageY
                        totalRequests += ageCounts[ageX] * ageCounts[ageY];
                    }
                }
            }
        }

        return totalRequests;
    }

    /**
     * Rejection Logic: Returns TRUE if x can send a request to y.
     */
    private boolean canSendRequest(int ageX, int ageY) {
        // Rejection conditions:
        if (ageY <= 0.5 * ageX + 7)
            return false;
        if (ageY > ageX)
            return false;
        if (ageY > 100 && ageX < 100)
            return false;

        // Also note: ageY <= ageX implies !(ageY > 100 && ageX < 100)
        // because if ageY > 100 and ageX < 100, then ageY > ageX.

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a1 = { 16, 16 };
        System.out.println("Result 1: " + sol.numFriendRequests(a1)); // 2

        int[] a2 = { 16, 17, 18 };
        System.out.println("Result 2: " + sol.numFriendRequests(a2)); // 2

        int[] a3 = { 20, 30, 100, 110, 120 };
        System.out.println("Result 3: " + sol.numFriendRequests(a3)); // 3
    }
}
