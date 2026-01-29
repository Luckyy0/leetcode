# 1137. N-th Tribonacci Number / Số Tribonacci thứ N

## Problem Description / Mô tả bài toán
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given `n`, return the value of Tn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Iteration / Quy hoạch Động / Lặp
Store previous 3 values.
T(n) = T(n-1) + T(n-2) + T(n-3).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterative Calculation
Use three variables to store the last three Tribonacci numbers. Iteratively update them to compute the next number in the sequence until reaching $N$. This avoids the overhead of recursion or a full array.
Sử dụng ba biến để lưu trữ ba số Tribonacci cuối cùng. Cập nhật lặp lại chúng để tính số tiếp theo trong chuỗi cho đến khi đạt đến $N$. Điều này tránh chi phí đệ quy hoặc một mảng đầy đủ.

---
