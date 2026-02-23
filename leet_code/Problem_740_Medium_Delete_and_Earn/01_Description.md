# Result for Delete and Earn
# *Kết quả cho bài toán Xóa và Nhận thưởng (Delete and Earn)*

## Description
## *Mô tả*

You are given an integer array `nums`. You want to maximize the number of points you get by performing the following operation any number of times:
*Cho một mảng số nguyên `nums`. Bạn muốn tối đa hóa số điểm nhận được bằng cách thực hiện thao tác sau bất kỳ số lần nào:*

Pick any `nums[i]` and delete it to earn `nums[i]` points. Afterwards, you must delete **every** element equal to `nums[i] - 1` and **every** element equal to `nums[i] + 1`.
*Chọn một số `nums[i]` và xóa nó để nhận `nums[i]` điểm. Sau đó, bạn phải xóa **tất cả** các phần tử bằng `nums[i] - 1` và **tất cả** các phần tử bằng `nums[i] + 1`.*

Return the maximum number of points you can earn.
*Hãy trả về số điểm tối đa mà bạn có thể nhận được.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [3,4,2]
**Output:** 6
**Explanation:** 
- Delete 4 to earn 4 points. Consequently, 3 is deleted. Then delete 2 to earn 2 points.
- Total points = 4 + 2 = 6.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2,2,3,3,3,4]
**Output:** 9
**Explanation:** 
- Delete 3 to earn 3 points. All 2's and 4's are deleted. Total = 3 + 3 + 3 = 9.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `1 <= nums[i] <= 10^4`
