# Analysis for Binary Tree Preorder Traversal
# *Phân tích cho bài toán Duyệt cây nhị phân theo thứ tự trước*

## 1. Problem Essence & Definition
## *1. Bản chất vấn đề & Định nghĩa*

### What is Preorder Traversal?
### *Duyệt thứ tự trước là gì?*
In a preorder traversal, we visit the nodes of a binary tree in the following order:
1.  **Root** (The current node).
2.  **Left** subtree.
3.  **Right** subtree.
*Trong phép duyệt thứ tự trước, chúng ta truy cập các nút của một cây nhị phân theo thứ tự sau: 1. Gốc (nút hiện tại). 2. Cây con trái. 3. Cây con phải.*

This traversal is useful for creating a copy of a tree or expressing an expression tree in prefix notation.
*Phép duyệt này hữu ích để tạo bản sao của cây hoặc biểu diễn một cây biểu thức dưới dạng ký pháp tiền tố.*

---

## 2. Approaches: Recursive vs. Iterative
## *2. Các hướng tiếp cận: Đệ quy so với Lặp*

### Approach 1: Recursive (Natural & Trivial)
### *Hướng tiếp cận 1: Đệ quy (Tự nhiên & Đơn giản)*
*Logic:*
- Define a helper function that takes a node and a list.
- If node is null, return.
- Add `node.val` to list.
- Recursively call for `node.left`.
- Recursively call for `node.right`.
- **Complexity:** $O(N)$ time and $O(H)$ space (stack depth).
*Logic: Định nghĩa một hàm bổ trợ nhận một nút và một danh sách. Nếu nút là null, trả về. Thêm giá trị nút vào danh sách. Gọi đệ quy cho nút trái. Gọi đệ quy cho nút phải. Độ phức tạp: Thời gian O(N) và không gian O(H).*

### Approach 2: Iterative (Using an Explicit Stack)
### *Hướng tiếp cận 2: Lặp (Sử dụng ngăn xếp tường minh)*
To convert recursion to iteration, we must manually manage the system stack using a `Stack` data structure.
*Để chuyển đệ quy sang lặp, chúng ta phải quản lý ngăn xếp hệ thống một cách thủ công bằng cấu trúc dữ liệu `Stack`.*

*Logic:*
1.  Initialize a `Stack` and push the `root` into it.
2.  While the stack is not empty:
    a. Pop the current node `curr` and add its value to the result list.
    b. **CRITICAL:** Push the **Right** child first, then the **Left** child.
       *Tại sao?* Because a stack is First-In-Last-Out (FILO). Since we want to process Left before Right, the Left child must be on top of the stack, meaning it must be pushed last.
    c. Repeat until the stack is empty.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursive Clarity:** The recursive code mirrors the mathematical definition of preorder traversal perfectly, making it highly readable.
    *Sự rõ ràng của đệ quy: Mã đệ quy phản ánh hoàn hảo định nghĩa toán học của phép duyệt thứ tự trước, làm cho nó rất dễ đọc.*
*   **Iterative Robustness:** The iterative approach avoids potential `StackOverflowError` in extremely deep trees (though $H \le 100$ in this specific problem make recursion safe). It demonstrates a deeper understanding of how recursion is executed under the hood.
    *Tính mạnh mẽ của vòng lặp: Phương pháp lặp tránh được lỗi `StackOverflowError` tiềm tàng trong các cây cực sâu. Nó thể hiện sự hiểu biết sâu sắc hơn về cách đệ quy được thực thi bên dưới.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Every node in the tree is visited exactly once.
    *Độ phức tạp thời gian: $O(N)$. Mọi nút trong cây được truy cập đúng một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree.
    - In the recursive version, this is the recursion call stack.
    - In the iterative version, this is the maximum size of the explicit `Stack`.
    - Worst case (skewed tree): $O(N)$.
    - Average case (balanced tree): $O(\log N)$.
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây. Trong phiên bản đệ quy, đây là ngăn xếp lệnh gọi đệ quy. Trong phiên bản lặp, đây là kích thước tối đa của Stack tường minh. Trường hợp xấu nhất: O(N). Trường hợp trung bình: O(log N).*

---

## 5. Visualized Dry Run (Iterative)
## *5. Chạy thử bằng hình ảnh (Lặp)*

**Input:** `root = [1, 2, 3]` (1 is root, 2 is left, 3 is right)

1.  `Stack = [1]`. Result = `[]`.
2.  Pop 1. Result = `[1]`.
    - Push Right (3). `Stack = [3]`.
    - Push Left (2). `Stack = [3, 2]`.
3.  Pop 2. Result = `[1, 2]`.
    - 2 has no children. `Stack = [3]`.
4.  Pop 3. Result = `[1, 2, 3]`.
    - 3 has no children. `Stack = []`.

**Final Result:** `[1, 2, 3]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Preorder traversal is one of the most fundamental tree algorithms. Mastering both recursive and iterative versions is essential. When asked "Iterative", always remember the reversed push order (Right then Left) to ensure the stack yields Left nodes first. For very large trees, iterative is safer, but for most everyday tasks, recursion is preferred for brevity.
*Duyệt thứ tự trước là một trong những thuật toán cây cơ bản nhất. Nắm vững cả phiên bản đệ quy và lặp là điều cần thiết. Khi được hỏi về "vòng lặp", hãy luôn nhớ thứ tự đẩy ngược (Phải rồi đến Trái) để đảm bảo ngăn xếp tạo ra các nút bên Trái trước. Đối với các cây rất lớn, vòng lặp an toàn hơn, nhưng đối với hầu hết các nhiệm vụ hàng ngày, đệ quy được ưu tiên vì sự ngắn gọn.*
---
*Hành trình khám phá một cái cây luôn bắt đầu từ gốc rễ, rẽ trái trước khi chạm tới những nhánh bên phải.*
The journey of exploring a tree always starts from the roots, turning left before reaching the branches on the right.
