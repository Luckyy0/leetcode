# Analysis for Longest Palindromic Subsequence
# *Phân tích cho bài toán Dãy con Palindrome Dài nhất*

## 1. Problem Essence & Interval DP
## *1. Bản chất vấn đề & Quy hoạch Động trên Khoảng*

### The Challenge
### *Thách thức*
Finding length of longest subsequence (not subarray) that reads same forwards and backwards.
- Subsequence means we can skip characters.
- Palindrome property: If $s[i] == s[j]$, then $2 + LPS(i+1, j-1)$ is a candidate.

### Strategy: DP on Intervals
### *Chiến lược: DP trên Khoảng*

1.  **State:** `dp[i][j]` is LPS length for substring `s[i...j]`.
2.  **Transitions:**
    - If `s[i] == s[j]`: `dp[i][j] = 2 + dp[i+1][j-1]`.
    - If `s[i] != s[j]`: `dp[i][j] = max(dp[i+1][j], dp[i][j-1])`.
3.  **Base Cases:** `dp[i][i] = 1`.
4.  **Order:** Iterate length `len` from 2 to N. Or iterate `i` backwards, `j` forwards.

### Alternative: LCS Method
### *Phương án thay thế: Phương pháp LCS*

- LPS of `s` is equivalent to Longest Common Subsequence (LCS) between `s` and `reverse(s)`.
- LCS takes $O(N^2)$ space/time.

---

## 2. Approach: 2D DP
## *2. Hướng tiếp cận: DP 2D*

### Logic
### *Logic*
(See above). Iterate `i` from $N-1$ down to 0, `j` from `i+1` to $N-1$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Substructure:** Problem breaks down to smaller inner substrings.
    *Cấu trúc con tối ưu: Vấn đề chia nhỏ thành các chuỗi con bên trong.*
*   **Space Optimization:** Only need previous row/column, can optimize to 1D array.
    *Tối ưu hóa không gian: Chỉ cần hàng/cột trước đó, có thể tối ưu thành mảng 1D.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$.
    *Độ phức tạp thời gian: $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$. Can be $O(N)$.
    *Độ phức tạp không gian: $O(N^2)$. Có thể là $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `bbbab`
- `dp[0][0]=1`, ...
- len 2: `bb` -> 2.
- ...
- `s[0]('b') == s[4]('b')`: `2 + dp[1][3] ('bba')`.
- `dp[1][3]` is LCS of `bba` -> `bb` length 2.
- Result 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Interval DP checking outer characters.
*DP khoảng kiểm tra các ký tự bên ngoài.*
---
*Ký ức đẹp (palindrome) là thứ có thể nhìn từ đầu hay từ cuối đều vẹn nguyên ý nghĩa. Để tìm lại những hồi ức dài nhất (longest subsequence), đôi khi ta phải chấp nhận bỏ qua những mảnh vụn rời rạc (skipping chars) để nối liền những điểm tương đồng (matching extremes).*
A beautiful memory (Palindrome) is something that makes sense from the beginning or the end. To find the longest memories (Longest Subsequence), sometimes we have to accept ignoring scattered fragments (Skipping Chars) to connect similar points (Matching Extremes).
