# Result for Bus Routes
# *Kết quả cho bài toán Các tuyến xe buýt*

## Description
## *Mô tả*

You are given an array `routes` representing bus routes where `routes[i]` is a bus route that the `i`-th bus repeats forever.
*Cho một mảng `routes` đại diện cho các tuyến xe buýt, trong đó `routes[i]` là một lộ trình mà xe buýt thứ `i` lặp đi lặp lại mãi mãi.*

*   For example, if `routes[0] = [1, 5, 7]`, this means that the 0-th bus travels in the sequence `1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ...` forever.
*   *Ví dụ, nếu `routes[0] = [1, 5, 7]`, nghĩa là xe buýt số 0 di chuyển theo chuỗi `1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ...` mãi mãi.*

You will start at the bus stop `source` (you are not on any bus initially), and you want to go to the bus stop `target`. You can travel between bus stops by buses only.
*Bạn sẽ bắt đầu tại trạm xe buýt `source` (ban đầu bạn không ở trên bất kỳ chiếc xe buýt nào), và bạn muốn đi đến trạm `target`. Bạn chỉ có thể di chuyển giữa các trạm bằng xe buýt.*

Return *the least number of buses you must take to travel from `source` to `target`*. If it is impossible to reach `target`, return `-1`.
*Trả về *số lượng xe buýt ít nhất bạn phải đi để di chuyển từ `source` đến `target`*. Nếu không thể đến được `target`, hãy trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** routes = [[1,2,7],[3,6,7]], source = 1, target = 6
**Output:** 2
**Explanation:** The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

## Example 2:
## *Ví dụ 2:*

**Input:** routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
**Output:** -1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= routes.length <= 500`.
*   `1 <= routes[i].length <= 10^5`.
*   All the values of `routes[i]` are **unique**.
*   sum of `routes[i].length` is at most `10^5`.
*   `0 <= routes[i][j] < 10^6`.
*   `0 <= source, target < 10^6`.
