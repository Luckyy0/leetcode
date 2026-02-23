# Analysis for Complete Binary Tree Inserter
# *Phân tích cho bài toán Trình chèn Cây Nhị phân Hoàn chỉnh*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Maintain a Complete Binary Tree and support efficiently inserting new nodes to the "next available" position.
*Duy trì một Cây nhị phân Hoàn chỉnh và hỗ trợ chèn nút mới vào vị trí "khả dụng tiếp theo" một cách hiệu quả.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A complete binary tree is filled level by level from left to right.
- To insert efficiently, we need to quickly find the first node that has **less than 2 children**.
- We can maintain a `Queue` (or Deque) of nodes that are **incomplete** (have 0 or 1 child).
- Specifically, the candidates for insertion are the nodes at the bottom-most level (that are not full) and the nodes at the level above (that have children but are not fully processed yet, though usually just the bottom level matters).
- Actually, a simpler approach: perform a BFS during initialization to populate a queue with all nodes that *can* accept a child.
  - A node can accept a child if it has no left child, or if it has a left child but no right child.
  - Nodes with 2 children are "full" and removed from consideration.
- When inserting:
  - Peek at the head of the queue. This is the parent.
  - If parent has no left child, add left. Parent remains in queue (might accept right).
  - If parent has left child, add right. Parent is now full -> remove from queue.
  - Add the new node to the queue (it will eventually accept children).
*Cây nhị phân hoàn chỉnh được lấp đầy từng mức từ trái sang phải. Để chèn hiệu quả, ta cần tìm nút đầu tiên có ít hơn 2 con. Ta có thể duy trì một hàng đợi (Queue) chứa các nút chưa đầy đủ. Khi khởi tạo, dùng BFS để tìm tất cả các nút có thể nhận con. Khi chèn: Peek đầu hàng đợi làm cha. Nếu chưa có con trái -> thêm trái. Nếu đã có con trái -> thêm phải và xóa cha khỏi hàng đợi. Thêm nút mới vào cuối hàng đợi.*

---

## 2. Strategy: Queue for Insertion Candidates
## *2. Chiến lược: Hàng đợi cho các Ứng viên Chèn*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** 
    - Store `root`.
    - Create `Queue<TreeNode> deque`.
    - Perform BFS on `root`.
    - If a node has a left child, add child to BFS queue.
    - If a node has a right child, add child to BFS queue.
    - If a node DOES NOT have 2 children (i.e., missing left or missing right), add it to `deque`.
    - Wait, the `deque` should store nodes in level order that *could* be parents.
    - Standard BFS Logic:
      - Queue `q` for BFS. `q.add(root)`.
      - While `q` not empty:
        - `node = q.poll()`.
        - If `node` has left, `q.add(node.left)`.
        - If `node` has right, `q.add(node.right)`.
        - If `node` is not full (missing L or R), or actually just check:
          - The insertion point is always the first node in level-order traversal that has < 2 children.
      - Optimization: Just keep a single `deque` of *all* nodes in level order? No, too much memory.
      - Better: Keep a `deque` of nodes that **can become parents**.
      - Iterate BFS. If a node has both children, add children to queue but don't keep node as candidate.
      - If node has 1 or 0 children, Keep it at head of `deque`?
      - The `deque` should store nodes that are part of the "insertion frontier".
      - Correct Initialization:
        - `queue` contains nodes that have 0 or 1 child. AND nodes that have 2 children but their children are leaves? No.
        - Just perform a BFS to populate the `deque` with nodes that **should be considered for parenthood**.
        - Any node with 2 children is "done" as a parent.
        - Any node with 0 or 1 child is a candidate.
        - Since it's a complete tree, the candidates are contiguous in level order.
        - So, traverse level order. If a node has both children, push children to traversal queue, but discard node. If a node has < 2 children, push to `deque` (and children to traversal queue).
    *   **Khởi tạo:** Lưu `root`. Dùng BFS để tìm các nút chưa đầy đủ (có < 2 con). Đưa các nút này vào `deque`.*

2.  **Insert `v`:**
    - `parent = deque.peek()`.
    - Create `node = new TreeNode(v)`.
    - If `parent.left == null`: `parent.left = node`.
    - Else: `parent.right = node`. `deque.poll()` (Parent is now full).
    - `deque.offer(node)` (New node is a future parent).
    - Return `parent.val`.
    *   **Chèn:** Lấy cha từ đầu `deque`. Gán con trái hoặc phải. Nếu cha đầy, xóa khỏi `deque`. Thêm con mới vào cuối `deque`. Trả về giá trị cha.*

3.  **Get_root:** Return `root`.
    *   **Lấy gốc:** Trả về `root`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.deque = new LinkedList<>();
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            // If node is not full, it's a candidate for insertion
            if (node.left == null || node.right == null) {
                deque.offer(node);
            }
            
            if (node.left != null) bfs.offer(node.left);
            if (node.right != null) bfs.offer(node.right);
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = deque.peek();
        
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            deque.poll(); // Parent is full now
        }
        
        deque.offer(node); // New node can be a parent later
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
```

Wait, slight correction on initialization:
If a node has 2 children, do we add it to `deque`? No.
If a node has 1 child (left), we add it to `deque`.
If a node has 0 children, we add it to `deque`.
The BFS logic above calculates this correctly.
Also, the problem guarantees a **complete binary tree** initially.
So if we encounter a node with no children, all subsequent nodes in BFS will also have no children. They all go into `deque`.
If we encounter a node with only left child, it goes to `deque`, and subsequent nodes (leaves) go to `deque`.
The order in `deque` will be correct level-order.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:**
    - Constructor: $O(N)$ for BFS.
    - Insert: $O(1)$.
    - Get_root: $O(1)$.
    *   **Độ phức tạp thời gian:** Constructor $O(N)$, Insert $O(1)$, Get_root $O(1)$.*
*   **Space Complexity:** $O(N)$ to store the deque.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a queue to track incomplete nodes allows for O(1) insertion, maintaining the complete tree property perfectly.
*Sử dụng hàng đợi để theo dõi các nút chưa đầy đủ cho phép chèn trong O(1), duy trì hoàn hảo tính chất cây hoàn chỉnh.*
