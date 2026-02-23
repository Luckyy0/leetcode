# Result for Combination Sum
# *Kết quả cho bài toán Tổng Các Tổ Hợp*

## Description
## *Mô tả*

Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the combinations in **any order**.
*Cho một mảng các số nguyên **phân biệt** `candidates` và một số nguyên mục tiêu `target`, trả về danh sách tất cả các **tổ hợp duy nhất** của `candidates` sao cho tổng của các số được chọn bằng `target`. Bạn có thể trả về các tổ hợp theo **bất kỳ thứ tự nào**.*

The **same** number may be chosen from `candidates` an **unlimited number of times**. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
*Một số **giống nhau** có thể được chọn từ `candidates` **không giới hạn số lần**. Hai tổ hợp là duy nhất nếu tần suất của ít nhất một trong các số được chọn là khác nhau.*

It is guaranteed that the number of unique combinations that sum up to `target` is less than `150` for the given input.
*Đảm bảo rằng số lượng các tổ hợp duy nhất có tổng bằng `target` ít hơn `150` đối với dữ liệu đầu vào đã cho.*

## Example 1:
## *Ví dụ 1:*

**Input:** `candidates = [2,3,6,7]`, `target = 7`
**Output:** `[[2,2,3],[7]]`
**Explanation:** 
2 and 3 are candidates, and 2+2+3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

## Example 2:
## *Ví dụ 2:*

**Input:** `candidates = [2,3,5]`, `target = 8`
**Output:** `[[2,2,2,2],[2,3,3],[3,5]]`

## Example 3:
## *Ví dụ 3:*

**Input:** `candidates = [2]`, `target = 1`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `1 <= candidates.length <= 30`
*   `1 <= candidates[i] <= 200`
*   All elements of `candidates` are **distinct**.
*   `1 <= target <= 500`
