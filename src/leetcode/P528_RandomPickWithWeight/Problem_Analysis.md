# 528. Random Pick with Weight / Chọn Ngẫu Nhiên Theo Trọng Số

## Problem Description / Mô tả bài toán
You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `i-th` index.
Bạn được cho một mảng **đánh số từ 0** gồm các số nguyên dương `w`, trong đó `w[i]` mô tả **trọng số** của chỉ số thứ `i`.

You need to implement the function `pickIndex()`, which randomly picks an index in the range `[0, w.length - 1]` (inclusive) and returns it. The probability of picking an index `i` is `w[i] / sum(w)`.
Bạn cần triển khai hàm `pickIndex()`, hàm này chọn ngẫu nhiên một chỉ số trong phạm vi `[0, w.length - 1]` (bao gồm cả hai đầu) và trả về nó. Xác suất chọn chỉ số `i` là `w[i] / sum(w)`.

### Example 1:
```text
Input
["Solution","pickIndex"]
[[[1,3]],[]]
Output
[null,1]
Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
```

## Constraints / Ràng buộc
- `1 <= w.length <= 10^4`
- `1 <= w[i] <= 10^5`
- `pickIndex` will be called at most `10^4` times.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum + Binary Search / Tổng tiền tố + Tìm kiếm nhị phân
To simulate weighted probability, we map each index to a range of numbers proportional to its weight on a number line.
Example: w = [1, 3] -> Total = 4.
Index 0 occupies range [0, 1).
Index 1 occupies range [1, 4).
If we pick a random number `x` in [0, 4), we check which range it falls into.

Algorithm:
1. Constructor:
   - Construct a `prefixSum` array where `prefixSum[i]` stores `sum(w[0]...w[i])`.
   - `totalWeight = prefixSum[last]`.
2. pickIndex:
   - Generate `target = random.nextInt(totalWeight) + 1`. (1-based for simpler binary search logic usually, or 0-based).
   - Use Binary Search (`upper_bound`) to find the first index `i` such that `prefixSum[i] >= target`.

### Complexity / Độ phức tạp
- **Time**: O(N) for constructor, O(log N) for `pickIndex`.
- **Space**: O(N) for prefix sums.

---

## Analysis / Phân tích

### Approach: Cumulative Distribution Function (CDF)

**Algorithm**:
1.  Compute prefix sums (CDF).
2.  Generate random value in total range.
3.  Binary search for random value insertion point.

---
