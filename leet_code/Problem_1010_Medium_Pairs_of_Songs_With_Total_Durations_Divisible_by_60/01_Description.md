# Result for Pairs of Songs With Total Durations Divisible by 60
# *Kết quả cho bài toán Cặp bài hát có tổng thời lượng chia hết cho 60*

## Description
## *Mô tả*

You are given a list of songs where the `i`-th song has a duration of `time[i]` seconds.
*Bạn được cung cấp một danh sách các bài hát, trong đó bài hát thứ `i` có thời lượng là `time[i]` giây.*

Return *the number of pairs of songs for which their total duration in seconds is divisible by* `60`. Formally, we want the number of indices `i`, `j` such that `i < j` with `(time[i] + time[j]) % 60 == 0`.
*Trả về số lượng các cặp bài hát sao cho tổng thời lượng tính bằng giây của chúng chia hết cho `60`. Nói một cách toán học, chúng ta muốn tìm số cặp chỉ số `i`, `j` sao cho `i < j` và `(time[i] + time[j]) % 60 == 0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** time = [30,20,150,100,40]
**Output:** 3
**Explanation:** Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

## Example 2:
## *Ví dụ 2:*

**Input:** time = [60,60,60]
**Output:** 3
**Explanation:** All three pairs have a total duration of 120, which is divisible by 60.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= time.length <= 6 * 10^4`
*   `1 <= time[i] <= 500`
