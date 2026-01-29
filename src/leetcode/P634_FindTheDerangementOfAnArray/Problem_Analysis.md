# 634. Find the Derangement of An Array / Tìm Sự Xáo Trộn Của Một Mảng

## Problem Description / Mô tả bài toán
In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in its original position.
Trong toán học tổ hợp, sự xáo trộn (derangement) là một hoán vị các phần tử của một tập hợp, sao cho không có phần tử nào xuất hiện ở vị trí ban đầu của nó.

You are given an integer `n`. There is originally an array consisting of `n` integers from `1` to `n` in ascending order, return the number of derangements it can generate. Since the answer may be huge, return it modulo `10^9 + 7`.
Bạn được cho một số nguyên `n`. Ban đầu có một mảng bao gồm `n` số nguyên từ `1` đến `n` theo thứ tự tăng dần, hãy trả về số lượng xáo trộn mà nó có thể tạo ra. Vì câu trả lời có thể rất lớn, hãy trả về nó modulo `10^9 + 7`.

### Example 1:
```text
Input: n = 3
Output: 2
Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Derangements Formula) / Quy Hoạch Động
Let `D(n)` be the number of derangements of n elements.
Consider element 1. It can go to `n-1` positions (say position `k`).
Element `k` (originally at pos `k`) has two choices:
1. Go to position 1. Then we swapped 1 and k. Remaining `n-2` elements need derangement. Count: `D(n-2)`.
2. Do NOT go to position 1. Element `k` needs to go somewhere else (not k, not 1... wait, effectively it has one forbidden spot, which is 1). This is isomorphic to deranging `n-1` elements. Count: `D(n-1)`.

Recurrence: `D(n) = (n - 1) * (D(n - 1) + D(n - 2))`.
Base cases: `D(0) = 1` (or undefined), `D(1) = 0`, `D(2) = 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (store only last 2 values).

---

## Analysis / Phân tích

### Approach: Linear DP

**Algorithm**:
1.  Handle n=0, 1.
2.  Iterate from 2 to n using formula.
3.  Keep modulo arithmetic.

---
