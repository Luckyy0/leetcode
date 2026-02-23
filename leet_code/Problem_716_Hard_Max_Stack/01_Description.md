# Result for Max Stack
# *Kết quả cho bài toán Ngăn xếp Cực đại*

## Description
## *Mô tả*

Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
*Thiết kế một cấu trúc dữ liệu ngăn xếp cực đại hỗ trợ các thao tác ngăn xếp thông thường và hỗ trợ tìm kiếm phần tử lớn nhất trong ngăn xếp.*

Implement the `MaxStack` class:
*   `MaxStack()` Initializes the stack object.
*   `void push(int x)` Pushes element `x` onto the stack.
*   `int pop()` Removes the element on top of the stack and returns it.
*   `int top()` Gets the element on the top of the stack without removing it.
*   `int peekMax()` Retrieves the maximum element in the stack without removing it.
*   `int popMax()` Retrives the maximum element in the stack and removes it. If there is more than one maximum element, only remove the **top-most** one.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
[[], [5], [1], [5], [], [], [], [], [], []]
**Output:** [null, null, null, null, 5, 5, 1, 5, 1, 5]

---

## Constraints:
## *Ràng buộc:*

*   `-10^7 <= x <= 10^7`
*   At most `10,000` calls will be made to `push`, `pop`, `top`, `peekMax`, and `popMax`.
*   There will be at least one element in the stack when `pop`, `top`, `peekMax`, and `popMax` are called.
