# Result for Kill Process
# *Kết quả cho bài toán Tiêu diệt Tiến trình*

## Description
## *Mô tả*

You have `n` processes, each process has a unique **PID** (process id) and its **PPID** (parent process id).
*Bạn có `n` tiến trình, mỗi tiến trình có một **PID** (id tiến trình) duy nhất và **PPID** (id tiến trình cha) của nó.*

Each process only has one parent process but may have multiple children processes. Only one process has PPID = 0, which means this process has no parent process.
*Mỗi tiến trình chỉ có một tiến trình cha nhưng có thể có nhiều tiến trình con. Chỉ có duy nhất một tiến trình có PPID = 0, nghĩa là tiến trình này không có tiến trình cha.*

All the PIDs will be distinct positive integers.
*Tất cả các PID sẽ là những số nguyên dương riêng biệt.*

We use two list of integers to represent a list of processes, where the first list contains PID of each process and the second list contains the corresponding PPID.
*Chúng ta dùng hai danh sách số nguyên để đại diện cho danh sách các tiến trình, trong đó danh sách thứ nhất chứa PID của mỗi tiến trình và danh sách thứ hai chứa PPID tương ứng.*

Now given a specific PID of a process to be killed, return a list of PIDs of processes that will be killed in the end. You should think that when a process is killed, all its children processes will be killed. No order is required for the final answer.
*Bây giờ, cho một PID cụ thể của một tiến trình sẽ bị tiêu diệt, hãy trả về danh sách các PID của các tiến trình sẽ bị tiêu diệt cuối cùng. Bạn nên nghĩ rằng khi một tiến trình bị tiêu diệt, tất cả các tiến trình con của nó sẽ bị tiêu diệt. Không yêu cầu thứ tự cho câu trả lời cuối cùng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** pid = [1, 3, 10, 5], ppid = [3, 0, 5, 3], kill = 5
**Output:** [5, 10]
**Explanation:** 
- Process 5 is the parent of process 10.
- When process 5 is killed, process 10 is also killed.

---

## Constraints:
## *Ràng buộc:*

*   `n == pid.length`
*   `n == ppid.length`
*   `1 <= n <= 5 * 104`
*   `1 <= pid[i] <= 5 * 104`
*   `0 <= ppid[i] <= 5 * 104`
*   Only one process has `ppid[i] = 0`.
*   `kill` is guaranteed to be in `pid`.
