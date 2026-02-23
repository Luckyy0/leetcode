# Result for Number of Recent Calls
# *Kết quả cho bài toán Số cuộc gọi Gần đây*

## Description
## *Mô tả*

You have a `RecentCounter` class which counts the number of recent requests within a certain time frame.
*Bạn có một lớp `RecentCounter`, lớp này đếm số lượng yêu cầu gần đây trong một khoảng thời gian nhất định.*

Implement the `RecentCounter` class:
*Triển khai lớp `RecentCounter`:*

*   `RecentCounter()` Initializes the counter with zero recent requests.
    *   `RecentCounter()` Khởi tạo bộ đếm với không yêu cầu gần đây nào.*
*   `int ping(int t)` Adds a new request at time `t`, where `t` represents some time in milliseconds, and returns the number of requests that has happened in the past `3000` milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range `[t - 3000, t]`.
    *   `int ping(int t)` Thêm một yêu cầu mới tại thời điểm `t`, trong đó `t` đại diện cho một thời gian tính bằng mili giây, và trả về số lượng yêu cầu đã xảy ra trong `3000` mili giây qua (bao gồm cả yêu cầu mới). Cụ thể, trả về số lượng yêu cầu đã xảy ra trong khoảng bao gồm `[t - 3000, t]`.*

It is guaranteed that every call to `ping` uses a strictly larger value of `t` than the previous call.
*Đảm bảo rằng mỗi cuộc gọi tới `ping` sử dụng giá trị `t` lớn hơn nghiêm ngặt so với cuộc gọi trước đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input**
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
**Output**
[null, 1, 2, 3, 3]

**Explanation**
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= t <= 10^9`
*   Each test case will call `ping` with strictly increasing values of `t`.
*   At most `10^4` calls will be made to `ping`.
