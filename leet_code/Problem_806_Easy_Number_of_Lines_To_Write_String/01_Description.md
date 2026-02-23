# Result for Number of Lines To Write String
# *Kết quả cho bài toán Số dòng để viết chuỗi*

## Description
## *Mô tả*

You are writing a string `s` across several lines, where each line has a maximum width of `100` pixels.
*Bạn đang viết một chuỗi `s` trên nhiều dòng, mỗi dòng có chiều rộng tối đa là `100` điểm ảnh (pixels).*

You are given an array `widths` of length 26, where `widths[0]` is the width of 'a', `widths[1]` is the width of 'b', and so on.
*Bạn được cho một mảng `widths` độ dài 26, trong đó `widths[0]` là chiều rộng của 'a', `widths[1]` là chiều rộng của 'b', v.v.*

When you write a character, if writing that character would cause the total width of the current line to exceed `100` pixels, you must write the entire character on the next line.
*Khi bạn viết một ký tự, nếu việc viết ký tự đó làm cho tổng chiều rộng của dòng hiện tại vượt quá `100`, bạn phải viết toàn bộ ký tự đó ở dòng tiếp theo.*

Return *an array of length 2* where:
*   `result[0]` is the total number of lines.
*   `result[1]` is the width of the last line in pixels.
*Trả về *một mảng độ dài 2* trong đó: `result[0]` là tổng số dòng, `result[1]` là chiều rộng của dòng cuối cùng (điểm ảnh).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "abcdefghijklmnopqrstuvwxyz"
**Output:** [3, 60]
**Explanation:** 
Every character has a width of 10. 
The first 10 characters "abcdefghij" fit in the first line (10 * 10 = 100).
The next 10 characters fit in the second line.
The last 6 characters fit in the third line.
There are 3 lines and the width of the last line is 60.

## Example 2:
## *Ví dụ 2:*

**Input:** widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "bbbcccdddaaa"
**Output:** [2, 4]

---

## Constraints:
## *Ràng buộc:*

*   `widths.length == 26`
*   `2 <= widths[i] <= 10`
*   `1 <= s.length <= 1000`
*   `s` consists of lowercase English letters.
