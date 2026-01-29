# 1355. Activity Participants / Người tham gia Hoạt động

## Problem Description / Mô tả bài toán
Tables `Friends`, `Activities`.
Find names of activities with neither maximum nor minimum number of participants.
Result `activity`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Window
1. Count participants per activity.
2. Find MAX count and MIN count.
3. Filter activities where count != MAX and count != MIN.

---
