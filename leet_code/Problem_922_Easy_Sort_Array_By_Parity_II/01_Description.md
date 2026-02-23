# Result for Sort Array By Parity II
# *Kết quả cho bài toán Sắp xếp Mảng theo Tính chẵn lẻ II*

## Description
## *Mô tả*

Given an array of integers `nums`, half of the integers in `nums` are **odd**, and the other half are **even**.
*Cho một mảng số nguyên `nums`, một nửa số nguyên trong `nums` là **lẻ**, và một nửa còn lại là **chẵn**.*

Sort the array so that whenever `nums[i]` is odd, `i` is **odd**, and whenever `nums[i]` is even, `i` is **even**.
*Sắp xếp mảng sao cho bất cứ khi nào `nums[i]` là lẻ, `i` cũng là **lẻ**, và bất cứ khi nào `nums[i]` là chẵn, `i` cũng là **chẵn**.*

Return *any answer array that satisfies this condition*.
*Hãy trả về *bất kỳ mảng kết quả nào thỏa mãn điều kiện này*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [4,2,5,7]
**Output:** [4,5,2,7]
**Explanation:** [4,7,2,5], [2,5,4,7], [2,7,4,5] would also be accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [2,3]
**Output:** [2,3]

---

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 2 * 10^4`
*   `nums.length` is even.
*   Half of the integers in `nums` are even.
*   `0 <= nums[i] <= 1000`
