# 1195. Fizz Buzz Multithreaded / Fizz Buzz Đa luồng

## Problem Description / Mô tả bài toán
Four threads: `fizz`, `buzz`, `fizzbuzz`, `number`.
Synchronize them to output FizzBuzz sequence from 1 to `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Synchronization Primitives / Nguyên tắc Đồng bộ hóa
Using `synchronized` and `wait/notifyAll` or `Semaphore` or `Lock/Condition`.
Counter `i` from 1 to `n`.
Each thread checks if `i` satisfies its condition.
If yes, print, increment `i`, notify all.
If no, wait.

Logic:
Critical section controls `currentNumber`.
Conditions:
- FizzBuzz: `num % 15 == 0`.
- Fizz: `num % 3 == 0 && num % 5 != 0`.
- Buzz: `num % 5 == 0 && num % 3 != 0`.
- Number: `num % 3 != 0 && num % 5 != 0`.

Wait loop condition is crucial.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Synchronized State Machine
Use a simple state variable (the current number `i`) protected by a lock (or synchronized methods). All 4 threads loop until `i > n`. Inside the loop, check the divisibility of the current `i`. If it matches the thread's responsibility, perform the print, increment `i`, and notify all threads. If not, wait. This effectively passes control between threads based on the properties of `i`.
Sử dụng một biến trạng thái đơn giản (số hiện tại `i`) được bảo vệ bởi khóa (hoặc các phương thức đồng bộ). Tất cả 4 luồng lặp lại cho đến khi `i > n`. Bên trong vòng lặp, hãy kiểm tra tính chia hết của `i` hiện tại. Nếu nó phù hợp với trách nhiệm của luồng, hãy thực hiện in, tăng `i` và thông báo cho tất cả các luồng. Nếu không, hãy đợi. Điều này chuyển giao quyền kiểm soát một cách hiệu quả giữa các luồng dựa trên các thuộc tính của `i`.

---
