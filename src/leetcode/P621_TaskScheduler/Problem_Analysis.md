# 621. Task Scheduler / Bộ Lập Lịch Tác Vụ

## Problem Description / Mô tả bài toán
Given a characters array `tasks`, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
Cho một mảng ký tự `tasks`, đại diện cho các tác vụ mà CPU cần thực hiện, trong đó mỗi chữ cái đại diện cho một tác vụ khác nhau. Các tác vụ có thể được thực hiện theo bất kỳ thứ tự nào. Mỗi tác vụ được thực hiện trong một đơn vị thời gian. Đối với mỗi đơn vị thời gian, CPU có thể hoàn thành một tác vụ hoặc chỉ ở chế độ nhàn rỗi.

However, there is a non-negative integer `n` that represents the cooldown period between two **same tasks** (the same letter in the array), that is that there must be at least `n` units of time between any two same tasks.
Tuy nhiên, có một số nguyên không âm `n` đại diện cho khoảng thời gian hồi chiêu giữa hai **tác vụ giống nhau** (cùng một chữ cái trong mảng), nghĩa là phải có ít nhất `n` đơn vị thời gian giữa hai tác vụ giống nhau.

Return the least number of units of times that the CPU will take to finish all the given tasks.
Trả về số đơn vị thời gian ít nhất mà CPU sẽ mất để hoàn thành tất cả các tác vụ đã cho.

### Example 1:
```text
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Scheduling / Lập Lịch Tham Lam
The length of the schedule is determined by the most frequent task.
Let `maxFreq` be the frequency of the most frequent task.
We can organize the tasks into `maxFreq - 1` groups of size `n + 1` (Task + n cooldown/other tasks).
The last group contains only the tasks that have `maxFreq`.
Calculation:
`result = (maxFreq - 1) * (n + 1) + numberOfTasksWithMaxFreq`.
Condition: `result` cannot be smaller than `tasks.length` (if n is small, we just run tasks without idle).
So `return Max(tasks.length, calculated_value)`.

Example: A:3, B:3, n=2.
Groups:
(A, B, idle)
(A, B, idle)
(A, B)
(3 - 1) * (2 + 1) + 2 = 2 * 3 + 2 = 8.

### Complexity / Độ phức tạp
- **Time**: O(N) to count freqs.
- **Space**: O(1) (26 chars).

---

## Analysis / Phân tích

### Approach: Frequency Calculation

**Algorithm**:
1.  Count frequency of each task.
2.  Find max frequency.
3.  Count how many tasks have this max frequency.
4.  Compute constrained length.
5.  Return max of constrained length and total tasks.

---
