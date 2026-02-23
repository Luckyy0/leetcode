# Analysis for Minimum Absolute Difference in BST
# *Phân tích cho bài toán Hiệu Tuyệt đối Nhỏ nhất trong BST*

## 1. Problem Essence & Sorted Property
## *1. Bản chất vấn đề & Tính chất Đã sắp xếp*

### The Challenge
### *Thách thức*
Finding min difference between any two nodes.
- Naïve: Compare all pairs -> $O(N^2)$.
- BST Property: In-order traversal yields sorted values.
- In a sorted array, min difference must occur between adjacent elements.

### Strategy: In-order Traversal
### *Chiến lược: Duyệt Trung thứ tự*

1.  **Traverse:** `Left -> Node -> Right`.
2.  **Track:** Maintain `prev` value.
3.  **Update:** `minDiff = min(minDiff, val - prev)`.

---

## 2. Approach: In-order DFS
## *2. Hướng tiếp cận: DFS Trung thứ tự*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Time:** $O(N)$.
    *Thời gian tuyến tính: $O(N)$.*
*   **No Extra List:** Just `prev` pointer.
    *Không danh sách phụ: Chỉ cần con trỏ `prev`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[4, 2, 6, 1, 3]`
Tree:
      4
    /   \
   2     6
  / \
 1   3

Inorder: `1, 2, 3, 4, 6`.
- 1: prev=null.
- 2: diff=1. min=1. prev=2.
- 3: diff=1. min=1. prev=3.
- 4: diff=1. min=1. prev=4.
- 6: diff=2. min=1. prev=6.
Result: 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In-order traversal to compare adjacent values.
*Duyệt trung thứ tự để so sánh giá trị liền kề.*
---
*Trong trật tự (sorted order), khoảng cách gần nhất (min difference) luôn nằm giữa những người hàng xóm. Không cần tìm kiếm xa xôi, chỉ cần nhìn sang người đứng ngay cạnh mình (adjacent) để thấy sự tương đồng hoặc khác biệt nhỏ nhất.*
In order (Sorted Order), the closest distance (Min Difference) is always between neighbors. No need to search far away, just look at the person standing right next to you (Adjacent) to see the smallest similarity or difference.
