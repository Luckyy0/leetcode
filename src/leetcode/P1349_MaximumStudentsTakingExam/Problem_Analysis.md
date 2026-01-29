# 1349. Maximum Students Taking Exam / Số lượng Sinh viên Tối đa Tham gia Kỳ thi

## Problem Description / Mô tả bài toán
Grid `seats`. '#' broken, '.' available.
Student can sit if no one in:
- Left, Right
- Upper-Left, Upper-Right
Maximize number of students.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask DP
Process row by row.
`dp[row][mask]` = max students in `row`...`m-1` given `mask` configuration of `row`.
Wait, if we process `row` to `m-1`, `dp[row][mask]` should mean max students up to `row` with `row` having `mask`? Or `row` having `mask` affecting `row+1`?
Constraints: `m, n` small (m <= 8, n <= 8).
State: `dp[row][mask]` where `mask` represents seating in current `row`.
Transition:
Iterate valid `current_mask` for `row`.
Check conflict within `current_mask` (adjacents).
Check conflict with `prev_mask` (upper-left, upper-right).
`dp[row][curr] = popcount(curr) + max(dp[row-1][prev])`.

### Complexity / Độ phức tạp
- **Time**: O(M * 2^N * 2^N). With N=8, 2^8=256. 8*256*256 ~ 500,000. Feasible.
- **Space**: O(M * 2^N) or O(2^N).

---

## Analysis / Phân tích

### Approach: DP with Bitmask
Represent each row state as a bitmask. Iterate row by row.
For `row i`, iterate all valid masks `currMask` (where students don't sit on broken seats and don't sit adjacent to each other).
For each `currMask`, iterate all valid `prevMask` from `row i-1` (where no student in `currMask` has a student in `prevMask` at Upper-Left or Upper-Right positions).
`dp[i][currMask] = count(currMask) + max(dp[i-1][prevMask])`.
Optimization: precompute valid masks for each row (no adjacent bits, no broken seats).
Biểu diễn mỗi trạng thái hàng dưới dạng bitmask. Lặp lại từng hàng.
Đối với `row i`, lặp lại tất cả các mặt nạ hợp lệ `currMask` (nơi sinh viên không ngồi trên ghế bị hỏng và không ngồi cạnh nhau).
Đối với mỗi `currMask`, lặp lại tất cả các `prevMask` hợp lệ từ `row i-1` (trong đó không có sinh viên nào trong `currMask` có sinh viên trong `prevMask` tại các vị trí Trên-Trái hoặc Trên-Phải).
`dp[i][currMask] = count(currMask) + max(dp[i-1][prevMask])`.

---
