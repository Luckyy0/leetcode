# 1131. Maximum of Absolute Value Expression / Giá trị Tuyệt đối Lớn nhất của Biểu thức

## Problem Description / Mô tả bài toán
Given two arrays of integers with equal length, return the maximum value of:
`|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|`
where the maximum is taken over all `0 <= i, j < arr1.length`.
Cho hai mảng các số nguyên có độ dài bằng nhau, hãy trả về giá trị lớn nhất của:
`|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|`
trong đó giá trị lớn nhất được lấy trên tất cả `0 <= i, j < arr1.length`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Expansion of Absolute Value / Mở rộng Toán học về Giá trị Tuyệt đối
`|A| + |B| + |C| = max(A+B+C, A+B-C, A-B+C, A-B-C, ...)` (8 combinations).
Since `|i - j|` is symmetric, we can assume `i >= j` and treat it as `(i - j)`.
Expression:
`max(`
  `(arr1[i] - arr1[j]) + (arr2[i] - arr2[j]) + (i - j)`,
  `(arr1[i] - arr1[j]) - (arr2[i] - arr2[j]) + (i - j)`,
  `...`
`)`
Group by `i` and `j`:
`expr = max(`
  `(arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)`,
  `(arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)`,
  `...`
`)`
In general, for each of the 4 sign combinations of `arr1` and `arr2` terms (+/+, +/-, -/+, -/-), we calculate `val[i]` and find `max(val) - min(val)`.
We need to consider 4 cases because `i` term is always `+i` relative to `-j`. Wait.
Actually `|i-j|` can be `i-j` or `j-i`.
But `i` and `j` are symmetric indices. If we maximize over all pairs, picking max and min of `(term_i)` works because `max_val - min_val` covers the optimal `i, j`.
Basically, evaluate 4 formulas for each `k`:
1. `arr1[k] + arr2[k] + k`
2. `arr1[k] + arr2[k] - k`
3. `arr1[k] - arr2[k] + k`
4. `arr1[k] - arr2[k] - k`
Wait. `|a| + |b| + |c|` expands to 8 cases.
But `|i-j|` term.
Actually simpler:
`val = |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|`.
Equivalent to `max over signs s1, s2, s3 in {-1, 1}` of `s1(arr1[i]-arr1[j]) + s2(arr2[i]-arr2[j]) + s3(i-j)`.
`= (s1*arr1[i] + s2*arr2[i] + s3*i) - (s1*arr1[j] + s2*arr2[j] + s3*j)`.
Since `i` and `j` are interchangeable, if we swap `i` and `j`, the signs flip effectively.
So we only need to maximize `(Expression at i) - (Expression at j)` for fixed sign sets.
There are 8 sign combinations `(s1, s2, s3)`. But due to symmetry (`i, j` swap flips all signs), we only check 4 combinations (e.g., fix `s3 = 1`).
So check 4 cases: `arr1 +/- arr2 + i`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Absolute Value Expansion
Expand the absolute value expression. Since $|x| = \max(x, -x)$, the expression $|x| + |y| + |z|$ is the maximum of $8$ linear combinations of the form $\pm x \pm y \pm z$. Grouping the terms by index $i$ and index $j$, we need to maximize $(C_i - C_j)$ for each combination, which is equivalent to finding $\max(C) - \min(C)$. Due to index symmetry, we only need to evaluate 4 distinct sign patterns for the variable terms.
Mở rộng biểu thức giá trị tuyệt đối. Vì $|x| = \max(x, -x)$, biểu thức $|x| + |y| + |z|$ là giá trị lớn nhất của $8$ tổ hợp tuyến tính có dạng $\pm x \pm y \pm z$. Nhóm các số hạng theo chỉ số $i$ và chỉ số $j$, chúng ta cần tối đa hóa $(C_i - C_j)$ cho mỗi tổ hợp, tương đương với việc tìm $\max(C) - \min(C)$. Do tính đối xứng của chỉ số, chúng ta chỉ cần đánh giá 4 mẫu dấu riêng biệt cho các biến số.

---
