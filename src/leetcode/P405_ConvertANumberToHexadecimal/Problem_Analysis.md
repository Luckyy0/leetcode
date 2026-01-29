# 405. Convert a Number to Hexadecimal / Chuyển Đổi Một Số Sang Cơ Số 16

## Problem Description / Mô tả bài toán
Given an integer `num`, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.
Cho một số nguyên `num`, hãy trả về một chuỗi đại diện cho biểu diễn thập lục phân (cơ số 16) của nó. Đối với các số nguyên âm, phương pháp bù hai được sử dụng.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except if the number itself is 0.
Tất cả các chữ cái trong chuỗi kết quả phải là ký tự viết thường và không được có bất kỳ số 0 nào ở đầu ngoại trừ trường hợp chính số đó là 0.

You are not allowed to use any built-in library method to directly solve this problem.
Bạn không được phép sử dụng bất kỳ phương thức thư viện có sẵn nào để giải quyết trực tiếp bài toán này.

### Example 1:
```text
Input: num = 26
Output: "1a"
```

### Example 2:
```text
Input: num = -1
Output: "ffffffff"
```

## Constraints / Ràng buộc
- `-2^31 <= num <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation / Thao tác Bit
A 32-bit integer can be represented by 8 hexadecimal digits (each hex digit represents 4 bits).
To convert a number to hex:
1. Extract the last 4 bits using a mask `0xf` (`1111` in binary).
2. Map the value (0-15) to hex characters `'0'-'9'` and `'a'-'f'`.
3. Shift the number right by 4 bits using the unsigned right shift `>>>` to handle negative numbers (Two's complement automatically handled by the bitwise representation).
4. Repeat up to 8 times or until the number becomes 0.

### Complexity / Độ phức tạp
- **Time**: O(1) - specifically at most 8 iterations.
- **Space**: O(1) - small fixed-size buffer for hex characters.

---

## Analysis / Phân tích

### Approach: Bit Extraction

**Algorithm**:
1.  Hande `num == 0` separately.
2.  Use a character map `0123456789abcdef`.
3.  Loop while `num != 0` and iteration count < 8:
    - `index = num & 0xf`.
    - Append `map[index]` to string.
    - `num >>>= 4`.
4.  Reverse the string and return.

---
