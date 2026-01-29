# 1276. Number of Burgers with No Waste of Ingredients / Số lượng Bánh mì kẹp thịt Không lãng phí Nguyên liệu

## Problem Description / Mô tả bài toán
Jumbo Burger: 4 tomato, 1 cheese.
Small Burger: 2 tomato, 1 cheese.
Given `tomatoSlices`, `cheeseSlices`.
Find number of Jumbo and Small such that all ingredients used.
Return `[jumbo, small]`. Else empty.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### System of Linear Equations / Hệ phương trình Tuyến tính
Let `x` be Jumbo, `y` be Small.
1. `4x + 2y = tomatoSlices`
2. `x + y = cheeseSlices`

Solve for `x` and `y`.
From (2): `y = cheese - x`.
Substitute in (1): `4x + 2(cheese - x) = tomato`
`4x + 2cheese - 2x = tomato`
`2x = tomato - 2 * cheese`
`x = (tomato - 2 * cheese) / 2`.
Conditions for valid solution:
- `tomato - 2 * cheese >= 0` (non-negative x)
- `(tomato - 2 * cheese) % 2 == 0` (integer x)
- `y >= 0` (check cheese - x >= 0)

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Math Formula
Solve the system of equations. Since $Jumbo = (Tomato - 2 \times Cheese) / 2$ and $Small = Cheese - Jumbo$, we can compute the values directly. Check if valid integer non-negative solutions exist: `Tomato - 2*Cheese` must be non-negative and even, and the resulting `Small` count must also be non-negative.
Giải hệ phương trình. Vì $Jumbo = (Tomato - 2 \times Cheese) / 2$ và $Small = Cheese - Jumbo$, chúng ta có thể tính toán trực tiếp các giá trị. Kiểm tra xem có tồn tại các nghiệm số nguyên không âm hợp lệ hay không: `Tomato - 2*Cheese` phải không âm và chẵn, và số lượng `Small` thu được cũng phải không âm.

---
