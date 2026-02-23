# Result for Can Place Flowers
# *Kết quả cho bài toán Có thể Trồng Hoa không*

## Description
## *Mô tả*

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in **adjacent** plots.
*Bạn có một luống hoa dài, trong đó một số ô đã được trồng hoa, và một số ô thì chưa. Tuy nhiên, hoa không thể được trồng ở các ô **liền kề** nhau.*

Given an integer array `flowerbed` containing `0`'s and `1`'s, where `0` means empty and `1` means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the `flowerbed` without violating the no-adjacent-flowers rule and `false` otherwise.
*Cho một mảng số nguyên `flowerbed` chứa các số `0` và `1`, trong đó `0` nghĩa là ô trống và `1` nghĩa là ô đã trồng hoa, và một số nguyên `n`, hãy trả về `true` nếu có thể trồng thêm `n` bông hoa mới vào `flowerbed` mà không vi phạm quy tắc không trồng hoa liền kề, và `false` nếu ngược lại.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** flowerbed = [1,0,0,0,1], n = 1
**Output:** true

## Example 2:
## *Ví dụ 2:*

**Input:** flowerbed = [1,0,0,0,1], n = 2
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= flowerbed.length <= 2 * 10^4`
*   `flowerbed[i]` is `0` or `1`.
*   There are no two adjacent flowers in `flowerbed` initially.
*   `0 <= n <= flowerbed.length`
