# Result for Design Log Storage System
# *Kết quả cho bài toán Thiết kế Hệ thống Lưu trữ Nhật ký*

## Description
## *Mô tả*

You are given several logs, each log contains a unique id and timestamp. Timestamp is a string that has the following format: `Year:Month:Day:Hour:Minute:Second`, for example, `2017:01:01:23:59:59`. All domains are zero-padded decimal numbers.
*Bạn được cho một vài nhật ký (logs), mỗi nhật ký chứa một ID duy nhất và một dấu thời gian (timestamp). Dấu thời gian là một chuỗi có định dạng sau: `Year:Month:Day:Hour:Minute:Second`, ví dụ: `2017:01:01:23:59:59`. Tất cả các trường đều là số thập phân được đệm bằng số không.*

Design a system to store these logs and retrieve ids that are within a certain range of time.
*Thiết kế một hệ thống để lưu trữ các nhật ký này và truy xuất các ID nằm trong một khoảng thời gian nhất định.*

Implement the `LogSystem` class:
*Triển khai lớp `LogSystem`:*
*   `LogSystem()`: Initializes the `LogSystem` object.
    *   *`LogSystem()`: Khởi tạo đối tượng `LogSystem`.*
*   `void put(int id, string timestamp)`: Stores the given log `(id, timestamp)` in the storage system.
    *   *`void put(int id, string timestamp)`: Lưu trữ nhật ký `(id, timestamp)` đã cho vào hệ thống lưu trữ.*
*   `int[] retrieve(string start, string end, string granularity)`: Returns the ids of the logs whose timestamps are within the range from `start` to `end` inclusive, with the given `granularity`.
    *   *`int[] retrieve(string start, string end, string granularity)`: Trả về danh sách ID của các nhật ký có dấu thời gian nằm trong phạm vi từ `start` đến `end` (bao gồm cả hai đầu), với `granularity` (độ chi tiết) đã cho.*

`granularity` means whether we should consider years, months, days, etc. for the comparison. For example, if `granularity = "Day"`, we only consider the year, month, and day fields of the timestamps.
*`granularity` có nghĩa là chúng ta có nên xem xét năm, tháng, ngày, v.v. cho việc so sánh hay không. Ví dụ: nếu `granularity = "Day"`, chúng ta chỉ xem xét các trường năm, tháng và ngày của các dấu thời gian.*

---

## Example 1:
## *Ví dụ 1:*

**Input:**
["LogSystem", "put", "put", "put", "retrieve", "retrieve"]
[[], [1, "2017:01:01:23:59:59"], [2, "2017:01:01:22:59:59"], [3, "2016:01:01:00:00:00"], ["2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"], ["2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"]]
**Output:**
[null, null, null, null, [3, 2, 1], [2, 1]]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= id <= 500`
*   Timestamps have the same format and are within the range `[2000:01:01:00:00:00, 2017:12:31:23:59:59]`.
*   `granularity` is one of `["Year", "Month", "Day", "Hour", "Minute", "Second"]`.
*   At most `500` calls will be made to `put` and `retrieve`.
