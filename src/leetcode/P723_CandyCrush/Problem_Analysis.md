# 723. Candy Crush / Candy Crush

## Problem Description / Mô tả bài toán
This problem is a simulation of the popular game. Given an `m x n` integer array `board`, return the finalized board after all possible candy crushes have occurred.
Bài toán này là một mô phỏng của trò chơi phổ biến. Cho một mảng số nguyên `m x n` `board`, hãy trả về bảng cuối cùng sau khi tất cả các vụ nổ kẹo (candy crush) khả thi đã xảy ra.

Rules:
1. If 3 or more candies of the same type are adjacent vertically or horizontally, they crash (represented by 0).
2. If multiple groups overlapping, all are crushed simultaneously.
3. After crushing, candies drop down to fill the spaces.
4. If new groups are formed after dropping, repeat the process.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Mô phỏng
1. **Find phase**: Scan horizontally and vertically for 3+ identical values. Mark them (e.g., make them negative).
2. **Crush phase**: If marks found, change them to 0. Else terminate.
3. **Gravity phase**: For each column, "drop" the non-zero values to the bottom.

### Complexity / Độ phức tạp
- **Time**: O((M * N)^2) in the worst case where only 3 candies are removed per full scan.
- **Space**: O(1) if we mark in-place.

---

## Analysis / Phân tích

### Approach: Iterate Found-Crush-Drop cycle
Use a helper `found` flag to continue the loop as long as at least one crush happened. The tagging phase must be careful not to overwrite the values before other directions check them.
Sử dụng một cờ `found` trợ giúp để tiếp tục vòng lặp miễn là có ít nhất một vụ nổ xảy ra. Giai đoạn gắn thẻ phải cẩn thận để không ghi đè lên các giá trị trước khi các hướng khác kiểm tra chúng.

---
