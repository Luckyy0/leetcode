# 635. Design Log Storage System / Thiết Kế Hệ Thống Lưu Trữ Nhật Ký

## Problem Description / Mô tả bài toán
You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: `Year:Month:Day:Hour:Minute:Second`, for example, `2017:01:01:23:59:59`. All domains are zero-padded decimal numbers.
Bạn được cung cấp một số nhật ký mà mỗi nhật ký chứa một id duy nhất và dấu thời gian. Dấu thời gian là một chuỗi có định dạng sau: `Year:Month:Day:Hour:Minute:Second`, ví dụ: `2017:01:01:23:59:59`. Tất cả các miền là số thập phân được đệm số không.

Design a log storage system to implement the following functions:
- `void Put(int id, string timestamp)`: Given a log's unique id and timestamp, store the log in your storage system.
- `int[] Retrieve(string start, string end, string granularity)`: Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

Granularity parameter: `Year, Month, Day, Hour, Minute, Second`.
Meaning: truncate the timestamp to that granularity for comparison?
Actually, the description implies adjusting the range query.
If granularity is "Year", we ignore Month..Second? NO.
Description says: "we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017".
Usually, granularity implies we treat the start and end as specifying a prefix, and we want everything in that range implied by the prefix?
Or does it mean we simply compare timestamps directly but align/truncate them?
Standard Interpretation:
`granularity` defines the "significant part".
`start` = `2017:01:01:23:59:59`, `granularity` = `Year`.
Effective Start: `2017:00:00:00:00:00`.
Effective End: `2017:12:31:23:59:59`?
Wait, the example says: `start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day"`.
This implies we compare up to Day.
Wait, if I compare up to day, `2017:01:01:....` vs `2017:01:02:...`
It means we look at `substring` corresponding to the granularity.
If log timestamp cut to granularity is `>= start_cut` AND `<= end_cut`.
Indices for substrings:
Year: 4
Month: 7
Day: 10
Hour: 13
Minute: 16
Second: 19

### Example 1:
```text
put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); 
// Returns [1,2,3] because all in 2016 or 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
// Returns [1,2]. Log 3 is not in range (Month/Day/Hour check).
```
Clarification: `retrieve` arguments `start` and `end` are full timestamps. Granularity tells us how much of that string to respect.
Actually, usually implies we replace the *suffix* of start with min values (00) and suffix of end with max values (59)?
No, the problem says "granularity means the time level for consideration".
If "Year", we compare only 2016 vs 2017.
If "Hour", we compare "2016:01:01:01" vs "2017:01:01:23".
Yes, string prefix comparison.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation / Linear Scan / Xử Lý Chuỗi / Quét Tuyến Tính
Stored logs: List of `{id, timestamp}`.
Indices mapping:
Year: 4, Month: 7, Day: 10, Hour: 13, Minute: 16, Second: 19.
Algorithm `Retrieve`:
1. Determine index `idx` based on granularity.
2. Truncate `start` to `s = start.substring(0, idx)`.
3. Truncate `end` to `e = end.substring(0, idx)`.
4. For each log:
   Truncate `t = log.timestamp.substring(0, idx)`.
   If `s.compareTo(t) <= 0 && t.compareTo(e) <= 0`, add id.

### Complexity / Độ phức tạp
- **Time**: O(N * L) per retrieve.
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Prefix Comparison

**Algorithm**:
1.  Map granularity string to substring length.
2.  Store all logs.
3.  On retrieve, cut strings and compare lexicographically.

---
