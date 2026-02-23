# Result for Insert Delete GetRandom O(1)
# *Kết quả cho bài toán Thêm, Xóa, Lấy Ngẫu nhiên O(1)*

## Description
## *Mô tả*

Implement the `RandomizedSet` class:
*Thực hiện lớp `RandomizedSet`:*

*   `RandomizedSet()` Initializes the `RandomizedSet` object.
    *`RandomizedSet()` Khởi tạo đối tượng `RandomizedSet`.*
*   `boolean insert(int val)` Inserts an item `val` into the set if not present. Returns `true` if the item was not present, `false` otherwise.
    *`boolean insert(int val)` Thêm một phần tử `val` vào tập hợp nếu nó chưa tồn tại. Trả về `true` nếu phần tử chưa tồn tại, ngược lại trả về `false`.*
*   `boolean remove(int val)` Removes an item `val` from the set if present. Returns `true` if the item was present, `false` otherwise.
    *`boolean remove(int val)` Xóa một phần tử `val` khỏi tập hợp nếu nó tồn tại. Trả về `true` nếu phần tử tồn tại, ngược lại trả về `false`.*
*   `int getRandom()` Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the **same probability** of being returned.
    *`int getRandom()` Trả về một phần tử ngẫu nhiên từ tập hợp các phần tử hiện tại (đảm bảo ít nhất một phần tử tồn tại khi phương thức này được gọi). Mỗi phần tử phải có **xác suất được chọn như nhau**.*

You must implement the functions of the class such that each function works in **average** `O(1)` time complexity.
*Bạn phải triển khai các chức năng của lớp sao cho mỗi chức năng hoạt động với độ phức tạp thời gian **trung bình** `O(1)`.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]`
`[[], [1], [2], [2], [], [1], [2], []]`
**Output:**
`[null, true, false, true, 2, true, false, 2]`

**Explanation:**
```java
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1);   // Inserts 1 to the set. Returns true.
randomizedSet.remove(2);   // 2 does not exist in the set, so return false.
randomizedSet.insert(2);   // Inserts 2 to the set. Returns true.
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1);   // Removes 1 from the set, returns true.
randomizedSet.insert(2);   // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() always returns 2.
```

## Constraints:
## *Ràng buộc:*

*   `-2^31 <= val <= 2^31 - 1`
*   At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
*   There will be at least one element in the data structure when `getRandom` is called.
