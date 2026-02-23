# Analysis for Minimum Distance Between BST Nodes
# *Phân tích cho bài toán Khoảng cách Tối thiểu Giữa các Nút BST*

## 1. Problem Essence & In-Order Traversal
## *1. Bản chất vấn đề & Duyệt Trung thứ tự (In-Order Traversal)*

### The Challenge
### *Thách thức*
In a BST, the in-order traversal yields sorted values.
The minimum difference between any two nodes must occur between **adjacent** values in the sorted sequence.
*Trong BST, việc duyệt trung thứ tự (in-order) sẽ tạo ra các giá trị đã được sắp xếp. Khoảng cách tối thiểu giữa bất kỳ hai nút nào nhất định phải xảy ra giữa các giá trị **liền kề** trong chuỗi đã sắp xếp.*

---

## 2. Strategy: Recursive In-Order
## *2. Chiến lược: Đệ quy Trung thứ tự*

### Algorithm
### *Thuật toán*

1.  **Traversal:** Standard In-Order (Left, Root, Right).
2.  **Tracking:** Keep track of the `prev` (previous) value visited.
3.  **Update Min:** `minDiff = Math.min(minDiff, root.val - prev)`.
4.  **Initial State:** `prev` starts as null (or negative infinity).
    *   **Duyệt:** Trung thứ tự chuẩn (Trái, Gốc, Phải). **Theo dõi:** Giữ lại giá trị `prev` đã thăm. **Cập nhật Min:** So sánh `val - prev` với `minDiff`.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
Integer prev = null;
int minDiff = Integer.MAX_VALUE;

public int minDiffInBST(TreeNode root) {
    inOrder(root);
    return minDiff;
}

void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(node.left);
    
    if (prev != null) {
        minDiff = Math.min(minDiff, node.val - prev);
    }
    prev = node.val;
    
    inOrder(node.right);
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit every node once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$ for recursion stack.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Tree:** `[4, 2, 6, 1, 3]`
1. Visit 1. Prev=null. Set Prev=1.
2. Visit 2. Diff=2-1=1. Min=1. Set Prev=2.
3. Visit 3. Diff=3-2=1. Min=1. Set Prev=3.
4. Visit 4. Diff=4-3=1. Min=1. Set Prev=4.
5. Visit 6. Diff=6-4=2. Min=1. Set Prev=6.
**Result:** 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Standard in-order traversal is the canonical solution for BST sorted property problems.
*Duyệt trung thứ tự chuẩn là giải pháp kinh điển cho các bài toán liên quan đến tính chất sắp xếp của BST.*
