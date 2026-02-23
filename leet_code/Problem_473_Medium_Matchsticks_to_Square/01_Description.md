# Result for Matchsticks to Square
# *Kết quả cho bài toán Que diêm tạo Hình vuông*

## Description
## *Mô tả*

You are given an integer array `matchsticks` where `matchsticks[i]` is the length of the `i^th` matchstick. You want to use **all the matchsticks** to make one square. You **should not break** any stick, but you can link them up, and each matchstick must be used **exactly one time**.
*Bạn được cho một mảng số nguyên `matchsticks` trong đó `matchsticks[i]` là độ dài của que diêm thứ `i`. Bạn muốn sử dụng **tất cả các que diêm** để tạo thành một hình vuông. Bạn **không được bẻ** bất kỳ que nào, nhưng bạn có thể nối chúng lại, và mỗi que diêm phải được sử dụng **đúng một lần**.*

Return `true` if you can make this square and `false` otherwise.
*Hãy trả về `true` nếu bạn có thể tạo thành hình vuông này và `false` nếu không.*

## Example 1:
## *Ví dụ 1:*

**Input:** `matchsticks = [1,1,2,2,2]`
**Output:** `true`
**Explanation:** You can form a square with length 2, one side of the square came two sticks with length 1.

## Example 2:
## *Ví dụ 2:*

**Input:** `matchsticks = [3,3,3,3,4]`
**Output:** `false`
**Explanation:** You cannot find a way to form a square with all the matchsticks.

## Constraints:
## *Ràng buộc:*

*   `1 <= matchsticks.length <= 15`
*   `1 <= matchsticks[i] <= 10^8`
