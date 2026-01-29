# 1348. Tweet Counts Per Frequency / Số lượng Tweet Mỗi Tần suất

## Problem Description / Mô tả bài toán
Implement class `TweetCounts`:
- `recordTweet(tweetName, time)`
- `getTweetCountsPerFrequency(freq, tweetName, startTime, endTime)`
Frequency can be "minute" (60s), "hour" (3600s), "day" (86400s).
Return list of counts for each interval.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Bucketing
Store tweets for each user in a sorted list (or map).
`getTweetCounts`:
- Calculate `delta` (60, 3600, 86400).
- Total intervals = `(endTime - startTime) / delta + 1`.
- Initialize `res` array.
- Iterate tweets for `tweetName`.
- If tweet time `t` in `[startTime, endTime]`:
  - `bucket = (t - startTime) / delta`.
  - `res[bucket]++`.
- Return list.

### Complexity / Độ phức tạp
- **Time**: Record O(1) or O(log N). Get O(N) where N is number of tweets.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Map of Lists
Use a `Map<String, List<Integer>>` to store tweet times for each `tweetName`.
For `recordTweet`, simply add the time to the list (keep it sorted if optimization needed, but appending is O(1) assuming mostly sorted or sort on query).
For `getTweetCountsPerFrequency`:
Determine `chunkSize` based on frequency string. Calculate number of buckets needed. Iterate through the stored times for the given user. If a time is within `[startTime, endTime]`, calculate its bucket index `(time - startTime) / chunkSize` and increment the count.
Sử dụng `Map<String, List<Integer>>` để lưu trữ thời gian tweet cho mỗi `tweetName`.
Đối với `recordTweet`, chỉ cần thêm thời gian vào danh sách (giữ cho nó được sắp xếp nếu cần tối ưu hóa, nhưng việc thêm vào là O(1) giả sử hầu hết đã được sắp xếp hoặc sắp xếp khi truy vấn).
Đối với `getTweetCountsPerFrequency`:
Xác định `chunkSize` dựa trên chuỗi tần suất. Tính số lượng nhóm cần thiết. Lặp qua thời gian đã lưu trữ cho người dùng đã cho. Nếu thời gian nằm trong khoảng `[startTime, endTime]`, hãy tính chỉ số nhóm của nó `(time - startTime) / chunkSize` và tăng số đếm.

---
