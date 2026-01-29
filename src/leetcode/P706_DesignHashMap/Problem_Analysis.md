# 706. Design HashMap / Thiết kế HashMap

## Problem Description / Mô tả bài toán
Design a HashMap without using any built-in hash table libraries.
Thiết kế một HashMap mà không sử dụng bất kỳ thư viện bảng băm có sẵn nào.

Implement `MyHashMap` class:
- `void put(key, value)` Inserts a `(key, value)` pair into the HashMap. If the `key` already exists in the map, update the corresponding `value`.
- `int get(key)` Returns the `value` to which the specified `key` is mapped, or `-1` if this map contains no mapping for the `key`.
- `void remove(key)` Removes the `key` and its corresponding `value` if the map contains the mapping for the `key`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array or Chaining / Mảng hoặc Chuỗi liên kết
Since keys can be up to 1,000,000, we can use:
1. **Large Integer Array**: `int[] map` where `map[key] = value`. Initialize with -1. This is very fast but uses O(1M) space.
   `int[] map` trong đó `map[key] = value`. Khởi tạo với -1. Cách này rất nhanh nhưng sử dụng không gian O(1M).
2. **Hash Table with Chaining**: Map key to a bucket (e.g., `key % 1000`) and store pairs in a linked list. This is more memory-efficient.

Given the typical context of this exercise, a direct addressing array is common.
Với bối cảnh thông thường của bài tập này, một mảng địa chỉ trực tiếp là phổ biến.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(N) where N is the maximum possible key value.

---

## Analysis / Phân tích

### Approach: Direct Addressing Array
Initialize an array of size 1,000,001 with -1. Direct access via key.
Khởi tạo một mảng kích thước 1.000.001 với giá trị -1. Truy cập trực tiếp qua khóa.

---
