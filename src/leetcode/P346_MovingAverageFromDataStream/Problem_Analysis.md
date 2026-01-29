# 346. Moving Average from Data Stream / Trung Bình Cộng Trượt Từ Luồng Dữ Liệu

## Problem Description / Mô tả bài toán
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
Cho một luồng số nguyên và kích thước cửa sổ, hãy tính trung bình cộng trượt của tất cả số nguyên trong cửa sổ trượt.

Implement the `MovingAverage` class:
- `MovingAverage(int size)` Initializes the object with the size of the window `size`.
- `double next(int val)` Returns the moving average of the last `size` values of the stream.

### Example 1:
```text
Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
```

## Constraints / Ràng buộc
- `1 <= size <= 1000`
- `-10^5 <= val <= 10^5`
- At most `10^4` calls will be made to `next`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Queue + Sum Tracking / Hàng Đợi + Theo Dõi Tổng
Use a Queue to store the last `size` elements.
Maintain a running `sum`.
When adding a new element:
- Add to `sum`.
- Add to `queue`.
- If `queue.size() > size`:
    - Remove front from `queue`.
    - Subtract removed value from `sum`.
- Return `sum / queue.size()`.

### Complexity / Độ phức tạp
- **Time**: O(1) per `next` call.
- **Space**: O(Size).

---

## Analysis / Phân tích

### Approach: Deque/Queue

**Algorithm**:
1.  Queue `q`.
2.  `currentSum`.
3.  `maxSize`.

---
