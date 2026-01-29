# 1533. Find the Index of the Large Integer / Tìm Chỉ số của Số nguyên Lớn

## Problem Description / Mô tả bài toán
Interface `ArrayReader`.
`compareSub(l, r, x, y)`: returns 1 if `arr[l..r] > arr[x..y]`, -1 if <, 0 if =.
Array has one element larger than all others (others equal).
Find the index of the largest.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search (Divide and Compare)
Range `[l, r]`. Length `len`.
Split into 2 halves needed or 3 parts?
Comparison compares sums.
If `len` is even: Compare `[l, mid]` vs `[mid+1, r]`.
If 1: max in left. If -1: max in right.
If `len` is odd: Compare `[l, mid-1]` vs `[mid+1, r]`. Exclude middle for comparison (or include).
If 0: max is middle element.
If 1: max in left.
If -1: max in right.
Recurse.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1) or O(log N) stack.

---

## Analysis / Phân tích

### Approach: Binary Search
Handle even/odd length.
While `left < right`:
  `len = right - left + 1`.
  `half = len / 2`.
  Compare `(left, left + half - 1)` and `(left + half + (len%2), right)`.
  Wait. If odd, e.g., 5. Indices 0, 1, 2, 3, 4.
  Compare `0, 1` vs `3, 4`. Exclude 2.
  Result 0: answer is 2.
  Result 1: answer in `0, 1`. Range becomes `0, 1`.
  Result -1: answer in `3, 4`. Range becomes `3, 4`.
  Correct.
  Corner case: if even, e.g., 2. 0 vs 1.
  If odd, simple split. `mid` is excluded.
Xử lý độ dài chẵn/lẻ.
Trong khi `left < right`:
  `len = right - left + 1`.

---
