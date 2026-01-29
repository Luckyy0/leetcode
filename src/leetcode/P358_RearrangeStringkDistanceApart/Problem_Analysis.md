# 358. Rearrange String k Distance Apart / Sắp Xếp Lại Chuỗi Cách Nhau k Khoảng

## Problem Description / Mô tả bài toán
Given a string `s` and an integer `k`, rearrange `s` such that the same characters are at least distance `k` from each other. If it is not possible to rearrange the string, return an empty string `""`.
Cho một chuỗi `s` và một số nguyên `k`, sắp xếp lại `s` sao cho các ký tự giống nhau cách nhau ít nhất `k` khoảng. Nếu không thể sắp xếp lại, trả về chuỗi rỗng `""`.

### Example 1:
```text
Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.
```

### Example 2:
```text
Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.
```

### Example 3:
```text
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 3 * 10^5`
- `0 <= k <= s.length`
- `s` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy + PriorityQueue / Tham Lam + Hàng Đợi Ưu Tiên
To satisfy the distance `k` constraint, we should greedily pick the character with the **highest remaining frequency** that is valid to place (i.e., not placed within last `k-1` positions).
Queue Mechanism:
1.  Count frequencies.
2.  Max Heap stores `(char, frequency)`.
3.  Wait Queue: Stores characters that were recently used and are currently "cooling down".
4.  Loop N times (length of string):
    - Poll from Heap. If empty, impossible -> return "".
    - Append char to result. Decrement count.
    - Add to Wait Queue with strict ordering (Queue ensures we release them after `k` steps).
    - If Wait Queue size >= `k`: Poll from Wait Queue (oldest used). If freq > 0, add back to Heap.
    - **Wait Logic Refined**:
      The character used at index `i` becomes available at index `i + k`.
      Wait Queue stores `Map.Entry` or similar.
      At each step, push current char to Wait Queue.
      If Wait Queue size reaches `k`, the front element is now valid (distance `k` passed). Poll it and push to Heap if freq > 0.

Wait, if `k=0`, simple sort? No, just original order or any order ok. Handled correctly as Queue poll immediate.

### Complexity / Độ phức tạp
- **Time**: O(N log A) where A is alphabet size (26). So O(N).
- **Space**: O(A).

---

## Analysis / Phân tích

### Approach: Max Heap + Queue

**Edge Cases**:
1.  `k=0`: Return `s` (or sorted `s`, doesn't matter). Logic works (Queue poll immediately).
2.  Impossible: Heap empty but still need chars.

---
