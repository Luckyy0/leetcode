# 715. Range Module / Mô-đun Phạm vi

## Problem Description / Mô tả bài toán
A Range Module is a module that tracks ranges of numbers. Your task is to design and implement a data structure that keeps track of whether a set of numbers is inside a range or not.
Mô-đun Phạm vi là một mô-đun theo dõi các phạm vi số. Nhiệm vụ của bạn là thiết kế và triển khai một cấu trúc dữ liệu theo dõi xem một tập hợp các số có nằm trong một phạm vi hay không.

Implement the `RangeModule` class:
- `addRange(int left, int right)` Adds the half-open interval `[left, right)`, tracking every real number in that interval.
- `queryRange(int left, int right)` Returns `true` if every real number in the interval `[left, right)` is currently being tracked.
- `removeRange(int left, int right)` Stops tracking every real number currently being tracked in the half-open interval `[left, right)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Balanced Tree (TreeMap) / Cây cân bằng (TreeMap)
In Java, `TreeMap<Integer, Integer>` can store intervals as `start -> end`.
Trong Java, `TreeMap<Integer, Integer>` có thể lưu trữ các khoảng dưới dạng `start -> end`.

Operations:
- **addRange**: Merge with overlapping intervals. This involves finding intervals that start or end within the new range and extending the boundaries.
- **queryRange**: Search for an existing interval that completely contains `[left, right)`.
- **removeRange**: Split or remove intervals that overlap with `[left, right)`.

### Complexity / Độ phức tạp
- **Time**: All operations are roughly O(log N) average, but worst-case merges can be O(N) where N is number of intervals.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: TreeMap Interval Merging
Use `TreeMap.subMap` to efficiently find and manipulate all intervals that intersect with the target range. Replace them with updated boundaries.
Sử dụng `TreeMap.subMap` để tìm và thao tác hiệu quả với tất cả các khoảng giao với phạm vi mục tiêu. Thay thế chúng bằng các ranh giới đã cập nhật.

---
