# 359. Logger Rate Limiter / Giới Hạn Tốc Độ Logger

## Problem Description / Mô tả bài toán
Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed **at most every 10 seconds** (i.e. a message printed at timestamp `t` will prevent other identical messages from being printed until timestamp `t + 10`).
Thiết kế hệ thống logger nhận luồng tin nhắn... Mỗi tin nhắn duy nhất chỉ được in **tối đa mỗi 10 giây**.

All messages will come in chronological order. Several messages may arrive at the same timestamp.
Implement the `Logger` class:
- `Logger()` Initializes the logger object.
- `bool shouldPrintMessage(int timestamp, string message)` Returns `true` if the `message` should be printed in the given `timestamp`, otherwise returns `false`.

### Example 1:
```text
Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
```

## Constraints / Ràng buộc
- `0 <= timestamp <= 10^9`
- Every timestamp will be passed in non-decreasing order (chronological order).
- `message` consists of upper-case letters.
- At most `10^4` calls will be made to `shouldPrintMessage`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashMap / Bảng Băm
Store `Map<Message, NextAllowedTime>`.
When `shouldPrintMessage(ts, msg)` called:
- If `!map.containsKey(msg)` OR `ts >= map.get(msg)`:
    - Update `map.put(msg, ts + 10)`.
    - Return true.
- Else:
    - Return false.

### Complexity / Độ phức tạp
- **Time**: O(1) per call (assuming Map operations O(1)).
- **Space**: O(M) where M is number of unique messages.

---

## Analysis / Phân tích

### Approach: HashMap

**Algorithm**:
1.  Map `nextValidTime`.
2.  Func: if `!map.contains(msg) || ts >= map.get(msg)` -> print. Update `ts+10`.

---
