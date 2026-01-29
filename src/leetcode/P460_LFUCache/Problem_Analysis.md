# 460. LFU Cache / Bộ Nhớ Đệm LFU

## Problem Description / Mô tả bài toán
Design and implement a data structure for a **Least Frequently Used (LFU)** cache.
Thiết kế và triển khai một cấu trúc dữ liệu cho bộ nhớ đệm **Ít được sử dụng nhất (LFU)**.

Implement the `LFUCache` class:
- `LFUCache(int capacity)` Initializes the object with the capacity of the data structure.
- `get(int key)` Gets the value of the `key` if the `key` exists in the cache. Otherwise, returns `-1`.
- `put(int key, int value)` Update the value of the `key` if present, or inserts the `key` if not already present. When the cache reaches its `capacity`, it should invalidate and remove the **least frequently used** key before inserting a new item. For this problem, when there is a **tie** (i.e., multiple keys with the same frequency), the **least recently used** key should be invalidated.

**To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.**
**Khi có nhiều khóa có cùng tần suất nhỏ nhất, khóa ít được sử dụng gần đây nhất (LRU) sẽ bị xóa.**

**All functions should run in `O(1)` time complexity.**
**Tất cả các hàm phải chạy với độ phức tạp thời gian `O(1)`.**

## Constraints / Ràng buộc
- `0 <= capacity <= 10^4`
- `0 <= key <= 10^5`
- `0 <= value <= 10^9`
- At most `2 * 10^5` calls will be made to `get` and `put`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Doubly Linked List + Multiple HashMaps / Danh sách liên kết đôi + Nhiều HashMaps
To achieve O(1) for both frequency tracking and recent usage tracking, we need:
1. `Map<Integer, Node> cache`: Maps `key` to its corresponding `Node` (containing `key, val, freq`).
2. `Map<Integer, DoubleLinkedList> freqMap`: Maps a `frequency` to a doubly linked list of nodes that have that frequency. The linked list maintains nodes in **LRU** order (most recent at head, least recent at tail).
3. `minFreq`: Keeps track of the minimum frequency currently in the cache.

Algorithm:
- **get(key)**:
  1. Find node in `cache`.
  2. Increment frequency:
     - Remove node from current frequency list.
     - If the list becomes empty and its frequency was `minFreq`, increment `minFreq`.
     - Add node to head of frequency list `f+1`.
  3. Return value.
- **put(key, value)**:
  1. If `key` exists, update value and call `get(key)` logic.
  2. If `key` is new:
     - If at capacity, remove the tail node of the list with frequency `minFreq`. Remove it from `cache` too.
     - Insert new node with frequency 1 into the `freq_1` list. Set `minFreq = 1`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(capacity).

---

## Analysis / Phân tích

### Approach: Frequency-grouped LRU

**Algorithm**:
1.  Define `Node` and `DLList`.
2.  Maintain `keyToNode` and `freqToDLList` maps.
3.  Update `minFreq` on every access.

---
