# Result for Course Schedule III
# *Kết quả cho bài toán Lập lịch Khóa học III*

## Description
## *Mô tả*

There are `n` different online courses numbered from `1` to `n`. You are given an array `courses` where `courses[i] = [duration_i, lastDay_i]` indicate that the `i`-th course should be taken continuously for `duration_i` days and must be finished before or on `lastDay_i`.
*Có `n` khóa học trực tuyến khác nhau được đánh số từ `1` đến `n`. Bạn được cho một mảng `courses` trong đó `courses[i] = [duration_i, lastDay_i]` cho biết rằng khóa học thứ `i` nên được học liên tục trong `duration_i` ngày và phải kết thúc trước hoặc vào ngày `lastDay_i`.*

You will start on the `1`-st day and you cannot take two or more courses simultaneously.
*Bạn sẽ bắt đầu vào ngày thứ `1` và bạn không thể tham gia hai hoặc nhiều khóa học cùng một lúc.*

Return the maximum number of courses that you can take.
*Trả về số lượng khóa học tối đa mà bạn có thể tham gia.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
**Output:** 3
**Explanation:** 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day, and ready to take the next course on the 1301st day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

## Example 2:
## *Ví dụ 2:*

**Input:** courses = [[1,2],[2,3]]
**Output:** 2

---

## Constraints:
## *Ràng buộc:*

*   `1 <= courses.length <= 10^4`
*   `1 <= duration_i, lastDay_i <= 10^4`
