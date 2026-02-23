# Analysis for Intersection of Two Arrays
# *Phân tích cho bài toán Giao của Hai Mảng*

## 1. Problem Essence & Set Intersection
## *1. Bản chất vấn đề & Giao của Tập hợp*

### The Challenge
### *Thách thức*
Find all unique common elements between two arrays. The result must contain each common element only once.

### Strategy: Two Sets
### *Chiến lược: Hai Tập hợp*
1.  Convert the first array `nums1` into a `HashSet` to store its unique elements. This allows $O(1)$ lookups.
2.  Iterate through the second array `nums2`. For each element, check if it exists in the set from `nums1`.
3.  If it exists, add it to a *second* `HashSet` (to ensure the intersection elements are unique).
4.  Convert the second set into an array and return.

### Strategic Variation: Sort + Two Pointers
### *Biến thể chiến lược: Sắp xếp + Hai con trỏ*
If the arrays are sorted (or we sort them), we can use two pointers to find common elements in $O(N \log N)$ or $O(N+M)$ if pre-sorted, while handling uniqueness by comparing with the previously added element.

---

## 2. Approach: HashSet
## *2. Hướng tiếp cận: HashSet*

### Logic
### *Logic*
Using `HashSet` is the most straightforward and efficient approach for unsorted arrays within the given constraints.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N + M) Time:** Linear time complexity on average.
    *Thời gian O(N + M): Độ phức tạp thời gian tuyến tính trung bình.*
*   **Intuitive:** Directly maps to the mathematical concept of set intersection.
    *Trực quan: Liên kết trực tiếp với khái niệm toán học về giao của hai tập hợp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$ average, where N and M are lengths of `nums1` and `nums2`.
    *Độ phức tạp thời gian: $O(N + M)$.*
*   **Space Complexity:** $O(min(N, M))$ to store the unique elements.
    *Độ phức tạp không gian: $O(min(N, M))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums1 = [4,9,5], nums2 = [9,4,9,8,4]`
1.  **Set1 (from nums1):** {4, 9, 5}
2.  **Iterate nums2:**
    - 9: In Set1? Yes. Add to IntersectionSet: {9}
    - 4: In Set1? Yes. Add to IntersectionSet: {9, 4}
    - 9: In Set1? Yes. Add to IntersectionSet: {9, 4} (already exists)
    - 8: In Set1? No.
    - 4: In Set1? Yes. Add to IntersectionSet: {9, 4} (already exists)
3.  **Result:** [9, 4]

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashSet for optimal speed.
*Sử dụng HashSet để đạt tốc độ tối ưu.*
---
*Điểm chung giữa hai con đường (arrays) đôi khi chỉ là những dấu chân hiếm hoi. Tìm kiếm giao điểm (intersection) là cách chúng ta tìm thấy sự đồng điệu trong sự khác biệt.*
The common point between two paths (arrays) is sometimes just rare footprints. Finding the intersection is how we find resonance in difference.
