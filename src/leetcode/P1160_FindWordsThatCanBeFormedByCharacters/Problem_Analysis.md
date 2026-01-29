# 1160. Find Words That Can Be Formed by Characters / Tìm các Từ Có thể Được tạo thành bởi Ký tự

## Problem Description / Mô tả bài toán
Given an array of strings `words` and a string `chars`.
A string is good if it can be formed by characters from `chars` (each character can only be used once).
Return the sum of lengths of all good strings in `words`.
Cho một mảng các chuỗi `words` và một chuỗi `chars`.
Một chuỗi là tốt nếu nó có thể được tạo thành bởi các ký tự từ `chars` (mỗi ký tự chỉ có thể được sử dụng một lần).
Trả về tổng độ dài của tất cả các chuỗi tốt trong `words`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Map / Bản đồ Tần suất
1. Count chars in `chars` array.
2. For each word, count chars.
3. Check if `wordCount` subset of `charsCount`.

---
