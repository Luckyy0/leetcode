# Result for Candy
# *Kết quả cho bài toán Kẹo*

## Description
## *Mô tả*

There are `n` children standing in a line. Each child is assigned a rating value given in the integer array `ratings`.
*Có `n` đứa trẻ đang đứng thành một hàng. Mỗi đứa trẻ được chỉ định một giá trị xếp hạng được cho trong mảng số nguyên `ratings`.*

You are giving candies to these children subjected to the following requirements:
*Bạn đang chia kẹo cho những đứa trẻ này theo các yêu cầu sau:*

*   Each child must have at least one candy.
    *Mỗi đứa trẻ phải có ít nhất một viên kẹo.*
*   Children with a higher rating get more candies than their neighbors.
    *Những đứa trẻ có xếp hạng cao hơn sẽ nhận được nhiều kẹo hơn những đứa trẻ hàng xóm của chúng.*

Return *the minimum number of candies you need to have to distribute the candies to the children*.
*Hãy trả về *số lượng kẹo tối thiểu bạn cần có để chia kẹo cho những đứa trẻ***.*

## Example 1:
## *Ví dụ 1:*

**Input:** `ratings = [1,0,2]`
**Output:** `5`
**Explanation:** You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

## Example 2:
## *Ví dụ 2:*

**Input:** `ratings = [1,2,2]`
**Output:** `4`
**Explanation:** You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

## Constraints:
## *Ràng buộc:*

*   `n == ratings.length`
*   `1 <= n <= 2 * 10^4`
*   `0 <= ratings[i] <= 2 * 10^4`
