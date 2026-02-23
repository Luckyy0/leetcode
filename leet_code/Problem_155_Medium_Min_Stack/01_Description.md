# Result for Min Stack
# *Kết quả cho bài toán Ngăn xếp tối thiểu*

## Description
## *Mô tả*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
*Thiết kế một ngăn xếp hỗ trợ các thao tác push (đẩy), pop (lấy ra), top (phần tử trên cùng) và truy xuất phần tử nhỏ nhất trong thời gian hằng số.*

Implement the `MinStack` class:
*Triển khai lớp `MinStack`:*

*   `MinStack()` initializes the stack object.
    *`MinStack()` khởi tạo đối tượng ngăn xếp.*
*   `void push(int val)` pushes the element `val` onto the stack.
    *`void push(int val)` đẩy phần tử `val` vào ngăn xếp.*
*   `void pop()` removes the element on the top of the stack.
    *`void pop()` loại bỏ phần tử trên cùng của ngăn xếp.*
*   `int top()` gets the top element of the stack.
    *`int top()` lấy phần tử trên cùng của ngăn xếp.*
*   `int getMin()` retrieves the minimum element in the stack.
    *`int getMin()` truy xuất phần tử nhỏ nhất trong ngăn xếp.*

You must implement a solution with **O(1)** time complexity for each function.
*Bạn phải triển khai một giải pháp với độ phức tạp thời gian **O(1)** cho mỗi hàm.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["MinStack","push","push","push","getMin","pop","top","getMin"]`
`[[],[-2],[0],[-3],[],[],[],[]]`

**Output**
`[null,null,null,null,-3,null,0,-2]`

**Explanation**
```java
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

## Constraints:
## *Ràng buộc:*

*   `-2^31 <= val <= 2^31 - 1`
*   Methods `pop`, `top` and `getMin` operations will always be called on **non-empty** stacks.
*   At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.
