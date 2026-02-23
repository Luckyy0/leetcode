package leet_code.Problem_299_Medium_Bulls_And_Cows;

public class Solution_Counting {

    /**
     * Calculates hint for Bulls and Cows.
     * Uses counting array (Histogram).
     * Time: O(N), Space: O(1) (size 10 array).
     * 
     * Tính toán gợi ý cho Bò và Cựu.
     * Sử dụng mảng đếm (Histogram).
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];

        // Pass 1: Count Bulls and populate frequency of non-bull secret digits
        // Lượt 1: Đếm Bò và điền tần suất các chữ số bí mật không phải bò
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
                numbers[s]++;
            }
        }

        // Pass 2: Count Cows based on frequency
        // Lượt 2: Đếm Cựu dựa trên tần suất
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s != g) {
                // If the guess digit exists in the secret (count > 0)
                // Nếu chữ số dự đoán tồn tại trong bí mật (số lượng > 0)
                if (numbers[g] > 0) {
                    cows++;
                    numbers[g]--;
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution_Counting solution = new Solution_Counting();

        // Test Case 1: "1807", "7810" -> "1A3B"
        System.out.println("Hint 1: " + solution.getHint("1807", "7810"));

        // Test Case 2: "1123", "0111" -> "1A1B"
        System.out.println("Hint 2: " + solution.getHint("1123", "0111"));
    }
}
