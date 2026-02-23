# Result for Logger Rate Limiter
# *Kết quả cho bài toán Bộ giới hạn Tốc độ Ghi nhật ký*

## Description
## *Mô tả*

Design a logger system that receives a stream of messages along with their timestamps. Each **unique** message should only be printed **at most once every 10 seconds** (i.e. a message printed at timestamp `t` will prevent other identical messages from being printed until timestamp `t + 10`).
*Thiết kế một hệ thống ghi nhật ký nhận một luồng tin nhắn cùng với dấu thời gian của chúng. Mỗi tin nhắn **duy nhất** chỉ được in **tối đa một lần cứ sau 10 giây** (nghĩa là một tin nhắn được in ở dấu thời gian `t` sẽ ngăn các tin nhắn giống hệt khác được in cho đến dấu thời gian `t + 10`).*

All messages will come in chronological order. Several messages may arrive at the same timestamp.
*Tất cả các tin nhắn sẽ đến theo thứ tự thời gian. Nhiều tin nhắn có thể đến cùng một dấu thời gian.*

Implement the `Logger` class:
*Thực hiện lớp `Logger`:*

*   `Logger()` Initializes the logger object.
    *`Logger()` Khởi tạo đối tượng logger.*
*   `boolean shouldPrintMessage(int timestamp, String message)` Returns `true` if the `message` should be printed in the given `timestamp`, otherwise returns `false`.
    *`boolean shouldPrintMessage(int timestamp, String message)` Trả về `true` nếu `message` nên được in ở `timestamp` đã cho, ngược lại trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]`
`[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]`
**Output:**
`[null, true, true, false, false, false, true]`

**Explanation:**
```java
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed: 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed: 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed: 21
```

## Constraints:
## *Ràng buộc:*

*   `0 <= timestamp <= 10^9`
*   Every message has a length of at most 30 characters.
*   At most `10^4` calls will be made to `shouldPrintMessage`.
