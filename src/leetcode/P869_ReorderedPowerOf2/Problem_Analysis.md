# 869. Reordered Power of 2 / Lũy thừa của 2 được Sắp xếp lại

## Problem Description / Mô tả bài toán
You are given an integer `n`. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
Bạn được cho một số nguyên `n`. Chúng ta sắp xếp lại các chữ số theo bất kỳ thứ tự nào (bao gồm cả thứ tự ban đầu) sao cho chữ số đầu tiên không phải là số 0.

Return `true` if and only if we can do this so that the resulting number is a power of 2.
Trả về `true` khi và chỉ khi chúng ta có thể làm điều này để số kết quả là một lũy thừa của 2.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digits Frequency or Sorting / Tần suất Chữ số hoặc Sắp xếp
Any two numbers that can be reordered into each other must have the same digits and the same counts of each digit.
Bất kỳ hai số nào có thể sắp xếp lại thành nhau phải có cùng các chữ số và cùng số lượng của mỗi chữ số.

Algorithm:
1. Generate all powers of 2 (up to 10^9).
Power of 2: `1, 2, 4, 8, 16, 32, 64, 128, ...`
2. For each power of 2:
   - Calculate its "digit signature" (count of 0s, 1s, ..., 9s).
3. Calculate the "digit signature" of `n`.
4. If `n` matches any signature of a power of 2, return `true`.

### Complexity / Độ phức tạp
- **Time**: O(log N) - only 30-31 powers of 2 to check.
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Signature Matching
Treat the problem as a set-membership check within the small pool of valid powers of 2. Instead of generating all permutations of `n`, we normalize both the candidates and the target into frequency arrays for instant comparison.
Coi bài toán là việc kiểm tra tư cách thành viên tập hợp trong một nhóm nhỏ các lũy thừa của 2 hợp lệ. Thay vì tạo ra tất cả các hoán vị của `n`, chúng ta chuẩn hóa cả các ứng viên và mục tiêu thành các mảng tần suất để so sánh ngay lập tức.

---
