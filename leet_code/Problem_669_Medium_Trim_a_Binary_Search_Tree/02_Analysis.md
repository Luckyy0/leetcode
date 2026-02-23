# Analysis for Trim a Binary Search Tree
# *Phân tích cho bài toán Cắt tỉa Cây Nhị phân Tìm kiếm*

## 1. Problem Essence & Recursive Elimination
## *1. Bản chất vấn đề & Loại bỏ Đệ quy*

### The Challenge
### *Thách thức*
We need to remove all nodes whose values fall outside the closed interval `[low, high]`. Because it's a Binary Search Tree (BST), the values are ordered, which significantly simplifies the decision of which branches to keep.
*Chúng ta cần loại bỏ tất cả các nút có giá trị nằm ngoài khoảng đóng `[low, high]`. Vì đây là Cây Nhị phân Tìm kiếm (BST), các giá trị đã được sắp xếp, điều này giúp đơn giản hóa việc quyết định nên giữ lại nhánh nào.*

---

## 2. Strategy: Recursive Trimming
## *2. Chiến lược: Cắt tỉa Đệ quy*

We can solve this by thinking about what each node should return to its parent.
*Chúng ta có thể giải quyết vấn đề này bằng cách suy nghĩ về việc mỗi nút nên trả lại cái gì cho nút cha của nó.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Lower Bound Violation ($root.val < low$):**
    - Since $root$ is too small, and every node in its **left** subtree is even smaller, we can discard the root and the entire left subtree.
    - The new candidate to take this spot is the result of trimming the **right** subtree.
    - **Vi phạm Ranh giới Thấp ($root.val < low$):** Vì nút gốc quá nhỏ, và mọi nút con bên trái đều nhỏ hơn nữa, ta loại bỏ gốc và toàn bộ nhánh trái. Ứng cử viên mới là kết quả cắt tỉa của nhánh phải.*

2.  **Upper Bound Violation ($root.val > high$):**
    - Since $root$ is too large, and every node in its **right** subtree is even larger, we discard the root and the entire right subtree.
    - Return the result of trimming the **left** subtree.
    - **Vi phạm Ranh giới Cao ($root.val > high$):** Ngược lại, ta loại bỏ gốc và nhánh phải, trả về kết quả cắt tỉa của nhánh trái.*

3.  **Within Bounds ($low \le root.val \le high$):**
    - The current `root` is valid. We keep it but must recursively trim its children.
    - `root.left = trim(root.left)`
    - `root.right = trim(root.right)`
    - Return `root`.
    - **Trong Ranh giới:** Giữ lại nút hiện tại và tiếp tục cắt tỉa hai con.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Structure Preservation:** The BST property (left < root < right) ensures that if a node's right child is also valid, it will remain to the right of the node even after trimming. The recursion naturally maintains the hierarchy.
    * **Bảo toàn Cấu trúc:** Đặc tính BST đảm bảo rằng sau khi cắt tỉa, thứ tự tương đối vẫn được giữ nguyên. Đệ quy thực hiện việc này một cách tự nhiên.*
*   **Unique Solution:** Because a BST has a strict layout, there is only one way to re-link valid subtrees once an invalid parent is removed.
    * **Đáp án Duy nhất:** Vì BST có bố cục nghiêm ngặt, chỉ có một cách duy nhất để liên kết lại các cây con.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of nodes in the tree. We visit each node once to decide its fate.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree, for the recursion stack. $O(N)$ in the worst case (skewed tree).
    * **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree:** [3, 0, 4, null, 2, null, null, 1]. low=1, high=3.
1. `Trim(3)`: 3 is in range [1, 3].
   - `3.left = Trim(0)`.
   - `3.right = Trim(4)`.
2. `Trim(0)`: 0 < 1. Return `Trim(2)`.
3. `Trim(2)`: 2 is in range [1, 3].
   - `2.left = Trim(1)` -> Returns 1.
   - `2.right = Trim(null)` -> Returns null.
   - Return 2.
4. `Trim(4)`: 4 > 3. Return `Trim(null)` -> Returns null.
**Final Structure:** Node 3's left child becomes Node 2 (with its child 1). Node 3's right child becomes null.
**Result:** [3, 2, null, 1].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Tree transformation problems are most elegantly solved by returning the "new" subtree root from each recursive call. For BSTs specifically, leverage the property that an out-of-bounds node allows you to immediately skip one of its entire halves.
*Các bài toán biến đổi cây được giải quyết một cách trang nhã nhất bằng cách trả về gốc của cây con "mới" từ mỗi lời gọi đệ quy.*
---
*Sự tinh giản (Trimming) là cách ta loại bỏ những gì dư thừa để bảo tồn những giá trị cốt lõi. Trong trật tự của Cây Tìm kiếm (BST), ranh giới (low, high) không phải là sự giới hạn, mà là sự chắt lọc. Dữ liệu dạy ta rằng bằng cách từ bỏ những gì không còn phù hợp (Discarding outliers) và tái kết nối những gì quý giá (Re-linking), ta có thể giữ vững tinh túy của cấu trúc trong một hình hài cân đối hơn.*
Simplicity (Trimming) is the way we remove what is redundant to preserve core values. In the order of the Search Tree (BST), boundaries (low, high) are not limits, but distillations. Data teaches us that by giving up what is no longer suitable (Discarding outliers) and re-connecting what is precious (Re-linking), we can keep the essence of the structure in a more balanced form.
