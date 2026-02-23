# Analysis for Binary Search Tree Iterator
# *Phân tích cho bài toán Bộ lặp cho cây tìm kiếm nhị phân*

## 1. Problem Essence & Structural Trade-offs
## *1. Bản chất vấn đề & Sự đánh đổi cấu trúc*

### Static vs. Dynamic Iteration
### *Duyệt tĩnh so với Duyệt động*
A simple way to implement this is to perform a full in-order traversal and store the nodes in a `List`. However, this requires $O(N)$ space and pre-processing time. 
*Một cách đơn giản là thực hiện duyệt thứ tự giữa đầy đủ và lưu trữ các nút trong một danh sách. Tuy nhiên, điều này yêu cầu không gian $O(N)$.*

The "professional" way is to simulate the in-order traversal dynamically using a **Stack**. This allows us to retrieve elements on-demand with $O(H)$ space (tree height), which is significantly better for large, balanced trees.
*Cách "chuyên nghiệp" là mô phỏng phép duyệt thứ tự giữa một cách động bằng **Ngăn xếp**. Điều này cho phép chúng ta truy xuất các phần tử theo yêu cầu với không gian $O(H)$.*

---

## 2. Approach: The "Push All Left" Strategy
## *2. Hướng tiếp cận: Chiến lược "Đẩy tất cả bên trái"*

To perform an in-order traversal (`Left -> Root -> Right`), we need to reach the leftmost node first.
*Để thực hiện duyệt thứ tự giữa, chúng ta cần đạt được nút ngoài cùng bên trái trước.*

### Implementation Steps
### *Các bước triển khai*
1.  **Hàm bổ trợ `pushAllLeft(node)`:** This function takes a node and pushes it and all its consecutive left children onto a `Stack`.
    *Hàm `pushAllLeft(node)`: Hàm này nhận một nút và đẩy nó cùng tất cả các con bên trái liên tiếp vào Ngăn xếp.*
2.  **Constructor:** Call `pushAllLeft(root)`. The stack now has the smallest element at the top.
3.  **`next()`:** 
    - Pop the top node `curr` from the stack.
    - If `curr` has a right child, call `pushAllLeft(curr.right)`. Why? Because after the root is visited, we must visit its entire right subtree in-order.
    - Return `curr.val`.
4.  **`hasNext()`:** Simply return `!stack.isEmpty()`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Memory Efficiency:** We only store nodes on the current "path" from the root to a leaf. This limits space to the height of the tree $O(H)$.
    *Hiệu quả bộ nhớ: Chúng ta chỉ lưu trữ các nút trên "đường đi" hiện tại từ gốc đến lá.*
*   **Average O(1) Performance:** While a single `next()` call might trigger multiple `pushAllLeft` operations, the **amortized** time complexity is $O(1)$. This is because each node in the tree is pushed and popped exactly once across all possible `next()` calls.
    *Hiệu suất O(1) trung bình: Mặc dù một lần gọi `next()` có thể kích hoạt nhiều phép toán đẩy, thời gian trung bình (amortized) vẫn là $O(1)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `next()`: $O(1)$ average (amortized), $O(H)$ worst case.
    - `hasNext()`: $O(1)$.
    *Độ phức tạp thời gian: `next()` trung bình $O(1)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree.
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:** `7 (root), left: 3, right: 15 (left: 9, right: 20)`

1.  **Init:** `Stack = [7, 3]`.
2.  **next():** Pop 3. `Stack = [7]`. Result: 3.
3.  **next():** Pop 7. 7 has right child 15.
    - Call `pushAllLeft(15)`. `Stack = [15, 9]`. Result: 7.
4.  **next():** Pop 9. `Stack = [15]`. Result: 9.
5.  **next():** Pop 15. 15 has right child 20.
    - Call `pushAllLeft(20)`. `Stack = [20]`. Result: 15.
6.  **next():** Pop 20. `Stack = []`. Result: 20.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The BST Iterator is a classic example of lazy evaluation. It shows how recursion (which uses the system stack) can be converted into an explicit stack-based state machine. This pattern is highly reusable for any tree-based data structure where memory is a concern. Always remember that the `pushAllLeft` step is the engine that drives the iteration forward.
*BST Iterator là một ví dụ kinh điển về tính toán lười biếng. Nó cho thấy cách đệ quy có thể được chuyển đổi thành một máy trạng thái dựa trên ngăn xếp tường minh. Mẫu hình này rất hữu ích cho bất kỳ cấu trúc cây nào khi bộ nhớ là một mối quan tâm. Hãy nhớ rằng bước `pushAllLeft` chính là động cơ thúc đẩy phép lặp tiến về phía trước.*
---
*Mọi sự vội vã đều dẫn đến lãng phí, nhưng bước từng bước đúng đắn sẽ giúp ta thấu hiểu cả một khu rừng chỉ với một nắm tay không gian.*
Every rush leads to waste, but taking right steps one by one will help us understand an entire forest with only a handful of space.
