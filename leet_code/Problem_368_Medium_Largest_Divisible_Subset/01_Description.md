# Result for Largest Divisible Subset
# *Kết quả cho bài toán Tập con Chia hết Lớn nhất*

## Description
## *Mô tả*

Given a set of **distinct** positive integers `nums`, return the largest subset `answer` such that every pair `(answer[i], answer[j])` of elements in this subset satisfies:
*Cho một tập hợp các số nguyên dương **khác biệt** `nums`, hãy trả về tập con lớn nhất `answer` sao cho mọi cặp phần tử `(answer[i], answer[j])` trong tập con này đều thỏa mãn:*

- `answer[i] % answer[j] == 0`, or
- `answer[j] % answer[i] == 0`

If there are multiple solutions, return any of them.
*Nếu có nhiều giải pháp, hãy trả về bất kỳ giải pháp nào trong số đó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `nums = [1,2,3]`
**Output:** `[1,2]`
**Explanation:** `[1,3]` is also accepted.

## Example 2:
## *Ví dụ 2:*

**Input:** `nums = [1,2,4,8]`
**Output:** `[1,2,4,8]`

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 1000`
*   `1 <= nums[i] <= 2 * 10^9`
*   All the integers in `nums` are **unique**.
