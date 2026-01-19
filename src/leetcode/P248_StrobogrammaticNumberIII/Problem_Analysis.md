# 248. Strobogrammatic Number III / Số Strobogrammatic III

## Problem Description / Mô tả bài toán
Given two strings `low` and `high` that represent two integers, return the number of **strobogrammatic numbers** that are in the range `[low, high]`.
Cho hai chuỗi `low` và `high` đại diện cho hai số nguyên, hãy trả về số lượng **số strobogrammatic** nằm trong khoảng `[low, high]`.

### Example 1:
```text
Input: low = "50", high = "100"
Output: 3
Explanation: 69, 88, and 96 are three strobogrammatic numbers.
```

### Example 2:
```text
Input: low = "0", high = "0"
Output: 1
```

## Constraints / Ràng buộc
- `1 <= low.length, high.length <= 15`
- `low` and `high` consist of only digits.
- `low <= high`
- The strobogrammatic numbers should appear in the range `[low, high]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Recursive Counting with Boundary Check / Đệ quy đếm với kiểm tra biên
Instead of generating all numbers and filtering (which works if range is small but constraints `10^15` imply potentially large search space, though strobogrammatic numbers are sparse), we can modify the traversal of Problem 247.

**Generate and Filter Approach (Optimized)**:
Strobogrammatic numbers are very sparse. A length 15 range might theoretically have many numbers, but strobogrammatic ones are few.
- Max strobogrammatic numbers of length 15 roughly `4 * 5^6 ~~ 60,000`. Total for length 1..15 is very manageable (< 10^5).
- We can generate all strobogrammatic numbers of lengths `low.length` to `high.length`.
- For numbers with length == `low.length` or `high.length`, check boundary values strictly.
- For lengths strictly between `low.length` and `high.length`, all generated numbers count.

**Algorithm**:
1.  Iterate `len` from `low.length()` to `high.length()`.
2.  Use DFS helper from P247 to generate all numbers of length `len`.
3.  Inside the DFS:
    - Instead of returning a full list (memory heavy), implement a `count` variable or check logic on the fly?
    - Actually, since we need to check value against `low` and `high`, constructing the string is necessary.
    - Given the sparsity, we can construct them and update a global count if `low <= num <= high`.
4.  String Comparison:
    - If `num.length` > `low.length` and `num.length` < `high.length`: Valid.
    - If `num.length` == `low.length`: Check `num.compareTo(low) >= 0`.
    - If `num.length` == `high.length`: Check `num.compareTo(high) <= 0`.
    - Combined check: `compare(num, low) >= 0` AND `compare(num, high) <= 0`.

**Optimization**:
Do not construct the full list. Just maintain `count`. Pass `low` and `high` boundaries to the recursive function?
Or simpler: Generate all for specific lengths and filter. The total count is small enough.

---

## Analysis / Phân tích

### Approach: Recursive Generation + Filtering

**Complexity / Độ phức tạp**:
- **Time**: O(5^(N/2)). For N=15, 5^7 is ~78,000. It's fast enough.
- **Space**: O(N) recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Count = 0**: If range has none.
2.  **low = high**: If it's strobo, count 1.
3.  **"0"**: Special handling for single digit 0 if in range.
