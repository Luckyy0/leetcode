package leet_code.Problem_374_Easy_Guess_Number_Higher_or_Lower;

/**
 * Mocking the Guess Game API.
 */
class GuessGame {
    private int pick;

    public void setPick(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        if (num > pick)
            return -1;
        if (num < pick)
            return 1;
        return 0;
    }
}

public class Solution_BinarySearch extends GuessGame {

    /**
     * Guesses the picked number.
     * Uses Binary Search.
     * Time: O(log N), Space: O(1).
     * 
     * Đoán con số đã chọn.
     * Sử dụng Tìm kiếm Nhị phân.
     */
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res == 1)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();
        solution.setPick(6);
        System.out.println("Picked: 6, Found: " + solution.guessNumber(10));
    }
}
