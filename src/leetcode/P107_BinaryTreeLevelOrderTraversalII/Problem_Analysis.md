# 107. Binary Tree Level Order Traversal II / Duyệt Cây Nhị Phân Theo Tầng II

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **bottom-up level order traversal** of its nodes' values. (i.e., from left to right, level by level from leaf to root).
Cho `root` của một cây nhị phân, trả về **duyệt theo thứ tự tầng từ dưới lên** các giá trị của các nút. (tức là, từ trái sang phải, theo từng tầng từ lá đến gốc).

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
```

### Example 2:
```text
Input: root = [1]
Output: [[1]]
```

### Example 3:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Relationship to Problem 102 / Mối quan hệ với Bài toán 102
This problem is essentially **Problem 102 (Level Order Traversal) with reversed output**.
Bài toán này về cơ bản là **Bài toán 102 (Duyệt Theo Tầng) với đầu ra đảo ngược**.

| Problem | Output Order |
|---------|--------------|
| **102** | Root to Leaf (Top-down) |
| **107** | Leaf to Root (Bottom-up) |

### Solution Strategies / Chiến lược Giải quyết

**Strategy 1: BFS + Reverse at End / BFS + Đảo ngược ở Cuối**
- Perform standard level order traversal.
- Reverse the result list at the end.
- **Time**: O(N) for BFS + O(L) for reverse where L is number of levels.

**Strategy 2: BFS + Insert at Front / BFS + Chèn vào Đầu**
- Use `LinkedList` for result.
- Insert each level at the front using `addFirst()`.
- **Time**: O(N), no extra reverse pass.

**Strategy 3: DFS with Level Tracking / DFS với Theo dõi Tầng**
- DFS approach, adding to appropriate level.
- Insert at front or reverse at end.

### Chosen Approach / Phương pháp được chọn
**Strategy 2** is elegant and efficient:
- Standard BFS structure.
- Use `result.addFirst(currentLevel)` instead of `result.add(currentLevel)`.
- O(1) insert at front for LinkedList.

---

## Analysis / Phân tích

### Algorithm
```
1. If root is null, return empty list
2. Initialize Queue with root
3. Initialize result as LinkedList (for efficient addFirst)
4. While queue is not empty:
   a. levelSize = queue.size()
   b. currentLevel = new ArrayList<>()
   c. For i = 0 to levelSize - 1:
      - node = queue.poll()
      - Add node.val to currentLevel
      - Enqueue children
   d. result.addFirst(currentLevel)  // Insert at front!
5. Return result
```

### Complexity / Độ phức tạp
- **Time**: O(N) - each node visited once.
- **Space**: O(W) for queue, where W is max tree width.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return `[]`.
2.  **Single node**: Return `[[val]]`.
3.  **Skewed tree**: Each level has 1 element.
