# 146. LRU Cache / Bộ Nhớ Đệm LRU

## Problem Description / Mô tả bài toán
Design a data structure that follows the constraints of a **Least Recently Used (LRU) cache**.
Thiết kế một cấu trúc dữ liệu tuân theo các ràng buộc của **bộ nhớ đệm LRU (Least Recently Used)**.

Implement the `LRUCache` class:
- `LRUCache(int capacity)` Initialize the LRU cache with positive size `capacity`.
- `int get(int key)` Return the value of the `key` if the key exists, otherwise return `-1`.
- `void put(int key, int value)` Update the value of the `key` if the `key` exists. Otherwise, add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation, **evict** the least recently used key.

The functions `get` and `put` must each run in **O(1)** average time complexity.

### Example 1:
```text
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
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

## Constraints / Ràng buộc
- `1 <= capacity <= 3000`
- `0 <= key <= 10^4`
- `0 <= value <= 10^5`
- At most `2 * 10^5` calls will be made to `get` and `put`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Data Structure Selection / Lựa chọn Cấu trúc Dữ liệu
To achieve O(1) for both `get` and `put`, we need a combination of two data structures:
1.  **HashMap**: For O(1) search of keys. The value in the map will be a reference to a node in our linked list.
2.  **Doubly Linked List**: To maintain the order of usage. 
    - **Most Recently Used (MRU)** nodes are added to the head.
    - **Least Recently Used (LRU)** nodes are evicted from the tail.
    - Splice operations (moving a node to the head) are O(1) in a doubly linked list.

### Logic / Luồng logic
- **`get(key)`**: 
  - Look up key in Map.
  - If not found, return -1.
  - If found, move the corresponding node to the front of the list (MRU) and return its value.
- **`put(key, value)`**:
  - Look up key in Map.
  - If exists, update value and move node to head.
  - If not exists:
    - If at capacity, remove the tail node (LRU) and delete from Map.
    - Create new node, add to head, and insert in Map.

---

## Analysis / Phân tích

### Approach: HashMap + Doubly Linked List

**Complexity / Độ phức tạp**:
- **Time**: O(1) for both operations.
- **Space**: O(Capacity) to store the elements.

---

## Edge Cases / Các trường hợp biên
1.  **Capacity 1**: Eviction happens on every new `put`.
2.  **Updating existing key**: Should not change the count, but should move to head.
3.  **Getting same key repeatedly**: Keeps it at the head.
