# 705. Design HashSet / Thiết kế HashSet

## Problem Description / Mô tả bài toán
Design a HashSet without using any built-in hash table libraries.
Thiết kế một HashSet mà không sử dụng bất kỳ thư viện bảng băm có sẵn nào.

Implement `MyHashSet` class:
- `void add(key)` Inserts the value `key` into the HashSet.
- `boolean contains(key)` Returns whether the value `key` exists in the HashSet or not.
- `void remove(key)` Removes the value `key` in the HashSet. If `key` does not exist in the HashSet, do nothing.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array or Chaining / Mảng hoặc Chuỗi liên kết
Since we need to handle keys without a built-in library, we can use:
1. **Large Boolean Array**: Simple but memory-heavy (if key range is 1M).
2. **Hash Table with Buckets**: Uses a hash function and handles collisions using linked lists or ArrayLists.

For simplicity and efficiency within a 1M range:
A `boolean[]` of size 1,000,001 is the fastest solution.
Đối với tính đơn giản và hiệu quả trong phạm vi 1 triệu: Một `boolean[]` kích thước 1.000.001 là giải pháp nhanh nhất.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(N) where N is the maximum possible key value.

---

## Analysis / Phân tích

### Approach: Direct Addressing Array
Given the constraints (keys up to 1,000,000), a direct addressing table (array) provides the most straightforward implementation.
Với các ràng buộc (khóa lên tới 1.000.000), bảng địa chỉ trực tiếp (mảng) cung cấp cách triển khai đơn giản nhất.

---
