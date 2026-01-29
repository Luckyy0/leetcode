# 1409. Queries on a Permutation With Key / Truy vấn trên Hoán vị với Khóa

## Problem Description / Mô tả bài toán
Permutation `P` initially `[1, 2, ..., m]`.
Queries `queries`.
For each `q` in `queries`:
- Find position of `q` in `P`. (0-indexed).
- Move `q` to the beginning of `P`.
Return list of positions.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Fenwick Tree (BIT)
Small constraints `m <= 1000`, `queries <= 1000`. O(Q * M) is acceptable.
Or use Fenwick Tree for O(Q log (M+Q)).
Fenwick Tree approach:
Map each value to a position. Initially `1` at pos `M`, `2` at `M+1`...
Wait. Easier:
Initially `1..m` are at indices.
We need to move to front.
We can allocate array of size `m + queries`.
Place `1..m` at `queries..queries+m-1`.
When element `x` moves to front:
- Previous position `pos[x]`.
- Count elements active before `pos[x]`. (Prefix sum).
- Update `pos[x]` to new front (decrementing pointer).

Given constraints, LinkedList or ArrayList simulation is simplest and sufficient.
`list.indexOf(val)` is O(M). `list.remove(index)`, `list.add(0, val)` is O(M).
Total O(Q * M) = 10^6 ops. Fast enough.

### Complexity / Độ phức tạp
- **Time**: O(Q * M).
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Simulation with LinkedList
Use a `LinkedList` initialized with `1` to `m`.
For each query `q`:
1. Find index of `q`: `list.indexOf(q)`.
2. Add index to result.
3. Remove `q` from list.
4. Add `q` to front (`addFirst`).
Sử dụng `LinkedList` được khởi tạo với `1` đến `m`.
Đối với mỗi truy vấn `q`:
1. Tìm chỉ mục của `q`: `list.indexOf(q)`.
2. Thêm chỉ mục vào kết quả.
3. Xóa `q` khỏi danh sách.
4. Thêm `q` vào trước (`addFirst`).

---
