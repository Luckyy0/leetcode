# Result for Two Sum II - Input Array Is Sorted
# *Kết quả cho bài toán Hai số tổng (Mảng đã sắp xếp)*

## Description
## *Mô tả*

Given a **1-indexed** array of integers `numbers` that is already **sorted in non-decreasing order**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.
*Cho một mảng các số nguyên `numbers` được đánh chỉ số bắt đầu từ **1** đã được **sắp xếp theo thứ tự không giảm**, hãy tìm hai số sao cho tổng của chúng bằng một số `target` cụ thể. Gọi hai số này là `numbers[index1]` và `numbers[index2]` trong đó `1 <= index1 < index2 <= numbers.length`.*

Return *the indices of the two numbers, `index1` and `index2`, **added by one** as an integer array `[index1, index2]` of length 2*.
*Trả về *chỉ số của hai số, `index1` và `index2`, **cộng thêm 1** dưới dạng một mảng số nguyên `[index1, index2]` có độ dài 2***.*

The tests are generated such that there is **exactly one solution**. You **may not** use the same element twice.
*Các trường hợp kiểm thử được tạo ra sao cho **có đúng một giải pháp**. Bạn **không được** sử dụng cùng một phần tử hai lần.*

Your solution must use only constant extra space.
*Giải pháp của bạn chỉ được sử dụng không gian bổ sung hằng số.*

## Example 1:
## *Ví dụ 1:*

**Input:** `numbers = [2,7,11,15], target = 9`
**Output:** `[1,2]`
**Explanation:** The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

## Example 2:
## *Ví dụ 2:*

**Input:** `numbers = [2,3,4], target = 6`
**Output:** `[1,3]`
**Explanation:** The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

## Example 3:
## *Ví dụ 3:*

**Input:** `numbers = [-1,0], target = -1`
**Output:** `[1,2]`

## Constraints:
## *Ràng buộc:*

*   `2 <= numbers.length <= 3 * 10^4`
*   `-1000 <= numbers[i] <= 1000`
*   `numbers` is sorted in **non-decreasing order**.
*   `-1000 <= target <= 1000`
*   The tests are generated such that there is **exactly one solution**.
