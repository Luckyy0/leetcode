# 124. Binary Tree Maximum Path Sum / Tổng Đường Đi Tối Đa Trong Cây Nhị Phân

## Problem Description / Mô tả bài toán
A **path** in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence **at most once**. Note that the path does not need to pass through the root.
Một **đường đi** trong cây nhị phân là một chuỗi các nút trong đó mỗi cặp nút liền kề trong chuỗi có một cạnh kết nối chúng. Một nút chỉ có thể xuất hiện trong chuỗi **tối đa một lần**. Lưu ý rằng đường đi không cần phải đi qua gốc.

The **path sum** of a path is the sum of the node's values in the path.
**Tổng đường đi** của một đường đi là tổng các giá trị của các nút trong đường đi.

Given the `root` of a binary tree, return the maximum **path sum** of any **non-empty** path.
Cho `root` của một cây nhị phân, trả về **tổng đường đi** tối đa của bất kỳ đường đi **không rỗng** nào.

### Example 1:
```text
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with path sum 2 + 1 + 3 = 6.
```

### Example 2:
```text
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with path sum 15 + 20 + 7 = 42.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 3 * 10^4]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Path Types in Binary Tree / Các Loại Đường Đi trong Cây Nhị Phân

A path can be:
Một đường đi có thể là:
1.  **Single node**: Just the node itself.
2.  **Goes down only**: Node → left subtree OR Node → right subtree.
3.  **Goes through node**: LeftPath ← Node → RightPath ("arch" shape).

### Key Insight: Two Different Computations / Điểm quan trọng: Hai Phép Tính Khác nhau

For each node, we compute two things:
Đối với mỗi nút, chúng ta tính hai thứ:

1.  **Max Path THROUGH this node** (for global max):
    `node.val + max(0, leftGain) + max(0, rightGain)`
    - This can form an "arch" - cannot be extended upward.
    - Đây có thể tạo thành một "vòm" - không thể mở rộng lên trên.

2.  **Max Path ENDING at this node** (for parent to use):
    `node.val + max(0, max(leftGain, rightGain))`
    - Can only go down ONE branch (to be extendable by parent).
    - Chỉ có thể đi xuống MỘT nhánh (để có thể mở rộng bởi cha).

### Algorithm Logic / Logic Thuật toán
```
maxGain(node):
    if node == null: return 0
    
    // Get max gains from children (ignore negative gains)
    leftGain = max(0, maxGain(node.left))
    rightGain = max(0, maxGain(node.right))
    
    // Path through this node (potential global max)
    pathThroughNode = node.val + leftGain + rightGain
    globalMax = max(globalMax, pathThroughNode)
    
    // Return max extendable path (going ONE direction)
    return node.val + max(leftGain, rightGain)
```

---

## Analysis / Phân tích

### Approach: DFS with Global Max Tracking / DFS với Theo dõi Max Toàn cục

### Complexity / Độ phức tạp
- **Time**: O(N) - visit each node once.
- **Space**: O(H) - recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: Return node value.
2.  **All negative values**: Return the least negative.
3.  **Negative and positive mix**: Algorithm handles via `max(0, gain)`.
