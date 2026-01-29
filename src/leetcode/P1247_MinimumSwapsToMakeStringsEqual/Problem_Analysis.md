# 1247. Minimum Swaps to Make Strings Equal / Số Hoán đổi Tối thiểu để Làm Chuỗi Bằng nhau

## Problem Description / Mô tả bài toán
Swap characters between `s1` and `s2` at any indices to make strings equal.
Return min swaps. Or -1.
Only 'x' and 'y'.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Pairing
Only care about indices `i` where `s1[i] != s2[i]`.
Two types of mismatches:
1. `s1[i]='x', s2[i]='y'` (Type XY)
2. `s1[i]='y', s2[i]='x'` (Type YX)
Let count of XY be `countXY`, count of YX be `countYX`.
- Pair two XYs: 1 swap. `xx` vs `yy` -> `xy` vs `xy`. (Fixes 2 mismatches).
- Pair two YXs: 1 swap. `yy` vs `xx` -> `yx` vs `yx`. (Fixes 2 mismatches).
- Pair one XY and one YX: 2 swaps. `xy` vs `yx` -> `yx` vs `yx` (swap 1) -> `xx` vs `yy` (not fixed yet? wait).
  - `xy` vs `yx`.
  - Swap 1: `s1[0]` with `s2[0]`. `yy` vs `xx`. becomes YX and XY? NO.
  - Swap `s1[0]` ('x') with `s2[1]` ('x'). `s1` becomes `xx`, `s2` becomes `yy`.
  - Then swap `s1[0]` ('x') with `s2[0]` ('y'). `s1` becomes `yx`, `s2` becomes `yx`. Fixed. 2 swaps.
Total mismatch count must be even (since each swap changes 2 chars, preserves parity of x/y counts relative). If `(countXY + countYX) % 2 != 0`, return -1.
Calculation:
`swaps = countXY / 2 + countYX / 2`.
Remaining: `remXY = countXY % 2`, `remYX = countYX % 2`.
If `remXY + remYX == 2`: add 2 swaps.
If `remXY + remYX == 0`: done.
Odd sum impossible.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Mismatch Resolution
Identify indices where characters mismatch. Count occurrences of `x` in `s1` (vs `y` in `s2`) as `xy`, and `y` in `s1` (vs `x` in `s2`) as `yx`.
- Two `xy` mismatches can be resolved in 1 swap.
- Two `yx` mismatches can be resolved in 1 swap.
- One `xy` and one `yx` require 2 swaps.
If `(xy + yx)` is odd, it's impossible (return -1).
Formula: `swaps = xy / 2 + yx / 2 + (xy % 2) * 2`. Note that `xy % 2` implies `yx % 2` must also be 1 if sum is even.
Xác định các chỉ số mà ký tự không khớp. Đếm số lần xuất hiện của `x` trong `s1` (so với `y` trong `s2`) là `xy`, và `y` trong `s1` (so với `x` trong `s2`) là `yx`.
- Hai lỗi `xy` có thể được giải quyết trong 1 lần hoán đổi.
- Hai lỗi `yx` có thể được giải quyết trong 1 lần hoán đổi.
- Một `xy` và một `yx` yêu cầu 2 lần hoán đổi.
Nếu `(xy + yx)` là lẻ, thì không thể (trả về -1).
Công thức: `swaps = xy / 2 + yx / 2 + (xy % 2) * 2`. Lưu ý rằng `xy % 2` ngụ ý `yx % 2` cũng phải là 1 nếu tổng là chẵn.

---
