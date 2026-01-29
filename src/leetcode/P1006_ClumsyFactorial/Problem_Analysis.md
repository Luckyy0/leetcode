# 1006. Clumsy Factorial / Giai thừa Vụng về

## Problem Description / Mô tả bài toán
The clumsy factorial of `n` is defined using the operations multiplication `*`, division `/`, addition `+`, and subtraction `-` in a fixed cycle.
Giai thừa vụng về của `n` được định nghĩa bằng cách sử dụng các phép nhân `*`, chia `/`, cộng `+`, và trừ `-` theo một chu kỳ cố định.

Example: `clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1`.
Calculate `clumsy(n)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack Simulation / Mô phỏng Ngăn xếp
Operations have precedence: `*` and `/` first, then `+` and `-`.
Các phép toán có thứ tự ưu tiên: `*` và `/` trước, sau đó là `+` và `-`.

Algorithm:
1. Maintain a stack of numbers to be summed.
2. Iterate from `N` down to 1.
3. Operations cycle: `*`, `/`, `+`, `-`.
4. If `*`: pop, multiply, push.
5. If `/`: pop, divide, push.
6. If `+`: push directly.
7. If `-`: push negative value.
8. Sum the stack.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Precedence-aware Accumulation
Process the sequence of numbers and operators. Since multiplication and division bind tighter than addition and subtraction, perform these high-priority operations immediately as they arrive. Store the additive terms (positive or negative) in a buffer to be summed at the end.
Xử lý chuỗi số và toán tử. Vì phép nhân và phép chia liên kết chặt chẽ hơn phép cộng và phép trừ, hãy thực hiện các phép toán ưu tiên cao này ngay khi chúng đến. Lưu trữ các số hạng cộng (dương hoặc âm) trong bộ đệm để tính tổng ở cuối.

---
