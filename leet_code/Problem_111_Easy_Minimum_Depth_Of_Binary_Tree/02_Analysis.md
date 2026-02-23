# Analysis for Minimum Depth of Binary Tree
# *Phân tích cho bài toán Chiều Sâu Tối Thiểu của Cây Nhị Phân*

## 1. Problem Definition & Core Concept
## *1. Định nghĩa bài toán & Khái niệm cốt lõi*

### Understanding the Objective
### *Hiểu rõ mục tiêu*
*   The goal is to find the length of the shortest path from the root node to any leaf node.
    *Mục tiêu là tìm độ dài của con đường ngắn nhất từ nút gốc đến bất kỳ nút lá nào.*
*   A **leaf node** is strictly defined as a node that has **no children** (both `left` and `right` are `null`).
    *Một **nút lá** được định nghĩa nghiêm ngặt là một nút **không có con** (cả `trái` và `phải` đều là `null`).*
*   This distinction is crucial because if a node has only one child, it is **not** a leaf, and the path must continue down to a true leaf.
    *Sự phân biệt này rất quan trọng vì nếu một nút chỉ có một con, nó **không** phải là lá, và con đường phải tiếp tục đi xuống một nút lá thực sự.*

### Input and Output
### *Dữ liệu Vào và Ra*
*   **Input:** The `root` of a binary tree. The tree can contain up to $10^5$ nodes.
    *Đầu vào: Nút `gốc` của một cây nhị phân. Cây có thể chứa tối đa $10^5$ nút.*
*   **Output:** An integer representing the minimum depth. If the tree is empty, the depth is 0.
    *Đầu ra: Một số nguyên đại diện cho chiều sâu tối thiểu. Nếu cây trống, chiều sâu là 0.*

---

## 2. Potential Pitfalls: The "One-Child" Case
## *2. Những sai lầm tiềm ẩn: Trường hợp "Một con"*

A common mistake is to simply use `1 + min(depth(left), depth(right))` for every node.
*Một sai lầm phổ biến là chỉ sử dụng `1 + min(chiều sâu(trái), chiều sâu(phải))` cho mọi nút.*

Consider Example 2: `2 -> null -> 3 -> null -> 4 ...`
*Hãy xem xét Ví dụ 2: `2 -> null -> 3 -> null -> 4 ...`*
*   The root `2` has a `null` left child and a non-null right child.
    *Nút gốc `2` có con bên trái là `null` và con bên phải không `null`.*
*   If we take `min(depth(null), depth(right))`, we get `min(0, depth(right)) = 0`.
    *Nếu chúng ta lấy `min(chiều sâu(null), chiều sâu(phải))`, chúng ta nhận được `min(0, chiều sâu(phải)) = 0`.*
*   The result would be `1 + 0 = 1`. But `2` is not a leaf! The shortest path to a leaf is actually `5`.
    *Kết quả sẽ là `1 + 0 = 1`. Nhưng `2` không phải là lá! Con đường ngắn nhất đến một lá thực sự là `5`.*

**Rule:** We only take the minimum of both children if **both** children exist. If one is missing, we must follow the path that exists.
***Quy tắc:** Chúng ta chỉ lấy giá trị tối thiểu của cả hai con nếu **cả hai** con đều tồn tại. Nếu một con bị thiếu, chúng ta phải đi theo con đường hiện có.*

---

## 3. Algorithmic Approaches
## *3. Các phương pháp giải thuật*

### Approach 1: Breadth-First Search (BFS) - Optimal for Minimum Depth
### *Hướng tiếp cận 1: Tìm kiếm theo chiều rộng (BFS) - Tối ưu cho chiều sâu tối thiểu*

*   **Logic:**
    1.  Traverse the tree level by level.
    2.  The first time we encounter a leaf node (a node with no children), the current level is the minimum depth.
    3.  This is highly efficient because we don't need to visit all nodes if a leaf is found early.
    *Sử dụng logic: Duyệt cây theo từng tầng. Lần đầu tiên chúng ta gặp một nút lá (một nút không có con), tầng hiện tại chính là chiều sâu tối thiểu. Điều này rất hiệu quả vì chúng ta không cần truy cập tất cả các nút nếu tìm thấy một lá sớm.*

*   **Pros:** Stops as soon as the answer is found.
    *Ưu điểm: Dừng lại ngay khi tìm thấy câu trả lời.*
*   **Complexity:**
    *   **Time:** $O(N)$ in the worst case (skewed tree), but often much less for balanced trees.
    *   **Space:** $O(W)$ where $W$ is the maximum width of the tree (to store the queue).

### Approach 2: Depth-First Search (DFS) - Simple Implementation
### *Hướng tiếp cận 2: Tìm kiếm theo chiều sâu (DFS) - Triển khai đơn giản*

*   **Logic:**
    1.  Recursive function `minDepth(node)`.
    2.  Base cases:
        *   If `node == null`, return 0.
        *   If `node` is a leaf (no left and no right), return 1.
    3.  If `left` is null, recurse on `right` and add 1.
    4.  If `right` is null, recurse on `left` and add 1.
    5.  If both exist, return `1 + min(minDepth(left), minDepth(right))`.
    *Sử dụng logic: Hàm đệ quy `minDepth(node)`. Các trường hợp cơ sở: Nếu nút null, trả về 0; nếu là nút lá, trả về 1. Nếu một bên null, gọi đệ quy bên còn lại. Nếu cả hai tồn tại, trả về 1 cộng với giá trị nhỏ nhất của hai bên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. In the worst case (all nodes in a single line), we must visit every node.
    *Độ phức tạp thời gian: $O(N)$. Trong trường hợp xấu nhất (tất cả các nút nằm trên một đường thẳng), chúng ta phải truy cập mọi nút.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This is for the recursive call stack. For a balanced tree, $H = \log N$. For a skewed tree, $H = N$.
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây. Đây là không gian cho ngăn xếp gọi đệ quy. Đối với một cây cân bằng, $H = \log N$. Đối với một cây bị lệch, $H = N$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

While DFS is shorter to write, **BFS** is technically better for "minimum depth" problems because it can terminate early. However, for LeetCode constraints where $N=10^5$, both methods are acceptable if implemented correctly to handle the one-child case.
*Mặc dù DFS viết ngắn gọn hơn, nhưng **BFS** về mặt kỹ thuật tốt hơn cho các bài toán "chiều sâu tối thiểu" vì nó có thể kết thúc sớm. Tuy nhiên, với các ràng buộc của LeetCode khi $N=10^5$, cả hai phương pháp đều được chấp nhận nếu được triển khai đúng cách để xử lý trường hợp một con.*
