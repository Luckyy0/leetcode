# 466. Count The Repetitions / Đếm Số Lần Lặp Lại

## Problem Description / Mô tả bài toán
We define `str = [s, n]` as the string `str` which consists of the string `s` concatenated `n` times.
Chúng ta định nghĩa `str = [s, n]` là chuỗi `str` bao gồm chuỗi `s` được nối `n` lần.

- For example, `str = ["abc", 3] ="abcabcabc"`.

We define that string `s1` can be obtained from string `s2` if we can remove some characters from `s2` such that the remaining characters are `s1`.
Chúng ta nói rằng chuỗi `s1` có thể thu được từ chuỗi `s2` nếu ta có thể xóa một số ký tự khỏi `s2` sao cho phần còn lại là `s1`.

Given two strings `s1` and `s2` and two integers `n1` and `n2`, return the maximum integer `m` such that `str = [s2, m]` can be obtained from `str = [s1, n1]`.
Cho hai chuỗi `s1`, `s2` và hai số nguyên `n1`, `n2`, hãy trả về số nguyên `m` lớn nhất sao cho `str = [s2, m]` có thể thu được từ `str = [s1, n1]`.

### Example 1:
```text
Input: s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
Output: 2
Explanation: [s1, 4] = "acbacbacbacb". [s2, 2] = "abab".
"abab" appears twice in "acbacbacbacb".
Wait, the actual strings are s2*m. [s2, m] must be a subsequence of [s1, n1].
```

## Constraints / Ràng buộc
- `1 <= s1.length, s2.length <= 100`
- `1 <= n1, n2 <= 10^6`
- `s1` and `s2` consist of lowercase English letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Cycle Detection / Mô phỏng với Phát hiện chu kỳ
Since `n1` can be up to $10^6$, we cannot build the full string. We must find a cycle.
The state of our simulation is determined by the index in `s2` we are currently looking for.

Algorithm:
1. Initialize `count2 = 0` (number of times `s2` is completed) and `index2 = 0` (current index in `s2`).
2. Simulate through `n1` copies of `s1`. For each copy `i` (from 1 to `n1`):
   - Traverse through `s1`. If `s1[j] == s2[index2]`:
     - Increment `index2`.
     - If `index2 == s2.length`: Increment `count2` and reset `index2 = 0`.
   - After one full `s1`, record the state `(index2, count2)` for the current `i`.
   - If we encounter the same `index2` at two different `i_old` and `i_new`:
     - A cycle is detected!
     - Calculate how many blocks of `s1` were in the cycle: `cycleBlocks = i_new - i_old`.
     - Calculate how many `s2` were completed in the cycle: `cycleS2Count = count2_new - count2_old`.
     - Use the cycle to jump ahead:
       - `numRemainingBlocks = (n1 - i_new)`.
       - `jump = (numRemainingBlocks / cycleBlocks) * cycleS2Count`.
       - Update `count2` and `i`.
3. Finally, return `count2 / n2`.

### Complexity / Độ phức tạp
- **Time**: O(s1.length * s2.length) to find the cycle.
- **Space**: O(s2.length) to store the states for cycle detection.

---

## Analysis / Phân tích

### Approach: Block-based Cycle Jumping

**Algorithm**:
1.  Iterate through `s1` blocks.
2.  Store `(indexInS2)` to detect repetition.
3.  Jump over cycles.

---
