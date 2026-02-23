# Analysis for Binary Tree Level Order Traversal II
# *Phân tích cho bài toán Duyệt Cây Nhị Phân Theo Tầng II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Root node of a binary tree. *Nút gốc của một cây nhị phân.*
*   **Output:** A list of lists, where each inner list contains values of nodes at a specific level, ordered from the bottom level to the top. *Một danh sách các danh sách, trong đó mỗi danh sách con chứa các giá trị của các nút tại một tầng cụ thể, được sắp xếp từ tầng cuối cùng lên đến tầng đầu tiên.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Node Count:** Up to 2000 nodes. An $O(N)$ approach is optimal and necessary. *Số lượng nút lên tới 2000. Hướng tiếp cận $O(N)$ là tối ưu và cần thiết.*
*   **Empty Tree:** The input `root` can be `null`. We must return an empty list. *Cây có thể trống. Chúng ta phải trả về một danh sách trống.*
*   **Bottom-up Order:** Unlike regular level-order traversal (Problem 102), the results must be reversed. *Thứ tự từ dưới lên: Khác với duyệt theo tầng thông thường, kết quả phải được đảo ngược.*

---

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Breadth-First Search (BFS) with Reverse Insertion
### *Hướng tiếp cận: Tìm kiếm theo chiều rộng (BFS) với Chèn ngược*

*   **Logic:**
    1.  The core logic for traversing a tree level-by-level is **BFS** using a `Queue`.
    2.  For each level, we find how many nodes it has (`size`). We process exactly that many nodes to ensure we don't accidentally start processing the next level.
    3.  Instead of appending the current level's results to the end of the final list, we insert them at the **beginning** (index 0).
    4.  By using a `LinkedList` for the final result, inserting at the front is an $O(1)$ operation.

*   **Algorithm Steps:**
    1.  Initialize `result = new LinkedList<List<Integer>>()`.
    2.  If `root == null`, return `result`.
    3.  Initialize `queue = new LinkedList<TreeNode>()`, add `root`.
    4.  While `queue` is not empty:
        *   Get `size = queue.size()`.
        *   Create `currentLevel = new ArrayList<Integer>()`.
        *   Loop `i` from 0 to `size - 1`:
            *   `node = queue.poll()`.
            *   Add `node.val` to `currentLevel`.
            *   If `node.left != null`, add to `queue`.
            *   If `node.right != null`, add to `queue`.
        *   **CRITICAL STEP:** `result.addFirst(currentLevel)` (or `result.add(0, currentLevel)`).
    5.  Return `result`.

*   **Complexity:**
    *   **Time Complexity:** $O(N)$. We visit each node exactly once. *Độ phức tạp thời gian: $O(N)$. Chúng ta truy cập mỗi nút đúng một lần.*
    *   **Space Complexity:** $O(N)$. The result list and the queue both store $N$ elements in total. The queue stores at most $W$ nodes (max width). *Độ phức tạp không gian: $O(N)$. Danh sách kết quả và hàng đợi lưu trữ tổng cộng $N$ phần tử.*

---

## 3. Dry Run
## *3. Chạy thử*

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

| Step | Queue (Start of Level) | Current Level List | Result List (Front Insertion) |
| :--- | :--- | :--- | :--- |
| **Start** | `[3]` | - | `[]` |
| **Level 0** | `[3]` | `[3]` | `[[3]]` |
| **Level 1** | `[9, 20]` | `[9, 20]` | `[[9, 20], [3]]` |
| **Level 2** | `[15, 7]` | `[15, 7]` | `[[15, 7], [9, 20], [3]]` |

**Final Result:** `[[15, 7], [9, 20], [3]]`

---

## 4. Key Takeaway
## *4. Điểm mấu chốt*
*   **Queue for Levels:** A Queue always processes nodes in their structural order (top to bottom). *Hàng đợi luôn xử lý các nút theo thứ tự cấu trúc (từ trên xuống dưới).*
*   **Result Modification:** The only difference between Level Order I and II is the **placement** of the level result in the final collection. *Sự khác biệt duy nhất giữa Duyệt theo tầng I và II là vị trí đặt kết quả tầng trong tập hợp cuối cùng.*
