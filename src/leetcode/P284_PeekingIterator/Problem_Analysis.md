# 284. Peeking Iterator / Bộ Lặp Có Thể Nhìn Trước

## Problem Description / Mô tả bài toán
Design an iterator that supports the `peek` operation on an existing iterator in addition to the `hasNext` and `next` operations.
Thiết kế một bộ lặp hỗ trợ thao tác `peek` (nhìn trước) trên một bộ lặp hiện có ngoài các thao tác `hasNext` và `next`.

Implement the `PeekingIterator` class:
- `PeekingIterator(Iterator<int> nums)` Initializes the object with the given integer iterator `nums`.
- `int next()` Returns the next element in the array and moves the pointer to the next element.
- `boolean hasNext()` Returns `true` if there are still elements in the array.
- `int peek()` Returns the next element in the array **without** moving the pointer.

### Example 1:
```text
Input
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 2, 2, 3, false]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 1000`
- All the calls to `next` and `peek` are valid.
- At most `1000` calls will be made to `next`, `hasNext`, and `peek`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Caching Next Element / Lưu Đệm Phần Tử Tiếp Theo
Standard iterators don't support `peek`.
To support `peek`, we must read the element from the underlying iterator **earlier** than requested.
- We maintain a variable `nextElement`.
- Upon initialization (or after `next()` is called), we fetch an element from the underlying iterator and store it in `nextElement`.
- `peek()` simply returns `nextElement`.
- `next()` returns `nextElement` and then advances the underlying iterator to update `nextElement`.
- `hasNext()` returns `true` if `nextElement` is not null.

**Null Handling**: Since inputs can be null in generic iterators (though here `int`), we might need a flag `done` or check against `null`. Since `nums[i] >= 1`, we can use `null`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Cache Next

**Algorithm**:
1.  Field `Iterator`, `Integer nextVal`.
2.  Constructor: Call `advance()` to fill `nextVal`.
3.  `advance()`: If `iter.hasNext()`, `nextVal = iter.next()`. Else `nextVal = null`.
4.  `peek()`: Return `nextVal`.
5.  `next()`:
    - Ret = `nextVal`.
    - `advance()`.
    - Return Ret.
6.  `hasNext()`: `nextVal != null`.

---
