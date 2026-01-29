# 1411. Number of Ways to Paint N × 3 Grid / Số Cách để Tô Đậm Lưới N × 3

## Problem Description / Mô tả bài toán
Grid `n x 3`. 3 colors (Red, Yellow, Green).
Adjacent cells (horizontal/vertical) different colors.
Count ways modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
Row size is constant 3.
Types of rows:
1. `ABC` types (3 colors used): E.g., RYG, RGY, YRG... (3! = 6 patterns).
2. `ABA` types (2 colors used): E.g., RYR, RGR... (3*2 = 6 patterns).
Total 12 valid row patterns.
Actually can simplify to just `type 0` (3 colors) `type 1` (2 colors).
Transitions:
- From `ABA` (2 colors):
  - Next row can be `BAB`, `BCB`, `CAC` ...
  - If previous is `121`. Next can be `212`, `232`, `312`, `313`.
  - Can transition to 3 `ABA` types and 2 `ABC` types.
- From `ABC` (3 colors):
  - If previous `123`. Next `212`, `231`, `232`, `312`.
  - Can transition to 2 `ABA` types and 2 `ABC` types.
State: `dp[i][0]` (num ways with type ABA), `dp[i][1]` (num ways with type ABC).
`newABA = 3 * ABA + 2 * ABC`
`newABC = 2 * ABA + 2 * ABC`
Wait, verify counts.
If prev `ABA` (121):
- Next `ABA`: `212`, `232`, `313`. (3 ways).
- Next `ABC`: `213`, `231`. (2 ways).
If prev `ABC` (123):
- Next `ABA`: `212`, `232`. (2 ways).
- Next `ABC`: `231`, `312`. (2 ways).
Equations correct.
Base case (n=1): `ABA`: 6 ways. `ABC`: 6 ways.
Result `ABA + ABC`.

### Complexity / Độ phức tạp
- **Time**: O(N). Matrix Exponentiation O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: DP with Pattern Types
Classify row patterns into two types:
- Type 0 (3 colors): `ABC` pattern (e.g., 123). There are 6 such assignments.
- Type 1 (2 colors): `ABA` pattern (e.g., 121). There are 6 such assignments.
Transitions:
- From Type 0 (`ABC`): Next row can be Type 0 (2 ways) or Type 1 (2 ways).
- From Type 1 (`ABA`): Next row can be Type 0 (2 ways) or Type 1 (3 ways).
Let `a` be count of Type 0, `b` be count of Type 1.
`new_a = (2 * a + 2 * b) % MOD`
`new_b = (2 * a + 3 * b) % MOD`
Initial: `a = 6`, `b = 6`.
Loop `n-1` times.
Final answer `(a + b) % MOD`.
Phân loại các mẫu hàng thành hai loại:
- Loại 0 (3 màu): `ABC`.
- Loại 1 (2 màu): `ABA`.
Chuyển đổi:
- Từ Loại 0: 2 cách Loại 0, 2 cách Loại 1.
- Từ Loại 1: 2 cách Loại 0, 3 cách Loại 1.
Khởi tạo `a=6`, `b=6`.
Lặp lại và cập nhật.

---
