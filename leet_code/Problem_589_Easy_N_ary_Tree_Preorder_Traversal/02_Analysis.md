# Analysis for N-ary Tree Preorder Traversal
# *Phân tích cho bài toán Duyệt Tiền thứ tự Cây N-phân*

## 1. Problem Essence & Sequential Processing
## *1. Bản chất vấn đề & Xử lý Tuần tự*

### The Challenge
### *Thách thức*
In a preorder traversal, we visit the current node first, and then visit all its children from left to right.
*Trong phép duyệt tiền thứ tự, chúng ta thăm nút hiện tại trước, sau đó mới thăm tất cả các con của nó từ trái sang phải.*

For an N-ary tree, a node can have any number of children (unlike a binary tree which has at most two).
*Đối với cây N-phân, một nút có thể có bất kỳ số lượng con nào (khác với cây nhị phân chỉ có tối đa hai).*

---

## 2. Strategy: Recursive vs Iterative Approaches
## *2. Chiến lược: Các phương pháp Tiếp cận Đệ quy và Lặp*

### Recursive Strategy
### *Chiến lược Đệ quy*
The most natural way:
*Cách tiếp cận tự nhiên nhất:*
1.  Add `node.val` to result.
    * *Thêm `node.val` vào kết quả.*
2.  For each `child` in `node.children`, call `traversal(child)`.
    * *Cho mỗi `child` trong `node.children`, hãy gọi `traversal(child)`.*

### Iterative Strategy (Using a Stack)
### *Chiến lược Lặp (Sử dụng Ngăn xếp)*
To simulate recursion, we use a manual stack:
*Để mô phỏng đệ quy, chúng ta sử dụng một ngăn xếp thủ công:*
1.  Push the `root` into the stack.
    * *Đẩy `root` vào ngăn xếp.*
2.  While the stack is not empty:
    * *Trong khi ngăn xếp không trống:*
    - Pop the top node `curr` and add its value to result.
    - *Lấy nút trên cùng `curr` ra và thêm giá trị của nó vào kết quả.*
    - **Crucial Step:** Push all children of `curr` into the stack in **reverse order** (from right to left).
    - * **Bước quan trọng:** Đẩy tất cả các con của `curr` vào ngăn xếp theo **thứ tự ngược lại** (từ phải sang trái).*
    - *Why?* Because a stack is Last-In-First-Out (LIFO). Pushing the rightmost child first ensures the leftmost child is popped and processed next.
    - *Tại sao?* Vì ngăn xếp là Vào-Sau-Ra-Trước (LIFO). Việc đẩy con ngoài cùng bên phải vào trước đảm bảo con ngoài cùng bên trái sẽ được lấy ra và xử lý tiếp theo.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Recursive Simplicity:** Recursive code is more concise and easier to read for tree problems.
    * **Sự đơn giản của đệ quy:** Mã đệ quy ngắn gọn và dễ đọc hơn đối với các bài toán về cây.*
*   **Iterative Safety:** Iterative solutions avoid `StackOverflowError` on very deep trees by using heap memory for the stack.
    * **Sự an toàn của vòng lặp:** Các giải pháp lặp tránh được lỗi `StackOverflowError` trên các cây rất sâu bằng cách sử dụng bộ nhớ heap cho ngăn xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of nodes in the tree. Every node is visited exactly once.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là tổng số nút trong cây. Mỗi nút được thăm chính xác một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This is the space for the recursion stack or the manual stack.
    * **Độ phức tạp không gian:** $O(H)$, trong đó $H$ là chiều cao của cây.*

---

## 5. Visualized Dry Run (Iterative)
## *5. Chạy thử bằng Hình ảnh (Giải pháp Lặp)*

**Input:** Root 1 with children [2, 3, 4]
- Stack: [1]
- Pop 1. Result: [1]. Push children [4, 3, 2] -> Stack: [4, 3, 2]
- Pop 2. Result: [1, 2].
- Pop 3. Result: [1, 2, 3].
- Pop 4. Result: [1, 2, 3, 4].
- Result: **[1, 2, 3, 4]**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Understand the relationship between recursion and the LIFO nature of a stack. When converting preorder traversal to iteration, always reverse the child processing order.
*Hãy hiểu rõ mối quan hệ giữa đệ quy và bản chất LIFO của ngăn xếp. Khi chuyển đổi duyệt tiền thứ tự sang vòng lặp, luôn luôn đảo ngược thứ tự xử lý các nút con.*
---
*Tiền thứ tự (Preorder) là sự ưu tiên cho hiện tại trước khi khám phá tương lai. Bằng cách chạm vào gốc rễ (Root) trước khi vươn tới cành lá (Children), ta xác lập một tầm nhìn rõ ràng về cấu trúc trước khi đi vào chi tiết.*
Preorder (Preorder) is a priority for the present before exploring the future. By touching the roots (Root) before reaching for the branches (Children), we establish a clear vision of the structure before going into details.
