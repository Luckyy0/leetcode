# Analysis for Convert Sorted List to Binary Search Tree
# *Phân tích cho bài toán Chuyển Đổi Danh Sách Đã Sắp Xếp Thành Cây Tìm Kiếm Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Head of a singly linked list, sorted ascending. *Đầu của một danh sách liên kết đơn, được sắp xếp tăng dần.*
*   **Output:** Root of a height-balanced BST. *Gốc của một cây BST cân bằng chiều cao.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Linked List vs Array:** Unlike an array, a linked list doesn't support $O(1)$ random access. Finding the middle element takes $O(N)$ time. *Danh sách liên kết so với Mảng: Không giống như mảng, danh sách liên kết không hỗ trợ truy cập ngẫu nhiên $O(1)$. Việc tìm phần tử ở giữa mất $O(N)$ thời gian.*
*   **Height-Balanced:** Same as Problem 108, we must pick the middle element as the root. *Cân bằng chiều cao: Giống như bài 108, chúng ta phải chọn phần tử ở giữa làm gốc.*
*   **Node Count:** Up to $2 \cdot 10^4$. Efficiency is important. *Số lượng nút lên tới $2 \cdot 10^4$. Hiệu quả là rất quan trọng.*

---

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach 1: Fast & Slow Pointers (Recursive)
*   **Logic:** Use two pointers (slow and fast) to find the middle of the linked list. The slow pointer moves one step while the fast pointer moves two. When fast reaches the end, slow is at the middle.
*   **Issue:** Each recursive step takes $O(N)$ to find the middle, leading to $O(N \log N)$ total time.

### Approach 2: Inorder Simulation (Optimized)
### *Hướng tiếp cận 2: Mô phỏng Thứ tự giữa (Tối ưu hóa)*

*   **Logic:**
    1.  Count the total number of nodes in the list.
    2.  The inorder traversal of a BST visits nodes in the exact same order as they appear in the sorted linked list.
    3.  We can build the tree structure recursively without picking the root first. Instead, we build the left subtree, then use the current linked list node for the root, and then build the right subtree.
    4.  We keep a global/instance pointer to the current linked list node and advance it as we "consume" nodes for the tree.

*   **Algorithm Steps:**
    1.  Calculate `size` of the linked list.
    2.  Define `helper(n)` which builds a BST using the first `n` nodes of the current list.
    3.  In `helper(n)`:
        *   If `n <= 0`, return `null`.
        *   `left = helper(n / 2)`.
        *   Create `root = new TreeNode(head.val)`.
        *   `root.left = left`.
        *   `head = head.next` (Advance the list pointer).
        *   `root.right = helper(n - n / 2 - 1)`.
        *   Return `root`.

*   **Complexity:**
    *   **Time Complexity:** $O(N)$. We traverse the list once to count and once to build. *Độ phức tạp thời gian: $O(N)$. Chúng ta duyệt danh sách một lần để đếm và một lần để xây dựng.*
    *   **Space Complexity:** $O(\log N)$ for the recursion stack. *Độ phức tạp không gian: $O(\log N)$ cho ngăn xếp đệ quy.*

---

## 3. Dry Run
## *3. Chạy thử*

**Input:** `head = [-10, -3, 0, 5, 9]`, `size = 5`.

1.  `build(5)`:
    -   `left = build(2)`:
        -   `left = build(1)`:
            -   `left = build(0) -> null`.
            -   `root = -10`, `head = -3`.
            -   `right = build(0) -> null`.
            -   Return `-10` node.
        -   `root = -3`, `head = 0`.
        -   `right = build(0) -> null`.
        -   Return node `-3` with left `-10`.
    -   `root = 0`, `head = 5`.
    -   `right = build(2)`:
        -   ... (similarly builds `5` as root and `9` as right child).
    -   Return node `0` with left tree `-3(-10)` and right tree `5(9)`.

**Resulting Tree:**
```
      0
     / \
   -3   5
   /     \
 -10      9
```

---

## 4. Key Takeaway
## *4. Điểm mấu chốt*
*   **Inorder Property:** Using the inorder traversal sequence ($O(N)$) avoids the multiple $O(N)$ searches for the middle element, making it more efficient than the fast/slow pointer method for linked lists. *Đặc điểm của Thứ tự giữa: Sử dụng chuỗi duyệt theo thứ tự giữa ($O(N)$) tránh được việc tìm kiếm phần tử giữa nhiều lần, giúp nó hiệu quả hơn phương pháp con trỏ nhanh/chậm đối với danh sách liên kết.*
*   **Global Pointer:** Keeping track of the current list node is essential for the inorder simulation. *Việc theo dõi nút hiện tại của danh sách là rất quan trọng cho việc mô phỏng thứ tự giữa.*
