# 988. Smallest String Starting From Leaf / Chuỗi Nhỏ nhất Bắt đầu từ Lá

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree where nodes have values from 0 to 25 representing characters 'a' to 'z', find the lexicographically smallest string that starts at a leaf and ends at the root.
Cho `root` của một cây nhị phân trong đó các nút có giá trị từ 0 đến 25 đại diện cho các ký tự 'a' đến 'z', hãy tìm chuỗi nhỏ nhất theo thứ tự từ điển được bắt đầu tại một lá và kết thúc tại gốc.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth-First Search (DFS) / Tìm kiếm theo chiều sâu (DFS)
Algorithm:
1. `dfs(node, currentString)`:
   - Prepend `char(node.val + 'a')` to `currentString`.
   - If node is a leaf:
     - Compare `currentString` with the global `smallest`.
   - Recurse `dfs(left)` and `dfs(right)`.

Important: Strings are constructed from leaf to root, but it's easier to build them root-to-leaf and then reverse them, OR prepend characters in each step.
Lưu ý: Các chuỗi được xây dựng từ lá đến gốc, nhưng sẽ dễ dàng hơn khi xây dựng chúng từ gốc đến lá rồi đảo ngược, HOẶC thêm các ký tự vào đầu trong mỗi bước.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where L is max path length (string comparisons).
- **Space**: O(H * L).

---

## Analysis / Phân tích

### Approach: Leaf-to-Root aggregation
Explore all paths from the root to every leaf. At each leaf, reverse the accumulated character sequence to form the path string. By comparing all such strings, we identify the lexicographically earliest sequence.
Khám phá tất cả các đường dẫn từ gốc đến mọi lá. Tại mỗi lá, đảo ngược chuỗi ký tự tích lũy được để tạo thành chuỗi đường dẫn. Bằng cách so sánh tất cả các chuỗi như vậy, chúng ta xác định được chuỗi xuất hiện sớm nhất theo thứ tự từ điển.

---
