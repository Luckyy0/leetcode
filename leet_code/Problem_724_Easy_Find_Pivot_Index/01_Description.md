# Result for Find Pivot Index
# *Kết quả cho bài toán Tìm Chỉ số Điểm tựa (Pivot)*

## Description
## *Mô tả*

Given an array of integers `nums`, calculate the **pivot index** of this array.
*Cho một mảng các số nguyên `nums`, hãy tính **chỉ số điểm tựa** của mảng này.*

The **pivot index** is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
* **Chỉ số điểm tựa** là chỉ số mà tại đó tổng của tất cả các số nằm hoàn toàn bên trái của chỉ số đó bằng với tổng của tất cả các số nằm hoàn toàn bên phải của nó.*

If the index is on the left edge of the array, the left sum is `0` because there are no elements to the left. This also applies to the right edge of the array.
*Nếu chỉ số nằm ở biên trái của mảng, tổng bên trái bằng `0` vì không có phần tử nào bên trái. Điều này cũng tương tự với biên phải của mảng.*

Return the **leftmost pivot index**. If no such index exists, return `-1`.
*Hãy trả về **chỉ số điểm tựa nằm ngoài cùng bên trái**. Nếu không tồn tại chỉ số như vậy, hãy trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [1,7,3,6,5,6]
**Output:** 3
**Explanation:**
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,3]
**Output:** -1
**Explanation:**
There is no index that satisfies the conditions in the array statement.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 10^4`
*   `-1000 <= nums[i] <= 1000`
