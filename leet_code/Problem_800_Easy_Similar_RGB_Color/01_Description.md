# Result for Similar RGB Color
# *Kết quả cho bài toán Màu RGB Tương tự*

## Description
## *Mô tả*

The 24-bit RGB color can be represented by a 6-digit hexadecimal string `"#RRGGBB"`. For example, `"#0000FF"` represents the blue color.
*Màu RGB 24-bit có thể được biểu diễn bằng chuỗi thập lục phân 6 chữ số `"#RRGGBB"`. Ví dụ: `"#0000FF"` đại diện cho màu xanh lam.*

We can also use a shorthand 3-digit hexadecimal string `"#RGB"`, which represents the 24-bit color `"#RRGGBB"`. For example, `"#123"` represents `"#112233"`.
*Chúng ta cũng có thể sử dụng chuỗi thập lục phân viết tắt 3 chữ số `"#RGB"`, đại diện cho màu 24-bit `"#RRGGBB"`. Ví dụ: `"#123"` đại diện cho `"#112233"`.*

Specifically, this shorthand is used only when every 2-digit component is formed by a character repeated twice.
*Cụ thể, kiểu viết tắt này chỉ được sử dụng khi mỗi thành phần 2 chữ số được tạo thành bởi một ký tự lặp lại hai lần.*

The similarity between two colors `"#ABCDEF"` and `"#XYZWUV"` is `-(A*16+B - (X*16+X))^2 - (C*16+D - (Y*16+Y))^2 - (E*16+F - (Z*16+Z))^2`.
*Độ tương tự giữa hai màu `"#ABCDEF"` và `"#XYZWUV"` là tổng âm bình phương độ lệch của các thành phần màu sắc.*

Given a 24-bit color `color`, return a 3-digit shorthand hexadecimal color that is most similar to the given color.
*Cho một màu 24-bit `color`, hãy trả về một màu thập lục phân viết tắt 3 chữ số tương tự nhất với màu đã cho.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** color = "#09d175"
**Output:** "#11ee66"
**Explanation:** 
The 24-bit color "#11ee66" is the shorthand for "#11ee66".
The similarity is -(0x09 - 0x11)^2 -(0xd1 - 0xee)^2 - (0x75 - 0x66)^2 = -8^2 - 29^2 - 15^2 = -64 - 841 - 225 = -1130.
This is the highest similarity among all colors that can be written in shorthand.

## Example 2:
## *Ví dụ 2:*

**Input:** color = "#4e8862"
**Output:** "#558866"

---

## Constraints:
## *Ràng buộc:*

*   `color` is a string of length 7 and starts with "#".
*   Each character in `color` after "#" is a hexadecimal digit.
