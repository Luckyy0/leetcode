# Result for Nested List Weight Sum
# *Kết quả cho bài toán Tổng Trọng số Danh sách Lồng nhau*

## Description
## *Mô tả*

You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists.
*Bạn được cho một danh sách các số nguyên lồng nhau `nestedList`. Mỗi phần tử là một số nguyên hoặc một danh sách mà các phần tử của nó cũng có thể là số nguyên hoặc danh sách khác.*

The **depth** of an integer is the number of lists that it is inside of. For example, the nested list `[1,[2,2],[[3],2],1]` has each integer's value set to its **depth**.
*Độ sâu (**depth**) của một số nguyên là số lượng danh sách mà nó nằm bên trong. Ví dụ, danh sách lồng nhau `[1,[2,2],[[3],2],1]` có giá trị của mỗi số nguyên được đặt thành độ sâu của nó.*

Return *the sum of each integer in* `nestedList` *multiplied by its **depth***.
*Trả về *tổng của mỗi số nguyên trong* `nestedList` *nhân với **độ sâu** của nó*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nestedList = [[1,1],2,[1,1]]`
**Output:** `10`
**Explanation:** Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.

## Example 2:
## *Ví dụ 2:*

**Input:** `nestedList = [1,[4,[6]]]`
**Output:** `27`
**Explanation:** One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 1 + 8 + 18 = 27.

## Example 3:
## *Ví dụ 3:*

**Input:** `nestedList = [0]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `1 <= nestedList.length <= 50`
*   The values of the integers in the nested list is in the range `[-100, 100]`.
*   The maximum depth of any integer is less than or equal to `50`.
