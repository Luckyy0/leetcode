# Result for Boats to Save People
# *Kết quả cho bài toán Thuyền để Cứu Người*

## Description
## *Mô tả*

You are given an array `people` where `people[i]` is the weight of the `i`-th person, and an infinite number of boats where each boat can carry a maximum weight of `limit`. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most `limit`.
*Bạn được cho một mảng `people` trong đó `people[i]` là cân nặng của người thứ `i`, và vô số chiếc thuyền trong đó mỗi chiếc thuyền có thể chở trọng lượng tối đa là `limit`. Mỗi chiếc thuyền chở tối đa hai người cùng một lúc, miễn là tổng cân nặng của những người đó không vượt quá `limit`.*

Return *the minimum number of boats to carry every given person*.
*Hãy trả về *số lượng thuyền tối thiểu để chở tất cả mọi người*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** people = [1,2], limit = 3
**Output:** 1
**Explanation:** 1 boat (1, 2)

## Example 2:
## *Ví dụ 2:*

**Input:** people = [3,2,2,1], limit = 3
**Output:** 3
**Explanation:** 3 boats (1, 2), (2) and (3)

## Example 3:
## *Ví dụ 3:*

**Input:** people = [3,5,3,4], limit = 5
**Output:** 4
**Explanation:** 4 boats (3), (3), (4), (5)

---

## Constraints:
## *Ràng buộc:*

*   `1 <= people.length <= 5 * 10^4`
*   `1 <= people[i] <= limit <= 3 * 10^4`
