# Result for Moving Average from Data Stream
# *Kết quả cho bài toán Trung bình Động từ Luồng Dữ liệu*

## Description
## *Mô tả*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
*Cho một luồng các số nguyên và một kích thước cửa sổ, hãy tính trung bình động của tất cả các số nguyên trong cửa sổ trượt.*

Implement the `MovingAverage` class:
*Thực hiện lớp `MovingAverage`:*

*   `MovingAverage(int size)` Initializes the object with the size of the window `size`.
    *`MovingAverage(int size)` Khởi tạo đối tượng với kích thước của cửa sổ `size`.*
*   `double next(int val)` Returns the moving average of the last `size` values of the stream.
    *`double next(int val)` Trả về trung bình động của `size` giá trị cuối cùng của luồng dữ liệu.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["MovingAverage", "next", "next", "next", "next"]`
`[[3], [1], [10], [3], [5]]`
**Output:**
`[null, 1.0, 5.5, 4.66667, 6.0]`

**Explanation:**
```java
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
```

## Constraints:
## *Ràng buộc:*

*   `1 <= size <= 1000`
*   `-10^5 <= val <= 10^5`
*   At most `10^4` calls will be made to `next`.
