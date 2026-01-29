# 307. Range Sum Query - Mutable / Truy Vấn Tổng Phạm Vi - Có Thể Thay Đổi

## Problem Description / Mô tả bài toán
Given an integer array `nums`, handle multiple queries of the following types:
1.  **Update**: Update the value of an element in `nums`.
2.  **Sum Range**: Calculate the sum of the elements of `nums` between indices `left` and `right` inclusive.
Cho một mảng số nguyên `nums`, xử lý nhiều truy vấn thuộc các loại sau:
1.  **Cập nhật**: Cập nhật giá trị của một phần tử trong `nums`.
2.  **Tổng Phạm Vi**: Tính tổng các phần tử của `nums` giữa các chỉ số `left` và `right` bao gồm.

Implement the `NumArray` class:
- `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
- `void update(int index, int val)` Updates the value of `nums[index]` to be `val`.
- `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right` inclusive.

### Example 1:
```text
Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `0 <= index < nums.length`
- `-100 <= val <= 100`
- `0 <= left <= right < nums.length`
- At most `3 * 10^4` calls will be made to `update` and `sumRange`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Indexed Tree (Fenwick Tree) / Cây Chỉ Số Nhị Phân
To support O(log N) update and O(log N) prefix sum.
- **Update**: `add(index, delta)`.
- **Query**: `sum(index)` returns sum from 0 to index.
- `sumRange(i, j) = sum(j) - sum(i-1)`.

**Structure**:
Array `bit` of size `n+1`.
`idx` in BIT is usually 1-based.
`update(i, val)`:
- `delta = val - nums[i]`.
- `add(i+1, delta)`.
- `nums[i] = val`.

`add(k, delta)`:
- `while k <= n: bit[k] += delta; k += k & -k`.

`query(k)`:
- `s = 0; while k > 0: s += bit[k]; k -= k & -k`.

### Segment Tree
Alternative.
- `O(N)` build.
- `O(log N)` update/query.
Slightly more code than BIT but supports range updates or other ops (min/max). Since we only need sum and point update, BIT is perfect.

### Complexity / Độ phức tạp
- **Time**: O(N log N) init (or O(N) if optimized), O(log N) query/update.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Fenwick Tree (BIT)

**Algorithm**:
1.  Class `BIT`: methods `update`, `query`.
2.  `NumArray` holds `nums` and `BIT`.
3.  Init: build BIT by calling update for each element.

---
