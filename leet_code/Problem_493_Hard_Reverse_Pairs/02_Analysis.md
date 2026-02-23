# Analysis for Reverse Pairs
# *Phân tích cho bài toán Cặp Đảo ngược*

## 1. Problem Essence & Order Statistics
## *1. Bản chất vấn đề & Thống kê Thứ tự*

### The Challenge
### *Thách thức*
Counting pairs $(i, j)$ such that $i < j$ and $nums[i] > 2 \times nums[j]$. This is a variation of finding *inversions*, but the condition is stronger ($> 2x$ instead of $> x$).
- Brute force is $O(N^2)$, which TLEs for $N=50000$.
- We need an $O(N \log N)$ approach.

### Strategy: Merge Sort (Divide and Conquer)
### *Chiến lược: Sắp xếp Trộn (Chia để Trị)*

1.  **Merge Sort Modification:** Standard merge sort counts inversions implicitly.
2.  **Separate Counting Step:** For "reverse pairs":
    - During the merge step of two sorted subarrays `left` and `right`:
    - For each element `nums[i]` in `left`, we want to count how many `nums[j]` in `right` satisfy `nums[i] > 2L * nums[j]`.
    - Since both are sorted, we can use two pointers.
        - Iterate `i` in `left`.
        - Increment `j` in `right` while `nums[i] > 2L * nums[j]`.
        - The count for this specific `i` is `j` (since indices 0 to `j-1` in `right` satisfy the condition).
        - **Crucial:** Because `left` is sorted, as `i` increases, `nums[i]` increases, so the valid `j` range can only expand. Thus `j` never resets. This makes the counting step linear $O(N)$.
3.  **Merge Step:** After counting, perform the standard merge to keep the array sorted for the parent recursion level.

### Alternative: BIT / Segment Tree
### *Phương án thay thế: Cây BIT / Segment Tree*

- Compress values to ranks.
- Iterate array: Query BIT for count of numbers $> 2 \times current$. Update BIT with current.
- Issue: $2 \times current$ might not exist in the coordinate compression ranks directly. Need to map $2x$ to rank carefully. Merge sort is often cleaner for "inequality" relations.

---

## 2. Approach: Merge Sort
## *2. Hướng tiếp cận: Sắp xếp Trộn*

### Logic
### *Logic*
(See above).
`mergeSort(start, end)`:
- `mid = (start + end) / 2`
- `count = mergeSort(start, mid) + mergeSort(mid + 1, end)`
- `count += countPairs(start, mid, end)`
- `merge(start, mid, end)`
- return `count`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** Uses the sorted property to count in linear time at each step.
    *Hiệu quả: Sử dụng tính chất đã sắp xếp để đếm trong thời gian tuyến tính tại mỗi bước.*
*   **Stability:** Doesn't require special data structures like BIT requiring coordinate compression.
    *Tính ổn định: Không yêu cầu cấu trúc dữ liệu đặc biệt như BIT cần nén tọa độ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$. Recursive steps: $T(N) = 2T(N/2) + O(N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for the temporary merge buffer.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 3, 2, 3, 1]`
1. Split -> `[1, 3, 2]` | `[3, 1]`
   ...
   Merge `[1]` and `[3]` -> Sorted `[1, 3]`. Count 0.
   Merge `[1, 3]` and `[2]`:
     - Left `[1, 3]`, Right `[2]`.
     - 1 > 2*2? No.
     - 3 > 2*2? No.
     - Count 0. Sorted `[1, 2, 3]`.
   Merge `[3]` and `[1]` -> Left `[3]`, Right `[1]`.
     - 3 > 2*1? Yes. Count 1. Sorted `[1, 3]`.
   Merge `[1, 2, 3]` (Left) and `[1, 3]` (Right):
     - Check Left `1`: `1 > 2*Right[j]`? R[0]=1. No. `j` stays 0.
     - Check Left `2`: `2 > 2`. No. `j` stays 0.
     - Check Left `3`: `3 > 2*1`. Yes. `j` moves to 1. `3 > 2*3`? No.
     - Add `j` (which is 1) to count. Total `1 + 1 = 2`.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Modified Merge Sort to count condition before merging.
*Sắp xếp Trộn sửa đổi để đếm điều kiện trước khi trộn.*
---
*Đôi khi để tìm ra những mối quan hệ ẩn giấu (reverse pairs), ta phải sắp xếp lại trật tự thế giới (sorting). Trong quá trình hợp nhất (merge) những quan điểm khác biệt, ta có cơ hội tốt nhất để nhìn nhận rõ ràng ai lớn hơn ai gấp bội lần. Chia nhỏ vấn đề (divide) và giải quyết từng phần (conquer) chính là chiến lược tối thượng để xử lý sự phức tạp.*
Sometimes to find hidden relationships (Reverse Pairs), we have to rearrange the world order (Sorting). In the process of merging (merge) different views, we have the best opportunity to see clearly who is exponentially greater than whom. Divide (Divide) and solving each part (Conquer) is the ultimate strategy to deal with complexity.
