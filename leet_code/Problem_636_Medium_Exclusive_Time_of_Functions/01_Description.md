# Result for Exclusive Time of Functions
# *Kết quả cho bài toán Thời gian Thực thi Riêng của các Hàm*

## Description
## *Mô tả*

On a **single-threaded** CPU, we execute a program containing `n` functions. Each function has a unique ID between `0` and `n-1`.
*Trên một CPU **đơn luồng**, chúng ta thực thi một chương trình chứa `n` hàm. Mỗi hàm có một ID duy nhất từ `0` đến `n-1`.*

Function calls are stored in a **call stack**: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the **current function being executed**. Each time a function starts or ends, we write a log with the format `"{function_id}:{start|end}:{timestamp}"`.
*Các lần gọi hàm được lưu trữ trong một **ngăn xếp cuộc gọi** (call stack): khi một cuộc gọi hàm bắt đầu, ID của nó được đẩy vào ngăn xếp, và khi một cuộc gọi hàm kết thúc, ID của nó được đưa ra khỏi ngăn xếp. Hàm có ID ở đầu ngăn xếp là **hàng hiện đang được thực thi**. Mỗi khi một hàm bắt đầu hoặc kết thúc, chúng ta ghi lại một nhật ký theo định dạng `"{function_id}:{start|end}:{timestamp}"`.*

You are given a list `logs`, where `logs[i]` represents the `i`-th log message formatted as a string.
*Bạn được cho một danh sách `logs`, trong đó `logs[i]` đại diện cho thông báo nhật ký thứ `i` được định dạng dưới dạng chuỗi.*

A function's **exclusive time** is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for `2` time units and another for `1` time unit, the exclusive time is `2 + 1 = 3`.
* **Thời gian thực thi riêng** của một hàm là tổng thời gian thực thi của tất cả các lần gọi hàm đó trong chương trình. Ví dụ: nếu một hàm được gọi hai lần, một lần thực thi trong `2` đơn vị thời gian và một lần khác trong `1` đơn vị thời gian, thời gian riêng là `2 + 1 = 3`.*

Return the exclusive time of each function in an array, where the value at the $i$-th index represents the exclusive time for the function with ID $i$.
*Trả về thời gian thực thi riêng của mỗi hàm trong một mảng, trong đó giá trị tại chỉ số thứ $i$ đại diện cho thời gian riêng của hàm có ID $i$.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
**Output:** [3,4]
**Explanation:**
Function 0 starts at time 0, executes for 2 units (0, 1).
Function 1 starts at time 2, executes for 4 units (2, 3, 4, 5).
Function 0 resumes at time 6, executes for 1 unit (6).
So, function 0 has an exclusive time of 2 + 1 = 3 and function 1 has an exclusive time of 4.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 100`
*   `1 <= logs.length <= 500`
*   `0 <= function_id < n`
*   `0 <= timestamp <= 10^9`
*   No two start events will happen at the same timestamp and no two end events will happen at the same timestamp.
*   Each function has a matching `start` and `end` log.
