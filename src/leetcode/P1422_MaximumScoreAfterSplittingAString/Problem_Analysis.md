# 1422. Maximum Score After Splitting a String / Điểm Tối đa Sau khi Chia Chuỗi

## Problem Description / Mô tả bài toán
String `s` of '0' and '1'. Split into non-empty left and right.
Score = (zeros in left) + (ones in right).
Maximize score.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum
Iterate `i` from 0 to `n-2` (split after `s[i]`).
Precompute total ones.
When moving from `i` to `i+1`:
- If `s[i] == '0'`, `zerosInLeft++`.
- If `s[i] == '1'`, `onesInRight--` (since it moves to left).
`score = zerosInLeft + onesInRight`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Count total ones initially - `totalOnes`.
Initialize `zerosLeft = 0`.
Iterate `i` from 0 to `n-2` (must leave at least one char for right).
- If `s[i] == '0'`, `zerosLeft++`.
- If `s[i] == '1'`, `totalOnes--` (this one moved to left, so right ones decrease).
- Score = `zerosLeft + totalOnes`. Update max.
Đếm tổng số số một ban đầu - `totalOnes`.
Khởi tạo `zerosLeft = 0`.
Lặp lại `i` từ 0 đến `n-2`.
- Nếu `s[i] == '0'`, `zerosLeft++`.
- Nếu `s[i] == '1'`, `totalOnes--`.
- Điểm = `zerosLeft + totalOnes`. Cập nhật điểm tối đa.

---
