# 1042. Flower Planting With No Adjacent / Trồng Hoa Không Liền kề

## Problem Description / Mô tả bài toán
You have `n` gardens, labeled `1` to `n`. There are `paths` connecting some gardens. Note that paths form a graph where each garden has at most 3 paths coming into or leaving it.
Bạn có `n` khu vườn, được đánh số từ `1` đến `n`. Có các `paths` kết nối một số khu vườn. Lưu ý rằng các con đường tạo thành một đồ thị trong đó mỗi khu vườn có tối đa 3 con đường đi vào hoặc đi ra khỏi nó.

You want to choose a flower type for each garden from 4 types (1, 2, 3, 4).
Ensure that for every `path` connecting `x` and `y`, `gardens[x]` is not equal to `gardens[y]`.
Bạn muốn chọn một loại hoa cho mỗi khu vườn từ 4 loại (1, 2, 3, 4). Đảm bảo rằng với mọi `path` kết nối `x` và `y`, `gardens[x]` không bằng `gardens[y]`.

Return *any* valid answer.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Graph Coloring / Tô màu Đồ thị Tham lam
Since the maximum degree of any node is 3, and we have 4 colors, a greedy strategy will **always** work.
Vì bậc tối đa của bất kỳ nút nào là 3 và chúng ta có 4 màu, chiến lược tham lam sẽ **luôn** hoạt động.
We can simply visit each node and pick a color that is not used by its already-colored neighbors.

Algorithm:
1. Build adjacency list for the graph.
2. Iterate `i` from 1 to `n`.
3. Check colors of neighbors of `i`.
4. Assign `i` the smallest color code (1-4) that is not present in neighbors.

### Complexity / Độ phức tạp
- **Time**: O(N + E).
- **Space**: O(N + E).

---

## Analysis / Phân tích

### Approach: Greedy Saturation
Construct the graph and iterate through the gardens sequentially. For each garden, inspect its assigned neighbors and select the first available flower type from the set {1, 2, 3, 4}. The constraint (degree $\le$ 3) guarantees that at least one color is always free.
Xây dựng đồ thị và lặp qua các khu vườn một cách tuần tự. Đối với mỗi khu vườn, hãy kiểm tra các hàng xóm đã được gán màu của nó và chọn loại hoa có sẵn đầu tiên từ tập hợp {1, 2, 3, 4}. Ràng buộc (bậc $\le$ 3) đảm bảo rằng ít nhất một màu luôn rảnh.

---
