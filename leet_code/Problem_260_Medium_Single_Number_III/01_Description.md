# Result for Single Number III
# *Kết quả cho bài toán Số đơn độc III*

## Description
## *Mô tả*

Given an integer array `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in **any order**.
*Cho một mảng số nguyên `nums`, trong đó chính xác hai phần tử chỉ xuất hiện một lần và tất cả các phần tử khác xuất hiện chính xác hai lần. Tìm hai phần tử chỉ xuất hiện một lần. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*Bạn phải viết một thuật toán chạy với độ phức tạp thời gian tuyến tính và chỉ sử dụng không gian phụ hằng số.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,1,3,2,5]`
**Output:** `[3,5]`
**Explanation:**  [5, 3] is also a valid answer.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [-1,0]`
**Output:** `[-1,0]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [0,1]`
**Output:** `[1,0]`

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 3 * 10^4`
*   `-2^31 <= nums[i] <= 2^31 - 1`
*   Each integer in `nums` will appear twice, only two integers will appear once.
