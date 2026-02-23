# Result for Compare Version Numbers
# *Kết quả cho bài toán So sánh các phiên bản*

## Description
## *Mô tả*

Given two version strings, `version1` and `version2`, compare them. A version string contains revisions separated by dots `'.'`. The value of the revision is its **integer conversion** ignoring leading zeros.
*Cho hai chuỗi phiên bản `version1` và `version2`, hãy so sánh chúng. Một chuỗi phiên bản chứa các bản sửa đổi được phân tách bằng dấu chấm `'.'`. Giá trị của bản sửa đổi là **chuyển đổi số nguyên** của nó, bỏ qua các số 0 ở đầu.*

Versions are compared from left to right. Each version contains at least one revision.
*Các phiên bản được so sánh từ trái sang phải. Mỗi phiên bản chứa ít nhất một lần sửa đổi.*

Return:
*Kết quả trả về:*
*   If `version1 < version2`, return `-1`.
    *Nếu `version1 < version2`, trả về `-1`.*
*   If `version1 > version2`, return `1`.
    *Nếu `version1 > version2`, trả về `1`.*
*   Otherwise, return `0`.
    *Ngược lại, trả về `0`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `version1 = "1.2", version2 = "1.10"`
**Output:** `-1`
**Explanation:** 1.2 < 1.10. Revision 1 is the same ("1"). Revision 2 is "2" and "10". Since 2 < 10, version1 < version2.

## Example 2:
## *Ví dụ 2:*

**Input:** `version1 = "1.01", version2 = "1.001"`
**Output:** `0`
**Explanation:** 1.01 = 1.001. Leading zeros are ignored.

## Example 3:
## *Ví dụ 3:*

**Input:** `version1 = "1.0", version2 = "1.0.0.0"`
**Output:** `0`
**Explanation:** All missing revisions are treated as "0".

## Constraints:
## *Ràng buộc:*

*   `1 <= version1.length, version2.length <= 500`
*   `version1` and `version2` only contain digits and `'.'`.
*   All revisions fit in a signed **32-bit** integer.
