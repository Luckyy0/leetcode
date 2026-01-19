# 103. Binary Tree Zigzag Level Order Traversal / Duyệt Cây Nhị Phân Theo Tầng Zigzag

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **zigzag level order traversal** of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
Cho `root` của một cây nhị phân, trả về **duyệt theo thứ tự tầng zigzag** các giá trị của các nút. (tức là, từ trái sang phải, sau đó từ phải sang trái cho tầng tiếp theo và xen kẽ giữa).

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
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
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Relationship to Level Order Traversal / Mối quan hệ với Duyệt Theo Tầng
This problem is a **variation** of Problem 102 (Level Order Traversal) with an additional constraint:
Bài toán này là một **biến thể** của Bài toán 102 (Duyệt Theo Tầng) với một ràng buộc bổ sung:
- **Even levels** (0, 2, 4, ...): Left to right
- **Odd levels** (1, 3, 5, ...): Right to left
- **Tầng chẵn** (0, 2, 4, ...): Từ trái sang phải
- **Tầng lẻ** (1, 3, 5, ...): Từ phải sang trái

### Solution Strategies / Chiến lược Giải quyết

**Strategy 1: BFS + Reverse / BFS + Đảo ngược**
- Perform standard BFS.
- After collecting each level, if it's an odd level, reverse the list.
- **Drawback**: Extra O(W) time for reversing.

**Strategy 2: BFS + LinkedList.addFirst / BFS + LinkedList.addFirst**
- Use `LinkedList` for current level.
- For odd levels, use `addFirst()` instead of `add()` to build in reverse order.
- **Benefit**: O(1) for `addFirst` on LinkedList.

**Strategy 3: Deque (Double-ended Queue) / Deque**
- Use Deque to process nodes.
- Alternate between pollFirst/addLast and pollLast/addFirst based on direction.
- More complex but shows understanding of Deque properties.

### Chosen Approach / Phương pháp được chọn
**Strategy 2** is optimal and elegant:
- Standard BFS structure maintained.
- Only change: `addFirst()` vs `add()` based on level parity.
- No extra passes over the data.

---

## Analysis / Phân tích

### Algorithm
```
1. Initialize queue with root, leftToRight = true
2. While queue is not empty:
   a. levelSize = queue.size()
   b. currentLevel = new LinkedList<>()
   c. For i = 0 to levelSize - 1:
      - node = queue.poll()
      - If leftToRight: currentLevel.add(node.val)
      - Else: currentLevel.addFirst(node.val)
      - Enqueue children (always left then right)
   d. Add currentLevel to result
   e. leftToRight = !leftToRight
3. Return result
```

### Time and Space Complexity
- **Time**: O(N) - each node visited once.
- **Space**: O(W) for queue, where W is max tree width.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return `[]`.
2.  **Single node**: Return `[[val]]` (level 0, left to right).
3.  **Skewed tree**: Each level has 1 element, direction doesn't matter.
