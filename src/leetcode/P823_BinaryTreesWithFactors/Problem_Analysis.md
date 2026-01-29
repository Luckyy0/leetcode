# 823. Binary Trees With Factors / Cây Nhị phân với các Thừa số

## Problem Description / Mô tả bài toán
Given an array of unique integers `arr`, where each integer `arr[i] > 1`.
Cho một mảng các số nguyên duy nhất `arr`, trong đó mỗi số nguyên `arr[i] > 1`.

We make a binary tree using these integers. Each node can have zero or two children. If a node has two children with values `left` and `right`, then `node.val = left * right`.
Chúng ta tạo một cây nhị phân bằng các số nguyên này. Mỗi nút có thể có không hoặc hai nút con. Nếu một nút có hai nút con với các giá trị `left` và `right`, thì `node.val = left * right`.

Return the number of binary trees we can make. Since the answer may be large, return it **modulo 10^9 + 7**.
Trả về số lượng cây nhị phân chúng ta có thể tạo ra. Vì câu trả lời có thể lớn, hãy trả về kết quả theo **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Mapping / Quy hoạch Động / Ánh xạ
Let `dp[v]` be the number of trees with root value `v`.
Gọi `dp[v]` là số lượng cây có giá trị gốc là `v`.

Algorithm:
1. Sort `arr` (to process smaller values first).
2. For each element `v` in `arr`:
   - Initially, `dp[v] = 1`. (Base case: single node).
   - Try to find factors `a` and `b` in `arr` such that `a * b = v`.
   - If found, add `dp[a] * dp[b]` to `dp[v]`.
   - Since `left` and `right` can be swapped (if `a != b`), we add the products carefully.

Optimization:
- Use a `HashMap` for fast lookup of `a` and `b`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Constructive DP
Build solutions for larger numbers using previously computed solutions for their factors. By sorting the array, we ensure that the required factor counts are always available before they are needed.
Xây dựng các giải pháp cho các số lớn hơn bằng cách sử dụng các giải pháp đã được tính toán trước đó cho các thừa số của chúng. Bằng cách sắp xếp mảng, chúng ta đảm bảo rằng số lượng thừa số cần thiết luôn có sẵn trước khi chúng được yêu cầu.

---
