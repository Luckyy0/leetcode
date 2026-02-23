# Result for Roman to Integer
# *Kết quả cho bài toán Đổi Số La Mã sang Số Nguyên*

## Description
## *Mô tả*

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
*Số La Mã được biểu diễn bằng bảy ký hiệu khác nhau: `I`, `V`, `X`, `L`, `C`, `D` và `M`.*

```text
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, `2` is written as `II` in Roman numeral, just two ones added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.
*Ví dụ, `2` được viết là `II` trong số La Mã, chỉ là hai số một cộng lại với nhau. `12` được viết là `XII`, đơn giản là `X + II`. Số `27` được viết là `XXVII`, chính là `XX + V + II`.*

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:
*Số La Mã thường được viết từ lớn nhất đến nhỏ nhất từ trái sang phải. Tuy nhiên, số bốn không phải là `IIII`. Thay vào đó, số bốn được viết là `IV`. Bởi vì số một đứng trước số năm, chúng ta trừ nó đi để thành bốn. Nguyên tắc tương tự áp dụng cho số chín, được viết là `IX`. Có sáu trường hợp phép trừ được sử dụng:*

*   `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
*   `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
*   `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
*Cho một số La Mã, hãy chuyển đổi nó thành số nguyên.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "III"`
**Output:** `3`
**Explanation:** III = 3.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "LVIII"`
**Output:** `58`
**Explanation:** L = 50, V= 5, III = 3.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "MCMXCIV"`
**Output:** `1994`
**Explanation:** M = 1000, CM = 900, XC = 90 and IV = 4.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 15`
*   `s` contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
*   It is guaranteed that `s` is a valid roman numeral in the range `[1, 3999]`.
    *Đảm bảo rằng `s` là một số La Mã hợp lệ trong phạm vi `[1, 3999]`.*
