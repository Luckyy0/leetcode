# 362. Design Hit Counter / Thiết Kế Bộ Đếm Lượt Truy Cập

## Problem Description / Mô tả bài toán
Design a hit counter which counts the number of hits received in the past `5` minutes (i.e., the past `300` seconds).
Thiết kế bộ đếm lượt truy cập đếm số lượng lượt truy cập nhận được trong `5` phút qua (tức là `300` giây qua).

Your system should accept a `timestamp` parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., `timestamp` is monotonically increasing).
Hệ thống của bạn nên chấp nhận tham số `timestamp`...

Implement the `HitCounter` class:
- `HitCounter()` Initializes the object of the hit counter system.
- `void hit(int timestamp)` Records a hit that happened at `timestamp`.
- `int getHits(int timestamp)` Returns the number of hits in the past 5 minutes from `timestamp` (i.e., the past `300` seconds).

### Example 1:
```text
Input
["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
[[], [1], [2], [3], [4], [300], [300], [301]]
Output
[null, null, null, null, 3, null, 4, 3]

Explanation
HitCounter hitCounter = new HitCounter();
hitCounter.hit(1);       // hit at timestamp 1.
hitCounter.hit(2);       // hit at timestamp 2.
hitCounter.hit(3);       // hit at timestamp 3.
hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
hitCounter.hit(300);     // hit at timestamp 300.
hitCounter.getHits(300); // get hits at timestamp 300, return 4.
hitCounter.getHits(301); // get hits at timestamp 301, return 3.
// Hits at (1, 2, 3) are in interval [2, 301] (301-300+1... wait, range is (ts-300, ts]).
// Range [ts - 299, ts]. Or 300 seconds window. [1, 300].
// At 301: Range [2, 301]. Hit at 1 is strictly outside (301 - 1 = 300, valid? usually [ts-299, ts] incl hit on ts. Or (ts-300, ts].
// Usually "past 300 seconds" means [ts - 300 + 1, ts].
// If ts=301, window [2, 301]. Hit 1 is expried. Hits 2, 3, 300. Count 3. Correct.
```

## Constraints / Ràng buộc
- `1 <= timestamp <= 2 * 10^9`
- All the calls are being made to the system in chronological order (i.e., `timestamp` is monotonically increasing).
- At most `300` calls will be made to `hit` and `getHits`.

**Follow up**: What if the number of hits per second could be huge? Does your design scale?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Queue / Hàng Đợi
Store timestamps of hits in a Queue.
`getHits`: Remove hits from queue that are outside window (`<= timestamp - 300`). Return queue size.

### Circular Buffer (Bucket) / Bộ Đệm Vòng (Follow Up)
If many hits per second, storing each hit in Queue is memory intensive.
Use fixed array `hits[300]` and `times[300]`.
`idx = timestamp % 300`.
If `times[idx] != timestamp`:
    `times[idx] = timestamp`.
    `hits[idx] = 1`.
Else:
    `hits[idx]++`.

`getHits`: Sum `hits[i]` where `times[i] >= timestamp - 299`.

I will implement the **Circular Buffer** approach as it is scalable (Follow-up ready).

---

## Analysis / Phân tích

### Approach: Circular Buffer

**Algorithm**:
1.  Arrays `times` (timestamp stored), `hits` (count). Size 300.
2.  `hit(ts)`:
    - index = `ts % 300`.
    - update or reset.
3.  `getHits(ts)`:
    - loop 0 to 299.
    - if `ts - times[i] < 300`: sum += `hits[i]`.

---
