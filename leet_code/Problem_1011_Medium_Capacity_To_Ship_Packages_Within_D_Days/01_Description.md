# Result for Capacity To Ship Packages Within D Days
# *Kết quả cho bài toán Trọng tải 🚢 chở hàng trong D ngày*

## Description
## *Mô tả*

A conveyor belt has packages that must be shipped from one port to another within `days` days.
*Một băng chuyền có các kiện hàng phải được vận chuyển từ cảng này sang cảng khác trong vòng `days` ngày.*

The `i`-th package on the conveyor belt has a weight of `weights[i]`. Each day, we load the ship with packages on the conveyor belt (in the order given by `weights`). We may not load more weight than the maximum weight capacity of the ship.
*Kiện hàng thứ `i` trên băng chuyền có trọng lượng là `weights[i]`. Mỗi ngày, chúng ta xếp các kiện hàng lên tàu theo thứ tự xuất hiện trên băng chuyền (như mảng `weights` chỉ định). Trọng lượng xếp lên không được phép vượt quá khả năng tải trọng tối đa của tàu.*

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within `days` days.
*Trả về trọng tải chở hàng tối thiểu của con tàu để có thể chuyển tất cả hàng hóa trên băng chuyền đi trong vòng `days` ngày.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** weights = [1,2,3,4,5,6,7,8,9,10], days = 5
**Output:** 15
**Explanation:** A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
*Giải thích: Tàu trọng tải 15 chạy 5 chuyến là khít. Lưu ý các khối hàng không thể bị phá chẻ hoặc thay đổi trình tự ra (phải sắp chuyến theo đúng thứ tự).*

## Example 2:
## *Ví dụ 2:*

**Input:** weights = [3,2,2,4,1,4], days = 3
**Output:** 6
**Explanation:** A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

## Example 3:
## *Ví dụ 3:*

**Input:** weights = [1,2,3,1,1], days = 4
**Output:** 3
**Explanation:**
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= days <= weights.length <= 5 * 10^4`
*   `1 <= weights[i] <= 500`
