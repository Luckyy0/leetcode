# Result for Tallest Billboard
# *Kết quả cho bài toán Bảng quảng cáo Cao nhất*

## Description
## *Mô tả*

You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.
*Bạn đang lắp đặt một bảng quảng cáo và muốn nó có chiều cao lớn nhất. Bảng quảng cáo sẽ có hai cột thép hỗ trợ, mỗi bên một cột. Mỗi cột thép hỗ trợ phải có chiều cao bằng nhau.*

You are given a collection of `rods` that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
*Bạn được cho một tập hợp các `thanh` (rods) có thể hàn lại với nhau. Ví dụ, nếu bạn có các thanh có độ dài 1, 2 và 3, bạn có thể hàn chúng lại để tạo thành một cột hỗ trợ có chiều dài 6.*

Return *the largest possible height of your billboard installation*. If you cannot support the billboard, return `0`.
*Trả về *chiều cao lớn nhất có thể của bảng quảng cáo*. Nếu bạn không thể hỗ trợ bảng quảng cáo, hãy trả về `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** rods = [1,2,3,6]
**Output:** 6
**Explanation:** We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** rods = [1,2,3,4,5,6]
**Output:** 10
**Explanation:** We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.

## Example 3:
## *Ví dụ 3:*

**Input:** rods = [1,2]
**Output:** 0
**Explanation:** The billboard cannot be supported, so we return 0.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= rods.length <= 20`
*   `1 <= rods[i] <= 1000`
*   `sum(rods[i]) <= 5000`
