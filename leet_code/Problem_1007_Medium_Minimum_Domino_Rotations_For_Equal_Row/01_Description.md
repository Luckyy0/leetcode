# Result for Minimum Domino Rotations For Equal Row
# *Kết quả cho bài toán Số lần quay Domino tối thiểu để tạo một hàng bằng nhau*

## Description
## *Mô tả*

In a row of dominoes, `tops[i]` and `bottoms[i]` represent the top and bottom halves of the `i`-th domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
*Trên một hàng các con số domino, `tops[i]` và `bottoms[i]` đại diện cho nửa trên và nửa dưới của con domino thứ `i`. (Domino là viên gạch có 2 số từ 1 đến 6 - trên mỗi nửa của viên gạch).*

We may rotate the `i`-th domino, so that `tops[i]` and `bottoms[i]` swap values.
*Chúng ta có thể quay nửa `i`-th của con domino, bằng cách tráo đổi giá trị giữa `tops[i]` và `bottoms[i]`.*

Return the minimum number of rotations so that all the values in `tops` are the same, or all the values in `bottoms` are the same.
*Trả về số lần xoay gạch tối thiểu để mọi giá trị mục tiêu ở `tops` đều đồng nhất, hoặc mọi giá trị ở `bottoms` đồng nhất.*

If it cannot be done, return `-1`.
*Nếu không thể thực hiện, trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
**Output:** 2
**Explanation:** 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
*Giải thích: Nếu xoay con domino thứ hai và thứ tư, chúng ta có thể làm cho toàn bộ hàng trên bằng 2.*

## Example 2:
## *Ví dụ 2:*

**Input:** tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
**Output:** -1
**Explanation:** 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
*Giải thích: Không xoay kiểu gì để hàng ra đồng nhất được cả.*

---

## Constraints:
## *Ràng buộc:*

*   `2 <= tops.length <= 2 * 10^4`
*   `bottoms.length == tops.length`
*   `1 <= tops[i], bottoms[i] <= 6`
