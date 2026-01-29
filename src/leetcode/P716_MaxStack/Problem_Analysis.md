# 716. Max Stack / Ngăn xếp Cực đại

## Problem Description / Mô tả bài toán
Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
Thiết kế một cấu trúc dữ liệu ngăn xếp cực đại hỗ trợ các thao tác ngăn xếp và hỗ trợ tìm phần tử lớn nhất của ngăn xếp.

Implement the `MaxStack` class:
- `void push(int x)` Pushes element `x` onto the stack.
- `int pop()` Removes the element on top of the stack and returns it.
- `int top()` Gets the element on the top of the stack without removing it.
- `int peekMax()` Retrieves the maximum element in the stack without removing it.
- `int popMax()` Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Doubly Linked List and TreeMap / Danh sách Liên kết kép và TreeMap
To achieve efficient `popMax`, we need a way to find and remove a specific value from the middle of the stack.
Để đạt được `popMax` hiệu quả, chúng ta cần một cách để tìm và xóa một giá trị cụ thể ở giữa ngăn xếp.

1. **Doubly Linked List**: Stores the elements in their insertion order (stack order).
2. **TreeMap**: Stores values as keys and a list of nodes as the value. This allows O(log N) access to the maximum value and O(1) removal from the linked list.

### Complexity / Độ phức tạp
- **Time**: `push`, `pop`, `top`, `peekMax`: O(log N). `popMax`: O(log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linked List with TreeMap Index
Use a `TreeMap<Integer, List<Node>>` to store the locations of all occurrences of each value. When `popMax` is called, use the TreeMap to find the last node added for that max value and remove it from the linked list.
Sử dụng `TreeMap<Integer, List<Node>>` để lưu trữ vị trí của tất cả các lần xuất hiện của mỗi giá trị. Khi `popMax` được gọi, hãy sử dụng TreeMap để tìm nút cuối cùng được thêm cho giá trị tối đa đó và xóa nó khỏi danh sách liên kết.

---
