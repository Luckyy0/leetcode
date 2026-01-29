# 352. Data Stream as Disjoint Intervals / Luồng Dữ Liệu Dưới Dạng Các Khoảng Rời Rạc

## Problem Description / Mô tả bài toán
Given a data stream input of non-negative integers `a_1, a_2, ..., a_n`, summarize the numbers seen so far as a list of disjoint intervals.
Cho một luồng dữ liệu đầu vào gồm các số nguyên không âm, tóm tắt các số đã thấy cho đến nay dưới dạng một danh sách các khoảng rời rạc.

Implement the `SummaryRanges` class:
- `SummaryRanges()` Initializes the object with an empty stream.
- `void addNum(int value)` Adds the integer `value` to the stream.
- `int[][] getIntervals()` Returns a summary of the integers in the stream currently as a list of disjoint intervals `[start_i, end_i]`. The answer should be sorted by `start_i`.

### Example 1:
```text
Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
```

## Constraints / Ràng buộc
- `0 <= value <= 10^4`
- At most `3 * 10^4` calls will be made to `addNum` and `getIntervals`.

**Follow up**: What if there are lots of merges and the number of disjoint intervals is small compared to the data stream's size?

---

## Theoretical Foundation / Cơ sở lý thuyết

### TreeMap (Interval Tree) / TreeMap
Maintain intervals in a `TreeMap<Integer, int[]>`. Key is `start`, value is interval `[start, end]`.
When adding `val`:
1.  Check if present. If yes, ignore.
2.  Find `floorKey(val)`: Interval starting before or at `val`.
    - `L = floorEntry(val)`.
    - If `L` covers `val` (`L.end >= val`), ignore.
    - If `L` ends at `val - 1`, we can potentially merge `val` into `L`.
3.  Find `higherKey(val)`: Interval starting after `val`.
    - `H = higherEntry(val)`.
    - If `H` starts at `val + 1`, we can merge `H` into `val` (or into `L`).

Cases:
1.  `val` bridges `L` and `H` (`L.end == val - 1` && `H.start == val + 1`):
    - Merge `L`, `val`, `H` -> `[L.start, H.end]`. Remove `H`. Update `L`.
2.  `val` extends `L` (`L.end == val - 1`):
    - Extend `L` -> `[L.start, val]`.
3.  `val` extends `H` (`H.start == val + 1`):
    - Extend `H` (actually change start) -> `[val, H.end]`. Key change requires remove/put.
4.  `val` is isolated:
    - Add `[val, val]`.

### Complexity / Độ phức tạp
- **Time**: `addNum` O(log K) where K is number of intervals. `getIntervals` O(K).
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: TreeMap Stores Intervals

**Algorithm**:
1.  `TreeMap<Integer, int[]>`.
2.  `addNum`:
    - Check duplicate.
    - `floor`.
    - `higher`.
    - Merge Logic.

---
