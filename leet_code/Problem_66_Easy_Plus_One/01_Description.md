# Result for Plus One
# *Kết quả cho bài toán Cộng Một*

## Description
## *Mô tả*

You are given a **large integer** represented as an integer array `digits`, where each `digits[i]` is the `ith` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s, except the number `0` itself.
*Bạn được cho một **số nguyên lớn** được đại diện bởi một mảng số nguyên `digits`, trong đó mỗi `digits[i]` là chữ số thứ `i` của số nguyên đó. Các chữ số được sắp xếp từ chữ số có ý nghĩa cao nhất đến chữ số có ý nghĩa thấp nhất theo thứ tự từ trái sang phải. Số nguyên lớn này không chứa bất kỳ chữ số `0` nào ở đầu, ngoại trừ chính số `0`.*

Increment the large integer by one and return *the resulting array of digits*.
*Hãy tăng số nguyên lớn đó lên một đơn vị và trả về *mảng các chữ số kết quả**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `digits = [1,2,3]`
**Output:** `[1,2,4]`
**Explanation:** The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

## Example 2:
## *Ví dụ 2:*

**Input:** `digits = [4,3,2,1]`
**Output:** `[4,3,2,2]`
**Explanation:** The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

## Example 3:
## *Ví dụ 3:*

**Input:** `digits = [9]`
**Output:** `[1,0]`
**Explanation:** The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

## Constraints:
## *Ràng buộc:*

*   `1 <= digits.length <= 100`
*   `0 <= digits[i] <= 9`
*   `digits` does not contain any leading `0`'s.
