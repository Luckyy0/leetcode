# Analysis for Leaf-Similar Trees
# *Phân tích cho bài toán Cây có Lá Tương tự*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Determine if two binary trees have the exact same sequence of leaf values when traversed from left to right.
*Xác định xem hai cây nhị phân có cùng một dãy các giá trị lá khi được duyệt từ trái sang phải hay không.*

---

## 2. Strategy: Depth-First Search (DFS)
## *2. Chiến lược: Tìm kiếm theo chiều sâu (DFS)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Extract Leaf Sequence:** Create a helper function `getLeaves(node, list)` that performs a DFS (specifically, a preorder or inorder traversal works fine).
    - If a node is a leaf (`left == null && right == null`), add its value to the list.
    - Otherwise, recursively visit `left` then `right`.
    *   **Trích xuất dãy lá:** Tạo hàm trợ giúp `getLeaves` thực hiện duyệt DFS. Nếu một nút là lá, hãy thêm giá trị của nó vào danh sách. Nếu không, hãy duyệt trái rồi duyệt phải một cách đệ quy.*

2.  **Compare Lists:**
    - Run the function for `root1` and `root2` to get two lists.
    - Check if the lists are equal using `List.equals()`.
    *   **So sánh Danh sách:** Chạy hàm cho `root1` và `root2` để lấy hai danh sách. Kiểm tra xem các danh sách có bằng nhau hay không.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList<>();
    List<Integer> leaves2 = new ArrayList<>();
    collectLeaves(root1, leaves1);
    collectLeaves(root2, leaves2);
    return leaves1.equals(leaves2);
}

private void collectLeaves(TreeNode node, List<Integer> leaves) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
        leaves.add(node.val);
        return;
    }
    collectLeaves(node.left, leaves);
    collectLeaves(node.right, leaves);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N_1 + N_2)$, where $N_1$ and $N_2$ are the number of nodes in the two trees. We visit every node once.
    *   **Độ phức tạp thời gian:** $O(N_1 + N_2)$, vì chúng ta ghé thăm mỗi nút một lần.*
*   **Space Complexity:** $O(L_1 + L_2)$, where $L$ is the number of leaves, to store the sequences. The recursion stack also takes $O(H)$ space.
    *   **Độ phức tạp không gian:** $O(L_1 + L_2)$ để lưu trữ các dãy lá. Ngăn xếp đệ quy cũng tốn $O(H)$ không gian.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple DFS is sufficient for trees of this size (up to 200 nodes).
*DFS đơn giản là đủ cho các cây có kích thước này (tối đa 200 nút).*
