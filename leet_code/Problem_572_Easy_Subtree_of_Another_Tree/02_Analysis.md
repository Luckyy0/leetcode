# Analysis for Subtree of Another Tree
# *Phân tích cho bài toán Cây con của một Cây khác*

## 1. Problem Essence & Structural Comparison
## *1. Bản chất vấn đề & So sánh Cấu trúc*

### The Challenge
### *Thách thức*
We need to determine if a target tree (`subRoot`) exists identically within a larger tree (`root`).
*Chúng ta cần xác định xem một cây mục tiêu (`subRoot`) có tồn tại giống hệt bên trong một cây lớn hơn (`root`) hay không.*

A key detail is that the matching must include **all descendants**. We cannot just find a part of the tree that matches; the matching point in the main tree must define a subtree that is exactly the same as the target tree.
*Một chi tiết quan trọng là việc so khớp phải bao gồm **tất cả các con cháu**. Chúng ta không thể chỉ tìm thấy một phần của cây khớp nhau; điểm khớp trong cây chính phải định nghĩa một cây con giống hệt như cây mục tiêu.*

---

## 2. Strategy: Recursive Matching (DFS within DFS)
## *2. Chiến lược: So khớp đệ quy (DFS trong DFS)*

The core algorithm consists of two recursive parts: one to traverse the main tree and another to compare structural equality.
*Thuật toán cốt lõi bao gồm hai phần đệ quy: một phần để duyệt cây chính và một phần khác để so sánh sự bằng nhau về cấu trúc.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Helper Function `isSameTree(p, q)`:**
    * **Hàm bổ trợ `isSameTree(p, q)`:**
    - If both nodes are `null`, they are the same (return `true`).
    - *Nếu cả hai nút đều `null`, chúng giống nhau (trả về `true`).*
    - If only one is `null` or values differ, they are not the same (return `false`).
    - *Nếu chỉ một nút `null` hoặc giá trị khác nhau, chúng không giống nhau (trả về `false`).*
    - Recursively check `isSameTree(p.left, q.left)` and `isSameTree(p.right, q.right)`.
    - *Kiểm tra đệ quy `isSameTree(p.left, q.left)` và `isSameTree(p.right, q.right)`.*

2.  **Main Function `isSubtree(root, subRoot)`:**
    * **Hàm chính `isSubtree(root, subRoot)`:**
    - If `root` is `null`, it can't contain `subRoot` (return `false`).
    - *Nếu `root` là `null`, nó không thể chứa `subRoot` (trả về `false`).*
    - If `root` and `subRoot` are the same tree (using `isSameTree`), return `true`.
    - *Nếu `root` và `subRoot` là cùng một cây (sử dụng `isSameTree`), trả về `true`.*
    - Otherwise, recursively check if `subRoot` is a subtree of the left child or the right child of `root`.
    - *Nếu không, hãy kiểm tra đệ quy xem `subRoot` có phải là cây con của nút con bên trái hoặc nút con bên phải của `root` hay không.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Recursive Simplicity:** The logic maps directly to the recursive definition of tree equality.
    * **Sự đơn giản của đệ quy:** Logic ánh xạ trực tiếp đến định nghĩa đệ quy về sự bằng nhau của cây.*
*   **Alternative (Serialization):** One could also serialize both trees into strings (e.g., using pre-order with null markers) and use string matching (`contains`). This is $O(M + N)$ but requires more space.
    * **Lựa chọn thay thế (Tuần tự hóa):** Người ta cũng có thể tuần tự hóa cả hai cây thành chuỗi (ví dụ: sử dụng pre-order với các dấu đánh dấu null) và sử dụng so khớp chuỗi (`contains`). Cách này có độ phức tạp $O(M + N)$ nhưng đòi hỏi nhiều không gian hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M$ is the number of nodes in `root` and $N$ is the number of nodes in `subRoot`. For each of the $M$ nodes, we might perform a comparison that takes $O(N)$ time.
    * **Độ phức tạp thời gian:** $O(M \times N)$, trong đó $M$ là số nút trong `root` và $N$ là số nút trong `subRoot`. Đối với mỗi nút trong số $M$ nút, chúng ta có thể thực hiện một phép so sánh tốn thời gian $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the main tree, utilized by the recursion stack.
    * **Độ phức tạp không gian:** $O(H)$, trong đó $H$ là chiều cao của cây chính, được sử dụng bởi ngăn xếp đệ quy.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Root:** `[1(root), 2, 3]`, **SubRoot:** `[2]`
- Check `isSameTree(1, 2)`: Different values. Fail.
- Check `isSubtree(1.left, 2)`:
  - `isSameTree(2, 2)`: Same nodes, same structure. **Match!**
- Result: **true**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Recursive traversal is the standard way to handle sub-structure problems on trees. Always separate the "navigation" logic from the "comparison" logic.
*Duyệt đệ quy là cách tiêu chuẩn để xử lý các bài toán cấu trúc con trên cây. Luôn tách biệt logic "di chuyển" khỏi logic "so sánh".*
---
*Một cái cây lớn (Root) được tạo nên từ vô vàn những nhành cây nhỏ (Subtree). Để nhận diện một nhành cây quen thuộc, ta phải so chiếu không chỉ vẻ ngoài (Value) mà cả cách chúng vươn ra (Structure) trong không gian. Sự đồng nhất thực sự nằm ở sự tỉ mỉ trong từng nhánh rễ.*
A large tree (Root) is made up of countless small branches (Subtree). To recognize a familiar branch, we must compare not only the appearance (Value) but also the way they reach out (Structure) in space. True identity lies in the meticulousness of each root branch.
