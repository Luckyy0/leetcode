# 432. All O`one Data Structure / Cấu Trúc Dữ Liệu All O`one

## Problem Description / Mô tả bài toán
Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
Thiết kế một cấu trúc dữ liệu để lưu trữ số lượng (count) của các chuỗi, với khả năng trả về các chuỗi có số lượng nhỏ nhất và lớn nhất.

Implement the `AllOne` class:
- `AllOne()` Initializes the object of the data structure.
- `inc(String key)` Increments the count of the string `key` by 1. If `key` does not exist in the data structure, insert it with count 1.
- `dec(String key)` Decrements the count of the string `key` by 1. If the count of `key` becomes 0 after the decrement, remove it from the data structure. It is guaranteed that `key` exists in the data structure before the decrement.
- `getMaxKey()` Returns one of the keys with the maximal count. If no element exists, return an empty string `""`.
- `getMinKey()` Returns one of the keys with the minimum count. If no element exists, return an empty string `""`.

**All functions should run in `O(1)` time complexity.**
**Tất cả các hàm phải chạy với độ phức tạp thời gian `O(1)`.**

### Constraints / Ràng buộc
- `1 <= key.length <= 10`
- `key` consists of lowercase English letters.
- At most `5 * 10^4` calls will be made to `inc`, `dec`, `getMaxKey`, and `getMinKey`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Doubly Linked List + HashMaps / Danh sách liên kết đôi + HashMaps
To achieve O(1) for all operations, we need a structure that maps keys to their counts and counts to a list of keys, while keeping counts sorted.

Structure:
1. `countMap`: `key -> count`.
2. `nodeMap`: `count -> Node`.
3. `Doubly Linked List`: A list of `Node` objects ordered by their `count`. Each `Node` contains a set of keys with the same count.

Logic for `inc(key)`:
1. Get current count `c` of `key`.
2. Move `key` to `Node(c + 1)`.
   - If `Node(c + 1)` doesn't exist, create it immediately after `Node(c)`.
3. If `Node(c)` becomes empty, remove it from the doubly linked list.

The same logic applies to `dec(key)`. `getMaxKey` and `getMinKey` simply look at the nodes adjacent to the dummy `head` and `tail` of the list.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(N) where N is the number of distinct keys.

---

## Analysis / Phân tích

### Approach: Sorted Buckets

**Algorithm**:
1.  Define a `Node` class with `count` and `Set<String> keys`.
2.  Maintain a doubly linked list of these nodes.
3.  Use two HashMaps for fast access to current count and the corresponding Node.

---
