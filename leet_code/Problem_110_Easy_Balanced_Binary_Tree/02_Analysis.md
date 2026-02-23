# Analysis for Balanced Binary Tree
# *Phân tích cho bài toán Cây Nhị Phân Cân Bằng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root of a binary tree. *Gốc của một cây nhị phân.*
*   **Output:** Boolean value indicating if the tree is balanced. *Giá trị Boolean cho biết cây có cân bằng hay không.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Balance Definition:** For **EVERY** node, $|height(left) - height(right)| \le 1$. *Định nghĩa cân bằng: Đối với MỖI nút, $|chiều cao(trái) - chiều cao(phải)| \le 1$.*
*   **Empty Tree:** A null tree is considered balanced. *Cây trống: Một cây null được coi là cân bằng.*
*   **Efficiency:** A naive approach would calculate height for every node repeatedly ($O(N^2)$). We need an $O(N)$ solution. *Hiệu quả: Một phương pháp ngây thơ sẽ tính toán chiều cao cho mỗi nút nhiều lần ($O(N^2)$). Chúng ta cần một giải pháp $O(N)$.*

---

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Bottom-Up DFS (Optimized)
### *Hướng tiếp cận: DFS Từ dưới lên (Tối ưu hóa)*

*   **Logic:**
    1.  Instead of calculating the height of each subtree separately, we can check for balance while calculating heights.
    2.  If any subtree is found to be unbalanced, we "bubble up" this information immediately.
    3.  A special value (e.g., `-1`) can be used to indicate that a subtree is unbalanced.
    4.  At each node:
        *   Get the height of the left subtree. If it's `-1`, return `-1`.
        *   Get the height of the right subtree. If it's `-1`, return `-1`.
        *   If $|leftHeight - rightHeight| > 1$, return `-1` (Unbalanced).
        *   Otherwise, return $1 + \max(leftHeight, rightHeight)$.

*   **Algorithm Steps:**
    1.  Create a helper function `checkHeight(node)`.
    2.  **Base Case:** If `node == null`, return 0.
    3.  Calculate `leftHeight = checkHeight(node.left)`.
    4.  If `leftHeight == -1`, return `-1`.
    5.  Calculate `rightHeight = checkHeight(node.right)`.
    6.  If `rightHeight == -1`, return `-1`.
    7.  Check if current node is balanced:
        *   If `Math.abs(leftHeight - rightHeight) > 1`, return `-1`.
        *   Else, return `Math.max(leftHeight, rightHeight) + 1`.
    8.  In the main function, return `checkHeight(root) != -1`.

*   **Complexity:**
    *   **Time Complexity:** $O(N)$. Each node is visited once. *Độ phức tạp thời gian: $O(N)$. Mỗi nút được truy cập một lần.*
    *   **Space Complexity:** $O(H)$, where $H$ is the tree height, due to recursion stack. *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao cây, do ngăn xếp đệ quy.*

---

## 3. Dry Run
## *3. Chạy thử*

**Input:** `root = [1, 2, 2, 3, 3, null, null, 4, 4]` (Unbalanced)

1.  `checkHeight(4)` at bottom: returns `1`.
2.  `checkHeight(3)` (parent of 4):
    -   `leftHeight = checkHeight(4) = 1`.
    -   `rightHeight = checkHeight(4) = 1`.
    -   Balance check: `|1 - 1| = 0 <= 1`. OK. Returns `2`.
3.  `checkHeight(2)` (parent of 3):
    -   `leftHeight = checkHeight(3) = 2`.
    -   `rightHeight = 0` (null).
    -   Balance check: `|2 - 0| = 2 > 1`. **FAIL!** Returns `-1`.
4.  Information bubbles up to root. Root returns `false`.

---

## 4. Key Takeaway
## *4. Điểm mấu chốt*
*   **Avoid Redundant Calculations:** By calculating height and checking balance simultaneously, we avoid the $O(N^2)$ trap. *Tránh các tính toán dư thừa: Bằng cách tính chiều cao và kiểm tra độ cân bằng đồng thời, chúng ta tránh được bẫy $O(N^2)$.*
*   **Sentinel Value:** Using `-1` as a signal for "not balanced" is a common and efficient pattern in tree problems. *Giá trị lính canh: Sử dụng `-1` làm tín hiệu cho "không cân bằng" là một mô hình phổ biến và hiệu quả trong các bài toán về cây.*
