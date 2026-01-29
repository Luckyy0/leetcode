# 436. Find Right Interval / Tìm Khoảng Bên Phải

## Problem Description / Mô tả bài toán
You are given an array of `intervals`, where `intervals[i] = [starti, endi]` and each `starti` is **unique**.
Bạn được cho một mảng các khoảng `intervals`, trong đó `intervals[i] = [starti, endi]` và mỗi `starti` là **duy nhất**.

The **right interval** for an interval `i` is an interval `j` such that `startj >= endi` and `startj` is **minimized**. Note that `i` may equal `j`.
**Khoảng bên phải** của một khoảng `i` là một khoảng `j` sao cho `startj >= endi` và `startj` được **tối thiểu hóa**. Lưu ý rằng `i` có thể bằng `j`.

Return an array of indices where `answer[i]` is the index of the right interval for interval `i`. If no such interval exists, `answer[i]` should be `-1`.
Hãy trả về một mảng các chỉ số trong đó `answer[i]` là chỉ số của khoảng bên phải cho khoảng `i`. Nếu không có khoảng nào thỏa mãn, `answer[i]` sẽ là `-1`.

### Example 1:
```text
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it cannot be to the right of itself. (Wait, the rule says startj >= endi. 1 >= 2 is False. So -1 is correct).
```

### Example 2:
```text
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: 
- For [3,4], no interval starts at or after 4.
- For [2,3], [3,4] is the right interval (start 3 >= end 3).
- For [1,2], [2,3] is the right interval (start 2 >= end 2).
```

## Constraints / Ràng buộc
- `1 <= intervals.length <= 2 * 10^4`
- `intervals[i].length == 2`
- `-10^6 <= starti < endi <= 10^6`
- Each `starti` is unique.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sorting + Binary Search / Sắp xếp + Tìm kiếm nhị phân
Since we need to find the smallest `start` that is greater than or equal to `end`, we can:
1. Store the starting points along with their original indices in a sorted structure.
2. For each interval, perform a binary search on the sorted starting points.

Algorithm:
1. Create a `TreeMap<Integer, Integer>` (start_point $\to$ index).
2. For each interval `i`, put `intervals[i][0]` and `i` into the map.
3. Iterate through intervals again. For each interval `[start, end]`:
   - Use `map.ceilingEntry(end)` to find the smallest entry with a key $\ge$ `end`.
   - If found, store the value (index) in the result. Otherwise, store `-1`.

Alternative (using manual binary search):
1. Store `[start, index]` pairs in an array and sort them by `start`.
2. For each `end`, binary search for the first pair where `pair[0] >= end`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) to build the map/sort and O(N log N) for queries. Total O(N log N).
- **Space**: O(N) to store the indices.

---

## Analysis / Phân tích

### Approach: TreeMap Ceiling

**Algorithm**:
1.  Initialize TreeMap.
2.  Populate with `start` and original `index`.
3.  Query `ceilingEntry`.

---
