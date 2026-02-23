# Result for Fair Candy Swap
# *Kết quả cho bài toán Trao đổi Kẹo Công bằng*

## Description
## *Mô tả*

Alice and Bob have a different total number of candy bars. You are given two integer arrays `aliceSizes` and `bobSizes` where `aliceSizes[i]` is the size of the `i`-th candy bar that Alice has, and `bobSizes[j]` is the size of the `j`-th candy bar that Bob has.
*Alice và Bob có tổng số lượng thanh kẹo khác nhau. Bạn được cho hai mảng số nguyên `aliceSizes` và `bobSizes` trong đó `aliceSizes[i]` là kích thước của thanh kẹo thứ `i` mà Alice có, và `bobSizes[j]` là kích thước của thanh kẹo thứ `j` mà Bob có.*

Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the sizes of candy bars they have.
*Vì họ là bạn bè, họ muốn trao đổi một thanh kẹo mỗi người sao cho sau khi đổi, cả hai đều có tổng lượng kẹo bằng nhau. Tổng lượng kẹo một người có là tổng kích thước các thanh kẹo mà họ sở hữu.*

Return *an integer array `ans` where `ans[0]` is the size of the candy bar that Alice must exchange, and `ans[1]` is the size of the candy bar that Bob must exchange*.
*Hãy trả về *một mảng số nguyên `ans` trong đó `ans[0]` là kích thước của thanh kẹo mà Alice phải đổi, và `ans[1]` là kích thước của thanh kẹo mà Bob phải đổi*.*

If there are multiple answers, you may return any one of them. It is guaranteed that an answer exists.
*Nếu có nhiều câu trả lời, bạn có thể trả về bất kỳ cái nào trong số đó. Đảm bảo rằng luôn tồn tại một câu trả lời.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** aliceSizes = [1,1], bobSizes = [2,2]
**Output:** [1,2]

## Example 2:
## *Ví dụ 2:*

**Input:** aliceSizes = [1,2], bobSizes = [2,3]
**Output:** [1,2]

## Example 3:
## *Ví dụ 3:*

**Input:** aliceSizes = [2], bobSizes = [1,3]
**Output:** [2,3]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= aliceSizes.length, bobSizes.length <= 10^4`
*   `1 <= aliceSizes[i], bobSizes[j] <= 10^5`
*   Alice and Bob have at least one candy bar.
*   Alice and Bob have different total amounts of candy.
*   There will be at least one valid answer for the given input.
