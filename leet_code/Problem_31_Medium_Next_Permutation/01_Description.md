# Result for Next Permutation
# *Kết quả cho bài toán Hoán Vị Tiếp Theo*

## Description
## *Mô tả*

A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.
*Một **hoán vị** của một mảng các số nguyên là một sự sắp xếp các thành viên của nó thành một trình tự hoặc thứ tự tuyến tính.*

For example, for `arr = [1,2,3]`, the following are all the permutations of `arr`: `[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]`.
*Ví dụ, đối với `arr = [1,2,3]`, sau đây là tất cả các hoán vị của `arr`: `[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]`.*

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the **next permutation** of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
* **Hoán vị tiếp theo** của một mảng các số nguyên là hoán vị lớn hơn tiếp theo về mặt từ điển của các số nguyên của nó. Cụ thể hơn, nếu tất cả các hoán vị của mảng được sắp xếp trong một vùng chứa theo thứ tự từ điển của chúng, thì **hoán vị tiếp theo** của mảng đó là hoán vị theo sau nó trong vùng chứa đã sắp xếp. Nếu sự sắp xếp như vậy không thể thực hiện được, mảng phải được sắp xếp lại theo thứ tự thấp nhất có thể (tức là sắp xếp theo thứ tự tăng dần).*

*   For example, the next permutation of `arr = [1,2,3]` is `[1,3,2]`.
*   Similarly, the next permutation of `arr = [2,3,1]` is `[3,1,2]`.
*   While the next permutation of `arr = [3,2,1]` is `[1,2,3]` because `[3,2,1]` does not have a lexicographical larger rearrangement.

Given an array of integers `nums`, find the next permutation of `nums`.
*Cho một mảng các số nguyên `nums`, hãy tìm hoán vị tiếp theo của `nums`.*

The replacement must be **in place** and use only constant extra memory.
*Việc thay thế phải là **tại chỗ** và chỉ sử dụng bộ nhớ phụ hằng số.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3]`
**Output:** `[1,3,2]`

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [3,2,1]`
**Output:** `[1,2,3]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [1,1,5]`
**Output:** `[1,5,1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 100`
*   `0 <= nums[i] <= 100`
