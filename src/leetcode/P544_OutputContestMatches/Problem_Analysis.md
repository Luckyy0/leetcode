# 544. Output Contest Matches / Xuất Các Trận Đấu

## Problem Description / Mô tả bài toán
During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank `n` team, which is a strategy to make the contest more interesting.
Trong vòng loại trực tiếp NBA, chúng tôi luôn sắp xếp đội mạnh hơn đấu với đội yếu hơn, như đội xếp hạng 1 đấu với đội xếp hạng `n`, đây là một chiến lược để làm cho cuộc thi thú vị hơn.

Now, you're given `n` teams, where `n` is a power of 2. Return the string representation of the pairing logic.
Bây giờ, bạn được cho `n` đội, trong đó `n` là lũy thừa của 2. Hãy trả về chuỗi biểu diễn logic ghép cặp.

### Example 1:
```text
Input: n = 4
Output: "((1,4),(2,3))"
```

### Example 2:
```text
Input: n = 8
Output: "(((1,8),(4,5)),((2,7),(3,6)))"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iterative string combining / Kết hợp chuỗi lặp lại
We start with `n` teams: `[1, 2, ..., n]`.
In the first round, we pair `first` with `last`, `second` with `second_last`...
The new "team list" becomes chunks of strings: `["(1,n)", "(2,n-1)", ...]`.
The size reduces by half. We repeat until size is 1.

Algorithm:
1. Create a string array `teams` initialized with "1", "2", ... "n".
2. While `n > 1`:
   - For `i` from `0` to `n/2 - 1`:
     - `teams[i] = "(" + teams[i] + "," + teams[n - 1 - i] + ")"`.
   - `n = n / 2`.
3. Return `teams[0]`.

### Complexity / Độ phức tạp
- **Time**: O(N). The length of string grows, but total operations proportional to output size.
- **Space**: O(N) to store the strings.

---

## Analysis / Phân tích

### Approach: Simulation of Tournament Bracket

**Algorithm**:
1.  Initialize team strings.
2.  Fold array in half iteratively.
3.  Combine `team[i]` and `team[n-1-i]`.
4.  Repeat until single match remains.

---
