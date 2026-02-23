package leet_code.Problem_423_Medium_Reconstruct_Original_Digits_from_English;

public class Solution_UniqueCount {

    /**
     * Reconstructs original digits from English words.
     * Strategy: Identify unique chars for each number.
     * Time: O(N), Space: O(1).
     * 
     * Tái cấu trúc các chữ số gốc từ các từ tiếng Anh.
     * Chiến lược: Nhận diện các ký tự duy nhất cho mỗi số.
     */
    public String originalDigits(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        int[] digitCount = new int[10];

        // Zero is identified by 'z'
        digitCount[0] = charCount['z' - 'a'];
        // Two is identified by 'w'
        digitCount[2] = charCount['w' - 'a'];
        // Four is identified by 'u'
        digitCount[4] = charCount['u' - 'a'];
        // Six is identified by 'x'
        digitCount[6] = charCount['x' - 'a'];
        // Eight is identified by 'g'
        digitCount[8] = charCount['g' - 'a'];

        // Three has 'h', but 'h' is also in 'eight'
        digitCount[3] = charCount['h' - 'a'] - digitCount[8];
        // Five has 'f', but 'f' is also in 'four'
        digitCount[5] = charCount['f' - 'a'] - digitCount[4];
        // Seven has 's', but 's' is also in 'six'
        digitCount[7] = charCount['s' - 'a'] - digitCount[6];

        // One has 'o', but 'o' is also in 0, 2, 4
        digitCount[1] = charCount['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4];
        // Nine has 'i', but 'i' is also in 5, 6, 8
        digitCount[9] = charCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int k = 0; k < digitCount[i]; k++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_UniqueCount solution = new Solution_UniqueCount();

        // Test Case 1: "owoztneoer" -> "012"
        System.out.println("Result 1: " + solution.originalDigits("owoztneoer"));

        // Test Case 2: "fviefuro" -> "45"
        System.out.println("Result 2: " + solution.originalDigits("fviefuro"));
    }
}
