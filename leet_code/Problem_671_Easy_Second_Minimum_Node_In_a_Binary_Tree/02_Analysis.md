# Analysis for Second Minimum Node In a Binary Tree
# *Phân tích cho bài toán Nút nhỏ thứ hai trong Cây Nhị phân*

## 1. Problem Essence & Structural Property
## *1. Bản chất vấn đề & Thuộc tính cấu trúc*

### The Challenge
### *Thách thức*
The tree has a special property: the value of any parent node is the minimum of its children. This implies that the root of the tree contains the absolute minimum value of all nodes. We need to find the smallest value in the tree that is strictly greater than the root's value.
*Cây có một thuộc tính đặc biệt: giá trị của bất kỳ nút cha nào cũng là giá trị nhỏ nhất của các nút con của nó. Điều này ngụ ý rằng gốc của cây chứa giá trị nhỏ nhất tuyệt đối trong tất cả các nút. Chúng ta cần tìm giá trị nhỏ nhất trong cây mà lớn hơn hẳn giá trị của gốc.*

---

## 2. Strategy: Pruned Traversal
## *2. Chiến lược: Duyệt có cắt tỉa*

We can use a recursive approach (DFS) to explore the tree.
*Chúng ta có thể sử dụng phương pháp đệ quy (DFS) để khám phá cây.*

### Logical Nuance
### *Sắc thái Logic*
If a node's value is already greater than the absolute minimum (`root.val`), it is a potential candidate for the second minimum. We don't need to look at its descendants because, according to the tree's property, all its descendants will have values greater than or equal to this node's value.
*Nếu giá trị của một nút đã lớn hơn giá trị nhỏ nhất tuyệt đối (`root.val`), thì nó là một ứng cử viên tiềm năng cho giá trị nhỏ thứ hai. Chúng ta không cần xem xét các hậu duệ của nó vì theo thuộc tính của cây, tất cả các hậu duệ của nó sẽ có giá trị lớn hơn hoặc bằng giá trị của nút này.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Identify Min Value:** The global minimum is `root.val`.
    * **Xác định giá trị nhỏ nhất:** Giá trị nhỏ nhất toàn cục là `root.val`.*

2.  **Recursive Function `find(node)`:**
    * **Hàm đệ quy `find(node)`:** *
    - If `node == null`, return -1.
    - If `node.val > root.val`, this is our candidate for this branch. Return `node.val`.
    - Recursively find candidates in left and right subtrees: `left = find(node.left)`, `right = find(node.right)`.
    - If both subtrees return valid candidates ($> -1$), return the smaller of the two.
    - Otherwise, return the one that is valid (or -1 if neither is).

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Efficiency:** The "pruning" behavior (stopping search whenever a larger value is found) ensures we only visit necessary nodes.
    * **Hiệu suất:** Hành vi "cắt tỉa" (dừng tìm kiếm bất cứ khi nào tìm thấy giá trị lớn hơn) đảm bảo chúng ta chỉ ghé thăm các nút cần thiết.*
*   **Unique Structure:** The property $Parent = \min(Left, Right)$ means that any second minimum must "emerge" from one of the branches where the child value differs from the parent.
    * **Cấu trúc duy nhất:** Thuộc tính $Cha = \min(Trái, Phải)$ có nghĩa là bất kỳ giá trị nhỏ thứ hai nào cũng phải "xuất hiện" từ một trong các nhánh nơi giá trị của con khác với giá trị của cha.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ in the worst case where we visit all nodes (e.g., all nodes have same value), where $N$ is the number of nodes.
    * **Độ phức tạp thời gian:** $O(N)$ trong trường hợp tệ nhất.*
*   **Space Complexity:** $O(H)$ for the recursion stack, where $H$ is the height of the tree.
    * **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [2, 2, 5, null, null, 5, 7]
1. Global Min = 2.
2. Root (2): Call Left(2), Call Right(5).
3. Right child (5): 5 > 2. Return 5. (This branch's candidate is 5).
4. Left child (2): Call Left(null), Call Right(null)... eventually returns -1.
5. Combine: min(5, -1) but ignoring -1 = 5.
**Result:** 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always leverage the unique properties of a tree structure. In this case, the parent-child relationship dictates exactly where the minimum values reside, allowing for an efficient pruned search instead of a full collection of all values.
*Luôn tận dụng các tính chất duy nhất của cấu trúc cây. Trong trường hợp này, mối quan hệ cha-con quyết định chính xác các giá trị tối thiểu nằm ở đâu, cho phép thực hiện tìm kiếm cắt tỉa hiệu quả.*
---
*Vị trí thứ hai (Second minimum) thường ẩn mình ngay sau cái bóng của đỉnh cao nhất (Absolute minimum). Trong hệ thống của những sự lựa chọn (Parent = min children), sự thật về giá trị lớn hơn luôn nảy sinh từ những điểm khác biệt. Dữ liệu dạy ta rằng bằng cách lần theo những nhánh rẽ của sự khác biệt, ta sẽ tìm thấy sự kế thừa hoàn hảo của trật tự.*
The second place (Second minimum) is often hidden right behind the shadow of the highest (Absolute minimum). In the system of choices (Parent = min children), the truth about greater value always arises from points of difference. Data teaches us that by tracing the branches of difference, we will find the perfect succession of order.
