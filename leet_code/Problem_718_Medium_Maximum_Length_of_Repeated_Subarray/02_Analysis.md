# Analysis for Maximum Length of Repeated Subarray
# *Phân tích cho bài toán Độ dài lớn nhất của Mảng con lặp lại*

## 1. Problem Essence & Longest Common Substring
## *1. Bản chất vấn đề & Chuỗi con chung dài nhất*

### The Challenge
### *Thách thức*
We are looking for the longest contiguous sequence that appears in both arrays. This is exactly the same as the "Longest Common Substring" problem, but applied to arrays instead of strings. 
*Chúng ta đang tìm dãy con liên tục dài nhất xuất hiện ở cả hai mảng. Đây chính là bài toán "Chuỗi con chung dài nhất", nhưng áp dụng cho mảng thay vì chuỗi.*

---

## 2. Strategy: 2D Dynamic Programming
## *2. Chiến lược: Quy hoạch động 2 chiều*

### State Definition
### *Định nghĩa trạng thái*
Let `dp[i][j]` be the length of the longest common suffix of `nums1[0...i-1]` and `nums2[0...j-1]`.
*Gọi `dp[i][j]` là độ dài của hậu tố chung dài nhất của các tiền tố `nums1` độ dài `i` và `nums2` độ dài `j`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** Create a table `dp` of size `(M+1) x (N+1)` filled with zeros.
    * **Khởi tạo:** Tạo bảng DP với kích thước lớn hơn 1 đơn vị.*

2.  **Transitions:**
    - Iterate through each pair $(i, j)$.
    - If `nums1[i-1] == nums2[j-1]`:
        - `dp[i][j] = dp[i-1][j-1] + 1`.
        - Update the global maximum `ans`.
    - If they don't match, `dp[i][j] = 0` (The continuity is broken).
    * **Chuyển trạng thái:** Nếu hai phần tử bằng nhau, ta lấy kết quả của cặp phần tử trước đó cộng thêm 1. Nếu không bằng nhau, ta gán về 0 để đánh dấu sự đứt gãy.*

3.  **Result:** The maximum value across the entire `dp` table is our answer.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Contiguity:** Unlike the "Longest Common Subsequence" where elements don't have to be adjacent, here the transition `dp[i][j] = 0` for mismatch enforces contiguity.
    * **Tính liên tục:** Khác với LCS (dãy con chung), ở đây khi không khớp ta phải gán về 0 để đảm bảo các phần tử phải nằm cạnh nhau.*
*   **Space Optimization:** We only need the previous row to calculate the current row, so we could optimize space to $O(N)$.
    * **Tối ưu không gian:** Có thể tối ưu xuống mảng 1 chiều.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M, N$ are matrix dimensions.
    * **Độ phức tạp thời gian:** $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ for the full DP table.
    * **Độ phức tạp không gian:** $O(M \times N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**nums1 = [1, 2], nums2 = [1, 2, 3]**
1. dp[1][1]: '1' == '1'. `dp[1][1] = 0 + 1 = 1`. ans = 1.
2. dp[2][2]: '2' == '2'. `dp[2][2] = dp[1][1] + 1 = 2`. ans = 2.
3. dp[2][3]: '2' != '3'. `dp[2][3] = 0`.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Longest Common Pattern" problems, DP is the most reliable approach. If constraints were much larger (e.g., $10^5$), we would use Binary Search + Rolling Hash or Suffix Automata. For $N=1000$, standard DP is optimal.
*Đối với các bài toán về "Mẫu chung dài nhất", DP là cách tiếp cận đáng tin cậy nhất. Với $N=1000$, DP chuẩn là tối ưu.*
---
*Sự lặp lại (Repetition) là nhịp điệu của dữ liệu. Trong hành trình tìm kiếm sự đồng nhất (Repeated subarray), mỗi bước khớp (Match) là một sự tích lũy của sức mạnh, và mỗi sự khác biệt (Mismatch) là một khởi đầu mới từ con số không. Dữ liệu dạy ta rằng bằng cách ghi lại dòng chảy của sự tương đồng (DP table), ta có thể nhận diện được những cấu trúc bền bãi nhất trong sự biến thiên của các dải số.*
Repetition (Repetition) is the rhythm of data. In the journey to find identity (Repeated subarray), each step of matching (Match) is an accumulation of strength, and each difference (Mismatch) is a new beginning from zero. Data teaches us that by recording the flow of similarity (DP table), we can identify the most persistent structures in the variation of number strips.
