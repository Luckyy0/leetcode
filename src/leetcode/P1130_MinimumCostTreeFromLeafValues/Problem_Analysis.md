# 1130. Minimum Cost Tree From Leaf Values / Cây Chi phí Tối thiểu Từ Giá trị Lá

## Problem Description / Mô tả bài toán
Given an array `arr` of positive integers, consider all binary trees such that:
- Each node has either 0 or 2 children.
- The values of `arr` correspond to the values of each **leaf** in an in-order traversal of the tree.
- The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtrees.

Return the smallest possible sum of the values of each non-leaf node.
Trả về tổng nhỏ nhất có thể của các giá trị của mỗi nút không phải lá.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Greedy / DP / Ngăn xếp Đơn điệu / Tham lam / DP
Greedy approach:
Cost = sum of `max(left_leaves) * max(right_leaves)`.
To minimize total cost, we want to multiply large numbers with small numbers? No.
We want to remove small leaf values by pairing them with their smallest neighbor, so the cost `small * neighbor` is added, and `small` is removed (effectively merged into `neighbor`'s max value context).
Basically, for any leaf `L`, it will eventually be multiplied by some other leaf `R`. The cost is `L*R`. Then `L` disappears (absorbed), and the node effectively acts as `max(L, R)`.
We want to get rid of small numbers "cheaply". The cheapest way to remove a number `x` is to pair it with `min(left_neighbor, right_neighbor)`.

Algorithm (Greedy Stack):
1. Maintain a decreasing stack.
2. When current `x` > `stack.peek()`, the element `mid = stack.pop()` must be paired with either `stack.peek()` or `x`.
3. To minimize cost, pick the smaller neighbor: `cost += mid * min(stack.peek(), x)`.
4. Repeat until stack is decreasing.
5. Push `x`.
6. Finally, elements remaining in stack are merged strictly right-to-left (or left-to-right). Cost logic applies.

DP Approach:
`dp[i][j]` minimum cost for range `i` to `j`.
`dp[i][j] = min(dp[i][k] + dp[k+1][j] + max(i..k) * max(k+1..j))` for `k` in `i..j-1`.
O(N^3). Since N <= 40, this is fine.

### Complexity / Độ phức tạp
- **Time**: O(N) using Stack. O(N^3) using DP. Given N=40, both fine.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Local-Minima Merging (Stack)
We want to combine adjacent leaf nodes repeatedly until only one node remains. Every combination generates a cost (product of max leaves) and results in a new node value (max of the two). To minimize the total cost, prioritize "removing" smaller leaf values by combining them with their smaller neighbor. This is efficiently handled by a monotonic decreasing stack (finding the next greater element). When a value is popped, it's combined with the smaller of its two neighbors—the one on the stack (previous) or the current incoming one (next).
Chúng ta muốn kết hợp các nút lá liền kề lặp đi lặp lại cho đến khi chỉ còn lại một nút. Mỗi lần kết hợp tạo ra một chi phí (tích của các lá lớn nhất) và dẫn đến một giá trị nút mới (giá trị lớn nhất của cả hai). Để giảm thiểu tổng chi phí, hãy ưu tiên "loại bỏ" các giá trị lá nhỏ hơn bằng cách kết hợp chúng với hàng xóm nhỏ hơn của nó. Điều này được xử lý hiệu quả bởi một ngăn xếp giảm đơn điệu (tìm phần tử lớn hơn tiếp theo). Khi một giá trị được lấy ra, nó được kết hợp với giá trị nhỏ hơn trong hai hàng xóm của nó—giá trị trên ngăn xếp (trước đó) hoặc giá trị đến hiện tại (tiếp theo).

---
