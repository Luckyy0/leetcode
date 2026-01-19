# 251. Flatten 2D Vector / Làm Phẳng Vector 2D

## Problem Description / Mô tả bài toán
Design an iterator to flatten a 2D vector. It should support the `next` and `hasNext` operations.
Thiết kế một bộ lặp (iterator) để làm phẳng một vector 2D. Nó phải hỗ trợ các thao tác `next` và `hasNext`.

Implement the `Vector2D` class:
- `Vector2D(int[][] vec)` initializes the object with the 2D vector `vec`.
- `next()` returns the next element from the 2D vector and moves the pointer one step forward. You may assume that all the calls to `next` are valid.
- `hasNext()` returns `true` if there are still some elements in the vector, and `false` otherwise.

### Example 1:
```text
Input
["Vector2D", "next", "next", "next", "hasNext", "hasNext", "next", "hasNext"]
[[[[1, 2], [3], [4]]], [], [], [], [], [], [], []]
Output
[null, 1, 2, 3, true, true, 4, false]
```

## Constraints / Ràng buộc
- `0 <= vec.length <= 200`
- `0 <= vec[i].length <= 500`
- `vec[i][j]` is an integer.
- At most `10^5` calls will be made to `next` and `hasNext`.

## Follow up / Câu hỏi mở rộng
As an added challenge, try to code it in C++ or Java by implementing the logic rather than simply flattening the 2D vector into a 1D list in the constructor (which takes O(N) space).
Như một thử thách thêm, hãy thử lập trình bằng cách triển khai logic thay vì chỉ đơn giản là làm phẳng vector 2D thành danh sách 1D trong hàm khởi tạo.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Pointers (Row and Col) / Hai Con Trỏ
We maintain `row` and `col` indices.
- `row`: current inner array index via `vec[row]`.
- `col`: current element index within `vec[row]`.

**Algorithm**:
- `hasNext()`:
    - While `row < vec.length` AND `col == vec[row].length`:
        - `col = 0`
        - `row++` (Skip empty rows or rows we finished traversing).
    - If `row < vec.length`, return `true`. Else `false`.
- `next()`:
    - Ensure valid state by calling logic of `hasNext()` (or assuming caller did).
    - Return `vec[row][col++]`.

### Complexity / Độ phức tạp
- **Time**:
    - `next()`: O(1) on average.
    - `hasNext()`: O(1) on average (amortized, might scan empty rows).
- **Space**: O(1) - Only storing pointers.

---

## Analysis / Phân tích

### Approach: Iterator Logic

**Algorithm**:
1.  Store `int[][] v`.
2.  `row`, `col`.
3.  Implement `advanceToNextValid()` helper.

---

## Edge Cases / Các trường hợp biên
1.  **Empty vector**: `[]` -> `hasNext` false.
2.  **Vector with empty rows**: `[[], [3]]` -> Skips first row correctly.
3.  **Holes**: `[[], [], [1], []]` -> Skips correctly.
