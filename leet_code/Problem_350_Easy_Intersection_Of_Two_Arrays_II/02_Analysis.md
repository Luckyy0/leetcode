# Analysis for Intersection of Two Arrays II
# *Phân tích cho bài toán Giao của Hai Mảng II*

## 1. Problem Essence & Frequency Matching
## *1. Bản chất vấn đề & Khớp Tần suất*

### The Challenge
### *Thách thức*
Find common elements between two arrays, but this time, the output should reflect the *count* of duplicates present in both. For example, if `2` appears three times in `nums1` and twice in `nums2`, it should appear twice in the result.

### Strategy 1: HashMap (Frequency Tracking)
### *Chiến lược 1: HashMap (Theo dõi Tần suất)*
1.  Store the frequencies of elements from the smaller array (say `nums1`) in a `HashMap`.
2.  Iterate through `nums2`. For each element, check if it's in the map and has a count > 0.
3.  If yes, add it to the result and decrement the count in the map.
4.  Complexity: $O(N + M)$.

### Strategy 2: Two Pointers (If Sorted)
### *Chiến lược 2: Hai Con trỏ (Nếu đã Sắp xếp)*
1.  Sort both arrays.
2.  Use two pointers `i` and `j` starting at the beginning of each array.
3.  Compare `nums1[i]` and `nums2[j]`:
    - Equal: Add to result, move both `i` and `j`.
    - `nums1[i] < nums2[j]`: Move `i`.
    - `nums1[i] > nums2[j]`: Move `j`.
4.  Complexity: $O(N \log N + M \log M)$.

---

## 2. Approach: HashMap
## *2. Hướng tiếp cận: HashMap*

### Logic
### *Logic*
(See Strategy 1 above). This is the best general-purpose approach for unsorted input.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Handling Duplicates:** Naturally handles multiple occurrences using frequency counts.
    *Xử lý trùng lặp: Tự nhiên xử lý nhiều lần xuất hiện bằng cách đếm tần suất.*
*   **Space Optimization:** We only store the map for the smaller array to save memory.
    *Tối ưu hóa không gian: Chúng ta chỉ lưu trữ bản đồ cho mảng nhỏ hơn để tiết kiệm bộ nhớ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$.
    *Độ phức tạp thời gian: $O(N + M)$.*
*   **Space Complexity:** $O(min(N, M))$.
    *Độ phức tạp không gian: $O(min(N, M))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums1 = [1,2,2,1], nums2 = [2,2]`
1.  **Map (from nums1):** {1: 2, 2: 2}
2.  **Iterate nums2:**
    - 2: In map? Yes (count 2). Add to Result: [2], Map: {1: 2, 2: 1}
    - 2: In map? Yes (count 1). Add to Result: [2, 2], Map: {1: 2, 2: 0}
3.  **Result:** [2, 2]

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap for the frequency-aware intersection.
*Sử dụng HashMap để thực hiện giao điểm có tính đến tần suất.*
---
*Mỗi tần số âm thanh (frequencies) khi hòa quyện (intersection) sẽ tạo nên một bản nhạc trọn vẹn. Thừa nhận và giữ lại sự trùng lặp (duplicates) là cách chúng ta tôn trọng sự hiện diện đầy đủ của các yếu tố trong cuộc sống.*
Each sound frequency (frequencies) when blending (intersection) will create a complete piece of music. Acknowledging and keeping duplicates (duplicates) is how we respect the full presence of elements in life.
