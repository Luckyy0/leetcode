# Result for Maximum Vacation Days
# *Kết quả cho bài toán Số ngày Nghỉ tối đa*

## Description
## *Mô tả*

LeetCode wants to give one of its best employees the option to travel among **n** cities to maximize the total number of vacation days. The employee can stay in a city for a week and then travel to another city or stay in the same city for the next week.
*LeetCode muốn trao cho một trong những nhân viên xuất sắc nhất của mình quyền lựa chọn đi du lịch giữa **n** thành phố để tối đa hóa tổng số ngày nghỉ. Nhân viên có thể ở lại một thành phố trong một tuần và sau đó di chuyển đến thành phố khác hoặc ở lại cùng một thành phố cho tuần tiếp theo.*

There are **n** cities and **k** weeks. You are given:
*Có **n** thành phố và **k** tuần. Bạn được cung cấp:*

1.  A 2D array `flights` where `flights[i][j] = 1` if there is a flight from city `i` to city `j`, and `flights[i][j] = 0` otherwise. Note that `flights[i][i]` is not necessarily 1, but you can always stay in the same city.
    *Một mảng 2 chiều `flights` trong đó `flights[i][j] = 1` nếu có chuyến bay từ thành phố `i` đến thành phố `j`, và `flights[i][j] = 0` nếu ngược lại. Lưu ý rằng `flights[i][i]` không nhất thiết là 1, nhưng bạn luôn có quyền ở lại cùng một thành phố.*
2.  A 2D array `days` where `days[i][j]` is the number of vacation days the employee can take in city `i` during week `j`.
    *Một mảng 2 chiều `days` trong đó `days[i][j]` là số ngày nghỉ mà nhân viên có thể có tại thành phố `i` trong tuần `j`.*

The employee starts at city `0` before week `0`. Return the **maximum vacation days** the employee can take.
*Nhân viên bắt đầu tại thành phố `0` trước tuần `0`. Trả về **số ngày nghỉ tối đa** mà nhân viên có thể nhận được.*

## Example 1:
## *Ví dụ 1:*

**Input:** `flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]`
**Output:** `12`
**Explanation:** 
Ans = 6 + 3 + 3 = 12. 
Week 0: Fly from city 0 to city 1, vacation days = 6.
Week 1: Stay in city 1, vacation days = 0. (Actually better: Fly from 1 to 2, days = 3)
Correct path for 12: Week 0 (city 1, 6 days), Week 1 (city 0, 3 days), Week 2 (city 1, 3 days) -> 12.

## Example 2:
## *Ví dụ 2:*

**Input:** `flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]`
**Output:** `21`

## Constraints:
## *Ràng buộc:*

*   `n == flights.length == flights[i].length`
*   `k == days[i].length`
*   `1 <= n, k <= 100`
*   `flights[i][j]` is `0` or `1`.
*   `0 <= days[i][j] <= 7`
