# 1018. Binary Prefix Divisible By 5 / Tiền tố Nhị phân Chia hết cho 5

## Problem Description / Mô tả bài toán
You are given a binary array `nums`. The `i-th` prefix corresponds to the binary interpretation of `nums[0...i]`. Return a boolean array `answer` where `answer[i]` is `true` if the `i-th` prefix is divisible by 5.
Bạn được cho một mảng nhị phân `nums`. Tiền tố thứ `i` tương ứng với giá trị nhị phân của `nums[0...i]`. Hãy trả về một mảng boolean `answer`, trong đó `answer[i]` là `true` nếu tiền tố thứ `i` chia hết cho 5.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modular Accumulation / Tích lũy Modulo
We check `val % 5 == 0` for each prefix.
We can update the value iteratively: `newVal = (oldVal * 2 + digit)`.
To avoid overflow, we only keep `newVal % 5`.
Để tránh tràn số, chúng ta chỉ giữ lại `newVal % 5`.

Algorithm:
1. `curr = 0`.
2. For each bit `b` in `nums`:
   - `curr = (curr * 2 + b) % 5`.
   - `res.add(curr == 0)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) beyond result.

---

## Analysis / Phân tích

### Approach: Stateful Remainder Tracking
Track the numerical value of the binary stream modulo 5. As we append each bit, update the current remainder using the formula $(2 \times \text{rem} + \text{bit}) \pmod 5$. This prevents integer overflow and directly answers the divisibility query at each step.
Theo dõi giá trị số của luồng nhị phân modulo 5. Khi chúng ta thêm mỗi bit, hãy cập nhật số dư hiện tại bằng công thức $(2 \times \text{rem} + \text{bit}) \pmod 5$. Điều này ngăn ngừa tràn số nguyên và trả lời trực tiếp truy vấn chia hết ở mỗi bước.

---
