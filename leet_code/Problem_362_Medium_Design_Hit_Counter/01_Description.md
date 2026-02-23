# Result for Design Hit Counter
# *Kết quả cho bài toán Thiết kế Bộ đếm Truy cập*

## Description
## *Mô tả*

Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
*Thiết kế một bộ đếm truy cập hiển thị số lượng truy cập nhận được trong 5 phút qua (nghĩa là 300 giây qua).*

Your system should support the following two operations:
*Hệ thống của bạn nên hỗ trợ hai thao tác sau:*

1.  `hit(timestamp)` - Shows a hit at the given timestamp (in seconds).
    *`hit(timestamp)` - Ghi nhận một lượt truy cập tại dấu thời gian đã cho (tính bằng giây).*
2.  `getHits(timestamp)` - Returns the number of hits in the past 5 minutes from the given timestamp.
    *`getHits(timestamp)` - Trả về số lượng truy cập trong 5 phút qua tính từ dấu thời gian đã cho.*

**Note:** The timestamps are in increasing order.
**Lưu ý:** Các dấu thời gian được cung cấp theo thứ tự tăng dần.

## Example 1:
## *Ví dụ 1:*

**Input:**
`["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]`
`[[], [1], [2], [3], [4], [300], [300], [301]]`
**Output:**
`[null, null, null, null, 3, null, 4, 3]`

**Explanation:**
```java
HitCounter counter = new HitCounter();
counter.hit(1);
counter.hit(2);
counter.hit(3);
counter.getHits(4);   // get hits at timestamp 4, return 3.
counter.hit(300);
counter.getHits(300); // get hits at timestamp 300, return 4.
counter.getHits(301); // get hits at timestamp 301, return 3.
```

## Constraints:
## *Ràng buộc:*

*   `1 <= timestamp <= 2 * 10^9`
*   All the calls are being made to the system in chronological order (i.e., `timestamp` is monotonically increasing).
*   At most `300` calls will be made to `hit` and `getHits`.

**Follow up:** What if the number of hits per second is very large? Does your design scale?
**Câu hỏi mở rộng:** Điều gì xảy ra nếu số lượng truy cập mỗi giây là rất lớn? Thiết kế của bạn có khả năng mở rộng không?
