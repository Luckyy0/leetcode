# 991. Broken Calculator / Máy tính bị Hỏng

## Problem Description / Mô tả bài toán
On a broken calculator, you can only perform two operations:
Trên một chiếc máy tính bị hỏng, bạn chỉ có thể thực hiện hai thao tác:
- **Double**: Multiply the number on the display by 2.
- **Decrement**: Subtract 1 from the number on the display.

Initially, the calculator displays `startValue`. Return the minimum number of operations needed to display `target`.
Ban đầu, máy tính hiển thị `startValue`. Hãy trả về số lượng thao tác tối thiểu cần thiết để hiển thị được `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Backward approach / Tiếp cận Tham lam Ngược
It's much easier to work backward from `target` to `startValue`.
Làm việc ngược từ `target` về `startValue` sẽ dễ dàng hơn nhiều.

Backward Operations:
- If `current` is even, **divide** by 2. (This is better than incrementing twice then dividing).
- If `current` is odd, **increment** by 1.

Algorithm:
1. While `target > startValue`:
   - `ans++`.
   - If `target % 2 == 0`, `target /= 2`.
   - Else, `target++`.
2. Final `ans += (startValue - target)`.

### Complexity / Độ phức tạp
- **Time**: O(log Target).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reverse-Engineering Simplicity
Instead of deciding when to double, decide when to divide. Working backwards ensures that we only subtract (or add, in reverse) when absolutely necessary, rapidly reducing the magnitude of the target until it bridges the gap to the start value.
Thay vì quyết định khi nào nên nhân đôi, hãy quyết định khi nào nên chia. Việc làm ngược lại đảm bảo rằng chúng ta chỉ thực hiện phép trừ (hoặc phép cộng, theo chiều ngược lại) khi thực sự cần thiết, nhanh chóng giảm độ lớn của mục tiêu cho đến khi nó thu hẹp khoảng cách với giá trị bắt đầu.

---
