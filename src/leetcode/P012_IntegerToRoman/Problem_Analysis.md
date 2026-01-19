# 12. Integer to Roman / Chuyển Đổi Số Nguyên Sang Số La Mã

## Problem Description / Mô tả bài toán
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Số La Mã được biểu diễn bởi bảy ký hiệu khác nhau: I, V, X, L, C, D và M.

| Symbol | Value |
|---|---|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

For example, `2` is written as `II` in Roman numeral, just two one's added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.
Ví dụ, `2` được viết là `II` trong số La Mã, chỉ là hai số một cộng lại. `12` được viết là `XII`, đơn giản là `X + II`. Số `27` được viết là `XXVII`, tức là `XX + V + II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:
Số La Mã thường được viết từ lớn nhất đến nhỏ nhất từ trái sang phải. Tuy nhiên, số bốn không phải là `IIII`. Thay vào đó, số bốn được viết là `IV`. Bởi vì số một đứng trước số năm, chúng ta trừ nó đi để thành bốn. Nguyên tắc tương tự áp dụng cho số chín, được viết là `IX`. Có sáu trường hợp sử dụng phép trừ:
- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.
Cho một số nguyên, hãy chuyển đổi nó thành số La Mã.

## Constraints / Ràng buộc
- `1 <= num <= 3999`

---

## Analysis / Phân tích

### Approach: Greedy / Tham lam
- **Idea**: Since the rules are fixed and we want to "Greedily" match the largest possible value first.
- **Ý tưởng**: Vì các quy tắc là cố định và chúng ta muốn khớp "Tham lam" giá trị lớn nhất có thể trước.
- Create two arrays:
    - `values`: `[1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]`
    - `symbols`: `["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]`
- Iterate through the values. While `num >= values[i]`, append `symbols[i]` and `num -= values[i]`.
- **Time Complexity**: O(1). Since the input is limited (<= 3999), the loop runs a fixed number of times.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Values with Subtraction**: 4 (IV), 9 (IX), 40 (XL), etc.
2.  **Regular Values**: 3 (III), 58 (LVIII).
3.  **Largest Number**: 3999 (MMMCMXCIX).
