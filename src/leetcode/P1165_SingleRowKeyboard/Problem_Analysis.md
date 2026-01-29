# 1165. Single-Row Keyboard / Bàn phím Một Hàng

## Problem Description / Mô tả bài toán
There is a special keyboard with all keys in a single row.
Given a string `keyboard` of length 26 indicating the layout of the keyboard (indexed from 0 to 25).
Initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger calculation is `|current_index - new_index|`.
Calculate total time to type a string `word`.
Có một bàn phím đặc biệt với tất cả các phím trên một hàng duy nhất.
Cho một chuỗi `keyboard` có độ dài 26 chỉ ra bố cực của bàn phím (được đánh chỉ số từ 0 đến 25).
Ban đầu ngón tay của bạn ở chỉ số 0. Để gõ một ký tự, bạn phải di chuyển ngón tay đến chỉ số của ký tự mong muốn. Thời gian di chuyển được tính bằng `|current_index - new_index|`.
Tính tổng thời gian để gõ chuỗi `word`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap / Array Mapping / Ánh xạ Mảng
Map each char to its index.
Iterate `word`. Sum distances.

---
