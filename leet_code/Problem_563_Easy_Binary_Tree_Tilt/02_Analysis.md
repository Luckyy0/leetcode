# Analysis for Binary Tree Tilt
# *Phân tích cho bài toán Độ nghiêng của Cây Nhị phân*

## 1. Problem Essence & Vertical Balance
## *1. Bản chất vấn đề & Sự cân bằng theo Chiều dọc*

### The Challenge
### *Thách thức*
The "tilt" of a node is defined as the absolute difference between the sum of all nodes in its left subtree and the sum of all nodes in its right subtree.
* "Độ nghiêng" của một nút được định nghĩa là giá trị tuyệt đối của hiệu giữa tổng tất cả các nút trong cây con bên trái và tổng tất cả các nút trong cây con bên phải của nó.*

We need to return the sum of tilts for **all** nodes in the tree.
*Chúng ta cần trả về tổng độ nghiêng của **tất cả** các nút trong cây.*

---

## 2. Strategy: Post-order Recursive Summation (The Bottom-Up Pass)
## *2. Chiến lược: Tính tổng Đệ quy Hậu thứ tự (Lượt quét từ dưới lên)*

To calculate the tilt of a parent, we must first know the total sum of its children's subtrees. This dependency pattern dictates a **Post-order Traversal** (Left, Right, then Root).
*Để tính độ nghiêng của nút cha, trước tiên chúng ta phải biết tổng của các cây con của nút con. Mô hình phụ thuộc này quy định một cách **Duyệt hậu thứ tự** (Trái, Phải, rồi đến Gốc).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Global Accumulator:** Define a variable `totalTilt` initialized to 0.
    * **Bộ tích lũy toàn cục:** Định nghĩa một biến `totalTilt` được khởi tạo bằng 0.*

2.  **Recursive Function `sum(node)`:**
    * **Hàm đệ quy `sum(node)`:**
    - If `node` is `null`, return 0.
    - *Nếu `node` là `null`, trả về 0.*
    - Recursively compute `leftSum = sum(node.left)`.
    - *Tính toán đệ quy `leftSum = sum(node.left)`.*
    - Recursively compute `rightSum = sum(node.right)`.
    - *Tính toán đệ quy `rightSum = sum(node.right)`.*
    - **Identify Local Tilt:** `localTilt = Math.abs(leftSum - rightSum)`.
    - * **Xác định độ nghiêng cục bộ:** `localTilt = Math.abs(leftSum - rightSum)`.*
    - Add `localTilt` to the global `totalTilt`.
    - *Cộng `localTilt` vào `totalTilt` toàn cục.*
    - **Return Subtree Sum:** Return `leftSum + rightSum + node.val` (this is used by the parent of the current node).
    - * **Trả về Tổng cây con:** Trả về `leftSum + rightSum + node.val` (giá trị này được sử dụng bởi nút cha của nút hiện tại).*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **Single-Pass Solution:** We use a single traversal to calculate both the subtree sums and the total tilt simultaneously.
    * **Giải pháp một lượt:** Chúng ta sử dụng một lần duyệt duy nhất để tính toán cả tổng cây con và tổng độ nghiêng cùng một lúc.*
*   **Encapsulation:** The recursion naturally bubbles up the information (sum) needed by higher levels while performing partial work (tilt) locally.
    * **Sự đóng gói:** Phép đệ quy đưa thông tin (tổng) cần thiết lên các cấp cao hơn một cách tự nhiên trong khi thực hiện công việc từng phần (độ nghiêng) tại địa phương.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We visit each node once.
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta thăm mỗi nút một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree, representing the recursion stack depth.
    * **Độ phức tạp không gian:** $O(H)$, trong đó $H$ là chiều cao của cây, đại diện cho độ sâu của ngăn xếp đệ quy.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree:**
```
    4
   / \
  2   9
 / \   \
3   5   7
```
- `sum(3)`: returns 3. LocalTilt = 0.
- `sum(5)`: returns 5. LocalTilt = 0.
- `sum(2)`: receives 3 and 5. returns 3+5+2=10. **LocalTilt = |3-5| = 2**.
- `sum(7)`: returns 7. LocalTilt = 0.
- `sum(9)`: receives 0 and 7. returns 0+7+9=16. **LocalTilt = |0-7| = 7**.
- `sum(4)`: receives 10 and 16. returns 10+16+4=30. **LocalTilt = |10-16| = 6**.
- **Total Tilt:** 0+0+2+0+7+6 = 15.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use post-order traversal to solve any tree problem where a parent's value depends on the cumulative properties of its children.
*Sử dụng duyệt hậu thứ tự để giải quyết bất kỳ bài toán cây nào mà giá trị của nút cha phụ thuộc vào các đặc tính tích lũy của các con nó.*
---
*Độ nghiêng (Tilt) là sự mất cân bằng giữa hai phía. Trong bài toán này, ta thu thập tất cả những sự chênh lệch đó để hiểu rõ hơn về trạng thái của cả cái cây. Đôi khi, sự thật về một nút (Node) chỉ được hé lộ sau khi ta đã thấu hiểu hoàn toàn các tầng dưới (Subtrees) của nó.*
Tilt (Tilt) is an imbalance between two sides. In this problem, we collect all those differences to better understand the state of the whole tree. Sometimes, the truth about a node (Node) is only revealed after we have fully understood its subtrees (Subtrees).
