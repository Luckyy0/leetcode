# 523. Continuous Subarray Sum / Tổng Mảng Con Liên Tục

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return `true` if nums has a continuous subarray of size at least 2 whose elements sum up to a multiple of `k`.
Cho mảng số nguyên `nums` và số nguyên `k`, trả về `true` nếu nums có mảng con liên tục có kích thước ít nhất 2 mà tổng các phần tử là bội số của `k`.

### Approach / Phương pháp
Use prefix sum with modulo. Store remainders in HashMap with their first occurrence index.
Sử dụng tổng tiền tố với phép chia dư. Lưu các số dư trong HashMap với chỉ số xuất hiện đầu tiên.

If same remainder appears again with gap >= 2, return true.
Nếu cùng số dư xuất hiện lại với khoảng cách >= 2, trả về true.
