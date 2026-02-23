# Result for Jewels and Stones
# *Kết quả cho bài toán Đá quý và Đá thường*

## Description
## *Mô tả*

You're given strings `jewels` representing the types of stones that are jewels, and `stones` representing the stones you have. Each character in `stones` is a type of stone you have. You want to know how many of the stones you have are also jewels.
*Bạn được cho chuỗi `jewels` đại diện cho các loại đá là đá quý, và `stones` đại diện cho các viên đá bạn có. Mỗi ký tự trong `stones` là một loại đá bạn sở hữu. Bạn muốn biết bao nhiêu viên đá bạn có cũng là đá quý.*

Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.
*Các chữ cái phân biệt chữ hoa chữ thường, vì vậy `"a"` được coi là một loại đá khác với `"A"`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** jewels = "aA", stones = "aAAbbbb"
**Output:** 3

## Example 2:
## *Ví dụ 2:*

**Input:** jewels = "z", stones = "ZZ"
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `1 <= jewels.length, stones.length <= 50`
*   `jewels` and `stones` consist of only English letters.
*   All the characters of `jewels` are **unique**.
