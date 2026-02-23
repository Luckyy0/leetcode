# Result for Implement Rand10() Using Rand7()
# *Kết quả cho bài toán Triển khai Rand10() bằng Rand7()*

## Description
## *Mô tả*

Given the API `rand7()` that generates a uniform random integer in the range `[1, 7]`, write a function `rand10()` that generates a uniform random integer in the range `[1, 10]`. You can only call the API `rand7()`, and you shouldn't call any other API. Please **do not** use a language's built-in random API.
*Cho một API `rand7()` tạo ra một số nguyên ngẫu nhiên đồng nhất trong khoảng `[1, 7]`, hãy viết một hàm `rand10()` tạo ra một số nguyên ngẫu nhiên đồng nhất trong khoảng `[1, 10]`. Bạn chỉ có thể gọi API `rand7()` và không nên gọi bất kỳ API nào khác. Vui lòng **không** sử dụng API ngẫu nhiên có sẵn của ngôn ngữ.*

Each test case will have one **internal** argument `n`, the number of times that your implemented `rand10()` function will be called while testing. Note that this is **not an argument** passed to `rand10()`.
*Mỗi trường hợp kiểm thử sẽ có một đối số **nội bộ** `n`, là số lần hàm `rand10()` bạn triển khai sẽ được gọi trong quá trình kiểm thử. Lưu ý rằng đây **không phải là đối số** được truyền cho `rand10()`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 1`
**Output:** `[2]`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 2`
**Output:** `[2,8]`

## Example 3:
## *Ví dụ 3:*

**Input:** `n = 3`
**Output:** `[3,8,10]`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^5`
