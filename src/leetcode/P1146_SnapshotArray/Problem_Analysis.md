# 1146. Snapshot Array / Mảng Snapshot

## Problem Description / Mô tả bài toán
Implement a `SnapshotArray` that supports the following interface:
- `SnapshotArray(int length)`: initializes an array-like data structure with the given length. Initially, each element equals 0.
- `void set(index, val)`: sets the element at the given `index` to be equal to `val`.
- `int snap()`: takes a snapshot of the array and returns the `snap_id`: the total number of times we called `snap()` minus 1.
- `int get(index, snap_id)`: returns the value at the given `index`, at the time we took the snapshot with the given `snap_id`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### List of Treemaps / Binary Search on History / Danh sách Treemap / Tìm kiếm Nhị phân trên Lịch sử
Store history of modifications for each index.
`List<TreeMap<Integer, Integer>>`.
Index `i` has a map `snap_id -> value`.
`snap()` increments global `snapId`.
`set(index, val)`: puts `(currentSnapId, val)` into map at `index`.
`get(index, snap_id)`: finds `floorEntry(snap_id)` in map at `index`.

Optimization: `TreeMap` is O(log S). `List/ArrayList` + Binary Search is O(log S) but prone to less overhead?
Since snap_ids are increasing, we can just use `List<int[]>` for each index. `[snap_id, val]`.
On `set`: if last entry has same `snap_id`, overwrite. Else add new entry.
On `get`: binary search for largest `snap_id <= target`.

### Complexity / Độ phức tạp
- **Time**: `set` O(1), `snap` O(1), `get` O(log S).
- **Space**: O(N + M) where M is number of sets.

---

## Analysis / Phân tích

### Approach: Versioned History via Binary Search
Maintain a list of modification histories for each array index. Each history is a list of pairs `(snap_id, value)`. When `set` is called, append the new value with the current snapshot ID (overwriting if the ID matches the last entry). When `get` is called, perform a binary search on the history list for the specified index to find the latest value recorded at or before the requested `snap_id`.
Duy trì danh sách lịch sử sửa đổi cho mỗi chỉ số mảng. Mỗi lịch sử là một danh sách các cặp `(snap_id, value)`. Khi `set` được gọi, thêm giá trị mới với ID ảnh chụp nhanh hiện tại (ghi đè nếu ID khớp với mục nhập cuối cùng). Khi `get` được gọi, thực hiện tìm kiếm nhị phân trên danh sách lịch sử cho chỉ số được chỉ định để tìm giá trị mới nhất được ghi lại tại hoặc trước `snap_id` được yêu cầu.

---
