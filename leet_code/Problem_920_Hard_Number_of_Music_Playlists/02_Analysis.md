# Analysis for Number of Music Playlists
# *Phân tích cho bài toán Số lượng Danh sách Phát nhạc*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Select `goal` songs from `n` available songs such that:
1. Every song is used at least once.
2. No song repeats until `k` other songs have played (distance > k).
*Chọn `goal` bài hát từ `n` bài hát sao cho: 1. Mỗi bài hát được dùng ít nhất một lần. 2. Không bài hát nào lặp lại cho đến khi `k` bài khác đã được phát.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a Dynamic Programming problem.
- State: `dp[i][j]` = number of playlists of length `i` using exactly `j` unique songs.
- Our target is `dp[goal][n]`.
- Transitions when building playlist of length `i` using `j` songs:
  1. **Add a new song (never used before):**
     - We pick from the remaining `n - (j - 1)` unused songs.
     - Previous state: `dp[i-1][j-1]`.
     - Ways: `dp[i-1][j-1] * (n - (j-1))`.
  2. **Replay an existing song:**
     - We can pick any of the `j` songs already used.
     - BUT, we can only pick a song if it hasn't been played in the last `k` turns.
     - This means there are $k$ restricted songs (the last $k$ songs in the playlist).
     - So we can pick from the `j` used songs minus the `k` restricted ones.
     - Available choices: `j - k` (if `j > k`).
     - Previous state: `dp[i-1][j]`.
     - Ways: `dp[i-1][j] * (j - k)`.
*Đây là bài toán Quy hoạch động. Trạng thái `dp[i][j]` là số playlist độ dài `i` dùng `j` bài khác nhau. Khi thêm bài thứ `i`: 1. Thêm bài mới: chọn từ `n - (j-1)` bài chưa dùng. 2. Dùng lại bài cũ: chọn từ `j - k` bài hợp lệ.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch Động*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize DP:** `dp[goal + 1][n + 1]`. `dp[0][0] = 1`.
    *   **Khởi tạo DP:** `dp` kích thước `(goal+1) x (n+1)`. `dp[0][0] = 1`.*

2.  **Iterate:** `i` from 1 to `goal`. `j` from 1 to `n`.
    - `dp[i][j] = dp[i-1][j-1] * (n - (j-1))`. (Add new song)
    - If `j > k`: `dp[i][j] += dp[i-1][j] * (j - k)`. (Replay song)
    - Take modulo.
    *   **Duyệt:** Tính `dp[i][j]` từ `dp[i-1][j-1]` và `dp[i-1][j]`.*

3.  **Return:** `dp[goal][n]`.
    *   **Trả về:** `dp[goal][n]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numMusicPlaylists(int n, int goal, int k) {
    long MOD = 1_000_000_007;
    long[][] dp = new long[goal + 1][n + 1];
    
    dp[0][0] = 1;
    
    for (int i = 1; i <= goal; i++) {
        for (int j = 1; j <= n; j++) {
            // Case 1: Play a new song
            // We choose one of the (n - (j - 1)) unused songs
            // Previous state: length i-1, unique songs j-1
            dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % MOD;
            
            // Case 2: Replay an old song
            // We can choose from the j unique songs used, but cannot choose the last k songs
            // So we have (j - k) options
            // Previous state: length i-1, unique songs j
            if (j > k) {
                long replayWays = (dp[i - 1][j] * (j - k)) % MOD;
                dp[i][j] = (dp[i][j] + replayWays) % MOD;
            }
        }
    }
    
    return (int) dp[goal][n];
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(goal \times n)$. Nested loops.
    *   **Độ phức tạp thời gian:** $O(goal \times n)$.*
*   **Space Complexity:** $O(goal \times n)$. Can assume $O(n)$ with space optimization (only need previous row).
    *   **Độ phức tạp không gian:** $O(goal \times n)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Straightforward DP counting problem. Key logic is distinguishing between adding a new song vs replaying an old song under constraints.
*Bài toán đếm DP trực tiếp. Logic chính là phân biệt giữa việc thêm bài mới và phát lại bài cũ dưới các ràng buộc.*
