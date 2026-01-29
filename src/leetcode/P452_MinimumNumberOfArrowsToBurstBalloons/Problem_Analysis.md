# 452. Minimum Number of Arrows to Burst Balloons / Số Lượng Mũi Tên Tối Thiểu Để Làm Nổ Bong Bóng

## Problem Description / Mô tả bài toán
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array `points` where `points[i] = [xstart, xend]` denotes a balloon whose **horizontal diameter** stretches between `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.
Có một số bong bóng hình cầu được dán trên một bức tường phẳng đại diện cho mặt phẳng XY. Các bong bóng được đại diện dưới dạng một mảng số nguyên 2 chiều `points` trong đó `points[i] = [xstart, xend]` biểu thị một bong bóng có **đường kính ngang** kéo dài từ `xstart` đến `xend`. Bạn không biết tọa độ y chính xác của các bong bóng.

Arrows can be shot up **vertically** (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is **burst** by an arrow shot at `x` if `xstart <= x <= xend`. There is **no limit** to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
Các mũi tên có thể được bắn lên **theo chiều dọc** từ các điểm khác nhau dọc theo trục x. Một bong bóng có `xstart` và `xend` sẽ bị **làm nổ** bởi một mũi tên bắn tại `x` nếu `xstart <= x <= xend`. Không có giới hạn về số lượng mũi tên có thể bắn. Một mũi tên sau khi bắn sẽ tiếp tục bay lên vô tận, làm nổ bất kỳ bong bóng nào trên đường đi của nó.

Given the array `points`, return the **minimum** number of arrows that must be shot to burst all balloons.
Cho mảng `points`, hãy trả về số lượng mũi tên **tối thiểu** phải bắn để làm nổ tất cả các bong bóng.

### Example 1:
```text
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
```

### Example 2:
```text
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
```

## Constraints / Ràng buộc
- `1 <= points.length <= 10^5`
- `points[i].length == 2`
- `-2^31 <= xstart < xend <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Strategy (Interval Scheduling) / Chiến lược Tham lam
This is a variation of the Interval Scheduling problem. To minimize arrows, we want each arrow to burst as many balloons as possible.

Algorithm:
1. Sort the balloons based on their **end coordinates**. (Sorting by end coordinate allows us to make the most optimal decision at each step).
2. Start with the first balloon. Place an arrow at its `end` position.
3. Iterate through the sorted balloons:
   - If the current balloon starts **after** the position of the last arrow (`points[i][0] > lastArrowPos`), it cannot be burst by the current arrow.
   - We must shoot a new arrow. Update `lastArrowPos` to the `end` coordinate of the current balloon and increment the arrow count.
4. Return the total count.

Why sort by `end`?
If we sort by `end`, we are always picking the arrow position that is as far to the right as possible within the current balloon, which maximizes its chance of hitting subsequent balloons.

### Complexity / Độ phức tạp
- **Time**: O(N log N) due to sorting.
- **Space**: O(log N) or O(N) for sorting space efficiency.

---

## Analysis / Phân tích

### Approach: Greedy End-point Tracking

**Algorithm**:
1.  Sort: `Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]))`.
2.  Count arrows based on overlaps.

---
