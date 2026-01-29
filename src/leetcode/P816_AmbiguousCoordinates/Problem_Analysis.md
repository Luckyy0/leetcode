# 816. Ambiguous Coordinates / Tọa độ Mơ hồ

## Problem Description / Mô tả bài toán
We had some coordinates written as `"(x, y)"`, where `x` and `y` are positive real numbers. We then removed all commas, spaces, and decimal points.
Chúng ta có một số tọa độ được viết là `"(x, y)"`, trong đó `x` và `y` là các số thực dương. Sau đó chúng ta loại bỏ tất cả các dấu phẩy, khoảng trắng và dấu thập phân.

Given a string `s`, return a list of strings representing all possibilities for what our original coordinates could have been.
Cho một chuỗi `s`, trả về một danh sách các chuỗi đại diện cho tất cả các khả năng tọa độ gốc có thể có.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force with Validation / Duyệt toàn bộ với Xác thực
1. Split the string into two parts `x` and `y` at every possible position.
2. For each part, find all valid ways to insert a decimal point.
A string is valid if:
- It doesn't have leading zeros (unless it's just "0").
- If it has a decimal point, it doesn't end with zero.

Algorithm:
- split `s` to `left` and `right`.
- `findDecimals(part)`:
  - Try placing `.` at every index.
  - Apply rules to filter invalid strings.
- Construct `(leftDec, rightDec)` pairs.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(N^3) for results.

---

## Analysis / Phân tích

### Approach: Segment and Reconstitute
Divide the input into two coordinate segments. For each segment, iteratively generate all mathematical representations that do not violate numeric formatting rules (e.g., no trailing zeroes after a decimal, no leading zeroes for integers).
Chia đầu vào thành hai đoạn tọa độ. Đối với mỗi đoạn, tạo lặp lại tất cả các biểu diễn toán học không vi phạm các quy tắc định dạng số (ví dụ: không có số 0 ở cuối sau số thập phân, không có số 0 ở đầu cho số nguyên).

---
