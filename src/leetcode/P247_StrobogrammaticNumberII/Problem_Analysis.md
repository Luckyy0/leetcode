# 247. Strobogrammatic Number II / Số Strobogrammatic II

## Problem Description / Mô tả bài toán
Given an integer `n`, return all the **strobogrammatic numbers** that are of length `n`. You may return the answer in **any order**.
Cho một số nguyên `n`, hãy trả về tất cả các **số strobogrammatic** có độ dài `n`. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: n = 2
Output: ["11","69","88","96"]
```

### Example 2:
```text
Input: n = 1
Output: ["0","1","8"]
```

## Constraints / Ràng buộc
- `1 <= n <= 14`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Recursion (Peeling Onion) / Đệ quy (Bóc Hành)
To form a strobogrammatic number of length `n`:
- We can surround a strobogrammatic number of length `n-2` with a valid pair `(Left, Right)`.
- Valid outer pairs: `(1,1), (6,9), (8,8), (9,6)`.
- Note: `(0,0)` is valid pair ONLY if it's not the outermost layer (leading zeros issue), unless `n=1`.

**Algorithm**:
1.  Base Case `n=0`: Return `[""]` (empty string).
2.  Base Case `n=1`: Return `["0", "1", "8"]` (middle digits).
3.  Recursive Step:
    - `middles = findStrobogrammatic(n - 2)`
    - For each `s` in `middles`:
        - Add `1` + `s` + `1`
        - Add `6` + `s` + `9`
        - Add `8` + `s` + `8`
        - Add `9` + `s` + `6`
        - If `n` is NOT the final requested length (inner layer recursion): Add `0` + `s` + `0`.

**Implementation Detail**:
Since we need to differentiate between the "outermost" call (where 0 is forbidden) and inner calls, we can use a helper function `helper(k, n)` where `k` is current length, `n` is target length. Or just handle `0` addition specially.

But standard recursion `solve(n)` returns list for length `n`.
If we call `solve(n-2)`, we get all valid valid cores.
When adding pairs, check if `n == original_n`. If so, skip `0...0`.

Wait, actually, usually `solve(n)` builds valid numbers of length n. But `00` is valid as inner part.
So `solve(n)` should output ALL combinations (including `00`), and we filter `0...0` at the top level?
Or pass a flag `boolean finalLayer`.

Common trick: `solve(currentK, targetN)`.
If `currentK == 0` return `[""]`.
If `currentK == 1` return `["0", "1", "8"]`.
Get list from `solve(currentK - 2, targetN)`.
Add pairs. Skip `0...0` if `currentK == targetN`.

---

## Analysis / Phân tích

### Approach: Recursion Construction

**Complexity / Độ phức tạp**:
- **Time**: ~O(5^(N/2)). Roughly 5 branches per 2 length.
- **Space**: O(N) recursion stack + output storage.

---

## Edge Cases / Các trường hợp biên
1.  **n=1**: `["0", "1", "8"]`. `0` is allowed because it is the only digit (not leading if length is 1).
2.  **Leading zeros**: "010" is invalid for n=3 (length 3, leading zero implies length 2 usually, but here problem says length n number, conventionally no leading zeros). "00" invalid for n=2.
