# 954. Array of Doubled Pairs / Mảng của các Cặp gấp đôi

## Problem Description / Mô tả bài toán
Given an integer array `arr`, return `true` if it's possible to reorder it such that for every `i < n/2`, `arr[2*i+1] = 2 * arr[2*i]`.
Cho một mảng số nguyên `arr`, hãy trả về `true` nếu có thể sắp xếp lại mảng sao cho với mọi `i < n/2`, `arr[2*i+1] = 2 * arr[2*i]`.
In other words, the array can be paired up such that one element in each pair is double the other.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Pairing with Sorting / Ghép cặp Tham lam với Sắp xếp
Algorithm:
1. Count the frequency of each number using a `TreeMap` (to keep keys sorted by absolute value).
2. Iterate through the sorted keys `x`:
   - If `count[x] == 0`, skip.
   - If `count[2*x] < count[x]`, return `false` (not enough `2x` to pair with `x`).
   - `count[2*x] -= count[x]`.
3. Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Ordered Multiplicity Depletion
Process elements starting from those with the smallest absolute value. Since a small number $x$ must be paired with $2x$, we greedily exhaust the required "match" for $x$ from the frequency pool. Sorting ensures we don't accidentally use a potential "double" for a different pairing.
Xử lý các phần tử bắt đầu từ những phần tử có giá trị tuyệt đối nhỏ nhất. Vì một số nhỏ $x$ phải được ghép cặp với $2x$, chúng ta khai thác một cách tham lam "cặp khớp" được yêu cầu cho $x$ từ tập hợp tần suất. Việc sắp xếp đảm bảo chúng ta không vô tình sử dụng một "số gấp đôi" tiềm năng cho một lần ghép cặp khác.

---
