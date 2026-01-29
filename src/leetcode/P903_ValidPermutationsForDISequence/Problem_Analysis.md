# 903. Valid Permutations for DI Sequence / Các Hoán vị Hợp lệ cho Chuỗi DI

## Problem Description / Mô tả bài toán
You are given a string `s` of length `n` containing 'D' (Decrease) and 'I' (Increase).
Bạn được cấp một chuỗi `s` độ dài `n` chứa 'D' (Giảm) và 'I' (Tăng).

Return the number of permutations `P` of `[0, 1, ..., n]` such that for all `i`:
- If `s[i] == 'D'`, `P[i] > P[i+1]`
- If `s[i] == 'I'`, `P[i] < P[i+1]`

Modulo 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i][j]` = number of valid permutations of length `i + 1` such that the last element `P[i]` is the `j-th` smallest among the available numbers (0 to `i`).
`dp[i][j]` = số lượng hoán vị hợp lệ có độ dài `i + 1` sao cho phần tử cuối cùng `P[i]` là phần tử nhỏ thứ `j` trong số các số có sẵn (từ 0 đến `i`).

Transition:
- If `s[i-1] == 'D'`: `P[i-1] > P[i]`. We can pick any `k >= j`.
- If `s[i-1] == 'I'`: `P[i-1] < P[i]`. We can pick any `k < j`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N).

---

## Analysis / Phân tích

### Approach: Position Ranking DP
By focusing on the relative rank of the last element, we abstract away the specific values used. Every transition involves summing a range of previous ranks, which can be further optimized using prefix sums.
Bằng cách tập trung vào thứ hạng tương đối của phần tử cuối cùng, chúng ta lược bỏ các giá trị cụ thể được sử dụng. Mỗi bước chuyển đổi bao gồm việc tính tổng một phạm vi các thứ hạng trước đó, điều này có thể được tối ưu hóa hơn nữa bằng cách sử dụng tổng tiền tố.

---
