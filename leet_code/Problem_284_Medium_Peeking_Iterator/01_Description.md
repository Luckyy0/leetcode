# Result for Peeking Iterator
# *Kết quả cho bài toán Iterator Nhìn trộm*

## Description
## *Mô tả*

Design an iterator that supports the `peek` operation on an existing iterator in addition to the `hasNext` and `next` operations.
*Thiết kế một iterator hỗ trợ thao tác `peek` trên một iterator hiện có bên cạnh các thao tác `hasNext` và `next`.*

Implement the `PeekingIterator` class:
*   `PeekingIterator(Iterator<int> nums)` Initializes the object with the given integer iterator `iterator`.
*   `int next()` Returns the next element in the array and advances the pointer.
*   `boolean hasNext()` Returns `true` if there are still elements in the array.
*   `int peek()` Returns the next element in the array **without** advancing the pointer.

Note: Each language may have a different implementation of the constructor and `Iterator`, but they all support the `int next()` and `boolean hasNext()` functions.

## Example 1:
## *Ví dụ 1:*

**Input:**
`["PeekingIterator", "next", "peek", "next", "next", "hasNext"]`
`[[[1, 2, 3]], [], [], [], [], []]`
**Output:**
`[null, 1, 2, 2, 3, false]`
**Explanation:**
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
peekingIterator.hasNext(); // return False

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `1 <= nums[i] <= 1000`
*   All the calls to `next` and `peek` are valid.
*   At most `1000` calls will be made to `next`, `hasNext`, and `peek`.

**Follow up:** How would you extend your design to be generic and work with all types, not just integer?
**Câu hỏi mở rộng:** Làm thế nào bạn mở rộng thiết kế của mình để tổng quát và làm việc với tất cả các loại, không chỉ số nguyên?
