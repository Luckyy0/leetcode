package leet_code.Problem_920_Hard_Number_of_Music_Playlists;

/**
 * Problem 920: Number of Music Playlists
 * https://leetcode.com/problems/number-of-music-playlists/
 */
public class Solution {

    /**
     * Calculates the number of possible playlists.
     * Strategy: Dynamic Programming.
     * 
     * @param n    Total distinct songs.
     * @param goal Length of the playlist.
     * @param k    Minimum gap between repeating songs.
     * @return Number of playlists modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng quy hoạch động.
     *         Gọi dp[i][j] là số lượng playlist có độ dài i và chứa đúng j bài hát
     *         khác nhau.
     *         2. Để tính dp[i][j], ta xét bài hát thứ i vừa được thêm vào:
     *         - Trường hợp 1: Bài hát thứ i là một bài hát MỚI (chưa từng xuất hiện
     *         trong i-1 bài trước).
     *         Nghĩa là trước đó ta đã dùng j-1 bài khác nhau.
     *         Số cách chọn bài hát mới này là (n - (j - 1)).
     *         => dp[i][j] += dp[i-1][j-1] * (n - j + 1).
     *         - Trường hợp 2: Bài hát thứ i là một bài hát CŨ (đã xuất hiện trước
     *         đó).
     *         Nghĩa là trước đó ta đã dùng đủ j bài khác nhau.
     *         Tuy nhiên, ta không được chọn k bài gần nhất vừa phát.
     *         Số bài có thể chọn lại là (j - k). (Lưu ý chỉ khi j > k).
     *         => dp[i][j] += dp[i-1][j] * (j - k).
     *         3. Kết quả là dp[goal][n], vì ta cần playlist độ dài 'goal' và dùng
     *         đủ 'n' bài hát.
     */
    public int numMusicPlaylists(int n, int goal, int k) {
        long MOD = 1_000_000_007;
        // dp[i][j]: number of playlists of length i using exactly j unique songs
        long[][] dp = new long[goal + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= goal; i++) {
            // Can't use more unique songs than the length of the playlist (j <= i)
            // Can't use more unique songs than available (j <= n)
            for (int j = 1; j <= n && j <= i; j++) { // Optimized loop bound

                // Case 1: The i-th song is a new song.
                // We pick 1 song from the remaining (n - (j-1)) unused songs.
                long newSongWays = (dp[i - 1][j - 1] * (n - (j - 1))) % MOD;
                dp[i][j] = (dp[i][j] + newSongWays) % MOD;

                // Case 2: The i-th song is a replay of an existing song.
                // We pick 1 song from the j songs already used, excluding the last k songs.
                if (j > k) {
                    long replayWays = (dp[i - 1][j] * (j - k)) % MOD;
                    dp[i][j] = (dp[i][j] + replayWays) % MOD;
                }
            }
        }

        return (int) dp[goal][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.numMusicPlaylists(3, 3, 1)); // 6
        System.out.println("Result: " + sol.numMusicPlaylists(2, 3, 0)); // 6
        System.out.println("Result: " + sol.numMusicPlaylists(2, 3, 1)); // 2
    }
}
