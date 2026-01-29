# 622. Design Circular Queue / Thiết Kế Hàng Đợi Vòng

## Problem Description / Mô tả bài toán
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
Thiết kế triển khai hàng đợi vòng của bạn. Hàng đợi vòng là một cấu trúc dữ liệu tuyến tính trong đó các hoạt động được thực hiện dựa trên nguyên tắc FIFO (Vào trước ra trước) và vị trí cuối cùng được kết nối lại với vị trí đầu tiên để tạo thành một vòng tròn. Nó còn được gọi là "Bộ đệm vòng".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
Một trong những lợi ích của hàng đợi vòng là chúng ta có thể tận dụng các khoảng trống phía trước hàng đợi. Trong hàng đợi bình thường, khi hàng đợi đầy, chúng ta không thể chèn phần tử tiếp theo ngay cả khi có khoảng trống phía trước hàng đợi. Nhưng sử dụng hàng đợi vòng, chúng ta có thể sử dụng khoảng trống để lưu trữ các giá trị mới.

Implementation the `MyCircularQueue` class:
- `MyCircularQueue(k)`: Initializes the object with the size of the queue to be `k`.
- `int Front()`: Gets the front item from the queue. If the queue is empty, return `-1`.
- `int Rear()`: Gets the last item from the queue. If the queue is empty, return `-1`.
- `boolean enQueue(int value)`: Inserts an element into the circular queue. Return `true` if the operation is successful.
- `boolean deQueue()`: Deletes an element from the circular queue. Return `true` if the operation is successful.
- `boolean isEmpty()`: Checks whether the circular queue is empty or not.
- `boolean isFull()`: Checks whether the circular queue is full or not.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array Implementation / Triển Khai Mảng
Use an array `data` of size `k`.
Indices: `head` and `tail`. Or `head` and `count`.
Using `count` is simpler to manage empty/full states.
- `enQueue`: `data[(head + count) % k] = val`, `count++`.
- `deQueue`: `head = (head + 1) % k`, `count--`.
- `Front`: `data[head]`.
- `Rear`: `data[(head + count - 1) % k]`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all ops.
- **Space**: O(k).

---

## Analysis / Phân tích

### Approach: Array with Pointers

**Algorithm**:
1.  Initialize array, head index, size variable.
2.  Implement methods using modulo arithmetic.
3.  Handle empty/full conditions carefully.

---
