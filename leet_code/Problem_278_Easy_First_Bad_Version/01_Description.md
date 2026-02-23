# Result for First Bad Version
# *Kết quả cho bài toán Phiên bản Lỗi đầu tiên*

## Description
## *Mô tả*

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
*Bạn là giám đốc sản phẩm và hiện đang lãnh đạo một nhóm phát triển sản phẩm mới. Thật không may, phiên bản mới nhất của sản phẩm không vượt qua kiểm tra chất lượng. Vì mỗi phiên bản được phát triển dựa trên phiên bản trước đó, tất cả các phiên bản sau phiên bản lỗi cũng đều bị lỗi.*

Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out the first bad one, which causes all the following ones to be bad.
*Giả sử bạn có `n` phiên bản `[1, 2, ..., n]` và bạn muốn tìm ra phiên bản lỗi đầu tiên, nguyên nhân khiến tất cả các phiên bản sau đều bị lỗi.*

You are given an API `bool isBadVersion(version)` which returns whether `version` is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*Bạn được cung cấp một API `bool isBadVersion(version)` trả về việc `version` có bị lỗi hay không. Hãy triển khai một hàm để tìm phiên bản lỗi đầu tiên. Bạn nên giảm thiểu số lần gọi đến API.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 5, bad = 4`
**Output:** `4`
**Explanation:**
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1, bad = 1`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= bad <= n <= 2^31 - 1`
