# 1207. Unique Number of Occurrences / Số lần Xuất hiện Duy nhất

## Problem Description / Mô tả bài toán
Given an array of integers `arr`, return `true` if the number of occurrences of each value in the array is unique, or `false` otherwise.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap and HashSet / HashMap và HashSet
1. Count frequencies: `Map<Integer, Integer>`.
2. check if all frequencies are unique: `new HashSet<>(map.values()).size() == map.size()`.

---
