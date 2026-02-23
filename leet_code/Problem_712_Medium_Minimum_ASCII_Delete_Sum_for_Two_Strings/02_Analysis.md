# Analysis for Minimum ASCII Delete Sum for Two Strings
# *Phân tích cho bài toán Tổng ASCII nhỏ nhất khi xóa ký tự của Hai chuỗi*

## 1. Problem Essence & Variation of LCS
## *1. Bản chất vấn đề & Biến thể của LCS*

### The Challenge
### *Thách thức*
This problem is a variation of the Longest Common Subsequence (LCS) problem. Instead of maximizing the length of the common subsequence, we want to maximize the **ASCII sum** of the common subsequence, or equivalently, minimize the ASCII sum of the characters we remove.
*Bài toán này là một biến thể của bài toán Chuỗi con chung dài nhất (LCS). Thay vì tối đa hóa độ dài, chúng ta muốn tối đa hóa **tổng mã ASCII** của chuỗi con chung, hoặc tương đương là tối thiểu hóa tổng ASCII của các ký tự bị xóa.*

---

## 2. Strategy: 2-Dimensional Dynamic Programming
## *2. Chiến lược: Quy hoạch động 2 chiều*

### State Definition
### *Định nghĩa trạng thái*
Let `dp[i][j]` be the minimum ASCII sum of deleted characters to make `s1.substring(0, i)` and `s2.substring(0, j)` equal.
*Gọi `dp[i][j]` là tổng ASCII tối thiểu của các ký tự cần xóa để làm cho tiền tố độ dài `i` của `s1` và tiền tố độ dài `j` của `s2` bằng nhau.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Base Cases:**
    - `dp[0][0] = 0` (Two empty strings are already equal).
    - `dp[i][0] = dp[i-1][0] + s1[i-1]` (To match `s1[0...i-1]` with an empty string, we must delete all characters in `s1`).
    - `dp[0][j] = dp[0][j-1] + s2[j-1]` (To match an empty string with `s2[0...j-1]`, we must delete all characters in `s2`).
    * **Trường hợp cơ sở:** Nếu một chuỗi rỗng, ta phải xóa toàn bộ chuỗi còn lại.*

2.  **Transitions:**
    - If `s1[i-1] == s2[j-1]`:
        - `dp[i][j] = dp[i-1][j-1]` (No characters need to be deleted for this match).
    - If `s1[i-1] != s2[j-1]`:
        - `dp[i][j] = min(dp[i-1][j] + s1[i-1], dp[i][j-1] + s2[j-1])` (We either delete the character from `s1` or from `s2` and pick the cheaper option).
    * **Chuyển trạng thái:** Nếu ký tự khớp, không tốn phí. Nếu không khớp, ta chọn xóa từ `s1` hoặc `s2` sao cho tổng phí là nhỏ nhất.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M, N$ are lengths of the strings. We fill an $M \times N$ matrix.
    * **Độ phức tạp thời gian:** $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ to store the DP table. Can be optimized to $O(N)$ since each row only depends on the previous row.
    * **Độ phức tạp không gian:** $O(M \times N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**s1 = "sea", s2 = "eat"**
1. Empty prefix row/col: `dp[i][0]` and `dp[0][j]` accumulate ASCII of 's', 'se', 'sea' and 'e', 'ea', 'eat'.
2. Process 's' and 'e': Mismatch. `dp[1][1] = min(dp[0][1]+'s', dp[1][0]+'e')`.
3. Process 'e' and 'e': Match! `dp[2][1] = dp[1][0]`.
4. Final answer at `dp[3][3]`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

When a problem asks for "minimum cost to make equal" and involves two strings, think about the Edit Distance or LCS structure. Using ASCII values as the "weight" in a weighted LCS DP is the most robust approach.
*Khi bài toán yêu cầu "phí tối thiểu để làm bằng nhau" giữa hai chuỗi, hãy nghĩ đến cấu trúc của Edit Distance hoặc LCS. Sử dụng mã ASCII làm "trọng số" trong DP là cách tiếp cận chuẩn xác nhất.*
---
*Giá trị của một sự tương đồng (Equality) đôi khi được đo bằng những gì ta sẵn lòng từ bỏ (Deleted sum). Trong dòng chảy của các ký tự (Strings), sự hy sinh tối thiểu (Minimum ASCII) dẫn lối tới sự hòa hợp tối đa. Dữ liệu dạy ta rằng bằng cách cân nhắc từng sự khác biệt (Mismatch) và ghi nhớ lộ trình tối ưu (DP), ta có thể tìm thấy tiếng nói chung giữa những thực thể dường như xa lạ.*
The value of a similarity (Equality) is sometimes measured by what we are willing to give up (Deleted sum). In the flow of characters (Strings), minimal sacrifice (Minimum ASCII) leads to maximum harmony. Data teaches us that by weighing every difference (Mismatch) and remembering the optimal path (DP), we can find common ground between seemingly alien entities.
