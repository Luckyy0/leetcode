# 922. Sort Array By Parity II / Sắp xếp Mảng theo tính Chẵn lẻ II

## Problem Description / Mô tả bài toán
Given an array of integers `nums`, half of the integers in `nums` are odd, and the other half are even.
Cho một mảng các số nguyên `nums`, một nửa là số lẻ và một nửa là số chẵn.

Sort the array so that whenever `nums[i]` is odd, `i` is odd, and whenever `nums[i]` is even, `i` is even.
Sắp xếp mảng sao cho bất cứ khi nào `nums[i]` là số lẻ thì `i` là số lẻ, và bất cứ khi nào `nums[i]` là số chẵn thì `i` là số chẵn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
Algorithm:
1. Initialize `i = 0` (even pointer) and `j = 1` (odd pointer).
2. While `i < n` and `j < n`:
   - If `nums[i]` is even, skip: `i += 2`.
   - Else if `nums[j]` is odd, skip: `j += 2`.
   - Else (even pos has odd, odd pos has even): swap `nums[i]` and `nums[j]`, then increment both.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Target-based Swapping
Identify misplaced elements by scanning even and odd indices concurrently. A mismatch at an even index implies an corresponding mismatch must exist at an odd index; swapping these restores correct parity for both locations.
Xác định các phần tử đặt sai vị trí bằng cách quét đồng thời các chỉ số chẵn và lẻ. Sự sai lệch tại một chỉ số chẵn ngụ ý rằng một sự sai lệch tương ứng phải tồn tại tại một chỉ số lẻ; việc hoán đổi chúng sẽ khôi phục tính chẵn lẻ chính xác cho cả hai vị trí.

---
