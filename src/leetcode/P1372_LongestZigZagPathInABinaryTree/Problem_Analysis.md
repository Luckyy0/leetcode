# 1372. Longest ZigZag Path in a Binary Tree / Đường ZigZag Dài nhất trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Binary Tree. ZigZag path: move left, then right, then left... or right, then left...
Find max length (number of edges).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with State
Recursion `dfs(node, direction, length)`.
Direction: 0 (left), 1 (right).
At each node:
- If current matching (e.g. came from Right, going Left?), extend length.
- If not matching (came from Right, trying Right again), reset length to 1 (start new path).
Actually simpler:
`solve(node, isRight, len)`
If we go opposite, `len+1`.
If we go same, `1`.
Max length stored globally.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: DFS Recursion
Define a recursive function `dfs(node, direction, length)` where `direction` indicates whether we arrived from a left child or a right child (or expected direction).
Actually better: `dfs(node, goLeft, len)`.
If `goLeft` is true, we should go `node.left`.
- If `node.left` exists: call `dfs(node.left, false, len + 1)`.
- If `node.right` exists: call `dfs(node.right, true, 1)` (start new zigzag).
Similar logic for `goLeft` false.
Start from root with both directions (len 0).
Actually, simpler visualization:
At any node, we have 2 potential paths starting (or continuing) from it:
1. `maxLeft`: Max zigzag length going left from here.
2. `maxRight`: Max zigzag length going right from here.
`maxLeft` depends on `node.left`'s `maxRight`. Specifically `1 + maxRight(node.left)`.
`maxRight` depends on `node.right`'s `maxLeft`. Specifically `1 + maxLeft(node.right)`.
DFS returns pairs `{maxLeft, maxRight}` (or updates global max).
If node is null, return -1 (so parent adding 1 gets 0).
Update global maximum with `max(maxLeft, maxRight)`.

Xác định một hàm đệ quy `dfs(node, direction, length)` trong đó `direction` chỉ ra liệu chúng ta đến từ con trái hay con phải.
Thực ra đơn giản hơn:
Tại bất kỳ nút nào, chúng ta có 2 đường dẫn tiềm năng bắt đầu (hoặc tiếp tục) từ nó:
1. `maxLeft`: Độ dài zigzag tối đa đi sang trái từ đây.
2. `maxRight`: Độ dài zigzag tối đa đi sang phải từ đây.
`maxLeft` phụ thuộc vào `maxRight` của `node.left`. Cụ thể `1 + maxRight(node.left)`.
`maxRight` phụ thuộc vào `maxLeft` của `node.right`. Cụ thể `1 + maxLeft(node.right)`.
DFS trả về các cặp `{maxLeft, maxRight}` (hoặc cập nhật tối đa toàn cục).
Nếu nút là null, trả về -1 (để cha thêm 1 nhận được 0).
Cập nhật tối đa toàn cục với `max(maxLeft, maxRight)`.

---
