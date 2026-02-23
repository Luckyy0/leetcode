# Analysis for Top K Frequent Elements
# *Phân tích cho bài toán Top K Phần tử Thường xuyên nhất*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### The Challenge
### *Thách thức*
Identify the most frequent elements in sub-linear logarithmic time ($O(N)$ or $O(N \log K)$).
Standard sorting approach would take $O(N \log N)$, which the follow-up asks us to beat.

### Strategy 1: Min-PriorityQueue
### *Chiến lược 1: Hàng đợi Ưu tiên (Min-Heap)*
1.  Count frequencies using a `HashMap`.
2.  Use a Min-Heap of size `k` to store elements based on their frequency.
3.  As we iterate through the map, if the heap exceeds size `k`, pop the element with the lowest frequency.
4.  Complexity: $O(N \log K)$.

### Strategy 2: Bucket Sort (Linear Time)
### *Chiến lược 2: Sắp xếp theo Thùng (Thời gian Tuyến tính)*
1.  Count frequencies using a `HashMap`.
2.  Create an array of buckets where the index represents the frequency.
3.  Store elements in buckets according to their frequency.
4.  Iterate from the highest frequency (highest index) to gather the top `k` elements.
5.  Complexity: $O(N)$. This is the most efficient approach.

---

## 2. Approach: Bucket Sort
## *2. Hướng tiếp cận: Sắp xếp theo Thùng*

### Logic
### *Logic*
(See Strategy 2 above). Using buckets allows us to avoid sorting entirely by utilizing the fact that the maximum possible frequency is the length of the input array.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Performance:** Truly linear time complexity, ideal for large datasets.
    *Hiệu suất O(N): Độ phức tạp thời gian thực sự tuyến tính, lý tưởng cho các tập dữ liệu lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ to count frequencies, $O(N)$ to fill buckets, and $O(N)$ to collect the top `k`. Total: $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the frequency map and buckets.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** [1, 1, 1, 2, 2, 3], k=2
1.  **Freq Map:** {1: 3, 2: 2, 3: 1}
2.  **Buckets (index is frequency):**
    - Bucket[0]: []
    - Bucket[1]: [3]
    - Bucket[2]: [2]
    - Bucket[3]: [1]
    - Bucket[4..6]: []
3.  **Collect top 2:**
    - Start from index 6...
    - Index 3: Add 1. (Remaining k: 1)
    - Index 2: Add 2. (Remaining k: 0)
4.  **Result:** [1, 2]

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Bucket Sort for linear time.
*Sắp xếp theo Thùng để đạt thời gian tuyến tính.*
---
*Trong cuộc đời, không phải ai cũng quan trọng như nhau (frequencies). Để tìm ra những giá trị tinh hoa nhất (top k), chúng ta cần biết cách phân loại (buckets) và tập trung vào những gì mang lại ý nghĩa sâu sắc nhất thay vì mải mê với những điều đại trà.*
In life, not everyone is equally important (frequencies). To find the most elite values (top k), we need to know how to classify (buckets) and focus on what brings the deepest meaning instead of getting lost in the generic ones.
