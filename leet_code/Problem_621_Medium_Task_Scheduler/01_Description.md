# Result for Task Scheduler
# *Kết quả cho bài toán Bộ điều phối Công việc*

## Description
## *Mô tả*

Given a characters array `tasks`, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
*Cho một mảng ký tự `tasks`, đại diện cho các công việc mà CPU cần thực hiện, trong đó mỗi chữ cái đại diện cho một công việc khác nhau. Các công việc có thể được thực hiện theo bất kỳ thứ tự nào. Mỗi công việc được thực hiện trong một đơn vị thời gian. Trong mỗi đơn vị thời gian, CPU có thể hoàn thành một công việc hoặc ở trạng thái nghỉ (idle).*

However, there is a non-negative integer `n` that represents the cooldown period between two **same tasks** (the same letter in the array), that is that there must be at least `n` units of time between any two same tasks.
*Tuy nhiên, có một số nguyên không âm `n` đại diện cho khoảng thời gian hạ nhiệt giữa hai **công việc giống nhau** (cùng một chữ cái trong mảng), nghĩa là phải có ít nhất `n` đơn vị thời gian giữa bất kỳ hai công việc giống nhau nào.*

Return the least number of units of time that the CPU will take to finish all the given tasks.
*Trả về số đơn vị thời gian ít nhất mà CPU sẽ mất để hoàn thành tất cả các công việc đã cho.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** tasks = ["A","A","A","B","B","B"], n = 2
**Output:** 8
**Explanation:** 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

## Example 2:
## *Ví dụ 2:*

**Input:** tasks = ["A","A","A","B","B","B"], n = 0
**Output:** 6
**Explanation:** On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

## Example 3:
## *Ví dụ 3:*

**Input:** tasks = ["A","A","A","B","B","B"], n = 2
**Output:** 8

---

## Constraints:
## *Ràng buộc:*

*   `1 <= tasks.length <= 10^4`
*   `tasks[i]` is upper-case English letter.
*   `0 <= n <= 100`
