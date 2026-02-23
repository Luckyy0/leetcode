# Result for Friends Of Appropriate Ages
# *Kết quả cho bài toán Bạn bè ở độ tuổi phù hợp*

## Description
## *Mô tả*

There are `n` persons on a social media website. You are given an integer array `ages` where `ages[i]` is the age of the `i`-th person.
*Có `n` người trên một mạng xã hội. Bạn được cho một mảng số nguyên `ages` trong đó `ages[i]` là tuổi của người thứ `i`.*

A Person `x` will not send a friend request to a person `y` (`x != y`) if any of the following conditions is true:
*Người `x` sẽ không gửi yêu cầu kết bạn cho người `y` (`x != y`) nếu bất kỳ điều kiện nào sau đây là đúng:*

*   `age[y] <= 0.5 * age[x] + 7`
*   `age[y] > age[x]`
*   `age[y] > 100 && age[x] < 100`

Otherwise, `x` will send a friend request to `y`.
*Nếu không, `x` sẽ gửi yêu cầu kết bạn cho `y`.*

Note that if `x` sends a request to `y`, `y` does not necessarily send a request to `x`. Also, a person will not send a friend request to themself.
*Lưu ý rằng nếu `x` gửi yêu cầu cho `y`, `y` không nhất thiết phải gửi yêu cầu cho `x`. Ngoài ra, một người sẽ không tự gửi yêu cầu cho chính mình.*

Return *the total number of friend requests made*.
*Trả về *tổng số lời mời kết bạn được thực hiện*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ages = [16,16]
**Output:** 2
**Explanation:** 2 people friend request each other.

## Example 2:
## *Ví dụ 2:*

**Input:** ages = [16,17,18]
**Output:** 2
**Explanation:** Friend requests are made 17 -> 16, 18 -> 17.

## Example 3:
## *Ví dụ 3:*

**Input:** ages = [20,30,100,110,120]
**Output:** 3
**Explanation:** Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

---

## Constraints:
## *Ràng buộc:*

*   `n == ages.length`
*   `1 <= n <= 2 * 10^4`
*   `1 <= ages[i] <= 120`
