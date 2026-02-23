# Result for Zigzag Conversion
# *Kết quả cho bài toán Chuyển Đổi Zigzag*

## Description
## *Mô tả*

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
*Chuỗi `"PAYPALISHIRING"` được viết theo mô hình zigzag trên một số lượng hàng nhất định như sau: (bạn có thể muốn hiển thị mô hình này bằng phông chữ cố định để dễ đọc hơn)*

```text
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`
*Và sau đó đọc từng dòng: `"PAHNAPLSIIGYIR"`*

Write the code that will take a string and make this conversion given a number of rows:
*Viết mã nhận vào một chuỗi và thực hiện chuyển đổi này với số lượng hàng cho trước:*

`string convert(string s, int numRows);`

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "PAYPALISHIRING"`, `numRows = 3`
**Output:** `"PAHNAPLSIIGYIR"`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "PAYPALISHIRING"`, `numRows = 4`
**Output:** `"PINALSIGYAHRPI"`
**Explanation:**
```text
P     I     N
A   L S   I G
Y A   H R
P     I
```

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "A"`, `numRows = 1`
**Output:** `"A"`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s` consists of English letters (lower-case and upper-case), ',' and '.'.
*   *`s` bao gồm các chữ cái tiếng Anh (chữ thường và chữ hoa), ',' và '.'.*
*   `1 <= numRows <= 1000`
