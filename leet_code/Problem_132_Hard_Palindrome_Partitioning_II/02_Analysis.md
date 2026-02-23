# Analysis for Palindrome Partitioning II
# *Phân tích cho bài toán Phân Tách Chuỗi Đối Xứng II*

## 1. Problem Essence & Optimization Goal
## *1. Bản Chất Vấn Đề & Mục Tiêu Tối Ưu Hóa*

### Minimum vs. All
### *Tối Thiểu so với Tất Cả*
*   In Part I (131), we needed to return *all* possible partitions. That was an exploration problem (Backtracking).
    *Trong Phần I (131), chúng ta cần trả về *tất cả* các phép phân tách có thể có. Đó là một bài toán khám phá (Quay lui).*
*   In Part II (132), we only need the *minimum* number of cuts. This is an optimization problem, which strongly suggests **Dynamic Programming**.
    *Trong Phần II (132), chúng ta chỉ cần số lần cắt *tối thiểu*. Đây là một bài toán tối ưu hóa, gợi ý mạnh mẽ về **Quy hoạch động (DP)**.*

### State Definition
### *Định Nghĩa Trạng Thái*
*   Let `minCuts[i]` be the minimum cuts needed for the prefix `s[0...i]`.
    *Gọi `minCuts[i]` là số lần cắt tối thiểu cần thiết cho tiền tố `s[0...i]`.*
*   Our final answer will be `minCuts[n-1]`.
    *Câu trả lời cuối cùng của chúng ta sẽ là `minCuts[n-1]`.*

---

## 2. Approach: Double Dynamic Programming
## *2. Hướng Tiếp Cận: Quy Hoạch Động Kép*

To compute `minCuts[i]` efficiently, we need a fast way to check if a substring is a palindrome.
*Để tính toán `minCuts[i]` hiệu quả, chúng ta cần một cách nhanh chóng để kiểm tra xem một chuỗi con có phải là đối xứng hay không.*

### Step 1: Palindrome Table
### *Bước 1: Bảng Chuỗi Đối Xứng*
Build a 2D boolean array `isPal[i][j]` where `isPal[i][j]` is true if `s[i...j]` is a palindrome.
*Xây dựng mảng boolean 2 chiều `isPal[i][j]` trong đó `isPal[i][j]` là đúng nếu `s[i...j]` là đối xứng.*
-   Base case: `isPal[i][i] = true`.
-   Transition: `isPal[i][j] = (s[i] == s[j]) && (j - i <= 2 || isPal[i+1][j-1])`.

### Step 2: Min Cuts Calculation
### *Bước 2: Tính Toán Số Lần Cắt Tối Thiểu*
Iterate through the string from `i = 0` to `n-1`:
1.  Initialize `minCuts[i]` to `i` (the maximum possible cuts: each character separately).
    *Khởi tạo `minCuts[i]` bằng `i` (số lần cắt tối đa: mỗi ký tự riêng biệt).*
2.  If `isPal[0][i]` is true, `minCuts[i] = 0` (no cuts needed for the entire prefix).
    *Nếu `isPal[0][i]` đúng, `minCuts[i] = 0` (không cần cắt cho toàn bộ tiền tố).*
3.  Otherwise, iterate `j` from `1` up to `i`:
    -   If `s[j...i]` is a palindrome (`isPal[j][i]`), then we can split the string at `j`.
        *Nếu `s[j...i]` là đối xứng (`isPal[j][i]`), chúng ta có thể tách chuỗi tại `j`.*
    -   `minCuts[i] = min(minCuts[i], minCuts[j-1] + 1)`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. We have two nested loops to build the `isPal` table and two nested loops to compute the `minCuts` array.
    *Độ phức tạp thời gian: $O(N^2)$. Chúng ta có hai vòng lặp lồng nhau để xây dựng bảng `isPal` và hai vòng lặp lồng nhau để tính toán mảng `minCuts`.*
*   **Space Complexity:** $O(N^2)$. This is dominated by the `isPal` boolean matrix.
    *Độ phức tạp không gian: $O(N^2)$. Điều này bị chiếm ưu thế bởi ma trận boolean `isPal`.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

**Input:** `s = "aab"`

-   `i = 0` ("a"): `isPal[0][0]` is true. `minCuts[0] = 0`.
-   `i = 1` ("aa"): `isPal[0][1]` is true. `minCuts[1] = 0`.
-   `i = 2` ("aab"): 
    -   `isPal[0][2]` is false.
    -   Try `j = 1`: `s[1...2]` ("ab") is not pal.
    -   Try `j = 2`: `s[2...2]` ("b") is pal. `minCuts[2] = min(inf, minCuts[1] + 1) = 1`.

**Result:** 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This is a classic variation of the 1D DP problem (similar to Word Break). The key difference is the addition of the 2D palindrome preprocessing. Without the precomputed table, the time complexity would degrade to $O(N^3)$. Understanding how to nest one DP within another is a vital skill for "Hard" level algorithmic challenges.
*Đây là một biến thể kinh điển của bài toán DP 1 chiều (tương tự như Word Break). Sự khác biệt chính là việc thêm bước tiền xử lý đối xứng 2 chiều. Nếu không có bảng tính toán trước, độ phức tạp thời gian sẽ giảm xuống $O(N^3)$. Hiểu cách lồng một giải pháp DP vào một giải pháp khác là một kỹ năng quan trọng cho các thử thách thuật toán cấp độ "Khó".*
---
*Đôi khi việc biết khi nào nên dừng lại và chia nhỏ vấn đề là cách hiệu quả nhất để tiết kiệm chi phí.*
Sometimes knowing when to stop and break down the problem is the most effective way to save costs.
