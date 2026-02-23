# Result for Design Circular Deque
# *Kết quả cho bài toán Thiết kế Hàng đợi kép Vòng*

## Description
## *Mô tả*

Design your implementation of the circular double-ended queue (deque).
*Thiết kế việc triển khai hàng đợi kép vòng (deque) của bạn.*

Implement the `MyCircularDeque` class:
*Triển khai lớp `MyCircularDeque`:*

*   `MyCircularDeque(k)`: Initializes the deque with a maximum size of `k`.
    *   *`MyCircularDeque(k)`: Khởi tạo deque với kích thước tối đa là `k`.*
*   `boolean insertFront()`: Adds an item at the front of Deque. Returns `true` if the operation is successful, or `false` otherwise.
    *   *`boolean insertFront()`: Thêm một mục vào phía trước Deque. Trả về `true` nếu thao tác thành công, ngược lại là `false`.*
*   `boolean insertLast()`: Adds an item at the rear of Deque. Returns `true` if the operation is successful, or `false` otherwise.
    *   *`boolean insertLast()`: Thêm một mục vào phía sau Deque. Trả về `true` nếu thao tác thành công, ngược lại là `false`.*
*   `boolean deleteFront()`: Deletes an item from the front of Deque. Returns `true` if the operation is successful, or `false` otherwise.
    *   *`boolean deleteFront()`: Xóa một mục khỏi phía trước Deque. Trả về `true` nếu thao tác thành công, ngược lại là `false`.*
*   `boolean deleteLast()`: Deletes an item from the rear of Deque. Returns `true` if the operation is successful, or `false` otherwise.
    *   *`boolean deleteLast()`: Xóa một mục khỏi phía sau Deque. Trả về `true` nếu thao tác thành công, ngược lại là `false`.*
*   `int getFront()`: Returns the front item from the Deque. Returns `-1` if the deque is empty.
    *   *`int getFront()`: Trả về mục phía trước từ Deque. Trả về `-1` nếu deque trống.*
*   `int getRear()`: Returns the last item from Deque. Returns `-1` if the deque is empty.
    *   *`int getRear()`: Trả về mục cuối cùng từ Deque. Trả về `-1` nếu deque trống.*
*   `boolean isEmpty()`: Returns `true` if the deque is empty, or `false` otherwise.
    *   *`boolean isEmpty()`: Trả về `true` nếu deque trống, ngược lại là `false`.*
*   `boolean isFull()`: Returns `true` if the deque is full, or `false` otherwise.
    *   *`boolean isFull()`: Trả về `true` nếu deque đầy, ngược lại là `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:**
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
**Output:**
[null, true, true, true, false, 2, true, true, true, 4]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 1000`
*   `0 <= value <= 1000`
*   At most `2000` calls will be made to `insertFront`, `insertLast`, `deleteFront`, `deleteLast`, `getFront`, `getRear`, `isEmpty`, `isFull`.
