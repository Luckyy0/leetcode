# 1124. Longest Well-Performing Interval / Khoảng Thời gian Hoạt động Tốt Dài nhất

## Problem Description / Mô tả bài toán
We are given `hours`, a list of the number of hours worked per day for a given employee.
A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
Return the length of the longest well-performing interval.
Một khoảng thời gian hoạt động tốt là một khoảng thời gian trong đó số ngày mệt mỏi lớn hơn hẳn số ngày không mệt mỏi.
Trả về độ dài của khoảng thời gian hoạt động tốt dài nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum with HashMap / Tổng Tiền tố với HashMap
Convert `hours` to an array where `tiring = 1` and `non-tiring = -1`.
We want longest subarray with sum > 0.
Let `prefixSum[i]` be sum from 0 to i.
We want max `j - i` such that `prefixSum[j] - prefixSum[i] > 0`.
If `prefixSum[j] > 0`, then subarray `0..j` works (`len = j + 1`).
If `prefixSum[j] <= 0`, we need to find smallest `i` such that `prefixSum[i] < prefixSum[j]`.
Actually, since we want sum > 0 (integer sum >= 1), we look for `i` where `prefixSum[i] = prefixSum[j] - 1`.
Why `-1`?
Wait, if `prefix[j] = P`, we want `P - prefix[i] >= 1`.
So `prefix[i] <= P - 1`.
In this problem, `prefix` changes by +1 or -1 at each step.
If `prefix[j]` decreases to `P`, and we want longest interval, we should look for the earliest index where prefix was `P-1`.
Why `P-1`? Because usually indices with smaller prefix sums appear even earlier (if monotonic? No).
But because step is -1, to reach P from a higher value, we must have crossed `P-1`.
So just tracking the first occurrence of `prefix[j] - 1` is sufficient.

Algorithm:
1. Initialize `sum = 0`. `map` stores first index of each sum. `map.put(0, -1)`.
2. Iterate `i`:
   - If `h > 8`, sum++. Else sum--.
   - If `sum > 0`, `maxlen = i + 1`.
   - Else:
     - `map.putIfAbsent(sum, i)`.
     - If `map.containsKey(sum - 1)`:
       - `maxlen = max(maxlen, i - map.get(sum - 1))`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix Sum Map
Transform the problem into finding the longest subarray with a positive sum. Converting values $>8$ to $+1$ and others to $-1$, the problem becomes finding $j - i$ such that $Prefix[j] - Prefix[i] \ge 1$. Since the prefix sum values change continuously by $\pm 1$, if $Prefix[j] \le 0$, the earliest index $i$ satisfying the condition must have $Prefix[i] = Prefix[j] - 1$.
Chuyển đổi bài toán thành tìm mảng con dài nhất có tổng dương. Chuyển đổi các giá trị $>8$ thành $+1$ và các giá trị khác thành $-1$, bài toán trở thành tìm $j - i$ sao cho $Prefix[j] - Prefix[i] \ge 1$. Vì các giá trị tổng tiền tố thay đổi liên tục theo $\pm 1$, nếu $Prefix[j] \le 0$, chỉ số sớm nhất $i$ thỏa mãn điều kiện phải có $Prefix[i] = Prefix[j] - 1$.

---
