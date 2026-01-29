# 1363. Largest Multiple of Three / Bội số Lớn nhất của Ba

## Problem Description / Mô tả bài toán
Array of digits. Form largest number multiple of 3.
Return as string.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modulo Arithmetic
Sum of digits % 3 == 0 -> whole number % 3 == 0.
Calculate total sum.
- If `sum % 3 == 0`: Use all digits.
- If `sum % 3 == 1`: Remove smallest digit with `mod 3 == 1`. If not possible, remove two smallest with `mod 3 == 2`.
- If `sum % 3 == 2`: Remove smallest digit with `mod 3 == 2`. If not possible, remove two smallest with `mod 3 == 1`.
Construct number descending.
Handle leading zeros.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N) with bucket sort.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Digits Removal
Count occurrences of each digit 0-9. Compute sum modulo 3.
If `rem == 1`: Try to decrement count of shortest digit `d` where `d % 3 == 1` (1, 4, 7). If none, remove two `d` where `d % 3 == 2` (2, 5, 8).
If `rem == 2`: Try to decrement count of `d` where `d % 3 == 2`. If none, remove two `d % 3 == 1`.
Construct string from remaining counts.
Special case: Empty string, or only zeros (return "0").
Đếm số lần xuất hiện của mỗi chữ số 0-9. Tính tổng modulo 3.
Nếu `rem == 1`: Cố gắng giảm số đếm của chữ số nhỏ nhất `d` trong đó `d % 3 == 1` (1, 4, 7). Nếu không có, hãy xóa hai `d` trong đó `d % 3 == 2` (2, 5, 8).
Nếu `rem == 2`: Cố gắng giảm số đếm của `d` trong đó `d % 3 == 2`. Nếu không có, hãy xóa hai `d % 3 == 1`.
Xây dựng chuỗi từ các số đếm còn lại.
Trường hợp đặc biệt: Chuỗi rỗng hoặc chỉ có số không (trả về "0").

---
