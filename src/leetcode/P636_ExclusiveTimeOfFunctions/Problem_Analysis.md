# 636. Exclusive Time of Functions / Thời Gian Độc Quyền Của Các Hàm

## Problem Description / Mô tả bài toán
On a **single-threaded** CPU, we execute a program containing `n` functions. Each function has a unique ID between `0` and `n-1`.
Trên CPU **đơn luồng**, chúng tôi thực thi một chương trình chứa `n` hàm. Mỗi hàm có một ID duy nhất từ `0` đến `n-1`.

Function calls are stored in a `logs` list, where each entry contains a timestamp. Format: `id:start:time` or `id:end:time`.
Các lệnh gọi hàm được lưu trữ trong danh sách `logs`, trong đó mỗi mục chứa một dấu thời gian. Định dạng: `id:start:time` hoặc `id:end:time`.

- `start` means the function starts executing at the beginning of the timestamp `time`.
- `end` means the function finishes executing at the end of the timestamp `time`.

Return the exclusive time of each function in an array. Exclusive time is the sum of execution times for this function, excluding time spent in nested calls.
Trả về thời gian độc quyền của mỗi hàm trong một mảng. Thời gian độc quyền là tổng thời gian thực thi cho hàm này, không bao gồm thời gian dành cho các lệnh gọi lồng nhau.

### Example 1:
```text
Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
Explanation:
Function 0 starts at 0, executes for 2 units (0,1).
Function 1 starts at 2, executes for 4 units (2,3,4,5).
Function 0 resumes at 6, executes for 1 unit (6).
Total 0: 2+1=3. Total 1: 4.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack / Ngăn Xếp
We simulate the call stack.
Logs are sorted by time.
- `start`:
  - If stack not empty, the current running function (peek) is paused. Update its exclusive time by `current_time - prev_time`.
  - Push new function ID to stack.
  - Set `prev_time = current_time`.
- `end`:
  - Function finishes. This must be the top of stack.
  - Update its exclusive time by `current_time - prev_time + 1` (since end includes the whole unit).
  - Pop call.
  - Set `prev_time = current_time + 1` (next instruction starts at time+1).

### Complexity / Độ phức tạp
- **Time**: O(L) where L is logs count.
- **Space**: O(N) (stack depth).

---

## Analysis / Phân tích

### Approach: Stack Simulation

**Algorithm**:
1.  Initialize stack and result array.
2.  Iterate through logs.
3.  On 'start': charge previous function, push new.
4.  On 'end': charge current function, pop, advance time.

---
