# 1016. Binary String With Substrings Representing 1 To N / Chuỗi Nhị phân Với các Chuỗi con Đại diện cho 1 đến N

## Problem Description / Mô tả bài toán
Given a binary string `s` and a positive integer `n`, return `true` if the binary representation of every integer in the range `[1, n]` is a substring of `s`, or `false` otherwise.
Cho một chuỗi nhị phân `s` và một số nguyên dương `n`, hãy trả về `true` nếu biểu diễn nhị phân của mọi số nguyên trong khoảng `[1, n]` là một chuỗi con của `s`, hoặc `false` nếu ngược lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Matching with Constraints / Khớp Chuỗi với Ràng buộc
The length of `s` is up to 1000.
Độ dài của `s` lên tới 1000.
If `n` is large (e.g., $10^9$), it's obviously impossible for a short string `s` to contain all numbers.
A binary string of length `L` can theoretically contain roughly `L` distinct substrings.
If `n` is roughly `2000`, checking all numbers is feasible.

Algorithm:
1. Iterate `i` from `n` down to 1.
   - Or just `n/2` to `n`. (Actually, if `2k` is present, `k` is a suffix of `2k >> 1` or something? No, `binary(2k) = binary(k) + '0'`. So if `2k` is in `s`, `k` is likely in `s`, but "likely" isn't enough, we must check).
   - Safer: Check all numbers from 1 to `n`.
2. Convert `i` to binary string.
3. Check `s.contains(binString)`.
4. If checking becomes slow, note that for large `n`, `s` won't support it.
   - If `n > 1000`, we might fail early? Actually, check all 1 to N is efficient enough if `n` is small.
   - Empirically, if `n > 2 * len(s)`, it's usually false.

### Complexity / Độ phức tạp
- **Time**: O(N * L).
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Exhaustive Containment Check
Iterate through every integer from 1 to N. Convert each number to its binary form and verify its presence as a substring within S. Due to the limited length of S (1000), N cannot be arbitrarily large, making this brute-force verification computationally viable.
Lặp qua từng số nguyên từ 1 đến N. Chuyển đổi mỗi số sang dạng nhị phân và xác minh sự hiện diện của nó dưới dạng chuỗi con trong S. Do độ dài hạn chế của S (1000), N không thể lớn tùy ý, khiến việc xác minh bằng cách duyệt trâu này trở nên khả thi về mặt tính toán.

---
