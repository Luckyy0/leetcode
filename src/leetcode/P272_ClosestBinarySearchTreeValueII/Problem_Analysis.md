# 272. Closest Binary Search Tree Value II / Giá Trị Gần Nhất Trong Cây Tìm Kiếm Nhị Phân II

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree, a `target` value, and an integer `k`, return the `k` values in the BST that are closest to the `target`. You may return the answer in **any order**.
Cho `root` của một cây tìm kiếm nhị phân, một giá trị `target` và một số nguyên `k`, hãy trả về `k` giá trị trong BST gần nhất với `target`. Bạn có thể trả về câu trả lời ở **bất kỳ thứ tự nào**.

You are guaranteed that there is only one unique set of `k` values in the BST that are closest to the `target`.
Bạn được đảm bảo rằng chỉ có một tập hợp duy nhất gồm `k` giá trị trong BST gần nhất với `target`.

### Example 1:
```text
Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
```

### Example 2:
```text
Input: root = [1], target = 0.000000, k = 1
Output: [1]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is `n`.
- `1 <= k <= n <= 10^4`.
- `0 <= Node.val <= 10^9`.
- `-10^9 <= target <= 10^9`.

**Follow up**: Assume that the BST is balanced. Could you solve it in less than `O(n)` runtime (where `n = total nodes`)?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Inorder Traversal + Sliding Window / Duyệt Trung Tự + Cửa Sổ Trượt
1.  **Simple Approach O(N)**:
    - Perform Inorder traversal to get a sorted list of all values.
    - Find the closest `k` values in the sorted list.
    - Since values are sorted, closest `k` will form a contiguous window.
    - Can use a sliding window or a `Deque`:
        - Iterate through sorted values.
        - Add values to deque.
        - If `deque.size() > k`:
            - If `abs(first - target) > abs(current - target)`, remove first (it's further away than current).
            - Else, the current value is definitely further away (and sorted means subsequent will be even further), so we can stop or just don't add? Actually, if `abs(first - target) < abs(current - target)`, then `first` is better than `current`. Since we process in order, once we reach a point where `current` is worse than `first` (the furthest 'small' el), we can stop? Not necessarily, `first` is the smallest value in the window. `current` is largest.
            - Correct checks: We want to keep `k` closest.
            - If `size > k`, we check if `head` (smallest val) is "worse" than `new_val` (largest val)? No, `head` is furthest to left. `new_val` is furthest to right.
            - If `abs(head - target) > abs(new_val - target)`, remove head.
            - Else (head is closer than new_val), then new_val (and all future vals) are worse. Stop adding! (Actually, just break loop).

### Optimized Two Stacks (O(k + log N)) / Hai Ngăn Xếp Tối Ưu
- `pred` stack: Predecessors of target (values <= target, closest first).
- `succ` stack: Successors of target (values > target, closest first).
- Initialize stacks in O(H).
- Pop `k` times from whichever stack has the closer value.

Given the constraints `N=10^4` and complexity of implementation, O(N) is very fast and cleaner. O(k + log N) is better only for huge N and very small k. I will implement the **Simple Inorder + Deque** method for robustness and readability, while mentioning the optimization.

---

## Analysis / Phân tích

### Approach: Inorder + Deque (O(N))

**Algorithm**:
1.  `Deque<Integer> q`.
2.  DFS Inorder:
    - If `q.size() < k`: `q.add(val)`.
    - Else:
        - `first = q.peekFirst()`.
        - If `abs(first - target) > abs(val - target)`: `q.pollFirst(); q.addLast(val);`.
        - Else: Return (pruning). Since traversal is strictly increasing, if current `val` is further than the furthest "small" candidate `first`, then all future `val`s will be even further.

**Pruning Detail**:
Wait, if `abs(first - target) < abs(val - target)`, it means `val` deviates more. Can we stop strictly? Yes, because Inorder yields x1 < x2 ... < xk < val < ...
If `x1` is closer to target than `val`, then `val` is "too far to the right". Any subsequent `val_next > val` will be even further. So we can `return` early from the entire traversal.

---
