# Analysis for Maximum Depth of N-ary Tree
# *Phân tích cho bài toán Chiều sâu Tối đa của Cây N-phân*

## 1. Problem Essence & Multi-Child Traversal
## *1. Bản chất vấn đề & Duyệt Đa con*

### The Challenge
### *Thách thức*
In a binary tree, each node has at most two children. In an N-ary tree, a node can have any number of children.
*Trong cây nhị phân, mỗi nút có tối đa hai con. Trong cây N-phân, một nút có thể có bất kỳ số lượng con nào.*

We need to find the "maximum depth", which is the length of the longest path from the root down to a leaf.
*Chúng ta cần tìm "chiều sâu tối đa", tức là độ dài của con đường dài nhất từ gốc xuống đến một lá.*

---

## 2. Strategy: Recursive DFS (The Bottom-Up Approach)
## *2. Chiến lược: DFS Đệ quy (Hướng tiếp cận từ dưới lên)*

The depth of any node can be defined recursively based on the depths of its children.
*Chiều sâu của bất kỳ nút nào cũng có thể được định nghĩa đệ quy dựa trên chiều sâu của các con nó.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Base Case:** If the `root` is `null`, its depth is 0.
    * **Trường hợp cơ sở:** Nếu `root` là `null`, chiều sâu của nó là 0.*

2.  **Leaf Case:** If a node has no children, its depth is 1.
    * **Trường hợp lá:** Nếu một nút không có con, chiều sâu của nó là 1.*

3.  **Recursive Visit:** For a node with children, we call `maxDepth` on each of its children.
    * **Duyệt đệ quy:** Đối với một nút có con, chúng ta gọi `maxDepth` trên từng nút con của nó.*

4.  **Aggregate Result:** Find the maximum depth value among all children, and then add 1 (to represent the current node itself).
    * **Tổng hợp kết quả:** Tìm giá trị chiều sâu lớn nhất trong tất cả các con, sau đó cộng thêm 1 (để đại diện cho chính nút hiện tại).*
    `Depth = 1 + max(depth of child_1, depth of child_2, ..., depth of child_n)`

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Generality:** This approach works regardless of the degree (N) of the tree.
    * **Tính tổng quát:** Cách tiếp cận này hoạt động bất kể bậc (N) của cây là bao nhiêu.*
*   **Breadth-First Alternative:** While DFS is more intuitive, one could also use BFS (level-order traversal) and simply count the number of levels.
    * **Lựa chọn thay thế theo chiều rộng:** Mặc dù DFS trực quan hơn, người ta cũng có thể sử dụng BFS (duyệt theo mức) và chỉ cần đếm số lượng các mức.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of nodes in the tree. Every node is visited exactly once.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là tổng số nút trong cây. Mỗi nút được thăm chính xác một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This is used by the recursion stack. In a balanced tree, $H = \log_k N$. In a skewed tree, $H = N$.
    * **Độ phức tạp không gian:** $O(H)$, trong đó $H$ là chiều cao của cây. Không gian này được sử dụng bởi ngăn xếp đệ quy. Trong một cây cân bằng, $H = \log_k N$. Trong một cây lệch, $H = N$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** Root 1 has children [3, 2, 4]. Node 3 has children [5, 6].
- `maxDepth(5)` = 1.
- `maxDepth(6)` = 1.
- `maxDepth(3)` = 1 + max(1, 1) = 2.
- `maxDepth(2)` = 1 (no children).
- `maxDepth(4)` = 1 (no children).
- `maxDepth(1)` = 1 + max(2, 1, 1) = 3.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Recursive DFS is the cleanest implementation for tree height/depth problems.
*DFS đệ quy là cách triển khai sạch sẽ nhất cho các bài toán về chiều cao/chiều sâu của cây.*
---
*Độ sâu của một cái cây (Tree depth) phản ánh hành trình vươn xa từ gốc rễ tới những ngọn lá cuối cùng. Trong cấu trúc N-phân (N-ary), mỗi nút có thể mở ra nhiều hướng đi mới, nhưng chỉ con đường dài nhất mới định nghĩa được tầm vóc thực sự của nó.*
The depth of a tree (Tree depth) reflects the journey that extends from the roots to the very last leaves. In the N-ary structure (N-ary), each node can open up many new directions, but only the longest path can define its true stature.
