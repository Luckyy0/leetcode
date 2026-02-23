# Result for All O`one Data Structure
# *Kết quả cho bài toán Cấu trúc dữ liệu All O`one*

## Description
## *Mô tả*

Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
*Hãy thiết kế một cấu trúc dữ liệu để lưu trữ số lượng các chuỗi với khả năng trả về các chuỗi có số lượng tối thiểu và tối đa.*

Implement the `AllOne` class:
*Triển khai lớp `AllOne`:*

-   `AllOne()` Initializes the object of the data structure.
-   `void inc(String key)` Increments the count of the string `key` by `1`. If `key` does not exist in the data structure, insert it with count `1`.
-   `void dec(String key)` Decrements the count of the string `key` by `1`. If the count of `key` becomes `0`, remove it from the data structure. It is guaranteed that `key` exists in the data structure before the decrement.
-   `String getMaxKey()` Returns one of the keys with the maximal count. If no element exists, return an empty string `""`.
-   `String getMinKey()` Returns one of the keys with the minimum count. If no element exists, return an empty string `""`.

**Note** that each function must run in $O(1)$ average time complexity.
*Lưu ý rằng mỗi hàm phải chạy với độ phức tạp thời gian trung bình là $O(1)$.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]`
`[[], ["hello"], ["hello"], [], [], ["leet"], [], []]`
**Output:**
`[null, null, null, "hello", "hello", null, "hello", "leet"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= key.length <= 10`
*   `key` consists of lowercase English letters.
*   At most `5 * 10^4` calls will be made to `inc`, `dec`, `getMaxKey`, and `getMinKey`.
