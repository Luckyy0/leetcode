# 1088. Confusing Number II / Số Gây nhầm lẫn II

## Problem Description / Mô tả bài toán
We can rotate digits by 180 degrees to form new digits.
Confusing number is a number that becomes a different number with each digit valid after rotation.
Given an integer `n`, return the number of confusing numbers between `1` and `n` inclusive.
Cho một số nguyên `n`, hãy trả về số lượng các số gây nhầm lẫn nằm giữa `1` và `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / Backtracking / Digit Generation / DFS / Quay lui / Tạo Chữ số
We generate numbers using valid digits: {0, 1, 6, 8, 9}.
For each number generated, check if `num <= n` and if it is confusing.
Confusing check: `rotated(num) != num`.

Algorithm:
1. `dfs(currentNum)`:
   - If `currentNum > n`, return (pruning).
   - If `currentNum` is confusing, count++.
   - For each digit `d` in {0, 1, 6, 8, 9}:
     - `nextNum = currentNum * 10 + d`.
     - `dfs(nextNum)`.
- Care with `0`: don't start number with 0 unless it is just 0 (but range is 1 to n).
- Overflow handling: `currentNum` can exceed `Integer.MAX_VALUE`. Use `long`.

Optimized check:
We can maintain "rotatedNum" during recursion to avoid recomputing.
If `num` is constructed as `d1 d2 ...`, rotated is `... rot(d2) rot(d1)`.
Wait, rotated value logic:
If `num = A * 10 + d`.
`Rot(num) = rot(d) * (10^len) + Rot(A)`? No.
`Rot(16) = 91`. `Rot(1) = 1`. `Rot(6)=9`.
`Rot(d1 d2 .. dk)` -> `rot(dk) ... rot(d1)`.
Since we build number from left to right (as `curr * 10 + d`), calculating rotated value on the fly is tricky because `d` becomes the highest power in rotated version?
No, `d` is LSB of `num`, so it becomes MSB of `rotated`.
We just need to know the current power of 10? No, we need to shift existing rotated value?
Actually `d` which is added at the end of `num` (LSB) will become MSB of `rotated`.
So `newRotated = rot(d) * 10^k + oldRotated`. Usually we just compute rotated fully at check time, or pass params. Since max digits is 9, full compute is cheap.

Count of confusing = Total valid numbers - Strobogrammatic numbers (where `num == rotated`).
Actually "confusing" means `rotated != num`.
So satisfy: `num <= n` AND (`rotated != num`).

### Complexity / Độ phức tạp
- **Time**: O(5^L) where L is digits in N.
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: Recursive Generation
Generate all numbers composed of the valid digits {0, 1, 6, 8, 9} up to the limit N using DFS. For each generated number, verify if it is "confusing" (i.e., its 180-degree rotation yields a different valid number). A number is confusing if `rotate(num) != num`. Use long to prevent overflow during construction.
Tạo tất cả các số bao gồm các chữ số hợp lệ {0, 1, 6, 8, 9} đến giới hạn N bằng cách sử dụng DFS. Đối với mỗi số được tạo, hãy xác minh xem nó có phải là "gây nhầm lẫn" không (tức là, vòng quay 180 độ của nó tạo ra một số hợp lệ khác). Một số gây nhầm lẫn nếu `rotate(num) != num`. Sử dụng long để ngăn ngừa tràn số trong quá trình xây dựng.

---
