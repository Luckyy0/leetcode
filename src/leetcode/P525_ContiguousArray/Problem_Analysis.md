# 525. Contiguous Array / Mảng Liên Tục

## Problem Description / Mô tả bài toán
Given a binary array `nums`, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Cho mảng nhị phân `nums`, trả về độ dài tối đa của mảng con liên tục có số lượng 0 và 1 bằng nhau.

### Approach / Phương pháp
Transform 0s to -1s. Find longest subarray with sum = 0.
Biến đổi 0 thành -1. Tìm mảng con dài nhất có tổng = 0.

Use HashMap to store first occurrence of each prefix sum.
Dùng HashMap lưu lần xuất hiện đầu tiên của mỗi tổng tiền tố.
