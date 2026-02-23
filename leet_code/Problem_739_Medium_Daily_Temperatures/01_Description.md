# Result for Daily Temperatures
# *Kết quả cho bài toán Nhiệt độ Hàng ngày (Daily Temperatures)*

## Description
## *Mô tả*

Given an array of integers `temperatures` represents the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i-th` day to get a warmer temperature.
*Cho một mảng các số nguyên `temperatures` đại diện cho nhiệt độ hàng ngày. Hãy trả về một mảng `answer` sao cho `answer[i]` là số ngày bạn phải chờ sau ngày thứ `i` để có một nhiệt độ ấm hơn.*

If there is no future day for which this is possible, keep `answer[i] == 0` instead.
*Nếu không có ngày nào trong tương lai thỏa mãn điều kiện này, hãy để `answer[i] == 0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** temperatures = [73,74,75,71,69,72,76,73]
**Output:** [1,1,4,2,1,1,0,0]

## Example 2:
## *Ví dụ 2:*

**Input:** temperatures = [30,40,50,60]
**Output:** [1,1,1,0]

## Example 3:
## *Ví dụ 3:*

**Input:** temperatures = [30,60,90]
**Output:** [1,1,0]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= temperatures.length <= 10^5`
*   `30 <= temperatures[i] <= 100`
