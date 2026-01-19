# 155. Min Stack / Ngăn xếp Tối thiểu

## Problem Description / Mô tả bài toán
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Thiết kế một ngăn xếp hỗ trợ các thao tác đẩy vào, lấy ra, lấy phần tử trên cùng và lấy phần tử nhỏ nhất trong thời gian hằng số.

Implement the `MinStack` class:
- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with **O(1)** time complexity for each function.

### Example 1:
```text
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

## Constraints / Ràng buộc
- `-2^31 <= val <= 2^31 - 1`
- Methods `pop`, `top` and `getMin` operations will always be called on **non-empty** stacks.
- At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Constant Time Minimum / Lấy giá trị nhỏ nhất trong thời gian hằng số
A standard stack (LIFO) supports `push`, `pop`, and `top` in O(1).
To support `getMin` in O(1), we need to store the minimum value **associated with each state** of the stack.
If we only store a single variable `globalMin`, we cannot easily recover the previous minimum after a `pop`.

**Strategy**:
1.  **Helper Stack**: Use a second stack to store the minimum value at each point of the regular stack.
    - When pushing `x`, push `min(x, currentMin)` onto the helper stack.
2.  **Single Stack with Value Pairs**: Each element in the stack is a pair `(value, minAtThisState)`.

---

## Analysis / Phân tích

### Approach: Two Stacks (Main Stack + Min Stack)

**Algorithm**:
- `push(x)`:
  - Push `x` to `mainStack`.
  - Push `min(x, minStack.peek())` to `minStack`.
- `pop()`:
  - Pop from both `mainStack` and `minStack`.
- `top()`:
  - Return `mainStack.peek()`.
- `getMin()`:
  - Return `minStack.peek()`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(N) to store the auxiliary minimum information.

---

## Edge Cases / Các trường hợp biên
1.  **Multiple identical minimums**: Helper stack must track them.
2.  **Values are large/small**: `int` range is sufficient as per constraints.
3.  **Pop reduces the minimum**: Helper stack automatically restores the previous minimum.
4.  **Empty stack**: Constraints state methods are only called on non-empty stacks.
