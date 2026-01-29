# 437. Path Sum III / Tổng Đường Đi III

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and an integer `targetSum`, return the number of paths where the sum of the values along the path equals `targetSum`.
Cho `root` của một cây nhị phân và một số nguyên `targetSum`, hãy trả về số lượng các đường đi sao cho tổng các giá trị dọc theo đường đi đó bằng `targetSum`.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
Đường đi không cần bắt đầu từ gốc hoặc kết thúc ở lá, nhưng nó phải đi xuống (tức là chỉ di chuyển từ nút cha đến nút con).

### Example 1:
```text
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are: [5,3], [5,2,1], [-3,11]
```

### Example 2:
```text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 1000]`.
- `-10^9 <= Node.val <= 10^9`
- `-1000 <= targetSum <= 1000`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum with DFS / Tổng tiền tố với DFS
Finding a sub-segment in a path that sums to `targetSum` is equivalent to finding two indices `i, j` such that `sum(0...j) - sum(0...i) == targetSum`.
This is the same principle used in "Subarray Sum Equals K".

Algorithm:
1. Maintain a `HashMap<Long, Integer>` that stores the frequencies of prefix sums found along the current path from the root.
2. Initialize the map with `{0: 1}` (meaning a sum of 0 has been seen once, representing an empty path).
3. Perform DFS:
   - Calculate the `currentSum` from root to the current node.
   - The number of valid paths ending at the current node is the number of times `currentSum - targetSum` has appeared in our prefix sums.
   - Update the map with the `currentSum`.
   - Recursively call DFS for children.
   - **Backtrack**: Remove the `currentSum` from the map (decrement its frequency) as we move back up the tree to ensure the map only contains prefix sums from the path to the root.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) where H is the height of the tree for recursion and the prefix sum map.

---

## Analysis / Phân tích

### Approach: Hash-Mapped Prefix Sum

**Algorithm**:
1.  Recursively DFS.
2.  Use `Long` for sums to avoid overflow.
3.  Track prefix sums in HashMap.

---
