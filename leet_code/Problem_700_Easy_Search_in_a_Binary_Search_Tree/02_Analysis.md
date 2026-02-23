# Analysis for Search in a Binary Search Tree
# *Phân tích cho bài toán Tìm kiếm trong Cây Nhị phân Tìm kiếm*

## 1. Problem Essence & BST Property
## *1. Bản chất vấn đề & Thuộc tính BST*

### The Challenge
### *Thách thức*
In a Binary Search Tree (BST), for any given node:
- All values in its **left subtree** are smaller than the node's value.
- All values in its **right subtree** are larger than the node's value.
Our task is to find a specific value by leveraging this sorted structure.
*Trong một Cây Nhị phân Tìm kiếm (BST), mọi nút ở cây con bên trái đều nhỏ hơn và mọi nút ở cây con bên phải đều lớn hơn nút hiện tại. Nhiệm vụ của ta là tìm một giá trị cụ thể dựa trên cấu trúc đã được sắp xếp này.*

---

## 2. Strategy: Binary Search on Tree
## *2. Chiến lược: Tìm kiếm Nhị phân trên Cây*

Similar to binary search in an array, we can discard half of the remaining branches at each step.
*Tương tự như tìm kiếm nhị phân trên mảng, ta có thể loại bỏ một nửa số nhánh tại mỗi bước.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Start at Root:** Set the current node to `root`.
2.  **Comparison Loop:** While the current node is not null:
    - If `current.val == val`: We found the target. Return the `current` node.
    - If `current.val > val`: The target must be in the left subtree. Move to `current.left`.
    - If `current.val < val`: The target must be in the right subtree. Move to `current.right`.
3.  **Failure:** If the loop ends (current becomes null), the target is not in the tree. Return `null`.
    * **Logic:** Bắt đầu từ gốc. Nếu giá trị nút hiện tại bằng `val`, trả về nút đó. Nếu lớn hơn `val`, đi sang trái. Nếu nhỏ hơn `val`, đi sang phải. Nếu không tìm thấy, trả về `null`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Iterative vs Recursive:** While recursion is intuitive, an iterative approach uses $O(1)$ additional space because it doesn't incur function call stack overhead.
    * **Lặp vs Đệ quy:** Cách tiếp cận lặp giúp tiết kiệm bộ nhớ stack ($O(1)$ thay vì $O(H)$).*
*   **Efficiency:** The search time is proportional to the height of the tree, not the total number of nodes.
    * **Hiệu suất:** Thời gian tìm kiếm tỷ lệ thuận với chiều cao của cây.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$, where $H$ is the height of the tree. In a balanced tree, this is $O(\log N)$. In the worst case (skewed tree), it is $O(N)$.
    * **Độ phức tạp thời gian:** $O(H)$ (chiều cao cây).*
*   **Space Complexity:** $O(1)$ for the iterative approach.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree: [4, 2, 7, 1, 3], val = 2**
1. Current = 4. 4 > 2, go left.
2. Current = 2. 2 == 2, found!
**Result:** Subtree starting at 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always leverage the BST property $Left < Node < Right$ to avoid checking every node. This fundamental structural property is what makes BSTs efficient for search, insertion, and deletion operations.
*Luôn tận dụng thuộc tính của BST để tránh phải kiểm tra mọi nút. Đây là tính chất cơ bản giúp BST truy vấn cực nhanh.*
---
*Sự tìm kiếm (Search) trong một trật tự (BST) là một hành trình của sự chọn lọc. Tại mỗi ngã rẽ, ta bỏ lại một nửa sự không chắc chắn (Discarding branches) để tiến gần hơn tới sự thật (Value). Dữ liệu dạy ta rằng bằng cách tuân theo quy luật của sự lớn nhỏ (Comparison), ta có thể tìm thấy đích đến giữa hàng nghìn những khả năng chỉ trong một vài bước chân.*
Searching (Search) in an order (BST) is a journey of refinement. At every fork in the road, we leave behind half of uncertainty (Discarding branches) to get closer to the truth (Value). Data teaches us that by following the rules of hierarchy (Comparison), we can find our destination among thousands of possibilities in just a few steps.
