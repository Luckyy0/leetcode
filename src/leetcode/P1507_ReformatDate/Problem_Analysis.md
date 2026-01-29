# 1507. Reformat Date / Định dạng lại Ngày

## Problem Description / Mô tả bài toán
Date string "Day Month Year". e.g. "20th Oct 2052".
Convert to "YYYY-MM-DD".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Parsing
Split by space.
Year: index 2.
Month: map name to number. "Jan"-> "01".
Day: parse number, remove "st", "nd", "rd", "th". Pad with 0 if < 10.

---
