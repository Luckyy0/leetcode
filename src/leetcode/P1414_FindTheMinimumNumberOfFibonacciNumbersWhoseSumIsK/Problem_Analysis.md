# 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K / Tìm Số lượng Số Fibonacci Tối thiểu có Tổng là K

## Problem Description / Mô tả bài toán
Integer `k`.
Sum of Fibonacci numbers equal to `k`. Each can be used multiple times? No, usually distinct implied or set? "Sum of Fibonacci numbers".
Usually greedy works best for Fibonacci representation (Zeckendorf's theorem says unique rep with non-consecutive distinct, but here minimum number? Greedy works for Fib).
Return min count.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach
Generate Fibonacci numbers <= k.
Subtract largest Fib number <= k from k.
Repeat until k=0.
Why Greedy works: Fibonacci numbers grow exponentially, greedy is optimal.

### Complexity / Độ phức tạp
- **Time**: O(log K).
- **Space**: O(log K).

---

## Analysis / Phân tích

### Approach: Greedy with Precomputed Fibs
Generate all terms of Fibonacci sequence less than or equal to `k`. Iterate from the largest term backwards. If a term `f` is less than or equal to `currentK`, subtract it from `currentK` and increment the count. Repeat until `currentK` is 0.
Tạo tất cả các số hạng của dãy Fibonacci nhỏ hơn hoặc bằng `k`. Lặp lại từ số hạng lớn nhất về phía sau. Nếu số hạng `f` nhỏ hơn hoặc bằng `currentK`, hãy trừ nó khỏi `currentK` và tăng số đếm. Lặp lại cho đến khi `currentK` bằng 0.

---
