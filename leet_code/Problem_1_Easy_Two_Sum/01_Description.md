# Result for Two Sum
# *Kết quả cho bài toán Hai Số Tổng*

## Description
## *Mô tả*

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
*Cho một mảng các số nguyên `nums` và một số nguyên `target`, hãy trả về chỉ số của hai số sao cho tổng của chúng bằng `target`.*

You may assume that each input would have **exactly one solution**, and you may not use the *same* element twice.
*Bạn có thể giả định rằng mỗi đầu vào sẽ có **chính xác một giải pháp**, và bạn không được sử dụng *cùng một* phần tử hai lần.*

You can return the answer in any order.
*Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [2,7,11,15]`, `target = 9`
**Output:** `[0,1]`
**Explanation:** Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.
***Giải thích:** Bởi vì `nums[0] + nums[1] == 9`, chúng ta trả về `[0, 1]`.*

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [3,2,4]`, `target = 6`
**Output:** `[1,2]`

## Example 3:
## *Ví dụ 3:*

**Input:** `nums = [3,3]`, `target = 6`
**Output:** `[0,1]`

## Constraints:
## *Ràng buộc:*

*   `2 <= nums.length <= 10^4`
*   `-10^9 <= nums[i] <= 10^9`
*   `-10^9 <= target <= 10^9`
*   **Only one valid answer exists.**
*   ***Chỉ tồn tại một câu trả lời hợp lệ.***
