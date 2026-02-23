# Result for Map Sum Pairs
# *Kết quả cho bài toán Tổng các cặp trong Bản đồ*

## Description
## *Mô tả*

Design a map that allows you to do the following:
*Thiết kế một bản đồ cho phép bạn thực hiện những việc sau:*

- Maps a string key to a given value.
    - *Ánh xạ một khóa chuỗi tới một giá trị cho trước.*
- Returns the sum of the values that have a key with a given prefix.
    - *Trả về tổng của các giá trị có khóa bắt đầu bằng một tiền tố cho trước.*

Implement the `MapSum` class:
*Cài đặt lớp `MapSum`:*

- `MapSum()` Initializes the `MapSum` object.
    - *`MapSum()` Khởi tạo đối tượng `MapSum`.*
- `void insert(String key, int val)` Inserts the `key-val` pair into the map. If the `key` already existed, the original `key-value` pair will be overridden to the new one.
    - *`void insert(String key, int val)` Chèn cặp `key-val` vào bản đồ. Nếu `key` đã tồn tại, cặp `key-value` ban đầu sẽ bị ghi đè bởi cặp mới.*
- `int sum(String prefix)` Returns the sum of all the pairs' value whose `key` starts with the `prefix`.
    - *`int sum(String prefix)` Trả về tổng giá trị của tất cả các cặp có `key` bắt đầu bằng `prefix`.*

---

## Example 1:
## *Ví dụ 1:*

**Input**
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
**Output**
[null, null, 3, null, 5]

**Explanation**
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)

---

## Constraints:
## *Ràng buộc:*

*   `1 <= key.length, prefix.length <= 50`
*   `key` and `prefix` consist of only lowercase English letters.
*   `1 <= val <= 1000`
*   At most `50` calls will be made to `insert` and `sum`.
