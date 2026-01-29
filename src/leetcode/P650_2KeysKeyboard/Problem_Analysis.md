# 650. 2 Keys Keyboard / Bàn Phím 2 Phím

## Problem Description / Mô tả bài toán
There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
Chỉ có một ký tự 'A' trên màn hình của notepad. Bạn có thể thực hiện một trong hai thao tác trên notepad này cho mỗi bước:
1. Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
   Sao chép tất cả: Bạn có thể sao chép tất cả các ký tự hiện có trên màn hình (không được phép sao chép một phần).
2. Paste: You can paste the characters which are copied last time.
   Dán: Bạn có thể dán các ký tự đã được sao chép lần trước.

Given an integer `n`, return the minimum number of operations to get the character 'A' exactly `n` times on the screen.
Cho một số nguyên `n`, hãy trả về số thao tác tối thiểu để có được ký tự 'A' chính xác `n` lần trên màn hình.

### Example 1:
```text
Input: n = 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
Step 1: Copy All. Result: 'A', Buffer: 'A'
Step 2: Paste. Result: 'AA', Buffer: 'A'
Step 3: Paste. Result: 'AAA', Buffer: 'A'
Total 3 steps.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prime Factorization / Mathematical / Phân Tích Thừa Số Nguyên Tố / Toán Học
Operations sequence usually looks like: Copy, Paste, Paste ... Copy, Paste ...
When we copy a string of length `i`, and paste `k-1` times, we get `i * k` characters. Cost is `k` steps (1 copy + k-1 pastes).
This is recursive. To get `n`, we might reach it from `n/k` using `k` steps.
We want to minimize sum of steps. `n = p1 * p2 * ... * pm`. Total steps = `p1 + p2 + ... + pm`.
This holds because `p_i` steps multiplies current count by `p_i`.
To minimize sum of factors, we should use prime factors.
e.g. 12 = 2 * 2 * 3. Steps = 2 + 2 + 3 = 7.
Start 1 -> (Copy, Paste) -> 2 -> (Copy, Paste) -> 4 -> (Copy, Paste, Paste) -> 12.

Algorithm: Sum of prime factors of `n`.

### Complexity / Độ phức tạp
- **Time**: O(sqrt(N)) to find prime factors.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sum of Prime Factors

**Algorithm**:
1.  Initialize sum = 0.
2.  Factorize `n` starting from prime `d=2`.
3.  While `n % d == 0`, add `d` to sum, `n /= d`.
4.  Increment `d`.
5.  Return sum.

---
