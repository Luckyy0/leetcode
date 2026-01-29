# 514. Freedom Trail / Đường Tự Do

## Problem Description / Mô tả bài toán
Specifically, you can rotate the ring clockwise (at one cost per character) or counter-clockwise (at one cost per character). After each rotation, you must press the center button to spell the current character of the keyword (at one cost per character).
Cụ thể, bạn có thể xoay vòng theo chiều kim đồng hồ (một chi phí cho mỗi ký tự) hoặc ngược chiều kim đồng hồ (một chi phí cho mỗi ký tự). Sau mỗi lần xoay, bạn phải nhấn nút trung tâm để đánh vần ký tự hiện tại của từ khóa (một chi phí cho mỗi ký tự).

Given the `ring` and the `key`, return the minimum number of steps to spell all the characters in the `key`.
Cho `ring` (vòng) và `key` (từ khóa), hãy trả về số bước tối thiểu để đánh vần tất cả các ký tự trong `key`.

### Example 1:
```text
Input: ring = "godding", key = "gd"
Output: 4
Explanation:
For the first character 'g', it's already at index 0. Cost = 1 (press).
For the second character 'd', move to index 2 or 6. 
Index 2: dist 2. Total = 1 + 2 + 1 = 4.
Index 6: dist 1. Total = 1 + 1 + 1 = 3.
Wait, output is 4. Let's re-verify. 
- 'g' at 0 -> 1 step
- move to 'd' at 2 -> 2 steps + 1 press = 3 steps. Total 4.
```

## Constraints / Ràng buộc
- `1 <= ring.length, key.length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / BFS / Quy hoạch động / BFS
For each character in the `key`, there might be multiple occurrences in the `ring`. Choosing which occurrence to use affects the distance for the next character.

Algorithm (DP with Memoization):
1. `dfs(ringIndex, keyIndex)`:
   - If `keyIndex == key.length`, return 0.
   - If `memo[ringIndex][keyIndex]` exists, return it.
   - Find all indices `i` in the `ring` such that `ring[i] == key[keyIndex]`.
   - For each such `i`:
     - Calculate distance: `d = min(abs(i - ringIndex), ring.length - abs(i - ringIndex))`.
     - `res = min(res, d + 1 + dfs(i, keyIndex + 1))`.
2. Return the result of `dfs(0, 0)`.

### Complexity / Độ phức tạp
- **Time**: O(key.length * ring.length^2) worst case.
- **Space**: O(key.length * ring.length).

---

## Analysis / Phân tích

### Approach: Recursive Distance Minimization

**Algorithm**:
1.  Map character positions in ring.
2.  DFS through key indices.
3.  Calculate circle distance (loop around).
4.  Memoize (ringPos, keyPos).

---
