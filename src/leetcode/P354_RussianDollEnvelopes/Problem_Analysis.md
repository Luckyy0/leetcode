# 354. Russian Doll Envelopes / Phong Bì Búp Bê Nga

## Problem Description / Mô tả bài toán
You are given a 2D array of integers `envelopes` where `envelopes[i] = [w_i, h_i]` represents the width and the height of an envelope.
Bạn được cung cấp một mảng 2D `envelopes` nơi `envelopes[i] = [w_i, h_i]` là chiều rộng và chiều cao của phong bì.

One envelope can fit into another if and only if both the width and height of one envelope are strictly greater than the width and height of the other envelope.
Một phong bì có thể đặt vào phong bì khác khi và chỉ khi cả chiều rộng và chiều cao của nó nhỏ hơn phong bì kia.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
Trả về số lượng tối đa các phong bì bạn có thể lồng vào nhau.

Note: You cannot rotate an envelope.

### Example 1:
```text
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
```

### Example 2:
```text
Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= envelopes.length <= 10^5`
- `envelopes[i].length == 2`
- `1 <= w_i, h_i <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sorting + LIS (Longest Increasing Subsequence) / Sắp Xếp + LIS
To fit `env1` inside `env2`, we need `w1 < w2` and `h1 < h2`.
This is a 2D LIS problem.
Trick to convert to 1D LIS:
1.  Sort envelopes based on `width` in **ascending** order.
2.  If widths are equal, sort based on `height` in **descending** order.
    - Why descending height?
    - If `[3, 3]` and `[3, 4]`. Sorted: `[3, 4], [3, 3]`.
    - LIS on heights: `4, 3`. Decreasing sequence -> LIS length 1.
    - If strictly increasing heights: `[3, 3], [3, 4]`. LIS on heights: `3, 4`. Length 2. But we CANNOT put `[3, 3]` into `[3, 4]` because widths are equal (not strictly greater).
    - By sorting heights descending for same width, we ensure we don't pick two envelopes with same width (since height will decrease, breaking "increasing" condition).
3.  Find LIS of the `heights` array.
    - Since widths are sorted increasing, if we pick a subsequence with increasing heights, the widths must be non-decreasing.
    - Because equal widths have decreasing heights, an increasing subsequence of heights implies strictly increasing widths (cannot be same width).
    - Thus, `w1 < w2` and `h1 < h2` is satisfied.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting + O(N log N) for LIS (using Binary Search).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sort + LIS (Patience Sorting)

**Algorithm**:
1.  Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]).
2.  Extract heights to array/list.
3.  Perform standard LIS algorithm (O(N log N)) on heights.
    - `tails` array.
    - For each `h`: find insertion point. Replace or extend.

---
