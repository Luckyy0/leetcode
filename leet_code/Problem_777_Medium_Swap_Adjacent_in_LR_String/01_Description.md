# Result for Swap Adjacent in LR String
# *Kết quả cho bài toán Hoán đổi Liền kề trong Chuỗi LR*

## Description
## *Mô tả*

In a string composed of `'L'`, `'R'`, and `'X'` characters, like `"RXXLRXRXL"`, a move consists of either replacing one occurrence of `"XL"` with `"LX"`, or replacing one occurrence of `"RX"` with `"XR"`. Given the starting string `start` and the ending string `end`, return `True` if and only if there exists a sequence of moves to transform `start` to `end`.
*Trong một chuỗi bao gồm các ký tự `'L'`, `'R'`, và `'X'`, ví dụ như `"RXXLRXRXL"`, một bước di chuyển bao gồm việc thay thế một lần xuất hiện của `"XL"` bằng `"LX"`, hoặc thay thế một lần xuất hiện của `"RX"` bằng `"XR"`. Cho chuỗi bắt đầu `start` và chuỗi kết thúc `end`, trả về `True` khi và chỉ khi tồn tại một chuỗi các bước di chuyển để biến đổi `start` thành `end`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** start = "RXXLRXRXL", end = "XRLXXRRLX"
**Output:** true
**Explanation:**
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

## Example 2:
## *Ví dụ 2:*

**Input:** start = "X", end = "L"
**Output:** false

---

## Constraints:
## *Ràng buộc:*

*   `1 <= start.length <= 10^4`
*   `start.length == end.length`
*   Both strings consist of `'L'`, `'R'`, and `'X'`.
