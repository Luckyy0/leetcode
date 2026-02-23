# Result for Maximum Frequency Stack
# *Kết quả cho bài toán Ngăn xếp Tần suất Tối đa*

## Description
## *Mô tả*

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
*Thiết kế một cấu trúc dữ liệu giống ngăn xếp để đẩy các phần tử vào ngăn xếp và lấy ra phần tử xuất hiện thường xuyên nhất từ ngăn xếp.*

Implement the `FreqStack` class:
*Triển khai lớp `FreqStack`:*

*   `FreqStack()` constructs an empty frequency stack.
    *   `FreqStack()` khởi tạo một ngăn xếp tần suất trống.*
*   `void push(int val)` pushes an integer `val` onto the top of the stack.
    *   `void push(int val)` đẩy một số nguyên `val` lên đầu ngăn xếp.*
*   `int pop()` removes and returns the most frequent element in the stack.
    *   `int pop()` loại bỏ và trả về phần tử xuất hiện thường xuyên nhất trong ngăn xếp.*
    *   If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
        *   *Nếu có nhiều phần tử có cùng tần suất cao nhất, phần tử gần đỉnh ngăn xếp nhất sẽ được loại bỏ và trả về.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
**Output:** [null, null, null, null, null, null, null, 5, 7, 5, 4]
**Explanation:** 
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

---

## Constraints:
## *Ràng buộc:*

*   `0 <= val <= 10^9`
*   At most `2 * 10^4` calls will be made to `push` and `pop`.
*   It is guaranteed that there will be at least one element in the stack before calling `pop`.
