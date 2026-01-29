# 524. Longest Word in Dictionary through Deleting / Từ Dài Nhất Trong Từ Điển Bằng Cách Xóa

## Problem Description / Mô tả bài toán
Given a string `s` and a string array `dictionary`, return the longest string in dictionary that can be formed by deleting some characters of `s`. If there are multiple answers, return the lexicographically smallest one.
Cho chuỗi `s` và mảng chuỗi `dictionary`, trả về chuỗi dài nhất trong dictionary có thể được hình thành bằng cách xóa một số ký tự của `s`.

### Approach / Phương pháp
Check each word in dictionary to see if it's a subsequence of s.
Kiểm tra từng từ trong dictionary xem có phải là dãy con của s không.

Track the longest valid word (lexicographically smallest if tied).
Theo dõi từ hợp lệ dài nhất (nhỏ nhất về từ điển nếu bằng nhau).
