# 1417. Reformat The String / Định dạng lại Chuỗi

## Problem Description / Mô tả bài toán
String `s` (alphanumeric). Reformat so no two adjacent chars are same type (digit/letter).
Permutation.
If impossible, return "".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Partitioning
Separate digits and letters.
If `|countD - countL| > 1`, impossible.
If `countD >= countL`: Start with Digit, Letter, Digit...
If `countL > countD`: Start with Letter, Digit, Letter...

---
