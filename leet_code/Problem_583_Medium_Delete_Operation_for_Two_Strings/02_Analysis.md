# Analysis for Delete Operation for Two Strings
# *Phân tích cho bài toán Thao tác Xóa cho Hai Chuỗi*

## 1. Problem Essence & Longest Common Subsequence
## *1. Bản chất vấn đề & Chuỗi con chung Dài nhất*

### The Challenge
### *Thách thức*
We need to find the minimum number of deletions to make two strings identical.
*Chúng ta cần tìm số lần xóa tối thiểu để làm cho hai chuỗi giống hệt nhau.*

Notice that if we want to delete as few characters as possible, we must preserve as many characters as possible. The characters we preserve must form a sequence that appears in both strings in the same relative order—this is the **Longest Common Subsequence (LCS)**.
*Hãy để ý rằng nếu chúng ta muốn xóa ít ký tự nhất có thể, chúng ta phải giữ lại nhiều ký tự nhất có thể. Các ký tự chúng ta giữ lại phải tạo thành một chuỗi xuất hiện trong cả hai chuỗi theo cùng một thứ tự tương đối—đây chính là **Chuỗi con chung Dài nhất (LCS)**.*

The formula for the total deletions is:
`Total Deletions = (Length of word1 - LCS) + (Length of word2 - LCS)`
`Total Deletions = Length of word1 + Length of word2 - 2 * LCS`
*Công thức cho tổng số lần xóa là: `Tổng số lần xóa = (Độ dài word1 - LCS) + (Độ dài word2 - LCS)`*

---

## 2. Strategy: 2D Dynamic Programming (LCS Calculation)
## *2. Chiến lược: Quy hoạch động 2 chiều (Tính toán LCS)*

We use DP to find the length of the Longest Common Subsequence between `word1` and `word2`.
*Chúng ta sử dụng Quy hoạch động để tìm độ dài của Chuỗi con chung Dài nhất giữa `word1` và `word2`.*

### DP State
### *Trạng thái DP*
`dp[i][j]`: The length of the LCS for the prefixes `word1[0...i-1]` and `word2[0...j-1]`.
*`dp[i][j]`: Độ dài của LCS cho các tiền tố `word1[0...i-1]` và `word2[0...j-1]`.*

### Transition Logic
### *Logic Chuyển trạng thái*
- **If `word1[i-1] == word2[j-1]`:** The current character can be part of the LCS.
- * **Nếu `word1[i-1] == word2[j-1]`:** Ký tự hiện tại có thể là một phần của LCS.*
  `dp[i][j] = dp[i-1][j-1] + 1`
- **If `word1[i-1] != word2[j-1]`:** The current characters don't match, so we take the best result from skipping either the character in `word1` or `word2`.
- * **Nếu `word1[i-1] != word2[j-1]`:** Các ký tự hiện tại không khớp, vì vậy chúng ta lấy kết quả tốt nhất từ việc bỏ qua ký tự trong `word1` hoặc `word2`.*
  `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Complementary Relationship:** This problem is a beautiful example of how a distance problem (deletions) can be transformed into a similarity problem (LCS).
    * **Mối quan hệ bổ trợ:** Bài toán này là một ví dụ đẹp đẽ về việc một bài toán khoảng cách (số lần xóa) có thể được chuyển đổi thành bài toán về sự tương đồng (LCS).*
*   **Space Optimization:** Since `dp[i]` only depends on `dp[i-1]`, we can reduce the space complexity from $O(M \times N)$ to $O(N)$ using a 1D array.
    * **Tối ưu hóa không gian:** Vì `dp[i]` chỉ phụ thuộc vào `dp[i-1]`, chúng ta có thể giảm độ phức tạp không gian từ $O(M \times N)$ xuống $O(N)$ bằng cách sử dụng mảng 1D.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M$ and $N$ are the lengths of the two strings. We fill every cell in the DP table.
    * **Độ phức tạp thời gian:** $O(M \times N)$, trong đó $M$ và $N$ là độ dài của hai chuỗi. Chúng ta lấp đầy mọi ô trong bảng DP.*
*   **Space Complexity:** $O(M \times N)$ for the 2D table, or $O(\min(M, N))$ with space optimization.
    * **Độ phức tạp không gian:** $O(M \times N)$ cho bảng 2D, hoặc $O(\min(M, N))$ với tối ưu hóa không gian.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Word1:** "sea", **Word2:** "eat"
1. `i=0, j=0`: Empty prefixes -> LCS = 0.
2. Match "e" in both: LCS increases.
3. Match "a" in both: LCS increases.
4. **Final LCS:** 2 ("ea").
5. **Total steps:** (3 - 2) + (3 - 2) = 2.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always relate string difference problems (Edit distance, deletions) to the core concepts of LCS or LCS-derived metrics for the most robust implementations.
*Luôn liên hệ các bài toán về sự khác biệt chuỗi (Khoảng cách chỉnh sửa, phép xóa) với các khái niệm cốt lõi của LCS hoặc các chỉ số bắt nguồn từ LCS để có các triển khai mạnh mẽ nhất.*
---
*Sự giống nhau (Similarity) là phần cốt lõi còn lại sau khi mọi khác biệt (Differences) đã bị loại bỏ. Để đưa hai con đường (Strings) về cùng một điểm đến chung, ta phải tìm ra những bước đi chung (LCS) dài nhất, và chấp nhận cắt bỏ (Deletions) những gì thuộc về riêng biệt.*
Similarity (Similarity) is the remaining core after all differences (Differences) have been removed. To bring two paths (Strings) to the same common destination, we must find the longest common steps (LCS), and accept cutting off (Deletions) what belongs individually.
