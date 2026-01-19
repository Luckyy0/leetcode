# 98. Validate Binary Search Tree / Kiểm Tra Cây Tìm Kiếm Nhị Phân Hợp Lệ

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).
Cho `root` của một cây nhị phân, xác định xem nó có phải là một cây tìm kiếm nhị phân (BST) hợp lệ hay không.

A **valid BST** is defined as follows:
Một **BST hợp lệ** được định nghĩa như sau:
- The left subtree of a node contains only nodes with keys **less than** the node's key.
- Cây con bên trái của một nút chỉ chứa các nút có khóa **nhỏ hơn** khóa của nút đó.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Cây con bên phải của một nút chỉ chứa các nút có khóa **lớn hơn** khóa của nút đó.
- Both the left and right subtrees must also be binary search trees.
- Cả cây con bên trái và bên phải cũng phải là cây tìm kiếm nhị phân.

### Example 1:
```text
Input: root = [2,1,3]
Output: true
```

### Example 2:
```text
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search Tree (BST) Properties / Thuộc tính của Cây Tìm Kiếm Nhị Phân

1.  **BST Ordering Property / Thuộc tính thứ tự BST**: For any node `N`:
    - All values in the left subtree of `N` are **strictly less than** `N.val`.
    - All values in the right subtree of `N` are **strictly greater than** `N.val`.
    - Tất cả giá trị trong cây con trái của `N` **nhỏ hơn** `N.val`.
    - Tất cả giá trị trong cây con phải của `N` **lớn hơn** `N.val`.

2.  **Inorder Traversal Property / Thuộc tính duyệt trung tự**: An **inorder traversal** (Left -> Root -> Right) of a valid BST produces a **strictly increasing** sequence.
    - Duyệt **trung tự** (Trái -> Gốc -> Phải) của một BST hợp lệ tạo ra một dãy **tăng nghiêm ngặt**.
    - This is a fundamental theorem used to validate BSTs.

3.  **Range Constraint Propagation / Truyền ràng buộc phạm vi**: When traversing:
    - Going **left** from node `N`: The **upper bound** becomes `N.val`.
    - Going **right** from node `N`: The **lower bound** becomes `N.val`.
    - Đi **trái** từ nút `N`: **Cận trên** trở thành `N.val`.
    - Đi **phải** từ nút `N`: **Cận dưới** trở thành `N.val`.

---

## Analysis / Phân tích

### Approach 1: Recursive Range Validation / Kiểm Tra Phạm Vi Đệ Quy
- **Idea**: Pass down valid range `(min, max)` during recursion. Each node must satisfy `min < node.val < max`.
- **Ý tưởng**: Truyền xuống phạm vi hợp lệ `(min, max)` trong quá trình đệ quy. Mỗi nút phải thỏa mãn `min < node.val < max`.
- **Algorithm**:
    ```
    isValid(node, min, max):
        if node == null: return true
        if node.val <= min or node.val >= max: return false
        return isValid(node.left, min, node.val) AND isValid(node.right, node.val, max)
    ```
- **Initial Call**: `isValid(root, -∞, +∞)`.
- **Why it works**: By narrowing the valid range at each step, we ensure that ALL descendants respect the BST property, not just the immediate children.
- **Tại sao nó hoạt động**: Bằng cách thu hẹp phạm vi hợp lệ ở mỗi bước, chúng ta đảm bảo rằng TẤT CẢ các con cháu tuân theo thuộc tính BST, không chỉ các con trực tiếp.
- **Time Complexity**: O(N) - visit each node once.
- **Space Complexity**: O(H) - recursion stack, where H is tree height.

### Approach 2: Inorder Traversal / Duyệt Trung Tự
- **Idea**: Perform inorder traversal and check if the sequence is strictly increasing.
- **Ý tưởng**: Thực hiện duyệt trung tự và kiểm tra xem dãy có tăng nghiêm ngặt hay không.
- **Algorithm**:
    ```
    prev = -∞
    inorder(node):
        if node == null: return true
        if not inorder(node.left): return false
        if node.val <= prev: return false
        prev = node.val
        return inorder(node.right)
    ```
- **Time Complexity**: O(N).
- **Space Complexity**: O(H).

### Why Approach 1 is Preferred / Tại sao Phương pháp 1 được ưu tiên
- Both have same complexity, but **Range Validation** is more intuitive for understanding BST properties.
- Early termination is natural: we stop as soon as we find a violation.
- Cả hai có cùng độ phức tạp, nhưng **Kiểm tra Phạm vi** trực quan hơn để hiểu các thuộc tính BST.
- Kết thúc sớm là tự nhiên: chúng ta dừng lại ngay khi tìm thấy vi phạm.

---

## Edge Cases / Các trường hợp biên
1.  **Single Node**: Always valid.
2.  **All Same Values**: Invalid (BST requires strict inequality).
3.  **Integer Overflow**: Use `Long.MIN_VALUE` and `Long.MAX_VALUE` for bounds, or use `Integer` objects with null for unbounded.
4.  **Left Child > Root or Right Child < Root**: Catch by range check.
5.  **Deep Violation**: e.g., `[5,4,6,null,null,3,7]` - The `3` is in the right subtree of `5` but is less than `5`. This is caught because when we go right to `6`, the lower bound becomes `5`, and `3 < 5` fails.
