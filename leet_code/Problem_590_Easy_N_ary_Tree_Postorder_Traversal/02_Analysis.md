# Analysis for N-ary Tree Postorder Traversal
# *Phân tích cho bài toán Duyệt Hậu thứ tự Cây N-phân*

## 1. Problem Essence & Bottom-Up Processing
## *1. Bản chất vấn đề & Xử lý từ Dưới lên*

### The Challenge
### *Thách thức*
In a postorder traversal, we visit all the children of a node from left to right **before** visiting the node itself.
*Trong phép duyệt hậu thứ tự, chúng ta thăm tất cả các con của một nút từ trái sang phải **trước khi** thăm chính nút đó.*

This is slightly more complex for iterative solutions because the parent stays on the call stack longer than its children.
*Điều này phức tạp hơn một chút đối với các giải pháp lặp vì nút cha nằm lại trong ngăn xếp cuộc gọi lâu hơn các con của nó.*

---

## 2. Strategy: Mirroring and Reversal (The Iterative Hack)
## *2. Chiến lược: Đối gương và Đảo ngược (Mẹo Vòng lặp)*

While recursive logic is straightforward, an elegant iterative solution uses a mathematical shortcut.
*Trong khi logic đệ quy là trực diện, một giải pháp lặp thanh lịch sử dụng một lối tắt toán học.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Modified Preorder:** Perform a traversal that visits the root first, then its children from **left to right** (normal preorder) OR **right to left**.
    * **Tiền thứ tự Sửa đổi:** Thực hiện một phép duyệt thăm gốc trước, sau đó là các con của nó từ **trái sang phải** (tiền thứ tự thông thường) HOẶC **phải sang trái**.*

2.  **The (Root, Right-to-Left) Pattern:**
    * **Mô hình (Gốc, Phải-sang-Trái):**
    - Use a stack. Push `root`.
    - *Sử dụng ngăn xếp. Đẩy `root`.*
    - While the stack is not empty, pop `curr`, and add to `result`.
    - *Trong khi ngăn xếp không trống, hãy lấy `curr` ra và thêm vào `result`.*
    - Push children into the stack from **left to right**. (This means the rightmost child will be popped next).
    - *Đẩy các con vào ngăn xếp từ **trái sang phải**. (Điều này nghĩa là con ngoài cùng bên phải sẽ được lấy ra tiếp theo).*
    - This generates a sequence: (Root, Child_last, ..., Child_first).
    - *Điều này tạo ra một chuỗi: (Gốc, Con_cuối, ..., Con_đầu).*

3.  **Reverse the Result:** If we reverse the sequence (Root, Child_n, ..., Child_1), we get (Child_1, ..., Child_n, Root).
    * **Đảo ngược Kết quả:** Nếu chúng ta đảo ngược chuỗi (Gốc, Con_n, ..., Con_1), chúng ta sẽ có (Con_1, ..., Con_n, Gốc).*
    - This is exactly the **Postorder Traversal**!
    - *Đây chính xác là **Duyệt Hậu thứ tự**!*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Logic Reuse:** The iterative postorder is essentially a "reversed reverse-preorder". If you understand preorder, postorder is just two small changes away.
    * **Tái sử dụng Logic:** Duyệt hậu thứ tự lặp về bản chất là một "phép tiền thứ tự đảo ngược của sự đảo ngược". Nếu bạn hiểu tiền thứ tự, hậu thứ tự chỉ cách đó hai thay đổi nhỏ.*
*   **Recursive Purity:** Recursive postorder remains the standard for tree summation or dependency resolution because the result of the children is available when processing the parent.
    * **Sự thuần khiết của đệ quy:** Hậu thứ tự đệ quy vẫn là tiêu chuẩn cho việc tính tổng cây hoặc giải quyết sự phụ thuộc vì kết quả của các con đã có sẵn khi xử lý nút cha.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node once and reverse the result list in line with $O(N)$.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là số lượng nút. Chúng ta thăm mỗi nút một lần và đảo ngược danh sách kết quả trong thời gian $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the tree height, for the stack.
    * **Độ phức tạp không gian:** $O(H)$, trong đó $H$ là chiều cao cây, cho ngăn xếp.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** Root 1 with children [2, 3]
1. Stack: [1]
2. Pop 1. Result: [1]. Push children left-to-right: [2, 3].
3. Pop 3. Result: [1, 3].
4. Pop 2. Result: [1, 3, 2].
5. Reverse Result: **[2, 3, 1]**.
**Final Postorder:** [2, 3, 1].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

To implement tree traversals iteratively, remember that a stack processes nodes in LIFO order. Reversing the input order or the final output list can transform one traversal type into another.
*Để triển khai duyệt cây bằng vòng lặp, hãy nhớ rằng ngăn xếp xử lý các nút theo thứ tự LIFO. Việc đảo ngược thứ tự đầu vào hoặc danh sách đầu ra cuối cùng có thể chuyển đổi loại hình duyệt này sang loại hình duyệt khác.*
---
*Hậu thứ tự (Postorder) tôn vinh nền tảng trước khi xác nhận đỉnh cao. Chỉ khi các mầm non (Children) đã được chăm sóc và thấu hiểu, cái cây (Root) mới đạt đến sự khẳng định cuối cùng về sự tồn tại của chính mình.*
Postorder (Postorder) honors the foundation before confirming the peak. Only when the seedlings (Children) have been cared for and understood, does the tree (Root) reach the final affirmation of its own existence.
