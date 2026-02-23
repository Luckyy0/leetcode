# Result for Heaters
# *Kết quả cho bài toán Máy sưởi*

## Description
## *Mô tả*

Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
*Mùa đông đang đến! Trong cuộc thi, công việc đầu tiên của bạn là thiết kế một máy sưởi tiêu chuẩn với bán kính sưởi ấm cố định để sưởi ấm tất cả các ngôi nhà.*

Every house can be warmed, as long as the house is within the heater's warm radius range.
*Mọi ngôi nhà đều có thể được sưởi ấm, miễn là ngôi nhà nằm trong phạm vi bán kính sưởi ấm của máy sưởi.*

Given the positions of `houses` and `heaters` on a horizontal line, return *the minimum radius standard of heaters so that those heaters could cover all houses.*
*Cho vị trí của `houses` (các ngôi nhà) và `heaters` (các máy sưởi) trên một đường thẳng nằm ngang, hãy trả về *tiêu chuẩn bán kính tối thiểu của các máy sưởi sao cho các máy sưởi đó có thể bao phủ tất cả các ngôi nhà*.*

**Notice** that all the heaters follow your radius standard, and the warm radius will the same.
*Lưu ý rằng tất cả các máy sưởi đều tuân theo tiêu chuẩn bán kính của bạn và bán kính sưởi ấm sẽ giống nhau.*

## Example 1:
## *Ví dụ 1:*

**Input:** `houses = [1,2,3], heaters = [2]`
**Output:** `1`
**Explanation:** The only heater was placed in the position 2, and if we use the radius 1, then all the houses can be warmed.

## Example 2:
## *Ví dụ 2:*

**Input:** `houses = [1,2,3,4], heaters = [1,4]`
**Output:** `1`
**Explanation:** The two heater was placed in the position 1 and 4. We need to use radius 1.

## Example 3:
## *Ví dụ 3:*

**Input:** `houses = [1,5], heaters = [2]`
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `1 <= houses.length, heaters.length <= 3 * 10^4`
*   `1 <= houses[i], heaters[i] <= 10^9`
