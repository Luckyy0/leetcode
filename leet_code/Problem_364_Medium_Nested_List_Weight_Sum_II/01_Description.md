# Result for Nested List Weight Sum II
# *Kết quả cho bài toán Tổng Trọng số Danh sách Lồng nhau II*

## Description
## *Mô tả*

You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists.
*Bạn được cho một danh sách lồng nhau gồm các số nguyên `nestedList`. Mỗi phần tử là một số nguyên hoặc một danh sách mà các phần tử của nó cũng có thể là số nguyên hoặc các danh sách khác.*

The **depth** of an integer is the number of lists that it is inside of. For example, the nested list `[1,[2,2],[[3],2],1]` has each integer's value and its depth:
* **1** at depth 1
* **2** at depth 2, **2** at depth 2
* **3** at depth 3, **2** at depth 2
* **1** at depth 1

The weight of an integer is `maxDepth - (the depth of the integer) + 1`.
*Trọng số của một số nguyên là `maxDepth - (độ sâu của số nguyên đó) + 1`.*

Return *the sum of each integer in `nestedList` multiplied by its weight*.
*Trả về *tổng của mỗi số nguyên trong `nestedList` nhân với trọng số của nó*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nestedList = [[1,1],2,[1,1]]`
**Output:** `8`
**Explanation:** Four 1's at depth 2, one 2 at depth 1.
Max depth is 2.
Weight of 1's: 2 - 2 + 1 = 1.
Weight of 2: 2 - 1 + 1 = 2.
Sum: 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8.

## Example 2:
## *Ví dụ 2:*

**Input:** `nestedList = [1,[4,[6]]]`
**Output:** `17`
**Explanation:** One 1 at depth 1, one 4 at depth 2, one 6 at depth 3.
Max depth is 3.
Weight of 1: 3 - 1 + 1 = 3.
Weight of 4: 3 - 2 + 1 = 2.
Weight of 6: 3 - 3 + 1 = 1.
Sum: 1*3 + 4*2 + 6*1 = 17.

## Constraints:
## *Ràng buộc:*

*   `1 <= nestedList.length <= 50`
*   The values of the integers in the nested list is in the range `[-100, 100]`.
*   The maximum depth of any integer is less than or equal to `50`.
