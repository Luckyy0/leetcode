# 1377. Frog Position After T Seconds / Vị trí Ếch sau T Giây

## Problem Description / Mô tả bài toán
Tree (undirected). Frog starts at vertex 1.
Each second, jumps to unvisited neighbor.
Probability equal among neighbors.
If no unvisited neighbors, stays there forever.
Find probability frog is at `target` after `t` seconds.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Probability
DFS(node, time, prob).
If `node == target`:
- If `time == t` OR (`time < t` and `isLeaf` (no unvisited neighbors)): return `prob`.
- Else (time < t but can jump): return 0 (must jump).
If `time >= t`: return 0 (didn't reach or overshot logic handled).
Moves:
Count children (unvisited neighbors).
If children > 0:
  Prob for each child = `prob / children`.
  Recurse.
If children == 0 (stuck):
  Wait. Frog stays forever.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DFS to Search Target
Perform DFS from node 1. Maintain `current_time` and `current_prob`.
Traverse to children. Keep track of parent to avoid going back.
If we reach `target`:
- Check conditions: `current_time == t` or (`current_time < t` and no children to jump to).
- If valid, return `current_prob`. Else 0.
If `current_time == t` and not target, return 0.
If valid path found, return prob. Since it's a tree, path is unique. We just need to find the unique path to target and verify time/leaf conditions.
Path finding approach:
Find path from 1 to target. Let path length be `L`.
If `L > t`, return 0. (Can't reach).
At each step on path, calculate probability (1 / degree).
Degree needs care: for root, degree in adj list. For others, `degree - 1` (exclude parent).
Special check: If `L < t`, we must be stuck at target (no children). If target has children, we would have jumped away. So if `L < t` and target is not leaf, return 0.

Path finding logic is faster but DFS handles it implicitly.
DFS logic:
At node `u`, time `time`.
`next_time = time + 1`.
`count = unvisited_children`.
If `u == target`:
  If `next_time > t + 1`: (Wait, logic? If `time == t`, perfect. If `time < t` and `count == 0` (leaf), perfect. Else 0).
  Return `prob`.
If `time == t`: return 0 (since not target).
Recurse to unvisited neighbors with `prob / count`.
Thực hiện DFS từ nút 1. Duy trì `current_time` và `current_prob`.
Di chuyển đến các con. Theo dõi cha để tránh quay lại.
Nếu chúng ta đến `target`:
- Kiểm tra các điều kiện: `current_time == t` hoặc (`current_time < t` và không có con để nhảy tới).
- Nếu hợp lệ, trả về `current_prob`. Ngược lại 0.
Nếu `current_time == t` và không phải target, trả về 0.
Nếu tìm thấy đường dẫn hợp lệ, trả về prob. Vì đó là một cái cây, đường dẫn là duy nhất. Chúng ta chỉ cần tìm đường dẫn duy nhất đến target và xác minh các điều kiện thời gian/lá.

---
