# Analysis for Maximum Sum of 3 Non-Overlapping Subarrays
# *Phân tích cho bài toán Tổng Cực đại của 3 Mảng con không Gối nhau*

## 1. Problem Essence & Middle-Anchored Strategy
## *1. Bản chất vấn đề & Chiến lược Neo ở giữa*

### The Challenge
### *Thách thức*
We need to select three segments of length $K$ that do not overlap and have the highest total sum. Since trying all combinations of three indices would be $O(N^3)$, we need a more efficient way to scan the array.
*Chúng ta cần chọn ba đoạn có độ dài $K$ không gối nhau và có tổng cao nhất. Vì việc thử tất cả các kết hợp sẽ tốn $O(N^3)$, chúng ta cần một cách duyệt mảng hiệu quả hơn.*

---

## 2. Strategy: Precomputed Best Neighbors
## *2. Chiến lược: Tính toán trước các Lân cận Tốt nhất*

The key is to iterate through every possible **middle** subarray and, for each one, instantly know the best possible **left** and **right** subarrays that do not overlap with it.
*Chìa khóa là duyệt qua mọi mảng con **ở giữa** khả thi, và với mỗi mảng đó, biết ngay được mảng con **bên trái** và **bên phải** tốt nhất không gối với nó.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Window Sums:** Calculate the sum of every window of size $K$. Let `sums[i]` be the sum of `nums[i...i+k-1]`.
    * **Tổng cửa sổ:** Tính tổng của mọi cửa sổ kích thước $K$.*

2.  **Left Best:** Create an array `left[i]` which stores the index of the window with the maximum sum in the range `[0, i]`.
    - `left[i]` is either `left[i-1]` or `i`.
    * **Bên trái Tốt nhất:** Tạo mảng `left[i]` lưu chỉ số của cửa sổ có tổng cực đại trong phạm vi `[0, i]`.*

3.  **Right Best:** Create an array `right[i]` which stores the index of the window with the maximum sum in the range `[i, end]`.
    - `right[i]` is either `right[i+1]` or `i`.
    * **Bên phải Tốt nhất:** Tạo mảng `right[i]` lưu chỉ số của cửa sổ có tổng cực đại trong phạm vi `[i, cuối]`.*

4.  **Enumerate Middle:** Iterate `j` from $k$ to $n-2k$:
    - The middle window is `sums[j]`.
    - The best left window is at `sums[left[j-k]]`.
    - The best right window is at `sums[right[j+k]]`.
    - Keep track of the triple that gives the maximum total.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Lexicographical Smallest:** When updating `leftBest`, use `>=` for the comparison if you want the first occurrence (smallest index). When updating `rightBest`, we iterate backwards. The logic ensures we pick the earliest indices for a given sum.
    * **Thứ tự từ điển nhỏ nhất:** Khi cập nhật `leftBest`, ta ưu tiên chỉ số nhỏ hơn nếu tổng bằng nhau.*
*   **Linear Pass:** After precomputing, the final search is $O(N)$, making the entire algorithm $O(N)$.
    * **Duyệt tuyến tính:** Toàn bộ thuật toán tốn $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We make a few linear passes over the array.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store window sums and the `left/right` index arrays.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**nums = [1,2,1,2,6,7,5,1], k = 2**
1. `sums`: [3, 3, 3, 8, 13, 12, 6] (Sums of [1,2], [2,1], [1,2], [2,6], [6,7], [7,5], [5,1]).
2. `left`: [0, 0, 0, 3, 4, 4, 4] (Best index so far from left).
3. `right`: [4, 4, 4, 4, 4, 5, 6] (Best index so far from right).
4. `j = 3` (Middle): Left [0], Mid [3], Right [5]. Sum: 3 + 8 + 12 = 23.
**Result:** [0, 3, 5].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For problems asking for multiple non-overlapping segments, try to anchor one segment (usually the middle one) and use precomputation (Prefix/Suffix Max) to find the others in $O(1)$. This prevents nested loops and simplifies the optimization logic.
*Đối với các bài toán yêu cầu nhiều đoạn không gối nhau, hãy thử "neo" một đoạn (thường là đoạn ở giữa) và sử dụng tính toán trước (Tiền tố/Hậu tố Max) để tìm các đoạn khác.*
---
*Sự tối ưu (Optimization) đôi khi không nằm ở việc tìm kiếm mọi ngóc ngách, mà ở việc chuẩn bị sẵn sàng (Precomputation). Trong bài toán của 3 mảng con (3 Subarrays), mảng ở giữa là cầu nối (Middle anchor) gắn kết quá khứ tốt nhất (Left best) và tương lai rực rỡ nhất (Right best). Dữ liệu dạy ta rằng bằng cách thấu thị cả hai phía (Prefix/Suffix scans), ta có thể tìm thấy sự kết hợp hoàn hảo nhất trong một dòng chảy duy nhất của thời gian.*
Optimization (Optimization) sometimes is not in searching every corner, but in being ready (Precomputation). In the problem of 3 subarrays (3 Subarrays), the middle array is the bridge (Middle anchor) connecting the best past (Left best) and the brightest future (Right best). Data teaches us that by understanding both sides (Prefix/Suffix scans), we can find the most perfect combination in a single flow of time.
