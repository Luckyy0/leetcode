# 517. Super Washing Machines / Máy Giặt Siêu Cấp

## Problem Description / Mô tả bài toán
You have `n` super washing machines on a line. Initially, each washing machine has some dresses or is empty.
Bạn có `n` chiếc máy giặt siêu cấp xếp trên một đường thẳng. Ban đầu, mỗi chiếc máy giặt có một số bộ quần áo hoặc trống rỗng.

In one step, you can choose any number of washing machines, and for each chosen washing machine, pass one dress to one of its adjacent washing machines at the same time.
Trong một bước, bạn có thể chọn bất kỳ số lượng máy giặt nào và đối với mỗi máy giặt được chọn, hãy chuyển đồng thời một bộ quần áo sang một trong các máy giặt liền kề của nó.

Given an integer array `machines` representing the number of dresses in each washing machine from left to right on the line, return the minimum number of steps to make all the washing machines have the same number of dresses. If it is not possible, return `-1`.
Cho một mảng mảng số nguyên `machines` biểu thị số lượng quần áo trong mỗi máy giặt từ trái sang phải, hãy trả về số bước tối thiểu để tất cả các máy giặt có cùng số lượng quần áo. Nếu không thể, hãy trả về `-1`.

### Example 1:
```text
Input: machines = [1,0,5]
Output: 3
Explanation: 
1st step:    1      0 <-- 5    =>    1     1     4
2nd step:    1 <-- 1      4    =>    2     1     3
3rd step:    2     1 <-- 3     =>    2     2     2
```

## Constraints / Ràng buộc
- `n == machines.length`
- `1 <= n <= 10^4`
- `0 <= machines[i] <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Flow balance/Greedy / Cân bằng dòng chảy/Tham lam
Total number of dresses must be divisible by `n`. Let `target = sum / n`.
For each machine, we define the "balance" as `machines[i] - target`.
The total net flow across a point between machine `i` and `i+1` is the cumulative sum of balances from `0` to `i`.
$Flux[i] = \sum_{j=0}^{i} (machines[j] - target)$

The minimum steps required is the maximum of:
1. The absolute value of the flux at any point: `abs(Flux[i])`. This is because we can only move 1 dress across a point per step.
2. The current balance of any specific machine: `machines[i] - target`. This is because a machine with a large surplus can only give away 1 dress to its neighbors per step (either left or right). Note that it can give to both, but that counts as 2 dresses being removed in terms of its balance, but only 1 per side. Actually, it can only give ONE dress total per step to one of its neighbors.

*Correction*: A single machine can only pass **one** dress to one of its adjacent machines in one step.
Wait, the rule says "pass one dress to one of its adjacent washing machines".
If a machine has a surplus of 10, it will take at least 10 steps to give them away.
If a gap needs a flow of 10, it will take at least 10 steps to pass them.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Local and Global Flow tracking

**Algorithm**:
1.  Check total dress sum divisibility.
2.  Iterate and track cumulative balance (flux).
3.  The result is `max(abs(flux), machine[i] - target)`.

---
