package leetcode.P1739_BuildingBoxes;

public class Solution {
    public int minimumBoxes(int n) {
        // Find max h such that tetrahedral number T(h) <= n
        // T(h) = sum(1..h) of triangular numbers
        // i-th triangular = i*(i+1)/2

        int h = 0;
        int total = 0;
        int nextLayer = 1; // Triangular number for h=1 is 1

        // Simulating adding layers
        // Using int is fine since n <= 10^9
        while (total + (h + 1) * (h + 2) / 2 <= n) {
            h++;
            total += h * (h + 1) / 2;
        }

        int area = h * (h + 1) / 2;
        int rem = n - total;

        if (rem == 0)
            return area;

        // Add partial layer
        // We need smallest j such that j*(j+1)/2 >= rem
        // Can simulate linear scan since j will be <= h+1 approx sqrt(2*rem)

        int j = 0;
        int addedCapacity = 0;
        while (addedCapacity < rem) {
            j++;
            addedCapacity += j;
        }

        return area + j;
    }
}
