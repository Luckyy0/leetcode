# Result for Course Schedule
# *Kết quả cho bài toán Lịch học*

## Description
## *Mô tả*

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you **must** take course `bi` first if you want to take course `ai`.
*Có tổng cộng `numCourses` khóa học bạn phải tham gia, được đánh số từ `0` đến `numCourses - 1`. Bạn được cung cấp một mảng `prerequisites` trong đó `prerequisites[i] = [ai, bi]` chỉ ra rằng bạn **phải** tham gia khóa học `bi` trước nếu bạn muốn tham gia khóa học `ai`.*

*   For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.
    *Ví dụ, cặp `[0, 1]` chỉ ra rằng để tham gia khóa học `0`, bạn phải tham gia khóa học `1` trước.*

Return `true` if you can finish all courses. Otherwise, return `false`.
*Trả về `true` nếu bạn có thể hoàn thành tất cả các khóa học. Ngược lại, trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `numCourses = 2, prerequisites = [[1,0]]`
**Output:** `true`
**Explanation:** There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

## Example 2:
## *Ví dụ 2:*

**Input:** `numCourses = 2, prerequisites = [[1,0],[0,1]]`
**Output:** `false`
**Explanation:** There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

## Constraints:
## *Ràng buộc:*

*   `1 <= numCourses <= 2000`
*   `0 <= prerequisites.length <= 5000`
*   `prerequisites[i].length == 2`
*   All the pairs prerequisites[i] are **unique**.
