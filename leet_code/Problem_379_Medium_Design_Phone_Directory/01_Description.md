# Result for Design Phone Directory
# *Kết quả cho bài toán Thiết kế Danh bạ Điện thoại*

## Description
## *Mô tả*

Design a phone directory that initially has `maxNumbers` empty slots that can store numbers. The directory should support the following operations:
*Thiết kế một danh bạ điện thoại ban đầu có `maxNumbers` khe trống có thể lưu trữ các số. Danh bạ nên hỗ trợ các thao tác sau:*

1.  `get`: Provide a number that is not assigned to anyone. Return -1 if no number is available.
    *`get`: Cung cấp một số chưa được gán cho bất kỳ ai. Trả về -1 nếu không còn số nào khả dụng.*
2.  `check`: Check if a number is available or not.
    *`check`: Kiểm tra xem một số có khả dụng hay không.*
3.  `release`: Recycle or release a number.
    *`release`: Thu hồi hoặc giải phóng một số.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]`
`[[3], [], [], [2], [], [2], [2], [2]]`
**Output:**
`[null, 0, 1, true, 2, false, null, true]`

**Explanation:**
```java
PhoneDirectory directory = new PhoneDirectory(3);
directory.get();      // It can return any available number. Here we return 0.
directory.get();      // It can return any available number. Here we return 1.
directory.check(2);   // The number 2 is available, so return true.
directory.get();      // It can return 2, which is the only number available.
directory.check(2);   // The number 2 is no longer available, so return false.
directory.release(2); // Release number 2 back to the pool.
directory.check(2);   // Number 2 is available again, so return true.
```

## Constraints:
## *Ràng buộc:*

*   `1 <= maxNumbers <= 10^4`
*   `0 <= number < maxNumbers`
*   At most `2 * 10^4` calls will be made to `get`, `check`, and `release`.
