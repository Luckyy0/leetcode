package leet_code.Problem_134_Medium_Gas_Station;

public class Solution_Greedy {

    /**
     * Finds the starting gas station index to complete a circuit.
     * Uses a greedy one-pass approach in O(N) time and O(1) space.
     * 
     * Tìm chỉ số trạm xăng bắt đầu để hoàn thành một vòng lặp.
     * Sử dụng phương pháp tham lam một lần duyệt trong thời gian O(N) và không gian
     * O(1).
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // Net gas for the whole loop
        int currentGas = 0; // Current tank from startStation
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currentGas += diff;

            // If current gas drops below 0, we can't start at any previous station
            // Since starting with potentially more gas didn't work.
            // Nếu lượng xăng hiện tại giảm xuống dưới 0, chúng ta không thể bắt đầu tại bất
            // kỳ trạm nào trước đó.
            if (currentGas < 0) {
                // Try starting from the next station
                // Thử bắt đầu từ trạm tiếp theo
                startStation = i + 1;
                // Reset current tank
                // Khởi động lại bình xăng hiện tại
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, completion is impossible
        // Nếu tổng lượng xăng ít hơn tổng chi phí, việc hoàn thành là không thể
        if (totalGas < 0) {
            return -1;
        }

        return startStation;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [1,2,3,4,5], [3,4,5,1,2] -> 3
        int[] g1 = { 1, 2, 3, 4, 5 };
        int[] c1 = { 3, 4, 5, 1, 2 };
        System.out.println("Test Case 1 Start: " + solution.canCompleteCircuit(g1, c1));
        // Expected: 3

        // Test Case 2: [2,3,4], [3,4,3] -> -1
        int[] g2 = { 2, 3, 4 };
        int[] c2 = { 3, 4, 3 };
        System.out.println("Test Case 2 Start: " + solution.canCompleteCircuit(g2, c2));
        // Expected: -1
    }
}
