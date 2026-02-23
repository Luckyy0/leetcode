# Analysis for Sum of Distances in Tree
# *Phân tích cho bài toán Tổng khoảng cách trong Cây*

## 1. Problem Essence & Complexity
## *1. Bản chất vấn đề & Độ phức tạp*

### THE CHALLENGE
### *Thách thức*
We need to find the sum of distances from *every* node to all other nodes in a tree. A naive $O(N^2)$ BFS (running BFS from each node) would be too slow for $N = 3 \cdot 10^4$. We need an $O(N)$ solution. This is a classic "Re-rooting Dynamic Programming" problem.
*Chúng ta cần tìm tổng khoảng cách từ *mỗi* nút đến tất cả các nút khác trong cây. Giải pháp $O(N^2)$ (chạy BFS từ mỗi nút) sẽ quá chậm cho $N = 3 \cdot 10^4$. Cần một giải pháp $O(N)$. Đây là bài toán điển hình về "Quy hoạch động Thay đổi gốc" (Re-rooting DP).*

---

## 2. Strategy: Re-rooting DP (Two-pass DFS)
## *2. Chiến lược: Re-rooting DP (DFS hai lượt)*

### Phase 1: Post-order DFS (Calculate for arbitrary root 0)
### *Giai đoạn 1: Duyệt DFS hậu thứ tự (Tính toán cho gốc 0)*
- We pick node 0 as a temporary root.
- `count[i]`: number of nodes in the subtree rooted at `i`.
- `ans[i]`: sum of distances from `i` to all nodes in its subtree.
- **Recursive Step:** `count[i] = 1 + sum(count[child])`, `ans[i] = sum(ans[child] + count[child])`.
*Chọn nút 0 làm gốc tạm thời. `count[i]` là số lượng nút trong cây con gốc `i`. `ans[i]` (tạm thời) là tổng khoảng cách từ `i` đến các nút trong cây con của nó. Công thức: `count[i] = 1 + tổng(count[con])`, `ans[i] = tổng(ans[con] + count[con])`.*

### Phase 2: Pre-order DFS (Propagate to other roots)
### *Giai đoạn 2: Duyệt DFS tiền thứ tự (Lan truyền đến các gốc khác)*
- When we move the root from `parent` to `child`, how does the total sum change?
- `ans[child]` will be `ans[parent]` minus the nodes that are now closer, plus the nodes that are now further away.
- Distance decreases by 1 for all `count[child]` nodes in the child's subtree.
- Distance increases by 1 for all `N - count[child]` nodes NOT in the child's subtree.
- **Formula:** `ans[child] = ans[parent] - count[child] + (N - count[child])`.
*Khi chuyển gốc từ `cha` sang `con`, tổng khoảng cách thay đổi thế nào? Khoảng cách giảm đi 1 cho `count[con]` nút trong cây con của `con` (các nút này gần `con` hơn `cha`). Khoảng cách tăng thêm 1 cho `N - count[con]` nút còn lại. Công thức: `ans[con] = ans[cha] - count[con] + (N - count[con])`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] sumOfDistancesInTree(int n, int[][] edges) {
    List<Set<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new HashSet<>());
    for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
    }
    
    int[] count = new int[n];
    int[] ans = new int[n];
    
    dfs1(0, -1, adj, count, ans);
    dfs2(0, -1, n, adj, count, ans);
    
    return ans;
}

private void dfs1(int curr, int p, List<Set<Integer>> adj, int[] count, int[] ans) {
    count[curr] = 1;
    for (int child : adj.get(curr)) {
        if (child == p) continue;
        dfs1(child, curr, adj, count, ans);
        count[curr] += count[child];
        ans[curr] += ans[child] + count[child];
    }
}

private void dfs2(int curr, int p, int n, List<Set<Integer>> adj, int[] count, int[] ans) {
    for (int child : adj.get(curr)) {
        if (child == p) continue;
        ans[child] = ans[curr] - count[child] + (n - count[child]);
        dfs2(child, curr, n, adj, count, ans);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We build the adjacency list and perform two full DFS traversals.
    *   **Độ phức tạp thời gian:** $O(N)$, do duyệt DFS hai lần.*
*   **Space Complexity:** $O(N)$, to store the adjacency list and the DP arrays.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu đồ thị và mảng DP.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree:** `0-1`, `0-2`. $N=3$.
1. **DFS1 (Root 0):**
   - count[1]=1, ans[1]=0.
   - count[2]=1, ans[2]=0.
   - count[0] = 1 + 1 + 1 = 3.
   - ans[0] = (ans[1]+count[1]) + (ans[2]+count[2]) = 1 + 1 = 2.
2. **DFS2 (Move Root):**
   - Child 1: `ans[1] = ans[0] - count[1] + (3 - count[1]) = 2 - 1 + 2 = 3`.
   - Child 2: `ans[2] = ans[0] - count[2] + (3 - count[2]) = 2 - 1 + 2 = 3`.
**Result:** [2, 3, 3].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Re-rooting DP is a powerful technique for tree optimization problems where an answer is required for every node. The relationship between a parent and child root is almost always computable in $O(1)$ based on child-subtree sizes.
*Re-rooting DP là kỹ thuật mạnh mẽ cho bài toán cây khi cần đáp án cho mọi nút. Mối quan hệ giữa kết quả của nút cha và con hầu như luôn có thể tính được trong $O(1)$ dựa trên kích thước cây con.*
