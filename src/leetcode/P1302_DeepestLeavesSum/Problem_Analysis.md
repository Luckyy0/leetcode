# 1302. Deepest Leaves Sum / Tổng các Lá Sâu nhất

## Problem Description / Mô tả bài toán
Binary tree. Sum values of deepest leaves.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS
BFS: Level order traversal. Last non-empty level sum is answer.
DFS: Pass `depth`. `Map<Depth, Sum>`. Track `maxDepth`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(Height).

---

## Analysis / Phân tích

### Approach: BFS (Level Order)
Perform a level-order traversal (BFS). Reset the sum at the beginning of each level. Iterate through all nodes at the current level, adding their values to the sum. When the traversal finishes, the sum variable will hold the sum of nodes at the last level (deepest leaves).
Thực hiện duyệt theo thứ tự cấp độ (BFS). Đặt lại tổng ở đầu mỗi cấp độ. Lặp qua tất cả các nút ở cấp độ hiện tại, cộng giá trị của chúng vào tổng. Khi quá trình duyệt kết thúc, biến tổng sẽ giữ tổng của các nút ở cấp độ cuối cùng (các lá sâu nhất).

---
