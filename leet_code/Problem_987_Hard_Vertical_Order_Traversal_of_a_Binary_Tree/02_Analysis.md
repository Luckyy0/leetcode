# Analysis for Vertical Order Traversal of a Binary Tree
# *Phân tích cho bài toán Duyệt cây nhị phân theo Chiều dọc*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Traverse a binary tree by columns (left to right), then by rows (top to bottom), and finally by node value if row and column are the same.
*Duyệt cây nhị phân theo các cột (từ trái qua phải), sau đó theo các hàng (từ trên xuống dưới), và cuối cùng theo giá trị nút nếu cùng hàng và cột.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Each node needs a coordinate system `(row, col)`.
- The root is at `(0, 0)`.
- The left child goes to `(row + 1, col - 1)` and the right child goes to `(row + 1, col + 1)`.
- We need to organize the nodes such that we can easily extract them ordered by:
  1. `col` (ascending)
  2. `row` (ascending)
  3. `value` (ascending)
- Number of nodes is small (1000). A global sort or nested TreeMaps works well.
- Approach 1: Traverse the tree (DFS or BFS), store instances of `NodeData(row, col, value)` in a list, then sort the list using a custom comparator.
- Approach 2: Use `TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>` where the mapping is `col -> row -> max-heap/min-heap of values`.
- Approach 1 (List + Custom Sort) is generally cleaner to write and slightly faster in terms of constant factors compared to nested TreeMaps/PriorityQueues for Java.
*Mỗi nút cần một tọa độ (row, col). Thu thập tất cả các nút cùng tọa độ của chúng vào một danh sách. Sau đó sắp xếp danh sách này dựa trên 3 tiêu chí: cột, hàng, giá trị.*

---

## 2. Strategy: Traverse and Sort
## *2. Chiến lược: Duyệt và Sắp xếp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define DTO:** Create a class `Point` containing `row`, `col`, and `val`.
    *   **Định nghĩa DTO:** Lớp chứa hàng, cột, giá trị.*

2.  **Traverse (DFS/BFS):** Perform a DFS on the tree. Pass `row` and `col` along. Store each node as a `Point` in a global `List<Point>`.
    *   **Duyệt:** DFS cây, lưu tọa độ và giá trị.*

3.  **Sort:** Sort the list of `Point` objects.
    - Compare `col`. If different, return the difference.
    - Else compare `row`. If different, return the difference.
    - Else compare `val`. Return the difference.
    *   **Sắp xếp:** So sánh theo cột -> hàng -> giá trị.*

4.  **Format Output:**
    - Iterate through the sorted list.
    - Group node values that share the same `col` into sublists.
    - Append each sublist to the final answer.
    *   **Định dạng Đầu ra:** Nhóm các nút cùng cột.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    class Point {
        int row, col, val;
        Point(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> points = new ArrayList<>();
        dfs(root, 0, 0, points);
        
        // Custom sort
        Collections.sort(points, (p1, p2) -> {
            if (p1.col != p2.col) {
                return Integer.compare(p1.col, p2.col);
            } else if (p1.row != p2.row) {
                return Integer.compare(p1.row, p2.row);
            } else {
                return Integer.compare(p1.val, p2.val);
            }
        });
        
        List<List<Integer>> ans = new ArrayList<>();
        if (points.isEmpty()) return ans;
        
        int currCol = points.get(0).col;
        List<Integer> currList = new ArrayList<>();
        
        for (Point p : points) {
            if (p.col == currCol) {
                currList.add(p.val);
            } else {
                ans.add(currList);
                currCol = p.col;
                currList = new ArrayList<>();
                currList.add(p.val);
            }
        }
        ans.add(currList); // add the last collected list
        
        return ans;
    }
    
    private void dfs(TreeNode node, int r, int c, List<Point> points) {
        if (node == null) return;
        points.add(new Point(r, c, node.val));
        dfs(node.left, r + 1, c - 1, points);
        dfs(node.right, r + 1, c + 1, points);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of nodes, dictated by the sorting step. Traversal takes $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for the list of points and the output structure. DFS recursion stack takes $O(H)$.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DFS traversal paired with a custom sort encapsulates the sorting rules perfectly and guarantees correctness cleanly.
*Duyệt DFS kết hợp với sắp xếp tùy chỉnh bao gồm các quy tắc sắp xếp một cách hoàn hảo và đảm bảo tính đúng đắn một cách rõ ràng.*
