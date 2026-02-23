# Analysis for Path Sum
# *Phân tích cho bài toán Tổng Đường Đi*

## 1. Problem Essence
## *1. Bản chất của bài toán*

### Definition of "Root-to-Leaf"
### *Định nghĩa "Từ Gốc đến Lá"*
*   The path must start at the **root** and end at a **leaf**.
    *Đường đi phải bắt đầu tại **gốc** và kết thúc tại một **lá**.*
*   A leaf is defined by `node.left == null && node.right == null`.
    *Một nút lá được xác định bởi `node.left == null && node.right == null`.*
*   This means if target sum is reached at a node that is **not** a leaf, it does not count.
    *Điều này có nghĩa là nếu đạt được tổng mục tiêu tại một nút **không** phải là lá, nó sẽ không được tính.*

### The Goal
### *Mục tiêu*
*   We need to determine if at least one such path exists.
    *Chúng ta cần xác định xem có tồn tại ít nhất một con đường như vậy hay không.*
*   Since the constraints on node values and target sum include negative numbers, we cannot rely on early stopping just because the current sum exceeds the target.
    *Vì các ràng buộc về giá trị nút và tổng mục tiêu bao gồm cả số âm, chúng ta không thể dựa vào việc dừng sớm chỉ vì tổng hiện tại vượt quá mục tiêu.*

---

## 2. Approach: Recursive Depth-First Search (DFS)
## *2. Hướng tiếp cận: Tìm kiếm theo chiều sâu (DFS) đệ quy*

### Core Logic
### *Logic cốt lõi*
1.  The base case for recursion is a `null` node, which returns `false`.
    *Trường hợp cơ sở cho đệ quy là một nút `null`, trả về `false`.*
2.  At each node, we "subtract" the node's value from the current `targetSum`.
    *Tại mỗi nút, chúng ta "trừ" giá trị của nút khỏi `targetSum` hiện tại.*
3.  If we reach a **leaf node**, we check if the remaining `targetSum` exactly matches the leaf node's value.
    *Nếu chúng ta đến một **nút lá**, chúng ta kiểm tra xem `targetSum` còn lại có khớp chính xác với giá trị của nút lá đó hay không.*
4.  Otherwise, we recursively check the left subtree and the right subtree. If either returns `true`, then the parent returns `true`.
    *Nếu không, chúng ta kiểm tra đệ quy cây con bên trái và cây con bên phải. Nếu một trong hai trả về `true`, thì nút cha sẽ trả về `true`.*

### Why Subtract Instead of Accumulate?
### *Tại sao lại trừ thay vì tích lũy?*
*   Subtracting allows us to pass a single parameter (`remainingSum`) down the tree without needing a helper function or an extra variable to store the "current total".
    *Việc trừ cho phép chúng ta truyền một tham số duy nhất (`remainingSum`) xuống cây mà không cần một hàm bổ trợ hoặc một biến bổ sung để lưu trữ "tổng hiện tại".*

---

## 3. Mathematical Perspective
## *3. Góc nhìn Toán học*

Let $P = \{v_1, v_2, ..., v_k\}$ be the values of nodes on a path from root to leaf.
*Gọi $P = \{v_1, v_2, ..., v_k\}$ là các giá trị của các nút trên một con đường từ gốc đến lá.*
The problem asks: Is there any $P$ such that $\sum_{i=1}^{k} v_i = targetSum$?
*Bài toán hỏi: Có tồn tại $P$ nào sao cho $\sum_{i=1}^{k} v_i = targetSum$ không?*

This is equivalent to:
*Điều này tương đương với:*
$v_1 + (v_2 + ... + v_k) = targetSum$
$\implies (v_2 + ... + v_k) = targetSum - v_1$

This recursive property justifies the DFS approach. We reduce the problem into a sub-problem of finding a path sum of $(targetSum - root.val)$ in either the left or right child.
*Đặc tính đệ quy này chứng minh cho hướng tiếp cận DFS. Chúng ta giảm bài toán thành một bài toán con là tìm tổng đường đi của $(targetSum - root.val)$ trong con bên trái hoặc bên phải.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes in the tree. In the worst case, we might have to visit every single node to determine if a valid path exists.
    *Độ phức tạp thời gian: $O(N)$, trong đó $N$ là số lượng nút trong cây. Trong trường hợp xấu nhất, chúng ta có thể phải truy cập mọi nút để xác định xem có tồn tại con đường hợp lệ hay không.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree.
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây.*
    *   In a **worst-case** skewed tree (like a linked list), $H = N$.
        *Trong trường hợp xấu nhất là cây bị lệch (như một danh sách liên kết), $H = N$.*
    *   In a **best-case** balanced tree, $H = \log N$.
        *Trong trường hợp tốt nhất là cây cân bằng, $H = \log N$.*

---

## 5. Implementation Considerations
## *5. Những cân nhắc khi triển khai*

*   **Handling Empty Tree:** If `root` is null, it should return `false` because an empty tree has no paths (even if `targetSum` is 0).
    *Xử lý cây trống: Nếu `root` là null, nó nên trả về `false` vì một cây trống không có đường đi nào (ngay cả khi `targetSum` là 0).*
*   **Logical OR:** We use `||` because we only need **one** path to be successful.
    *Phép toán OR: Chúng ta sử dụng `||` vì chúng ta chỉ cần **một** con đường thành công.*
*   **Leaf Check:** Ensure the condition `node.left == null && node.right == null` is strictly followed.
    *Kiểm tra nút lá: Đảm bảo điều kiện `node.left == null && node.right == null` được tuân thủ nghiêm ngặt.*
