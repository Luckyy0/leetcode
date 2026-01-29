# 1521. Find a Value of a Mysterious Function Closest to Target / Tìm Giá trị của Hàm Bí ẩn Gần nhất với Mục tiêu

## Problem Description / Mô tả bài toán
Func(arr, l, r) = arr[l] & ... & arr[r].
Find sub-array AND sum closest to `target`.
Return `|func(arr, l, r) - target|`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitwise AND Monotonicity
For fixed `r`, as `l` decreases, AND value stays same or decreases (bits turn off).
The number of unique AND values ending at `r` is small (at most 32 because each change unsets bits).
Maintain a set of reachable AND values ending at current index.
Update set for next index: `newSet = { x & arr[i] | x in prevSet } U { arr[i] }`.
Check `abs(val - target)` for all generated values.

### Complexity / Độ phức tạp
- **Time**: O(N * 30).
- **Space**: O(30).

---

## Analysis / Phân tích

### Approach: Set Iteration
Maintain `valid` set.
Iterate num in `arr`.
`newValid` set.
Add `num`. For each `v` in `valid`, add `v & num`.
Update answer.
Set `valid = newValid`.
Duy trì tập `valid`.
Lặp số trong `arr`.
Bộ `newValid`.
Thêm `num`. Đối với mỗi `v` trong `valid`, hãy thêm `v & num`.
Cập nhật câu trả lời.
Đặt `valid = newValid`.

---
