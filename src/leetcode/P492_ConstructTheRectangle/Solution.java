package leetcode.P492_ConstructTheRectangle;

public class Solution {

    /**
     * Problem 492: Construct the Rectangle
     * Approach: Search for W starting from sqrt(area) downwards
     * 
     * Time Complexity: O(sqrt(Area))
     * Space Complexity: O(1)
     */
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[] { area / w, w };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 4 -> [2, 2]
        int[] res1 = sol.constructRectangle(4);
        System.out.println("Result 1: [" + res1[0] + ", " + res1[1] + "]");

        // 37 -> [37, 1]
        int[] res2 = sol.constructRectangle(37);
        System.out.println("Result 2: [" + res2[0] + ", " + res2[1] + "]");

        // 122122 -> [427, 286]
        int[] res3 = sol.constructRectangle(122122);
        System.out.println("Result 3: [" + res3[0] + ", " + res3[1] + "]");
    }
}
