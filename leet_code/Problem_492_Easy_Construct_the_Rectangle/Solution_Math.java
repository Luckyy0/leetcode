package leet_code.Problem_492_Easy_Construct_the_Rectangle;

public class Solution_Math {

    /**
     * Constructs the rectangle with minimal L - W.
     * Strategy: Iterate width from sqrt(area) downwards.
     * Time: O(sqrt(area)), Space: O(1).
     */
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (area % w != 0) {
            w--;
        }

        return new int[] { area / w, w };
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        int[] res1 = solution.constructRectangle(4);
        System.out.println("Result 4: [" + res1[0] + ", " + res1[1] + "]"); // [2, 2]

        int[] res2 = solution.constructRectangle(37);
        System.out.println("Result 37: [" + res2[0] + ", " + res2[1] + "]"); // [37, 1]
    }
}
