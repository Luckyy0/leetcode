# 842. Split Array into Fibonacci Sequence / Chia mảng thành Dãy Fibonacci

## Problem Description / Mô tả bài toán
Given a string `num` of digits, split it into a Fibonacci-like sequence `[a, b, c, ...]`.
Cho một chuỗi `num` gồm các chữ số, hãy chia nó thành một dãy giống Fibonacci `[a, b, c, ...]`.

A sequence is Fibonacci-like if `a + b = c` and each number is $\le 2^{31} - 1$ and contains no leading zeros.
Một dãy giống Fibonacci nếu `a + b = c` và mỗi số $\le 2^{31} - 1$ và không chứa các số 0 ở đầu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Quay lui
We need to find the first two numbers, then the rest of the sequence is determined.
Chúng ta cần tìm hai số đầu tiên, sau đó phần còn lại của dãy sẽ được xác định.

Algorithm:
1. Start backtracking with an empty list.
2. For the current index, try picking a substring of length `1, 2, ...`.
3. Validate the number:
   - No leading zero.
   - Value $\le$ Integer.MAX_VALUE.
4. If list size is $< 2$, add and recurse.
5. If list size is $\ge 2$, check if the current number equals the sum of the last two.
6. If it matches, add and recurse. If it's already larger than the sum, break (pruning).

### Complexity / Độ phức tạp
- **Time**: O(N^2) in worst case (not many valid starting pairs).
- **Space**: O(N) for recursion.

---

## Analysis / Phân tích

### Approach: Recursive validation
Systematically test all possible starting pairs. Once two numbers are chosen, the rest of the path is strictly constrained by the additive property.
Thử nghiệm hệ thống tất cả các cặp bắt đầu có thể. Một khi hai số được chọn, phần còn lại của đường đi bị ràng buộc nghiêm ngặt bởi thuộc tính cộng.

---
