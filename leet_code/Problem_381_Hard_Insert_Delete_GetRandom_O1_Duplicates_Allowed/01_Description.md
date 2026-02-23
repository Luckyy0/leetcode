# Result for Insert Delete GetRandom O(1) - Duplicates allowed
# *Kết quả cho bài toán Thêm, Xóa, Lấy Ngẫu nhiên O(1) - Cho phép Trùng lặp*

## Description
## *Mô tả*

Implement the `RandomizedCollection` class:
*Thực hiện lớp `RandomizedCollection`:*

*   `RandomizedCollection()` Initializes the `RandomizedCollection` object.
    *`RandomizedCollection()` Khởi tạo đối tượng `RandomizedCollection`.*
*   `boolean insert(int val)` Inserts an item `val` into the collection. Returns `true` if the item was not present, `false` otherwise.
    *`boolean insert(int val)` Thêm một phần tử `val` vào tập hợp. Trả về `true` nếu phần tử chưa tồn tại, ngược lại trả về `false`.*
*   `boolean remove(int val)` Removes an item `val` from the collection if present. Returns `true` if the item was present, `false` otherwise.
    *`boolean remove(int val)` Xóa một phần tử `val` khỏi tập hợp nếu nó tồn tại. Trả về `true` nếu phần tử tồn tại, ngược lại trả về `false`.*
*   `int getRandom()` Returns a random element from the current collection of elements. Each element must have the **same probability** of being returned.
    *`int getRandom()` Trả về một phần tử ngẫu nhiên từ tập hợp các phần tử hiện tại. Mỗi phần tử phải có **xác suất được chọn như nhau**.*

You must implement the functions of the class such that each function works in **average** `O(1)` time complexity.
*Bạn phải triển khai các chức năng của lớp sao cho mỗi chức năng hoạt động với độ phức tạp thời gian **trung bình** `O(1)`.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]`
`[[], [1], [1], [2], [], [1], []]`
**Output:**
`[null, true, false, true, 1, true, 1]`

**Explanation:**
```java
RandomizedCollection collection = new RandomizedCollection();
collection.insert(1);   // Inserts 1 to the collection. Returns true since it's a new element.
collection.insert(1);   // Inserts another 1. Returns false as 1 is already present.
collection.insert(2);   // Inserts 2. Returns true.
collection.getRandom(); // Returns either 1 or 2 with appropriate probabilities (1: 2/3, 2: 1/3).
collection.remove(1);   // Removes one 1 from the collection. Returns true.
collection.getRandom(); // Returns 1 or 2 with 50% probability each.
```

## Constraints:
## *Ràng buộc:*

*   `-2^31 <= val <= 2^31 - 1`
*   At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
*   There will be at least one element in the data structure when `getRandom` is called.
