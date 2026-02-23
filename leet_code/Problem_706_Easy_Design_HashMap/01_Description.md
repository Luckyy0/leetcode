# Result for Design HashMap
# *Kết quả cho bài toán Thiết kế HashMap*

## Description
## *Mô tả*

Design a HashMap without using any built-in hash table libraries.
*Thiết kế một HashMap mà không sử dụng bất kỳ thư viện bảng băm có sẵn nào.*

Implement `MyHashMap` class:
*   `void put(key, value)` Inserts a `(key, value)` pair into the HashMap. If the `key` already exists in the map, update the corresponding `value`.
*   `int get(key)` Returns the `value` to which the specified `key` is mapped, or `-1` if this map contains no mapping for the `key`.
*   `void remove(key)` Removes the `key` and its corresponding `value` if the map contains the mapping for the `key`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
**Output:** [null, null, null, 1, -1, null, 1, null, -1]

---

## Constraints:
## *Ràng buộc:*

*   `0 <= key, value <= 10^6`
*   At most `10^4` calls will be made to `put`, `get`, and `remove`.
