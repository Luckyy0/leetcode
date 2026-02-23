# Result for Combination Sum III
# *Kết quả cho bài toán Tổng tổ hợp III*

## Description
## *Mô tả*

Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:
*Tìm tất cả các tổ hợp hợp lệ của `k` số có tổng bằng `n` sao cho các điều kiện sau đây là đúng:*

*   Only numbers `1` through `9` are used.
    *Chỉ sử dụng các số từ `1` đến `9`.*
*   Each number is used **at most once**.
    *Mỗi số được sử dụng **nhiều nhất một lần**.*

Return *a list of all possible valid combinations*. The list must not contain the same combination twice, and the combinations may be returned in any order.
*Trả về *danh sách tất cả các tổ hợp hợp lệ có thể*. Danh sách không được chứa cùng một tổ hợp hai lần, và các tổ hợp có thể được trả về theo bất kỳ thứ tự nào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `k = 3, n = 7`
**Output:** `[[1,2,4]]`
**Explanation:**
1 + 2 + 4 = 7
There are no other valid combinations.

## Example 2:
## *Ví dụ 2:*

**Input:** `k = 3, n = 9`
**Output:** `[[1,2,6],[1,3,5],[2,3,4]]`
**Explanation:**
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

## Example 3:
## *Ví dụ 3:*

**Input:** `k = 4, n = 1`
**Output:** `[]`
**Explanation:** There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum is 1+2+3+4 = 10, which is greater than 1.

## Constraints:
## *Ràng buộc:*

*   `2 <= k <= 9`
*   `1 <= n <= 60`
