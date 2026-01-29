# 1402. Reducing Dishes / Giảm Món Ăn

## Problem Description / Mô tả bài toán
Array `satisfaction`. Cook any number of dishes in any order.
Time 1, 2, 3...
Total coeff = `sum(time[i] * satisfaction[i])`.
Maximize coeff.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy + Prefix Sum
Sort `satisfaction` descending.
Iterate and add dishes as long as they increase the total gain.
Current dish `s` adds `s` to sum, and all previous dishes are pushed 1 unit time further (adding their sum again).
Actually:
Let sorted DESC: `s1, s2, s3...`.
Taking 1: `1*s1`. Total `s1`.
Taking 2: `1*s2 + 2*s1`? No, specific order.
We want larger satisfaction at later times.
So sort ASCENDING: `-1, -8, 0, 5, 9`.
We should take positive ones: `0*1 + 5*2 + 9*3`.
Should we take negatives?
Sort DESC: `9, 5, 0, -1, -8`.
Step 1: take `9`. Value `9`. Sum `9`.
Step 2: take `5, 9`. Value `5*1 + 9*2 = 23`. Delta: added `5` and `9` shifted (added `9` again). Delta `5+9`.
Usually:
`current_suffix_sum += s[i]`
`current_total += current_suffix_sum`
If `current_suffix_sum > 0`, it helped.
Iterate from largest to smallest. Stop when prefix sum becomes negative.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1) or O(log N) stack.

---

## Analysis / Phân tích

### Approach: Greedy Suffix Sum
Sort the satisfaction array in descending order.
Iterate through the array, maintaining a `currentSum` (sum of elements picked so far) and `totalCoef` (current coefficient sum).
In each step, adding a new element `x` effectively adds `currentSum + x` to the `totalCoef` (because existing elements are shifted by 1 time unit, adding their sum again, and new element x is added at time 1? No, logic is reverse usually for suffix).
Wait. If we process `s1` (largest), time 1. `1*s1`.
Adding `s2`: `s2` at time 1, `s1` at time 2. Total `1*s2 + 2*s1`. Increase is `s2 + s1`.
Wait. Difference: `(s2 + 2s1) - (s1) = s2 + s1`.
So at each step, we add `(sum of all picked elements)` to the total result.
We should pick element `x` if `sum of picked + x > 0`.
Algorithm:
1. Sort DESC.
2. Loop `x` in sorted:
   `if (prefixSum + x > 0)`:
     `prefixSum += x`
     `res += prefixSum`
   `else`: break.
Return `res`.
Sắp xếp mảng theo thứ tự giảm dần.
Lặp qua mảng, duy trì `currentSum` (tổng các phần tử đã chọn) và `totalCoef` (tổng hệ số hiện tại).
Thuật toán:
1. Sắp xếp DESC.
2. Lặp `x` trong danh sách đã sắp xếp:
   `if (prefixSum + x > 0)`:
     `prefixSum += x`
     `res += prefixSum`
   `else`: break.
Trả về `res`.

---
