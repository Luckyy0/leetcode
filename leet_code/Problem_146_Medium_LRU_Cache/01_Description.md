# Result for LRU Cache
# *Kết quả cho bài toán Bộ nhớ đệm LRU*

## Description
## *Mô tả*

Design a data structure that follows the constraints of a **Least Recently Used (LRU) cache**.
*Thiết kế một cấu trúc dữ liệu tuân theo các ràng buộc của **bộ nhớ đệm LRU (Least Recently Used)***.*

Implement the `LRUCache` class:
*Triển khai lớp `LRUCache`:*

*   `LRUCache(int capacity)` Initialize the LRU cache with **positive** size `capacity`.
    *`LRUCache(int capacity)` Khởi tạo bộ nhớ đệm LRU với kích thước **dương** `capacity`.*
*   `int get(int key)` Return the value of the `key` if the `key` exists, otherwise return `-1`.
    *`int get(int key)` Trả về giá trị của `key` nếu `key` tồn tại, ngược lại trả về `-1`.*
*   `void put(int key, int value)` Update the value of the `key` if the `key` exists. Otherwise, add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation, **evict** the least recently used key.
    *`void put(int key, int value)` Cập nhật giá trị của `key` nếu `key` tồn tại. Ngược lại, thêm cặp `key-value` vào bộ nhớ đệm. Nếu số lượng key vượt quá `capacity` sau thao tác này, hãy **loại bỏ** key ít được sử dụng nhất.*

The functions `get` and `put` must each run in **O(1)** average time complexity.
*Các hàm `get` và `put` mỗi hàm phải chạy với độ phức tạp thời gian trung bình **O(1)**.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]`
`[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]`
**Output**
`[null, null, null, 1, null, -1, null, -1, 3, 4]`

**Explanation**
```java
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

## Constraints:
## *Ràng buộc:*

*   `1 <= capacity <= 3000`
*   `0 <= key <= 10^4`
*   `0 <= value <= 10^5`
*   At most `2 * 10^5` calls will be made to `get` and `put`.
