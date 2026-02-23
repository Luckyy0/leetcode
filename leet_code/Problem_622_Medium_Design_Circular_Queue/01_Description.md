# Result for Design Circular Queue
# *Kết quả cho bài toán Thiết kế Hàng đợi Vòng*

## Description
## *Mô tả*

Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
*Thiết kế việc triển khai hàng đợi vòng của bạn. Hàng đợi vòng là một cấu trúc dữ liệu tuyến tính trong đó các thao tác được thực hiện dựa trên nguyên tắc FIFO (Vào trước Ra trước) và vị trí cuối cùng được kết nối lại với vị trí đầu tiên để tạo thành một vòng tròn. Nó còn được gọi là "Bộ đệm vòng" (Ring Buffer).*

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
*Một trong những lợi ích của hàng đợi vòng là chúng ta có thể tận dụng các khoảng trống ở phía trước hàng đợi. Trong một hàng đợi thông thường, một khi hàng đợi đã đầy, chúng ta không thể chèn phần tử tiếp theo ngay cả khi có khoảng trống ở phía trước hàng đợi. Nhưng khi sử dụng hàng đợi vòng, chúng ta có thể sử dụng không gian đó để lưu trữ các giá trị mới.*

Implementation should support following operations:
*Việc triển khai nên hỗ trợ các thao tác sau:*

*   `MyCircularQueue(k)`: Initializes the object with the size of the queue to be `k`.
    *   *`MyCircularQueue(k)`: Khởi tạo đối tượng với kích thước của hàng đợi là `k`.*
*   `Front()`: Gets the front item from the queue. If the queue is empty, return `-1`.
    *   *`Front()`: Lấy mục ở phía trước của hàng đợi. Nếu hàng đợi trống, trả về `-1`.*
*   `Rear()`: Gets the last item from the queue. If the queue is empty, return `-1`.
    *   *`Rear()`: Lấy mục cuối cùng từ hàng đợi. Nếu hàng đợi trống, trả về `-1`.*
*   `enQueue(value)`: Inserts an element into the circular queue. Return `true` if the operation is successful.
    *   *`enQueue(value)`: Chèn một phần tử vào hàng đợi vòng. Trả về `true` nếu thao tác thành công.*
*   `deQueue()`: Deletes an element from the circular queue. Return `true` if the operation is successful.
    *   *`deQueue()`: Xóa một phần tử khỏi hàng đợi vòng. Trả về `true` nếu thao tác thành công.*
*   `isEmpty()`: Checks whether the circular queue is empty or not.
    *   *`isEmpty()`: Kiểm tra xem hàng đợi vòng có trống hay không.*
*   `isFull()`: Checks whether the circular queue is full or not.
    *   *`isFull()`: Kiểm tra xem hàng đợi vòng đã đầy hay chưa.*

---

## Example 1:
## *Ví dụ 1:*

**Input:**
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
**Output:**
[null, true, true, true, false, 3, true, true, true, 4]

**Explanation:**
```
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();   // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
```

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 1000`
*   `0 <= value <= 1000`
*   At most `3000` calls will be made to `enQueue`, `deQueue`, `Front`, `Rear`, `isEmpty`, and `isFull`.
