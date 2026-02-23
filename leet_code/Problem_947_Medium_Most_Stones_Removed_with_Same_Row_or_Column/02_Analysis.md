# Analysis for Most Stones Removed with Same Row or Column
# *Phân tích cho bài toán Xoá nhiều Đá nhất cùng Hàng hoặc Cột*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Remove stones that share a row/column with another existing stone. Maximize removed stones.
*Xóa các viên đá chia sẻ cùng hàng/cột với viên đá khác. Tối đa hóa số lượng đá bị xóa.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This problem can be modeled as finding **Connected Components** in a graph.
- Each stone is a node. An edge exists if two stones share a row or column.
- In each connected component, we can remove all stones except one (the "root" that supports the rest).
- Think about it: If we have a connected component of size `k`, we can always find a removal order to remove `k-1` stones. We can view it as a spanning tree. We remove leaves until only the root remains.
- Total Removed = Total Stones - Number of Connected Components.
- We can use **Union-Find (Disjoint Set Union)** or **DFS**.
- Since coordinates can be up to $10^4$, but $N \le 1000$, iterating all pairs takes $O(N^2)$.
- Optimization: Map row `x` and column `y` to unique ID nodes.
  - Rows: $0 \dots 10000$. Columns: $10001 \dots 20001$.
  - For each stone $(x, y)$, union node $x$ and node $y + 10001$.
  - Number of components = Number of disjoint sets formed by `x` and `y` nodes.
  - Wait, careful. Total components is counted based on stones?
  - Actually, better approach: Treat stones as nodes. Connect stone $i$ and stone $j$ if they share row/col.
  - Count components of stones.
  - If we use the row/col node trick:
    - We have row nodes and col nodes. Each stone is an edge connecting a row node and a col node.
    - This forms a bipartite graph. The number of stones we keep is the number of connected components in this bipartite graph.
    - Actually simpler: Just Union-Find on stones directly is $O(N^2)$.
    - Or simpler: Union row index and col index.
      - A stone at $(r, c)$ connects row $r$ and col $c$.
      - Union sets containing $r$ and $c + \text{OFFSET}$.
      - Count how many unique roots we have for the rows/cols involved. That's the number of components.
      - Result = $N$ - (number of components).
*Bài toán quy về tìm số Thành phần Liên thông. Trong mỗi thành phần liên thông kích thước `k`, ta có thể xóa `k-1` đá. Kết quả = `N` - số thành phần liên thông. Dùng Union-Find. Hợp nhất chỉ số hàng `r` và cột `c + OFFSET`.*

---

## 2. Strategy: Union-Find (Row-Column Union)
## *2. Chiến lược: Union-Find (Hợp nhất Hàng-Cột)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Union-Find:** Map or array to store parent of each row/col index. Since coordinates are up to $10^4$, simple array is fine. Offset cols by 10001.
    *   **Khởi tạo Union-Find:** Mảng lưu cha của chỉ số hàng/cột. Offset cột.*

2.  **Iterate Stones:** For each stone $(x, y)$:
    - `union(x, y + 10001)`.
    *   **Duyệt đá:** Hợp nhất `x` và `y + 10001`.*

3.  **Count Components:**
    - Iterate through all stones again. Find root of `x` (or `y+10001`). Add unique roots to a Set.
    - The size of this Set is the number of connected components.
    *   **Đếm thành phần:** Đếm số root duy nhất.*

4.  **Result:** `n - components`.
    *   **Kết quả:** `n - số thành phần`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // Use a map for DSU to handle sparse coordinates or just array 
        // since max coordinate 10^4 is manageable (20002 size).
        int range = 20002;
        int[] parent = new int[range];
        for (int i = 0; i < range; i++) parent[i] = i;
        
        for (int[] stone : stones) {
            union(parent, stone[0], stone[1] + 10001);
        }
        
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(find(parent, stone[0]));
        }
        
        return n - uniqueRoots.size();
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \alpha(\text{Range}))$. Almost linear.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(\text{Range})$ for parent array.
    *   **Độ phức tạp không gian:** $O(\text{Range})$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Treating rows and columns as nodes in a graph connected by stones is an elegant way to reduce dimensionality and solve using Union-Find efficiently.
*Coi hàng và cột như các nút trong đồ thị được nối bởi các viên đá là một cách thanh lịch để giảm chiều dữ liệu và giải quyết hiệu quả bằng Union-Find.*
