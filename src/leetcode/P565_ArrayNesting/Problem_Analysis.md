# 565. Array Nesting / Lồng Ghép Mảng

## Problem Description / Mô tả bài toán
You are given an integer array `nums` of length `n` where `nums` is a permutation of the numbers in the range `[0, n - 1]`.
Bạn được cho một mảng số nguyên `nums` có độ dài `n`, trong đó `nums` là một hoán vị của các số trong phạm vi `[0, n - 1]`.

You should build a set `s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... }` subjected to the rule below.
Bạn nên xây dựng một tập hợp `s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... }` tuân theo quy tắc dưới đây.

The first element in `s[k]` starts with the selection of the element `nums[k]` of index = `k`. The next element in `s[k]` should be `nums[nums[k]]`, and then `nums[nums[nums[k]]]`, and so on.
Phần tử đầu tiên trong `s[k]` bắt đầu bằng việc chọn phần tử `nums[k]` của chỉ số = `k`. Phần tử tiếp theo trong `s[k]` phải là `nums[nums[k]]`, và sau đó là `nums[nums[nums[k]]]`, v.v.

We stop adding right before a duplicate element occurs in `s[k]`.
Chúng ta dừng thêm ngay trước khi một phần tử trùng lặp xuất hiện trong `s[k]`.

Return the longest length of a set `s[k]`.
Hãy trả về độ dài lớn nhất của một tập hợp `s[k]`.

### Example 1:
```text
Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cycle Detection / Phát Hiện Chu Trình
Since `nums` is a permutation of `0` to `n-1`, the structure consists of several disjoint cycles.
Each element belongs to exactly one cycle.
The length of the set starting at `k` is simply the length of the cycle containing `k`.

Algorithm:
1. Initialize `maxLen = 0`.
2. Initialize `visited` boolean array.
3. Iterate `i` from `0` to `n-1`:
   - If `!visited[i]`:
     - Start traversing the cycle starting at `i`.
     - `count = 0`, `curr = i`.
     - While `!visited[curr]`:
       - `visited[curr] = true`.
       - `curr = nums[curr]`.
       - `count++`.
     - `maxLen = max(maxLen, count)`.
4. Return `maxLen`.

### Complexity / Độ phức tạp
- **Time**: O(N). Each node is visited once.
- **Space**: O(N) for visited array (or O(1) if modifying `nums` to mark visited, e.g., setting to -1).

---

## Analysis / Phân tích

### Approach: Cycle Decomposition

**Algorithm**:
1.  Iterate through array.
2.  If element unvisited, follow the permutation cycle.
3.  Mark elements as visited.
4.  Count cycle length and update maximum.

---
